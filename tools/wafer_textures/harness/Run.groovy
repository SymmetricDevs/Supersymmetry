import globals.semiconductors.*
import org.codehaus.groovy.control.CompilerConfiguration

def root = new File(args[0])
def files = args[1..-2]
def out = args[-1]

// Intercept static helper calls to record which process step produced each recipe
[Deposition, Etching, Doping, Lithography, Mechanicals, Packaging].each { C ->
    C.metaClass.static.invokeMethod = { String name, a ->
        def mm = C.metaClass.getStaticMetaMethod(name, a)
        if (mm == null) throw new MissingMethodException(name, C, a)
        Stubs.ctx.push([C.simpleName, name, a as List])
        try { return mm.doMethodInvoke(C, a) } finally { Stubs.ctx.pop() }
    }
}

class DBinding extends Binding {
    Object getVariable(String n) {
        if (variables.containsKey(n)) return super.getVariable(n)
        // Recipe maps missing from Recipemaps (e.g. SCREEN_PRINTING) still need recording
        if (n ==~ /[A-Z][A-Z0-9_]+/) return new RecipeMap(name: n.toLowerCase())
        return new Dummy(n)
    }
}

files.each { f ->
    def src = new File(root, f).text
    src = src.readLines().collect { l ->
        if (l ==~ /\s*import .*/ && !(l =~ /globals\.semiconductors|prePostInit|GTValues|CleanroomType/)) return '// ' + l
        return l
    }.join('\n')
    // Texture-only fixups for recipe typos, so orphaned items still get a producing step
    src = src.replace("'novolacs_liftoff_resist'", "'novolac_liftoff_resist'")
             .replace("400, 'boron')", "400, 'boron_trifluoride')")
             .replace("400, 'phosphorus')", "400, 'phosphine')")
    src = 'import static Stubs.*\n' + src
    Stubs.currentScript = f
    def shell = new GroovyShell(this.class.classLoader, new DBinding())
    try {
        shell.evaluate(src, f.replaceAll(/[^A-Za-z0-9]/, '_'))
        println "OK   $f"
    } catch (Throwable t) {
        println "FAIL $f: $t"
        t.stackTrace.findAll { it.fileName?.contains('_groovy') || it.fileName?.endsWith('.groovy') }.take(3).each { println "     $it" }
    }
}
Stubs.dump(out)
println "recipes: ${Stubs.recipes.size()}"
