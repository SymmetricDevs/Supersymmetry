package globals

class Petrochemistry {

    public static void main (String[] args) {}

    public static class Oil {
        String name
        String brine

        Oil(String name, String brine) {
            this.name = name
            this.brine = brine
        }
        
        def getDiluted(int amount) {
            return fluid('diluted_' + this.name) * amount
        }

        def getDesalted(int amount) {
            return fluid('desalted_' + this.name) * amount
        }

        def getHeated(int amount) {
            return fluid('heated_' + this.name) * amount
        }

        def getBrine(int amount) {
            return fluid(this.brine) * amount
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    trait CatalyticCrackable {
        boolean catalytic_crackable = true

        def getCatalyticallyCracked(int amount) {
            return fluid('catalytically_cracked_' + this.name) * amount
        }

        def getCrudeCatalyticallyCracked(int amount) {
            return fluid('crude_catalytically_cracked_' + this.name) * amount
        }
    }

    trait ThermalCrackable {
        boolean thermal_crackable = true

        def getThermallyCracked(int amount) {
            return fluid('thermally_cracked_' + this.name) * amount
        }

        def getQuenched(int amount) {
            return fluid('quenched_' + this.name) * amount
        }
    }

    trait HydroCrackable {
        boolean hydro_crackable = true
        int hydrogen_consumed
        int gas_produced

        def getHydro(int amount) {
            return fluid('hydrocracked_' + this.name) * amount
        }
    }

    trait SteamCrackable {
        boolean steam_crackable = true

        def getSteam(int amount) {
            return fluid('steamcracked_' + this.name) * amount
        }
    }

    trait Heatable {
        def getHeated(int amount) {
            return fluid('heated_' + this.name) * amount
        }
    }

    trait Sulfuric {
        boolean sulfuric = true

        def getTreatedSulfuric(int amount) {
            return fluid('treated_sulfuric_' + this.name) * amount
        }

        def getSulfuric(int amount) {
            return fluid('sulfuric_' + this.name) * amount
        }
    }

    trait Crude {
        def getCrude(int amount) {
            return fluid('crude_' + this.name) * amount
        }
    }

    trait Strippable extends Crude {
        boolean strippable = true
    }

    public static class OilFraction {
        String name
        boolean strippable = false
        boolean sulfuric = false

        OilFraction(String name) {
            this.name = name
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static class Crackable {
        String name
        boolean thermal_crackable = false
        boolean hydro_crackable = false
        boolean steam_crackable = false
        boolean catalytic_crackable = false

        Crackable(String name) {
            this.name = name
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    /* Data on fractions
        - Fuel gas: 3.56 carbons per mol        51.8 g/mol
        - Light naphtha: 5.5 carbons per mol    77 g/mol
        - Full naphtha: 6.5 carbons per mol     91 g/mol
        - Heavy naphtha: 9 carbons per mol      126 g/mol
        - Kerosene: 11.5 carbons per mol        161.6 g/mol
        - Light gas oil: 15.5 carbons per mol   215.6 g/mol
        - Heavy gas oil: 20 carbons per mol     274.5 g/mol
        - Atm. residuum: 40 carbons per mol     547.6 g/mol
        - Vac. residuum: 45 carbons per mol     603.0 g/mol
        - Light cycle oil: 12 carbons per mol   163.5 g/mol
    */

    public static fractions = [
        heavy_gas_oil : new OilFraction('heavy_gas_oil').withTraits(Sulfuric, Heatable, Strippable),
        light_gas_oil : new OilFraction('light_gas_oil').withTraits(Sulfuric, Heatable, Strippable),
        kerosene : new OilFraction('kerosene').withTraits(Sulfuric, Heatable, Strippable),
        heavy_naphtha : new OilFraction('heavy_naphtha').withTraits(Sulfuric, Heatable),
        light_cycle_oil : new OilFraction('light_cycle_oil').withTraits(Sulfuric, Heatable),
        naphtha : new OilFraction('naphtha').withTraits(Crude),
        light_naphtha : new OilFraction('light_naphtha').withTraits(Sulfuric, Heatable),
    ]

    public static crackables = [
        vacuum_oil_residue : new Crackable('vacuum_oil_residue').withTraits(CatalyticCrackable, HydroCrackable, ThermalCrackable).tap { hydrogen_consumed = 3560; gas_produced = 550 },
        atmospheric_oil_residue : new Crackable('atmospheric_oil_residue').withTraits(CatalyticCrackable, HydroCrackable, ThermalCrackable).tap { hydrogen_consumed = 3540; gas_produced = 610 },
        light_gas_oil : new Crackable('light_gas_oil').withTraits(HydroCrackable, SteamCrackable).tap { hydrogen_consumed = 880; gas_produced = 1790 },
        heavy_gas_oil : new Crackable('heavy_gas_oil').withTraits(CatalyticCrackable, HydroCrackable, SteamCrackable).tap { hydrogen_consumed = 1490; gas_produced = 1020 },
        ethane : new Crackable('ethane').withTraits(SteamCrackable),
        propane : new Crackable('propane').withTraits(SteamCrackable),
        butane : new Crackable('butane').withTraits(SteamCrackable),
        light_cycle_oil : new Crackable('light_cycle_oil').withTraits(HydroCrackable).tap { hydrogen_consumed = 1130; gas_produced = 1290 }
    ]

    public static oils = [
        oil: new Oil('oil', 'oily_brine'),
        oil_light: new Oil('oil_light', 'light_oily_brine'),
        oil_heavy: new Oil('oil_heavy', 'heavy_oily_brine') 
    ]
}