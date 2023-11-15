import groovy.transform.TupleConstructor

class CarbonGlobals {

    public static void main (String[] args) {}

    // Anthracite coal value, so most recipes would require
    // equal amount of carbon/coke/anthracite and 2x coal
    static final int UNIVERSAL_COAL_EQUIVALENT = 90

    trait Combustible {
        int amount
        int duration
        {
            amount = equivalent(1)
        }
    }

    trait HighPurityCombustible extends Combustible {}

    // Get number of items which would contatin `required` amount of
    // material if single item has `provider` amount
    // E.g. for 90 carbon this would yield 1 for dustCarbon or
    // dustAnthracite and 2 for dustCharcoal or gemLigniteCoke
    static int item_amount_of_provider(int required, int provider) {
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

        // currently not used, but may be interesting for future uses
        public int amount_of_carbon(int required_carbon) {
            return item_amount_of_provider(required_carbon, this.carbon)
        }

        // Return the number of CarbonSource items with summary carbon content
        // equal to carbon content of %required_carbon_items% anthracite items
        public int equivalent(int required_carbon_items) {
            return item_amount_of_provider(required_carbon_items * UNIVERSAL_COAL_EQUIVALENT, this.carbon)
        }
    }

    public static sources = [
        new CarbonSource('dustCarbon', 100, 'dustTinyAsh').withTraits(HighPurityCombustible).tap {
            duration = 1
        },
        new CarbonSource('gemCoke', 100, 'dustTinyAsh').withTraits(Combustible).tap {
            duration = 2
        },
        new CarbonSource('dustCoke', 100, 'dustTinyAsh').withTraits(HighPurityCombustible).tap {
            duration = 2
        },
        new CarbonSource('gemAnthracite', 90, 'dustTinyAsh').withTraits(Combustible).tap {
            duration = 2
        },
        new CarbonSource('dustAnthracite', 90, 'dustTinyAsh').withTraits(Combustible).tap {
            duration = 2
        },
        new CarbonSource('gemLigniteCoke', 75, 'dustTinyAsh').withTraits(Combustible).tap {
            duration = 3
        },
        new CarbonSource('dustLigniteCoke', 75, 'dustTinyAsh').withTraits(Combustible).tap {
            duration = 3
        },
        new CarbonSource('gemCoal', 75, 'dustTinyDarkAsh').withTraits(Combustible).tap {
            duration = 4
        },
        new CarbonSource('dustCoal', 75, 'dustTinyDarkAsh').withTraits(Combustible).tap {
            duration = 4
        },
        new CarbonSource('gemCharcoal', 60, 'dustTinyDarkAsh').withTraits(Combustible).tap {
            duration = 4
        },
        new CarbonSource('dustCharcoal', 60, 'dustTinyDarkAsh').withTraits(Combustible).tap {
            duration = 4
        },
        new CarbonSource('gemLignite', 25, 'dustTinyAsh'),
        new CarbonSource('dustLignite', 25, 'dustTinyAsh')
    ]

    public static List combustibles() { sources.grep(Combustible) }
    public static List highPurityCombustibles() { sources.grep(HighPurityCombustible) }
    public static List dusts() { sources.grep { it.name.startsWith('dust') } }

}