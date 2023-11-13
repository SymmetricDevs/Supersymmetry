import groovy.transform.TupleConstructor

class CarbonGlobals {

    public static void main (String[] args) {}

    trait Combustible {
        int amount
        int duration
        {
            amount = item_amount_for_combustible()
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

        public int item_amount_of_carbon(int required_carbon) {
            return item_amount_of_provider(required_carbon, this.carbon)
        }

        int item_amount_for_combustible() {
            return item_amount_of_carbon(90)
        }
    }

    public static carbon_sources = [
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

    public static List combustibles() { carbon_sources.grep(Combustible) }
    public static List highPurityCombustibles() { carbon_sources.grep(HighPurityCombustible) }

}