import groovy.json.JsonOutput

class Stubs {
    static List recipes = []
    static List ctx = []
    static String currentScript = ''

    public static final Dummy log = new Dummy('log')
    static def metaitem(Object n) { new Stack(kind: 'metaitem', name: String.valueOf(n)) }
    static def fluid(Object n) { new Stack(kind: 'fluid', name: String.valueOf(n)) }
    static def ore(Object n) { new Stack(kind: 'ore', name: String.valueOf(n)) }
    static def item(String n, Object... a) { new Stack(kind: 'item', name: n) }
    static def recipemap(String n) { new RecipeMap(name: n) }
    static def material(String n) { new Dummy('material:' + n) }

    static void dump(String path) { new File(path).text = JsonOutput.toJson(recipes) }
}

class Dummy {
    String n
    Dummy(String n) { this.n = n }
    def methodMissing(String name, args) { return this }
    def propertyMissing(String name) { return this }
    def propertyMissing(String name, val) { }
    def multiply(x) { this }
    def plus(x) { this }
    def minus(x) { this }
    def div(x) { this }
    def getAt(x) { this }
    def call(Object... a) { this }
    // Iterate once so loops over unknown lists (Sintering fuels, ...) still emit their recipe
    Iterator iterator() { [this].iterator() }
    boolean asBoolean() { true }
    String toString() { n }
}
class Stack {
    String kind; String name; int amount = 1
    def multiply(x) { new Stack(kind: kind, name: name, amount: (x instanceof Number ? (int) x : 1) * amount) }
    def withNbt(Object... a) { this }
    def methodMissing(String n, args) { this }
    String toString() { kind + ':' + name }
}
class Builder {
    String map
    Map r = [inputs: [], outputs: [], fluidInputs: [], fluidOutputs: [], notConsumable: [], chancedOutputs: []]
    def inputs(Object... xs) { xs.flatten().each { r.inputs << str(it) }; this }
    def outputs(Object... xs) { xs.flatten().each { r.outputs << str(it) }; this }
    def fluidInputs(Object... xs) { xs.flatten().each { r.fluidInputs << str(it) }; this }
    def fluidOutputs(Object... xs) { xs.flatten().each { r.fluidOutputs << str(it) }; this }
    def notConsumable(Object... xs) { xs.flatten().each { r.notConsumable << str(it) }; this }
    def chancedOutput(Object x, Object... rest) { r.chancedOutputs << str(x); this }
    static String str(x) { x instanceof Stack ? x.kind + ':' + x.name : String.valueOf(x) }
    def buildAndRegister() {
        r.map = map
        r.script = Stubs.currentScript
        r.ctx = Stubs.ctx.collect { [it[0], it[1], it[2].collect { a -> a instanceof String || a instanceof Number || a instanceof Boolean ? a : (a instanceof Map ? a.collectEntries { k, v -> [(String.valueOf(k)): String.valueOf(v)] } : String.valueOf(a)) }] }
        Stubs.recipes << r
        return null
    }
    def methodMissing(String name, args) { this }
    def propertyMissing(String name) { this }
}
class RecipeMap {
    String name
    def recipeBuilder() { new Builder(map: name) }
    def methodMissing(String n, args) { new Dummy(n) }
}

