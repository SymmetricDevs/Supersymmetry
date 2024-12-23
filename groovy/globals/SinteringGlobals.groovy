package globals

class SinteringGlobals {

    public static void main (String[] args) {

    }

    public static class Combustible {
        String name
        boolean isPlasma
        int amountRequired
        int duration
        String byproduct
        int byproductAmount

        Combustible(name, isPlasma, amountRequired, duration, byproduct, byproductAmount) {
            this.name = name
            this.isPlasma = isPlasma
            this.amountRequired = amountRequired
            this.duration = duration
            this.byproduct = byproduct
            this.byproductAmount = byproductAmount
        }
    }

    public static class Comburent {
        String name
        int amountRequired
        int duration

        Comburent(name, amountRequired, duration) {
            this.name = name
            this.amountRequired = amountRequired
            this.duration = duration
        }
    }

    public static class Blanket {
        String name
        int amountRequired
        int duration

        Blanket(name, amountRequired, duration) {
            this.name = name
            this.amountRequired = amountRequired
            this.duration = duration
        }
    }

    public static sintering_fuels = [
        new Combustible('methane', false, 10, 50, 'carbon_dioxide', 5),
        new Combustible('syngas', false, 10, 50, 'carbon_dioxide', 5),
        new Combustible('natural_gas', false, 10, 50, 'carbon_dioxide', 5),
        new Combustible('plasma.helium', true, 10, 5, 'helium', 10)
    ]

    public static sintering_comburents = [
        new Comburent('air', 10, 50),
        new Comburent('oxygen', 8, 30)
    ]

    public static sintering_blankets = [
        new Blanket('argon', 100, 300)
    ]

    public static rotary_kiln_fuels = [
        new Combustible('methane', false, 25, 50, 'carbon_dioxide', 25),
        new Combustible('natural_gas', false, 8, 50, 'carbon_dioxide', 25),
        new Combustible('light_gas_oil', false, 4, 50, 'carbon_dioxide', 25),
    ]

    public static rotary_kiln_comburents = [
        new Comburent('air', 250, 50),
        new Comburent('oxygen', 50, 30)
    ]
}
