package globals
import Dummy
class Globals {
    public static voltageTiers = ['ulv','lv','mv','hv','ev','iv','luv','zpm','uv','uhv']
    public static solders = ['tin': 144, 'soldering_alloy': 72]
    static def $static_propertyMissing(String n) { return new Dummy('Globals.'+n) }
}
