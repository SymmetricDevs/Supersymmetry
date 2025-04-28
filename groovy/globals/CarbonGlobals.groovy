package globals

import groovy.transform.TupleConstructor

class CarbonGlobals {

    public static void main (String[] args) {}

    // Anthracite coal value, so most recipes would require
    // equal amount of carbon/coke/anthracite and 2x coal
    static final int UNIVERSAL_COAL_EQUIVALENT = 90

    trait Combustible {
        int duration
    }

    trait HighPurityCombustible extends Combustible {}

    trait Pyrolyzable {
        String pyrolysis_product
    }

    // Get number of items which would contatin %required% amount of
    // material if single item has %provider% amount
    // E.g. for 90 carbon this would yield 1 for dustCarbon or
    // dustAnthracite and 2 for dustCharcoal or gemLigniteCoke
    static int num_item_by_provider(int required, int provider) {
        int result = required.intdiv(provider)
        if (required % provider > 0) {
            result += 1
        }
        return result
    }

    @TupleConstructor
    public static class CarbonSource {
        String name
        int carbon
        String byproduct

        public int num_items_by_carbon(int required_carbon) {
            return num_item_by_provider(required_carbon, this.carbon)
        }

        // Return the number of CarbonSource items with summary carbon content
        // equal to carbon content of %required_carbon_items% anthracite items
        public int equivalent(int required_carbon_items) {
            return num_item_by_provider(required_carbon_items * UNIVERSAL_COAL_EQUIVALENT, this.carbon)
        }
    }

    public static sources = [
        new CarbonSource('dustHighPurityCarbon', 100, 'dustTinyAsh').withTraits(HighPurityCombustible).tap {
            duration = 1
        },
        new CarbonSource('dustCarbon', 100, 'dustTinyAsh').withTraits(HighPurityCombustible).tap {
            duration = 1
        },
        new CarbonSource('gemCoke', 100, 'dustTinyAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 2
            pyrolysis_product = 'dustCarbon'
        },
        new CarbonSource('dustCoke', 100, 'dustTinyAsh').withTraits(HighPurityCombustible, Pyrolyzable).tap {
            duration = 2
            pyrolysis_product = 'dustCarbon'
        },
        new CarbonSource('dustGreenCoke', 100, 'dustTinyAsh').withTraits(HighPurityCombustible, Pyrolyzable).tap {
            duration = 2
            pyrolysis_product = 'dustCarbon'
        },
        new CarbonSource('gemAnthracite', 90, 'dustTinyAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 2
            pyrolysis_product = 'gemCoke'
        },
        new CarbonSource('dustAnthracite', 90, 'dustTinyAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 2
            pyrolysis_product = 'dustCoke'
        },
        new CarbonSource('gemLigniteCoke', 75, 'dustTinyAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 3
            pyrolysis_product = 'dustCarbon'
        },
        new CarbonSource('dustLigniteCoke', 75, 'dustTinyAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 3
            pyrolysis_product = 'dustCarbon'
        },
        new CarbonSource('gemCoal', 75, 'dustTinyDarkAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 4
            pyrolysis_product = 'gemCoke'
        },
        new CarbonSource('dustCoal', 75, 'dustTinyDarkAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 4
            pyrolysis_product = 'dustCoke'
        },
        new CarbonSource('gemCharcoal', 60, 'dustTinyDarkAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 4
            pyrolysis_product = 'gemCoke'
        },
        new CarbonSource('dustCharcoal', 60, 'dustTinyDarkAsh').withTraits(Combustible, Pyrolyzable).tap {
            duration = 4
            pyrolysis_product = 'dustCoke'
        },
        new CarbonSource('gemLignite', 25, 'dustTinyAsh').withTraits(Pyrolyzable).tap {
            pyrolysis_product = 'gemLigniteCoke'
        },
        new CarbonSource('dustLignite', 25, 'dustTinyAsh').withTraits(Pyrolyzable).tap {
            pyrolysis_product = 'dustLigniteCoke'
        }
    ]

    static Map sourcesMap = sources.collectEntries{[it.name, it]}
    public static def byName(String name) {sourcesMap[name] }
    public static List byNames(List names) { sourcesMap.subMap(names)*.value }

    public static List combustibles() { sources.grep(Combustible) }
    public static List highPurityCombustibles() { sources.grep(HighPurityCombustible) }
    public static List dusts() { sources.grep { it.name.startsWith('dust') } }

}