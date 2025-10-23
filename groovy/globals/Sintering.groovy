package globals

import groovy.transform.TupleConstructor

class Sintering {
    @TupleConstructor
    static class Fuel {
        String name
        int amountRequired
        int duration
        String byproduct
        int byproductAmount
    }

    record Comburent(String name, int amountRequired, int duration) {}

    record Blanket(String name, int amountRequired, int duration) {}

    trait Plasma {}

    public static fuels = [
        new Fuel('methane', 10, 50, 'carbon_dioxide', 5),
        new Fuel('hydrogen_rich_syngas', 10, 50, 'carbon_dioxide', 5),
        new Fuel('monoxide_rich_syngas', 10, 50, 'carbon_dioxide', 5),
        new Fuel('natural_gas', 10, 50, 'carbon_dioxide', 5),
        new Fuel('plasma.helium', 10, 5, 'helium', 10).withTraits(Plasma)
    ]
    public static List plasmaFuels() { fuels.grep(Plasma) }
    public static List nonPlasmaFuels() { fuels.grep { it !instanceof Plasma } }

    public static comburents = [
        new Comburent('air', 10, 50),
        new Comburent('oxygen', 8, 30)
    ]

    public static blankets = [
        new Blanket('argon', 100, 300)
    ]

    static class RotaryKiln {
        public static fuels = [
            new Fuel('methane', 25, 50, 'carbon_dioxide', 25),
            new Fuel('natural_gas', 8, 50, 'carbon_dioxide', 25),
            new Fuel('light_gas_oil', 4, 50, 'carbon_dioxide', 25),
        ]
        public static comburents = [
            new Comburent('air', 250, 50),
            new Comburent('oxygen', 50, 30)
        ]
    }
}
