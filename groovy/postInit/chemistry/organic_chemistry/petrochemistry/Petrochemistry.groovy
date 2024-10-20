package petrochemistry

class Petrochemistry = {

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
            return this.brine
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    trait CatalyticCrackable {
        catalytic_crackable = true

        def getCatalyticallyCracked(int amount) {
            return fluid('catalytically_cracked_' + this.name) * amount
        }

        def getCrudeCatalyticallyCracked(int amount) {
            return fluid('crude_catalytically_cracked_' + this.name) * amount
        }
    }

    trait ThermalCrackable {
        thermal_crackable = true

        def getThermallyCracked(int amount) {
            return fluid('thermally_cracked_' + this.name) * amount
        }
    }

    trait HydroCrackable {
        hydro_crackable = true

        def getHydro(int amount) {
            return fluid('hydrocracked_' + this.name) * amount
        }
    }

    trait SteamCrackable {
        steam_crackable = true

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
        sulfuric = true

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
        strippable = true
    }

    public static class OilFraction {
        String name
        String strippable = false
        String sulfuric = false

        OilFraction(String name) {
            this.name = name
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static class Crackable {
        String name
        String thermal_crackable = false
        String hydro_crackable = false
        String steam_crackable = false
        String catalytic_crackable = false

        Crackable(String name) {
            this.name = name
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static fractions = [
        vacuum_oil_residue : new OilFraction('vacuum_oil_residue').withTraits(Sulfuric),
        atmospheric_oil_residue : new OilFraction('atmospheric_oil_residue').withTraits(Sulfuric),
        lubricating_oil : new OilFraction('lubricating_oil').withTraits(Sulfuric, Crude),
        heavy_gas_oil : new OilFraction('heavy_gas_oil').withTraits(Sulfuric, Heatable, Strippable),
        light_gas_oil : new OilFraction('light_gas_oil').withTraits(Sulfuric, Heatable, Strippable),
        kerosene : new OilFractionCrackable('kerosene').withTraits(Sulfuric, Heatable, Strippable),
        heavy_naphtha : new OilFractionCrackable('heavy_naphtha').withTraits(Sulfuric, Heatable),
        naphtha : new OilFractionCrackable('naphtha').withTraits(Crude),
        light_naphtha : new OilFractionCrackable('light_naphtha').withTraits(Sulfuric, Heatable),
        refinery_gas : new OilFraction('refinery_gas').withTraits(Sulfuric)
    ]

    public static crackables = [
        vacuum_oil_residue : new Crackable('vacuum_oil_residue').withTraits(CatalyticCrackable, HydroCrackable, ThermalCrackable),
        atmospheric_oil_residue : new Crackable('atmospheric_oil_residue').withTraits(CatalyticCrackable, HydroCrackable, ThermalCrackable),
        light_gas_oil : new Crackable('light_gas_oil').withTraits(HydroCrackable, SteamCrackable)
        heavy_gas_oil : new Crackable('heavy_gas_oil').withTraits(CatalyticCrackable, HydroCrackable, SteamCrackable),
        ethane : new Crackable('ethane').withTraits(SteamCrackable),
        propane : new Crackable('propane').withTraits(SteamCrackable),
        butane : new Crackable('butane').withTraits(SteamCrackable),
        light_naphtha : new Crackable('light_naphtha').withTraits(SteamCrackable, HydroCrackable),
        heavy_naphtha : new Crackable('heavy_naphtha').withTraits(SteamCrackable, HydroCrackable),
        light_cycle_oil : new Crackable('light_cycle_oil').withTraits(HydroCrackable),
        heavy_cycle_oil : new Crackable('heavy_cycle_oil').withTraits(HydroCrackable),
        slurry_oil : new Crackable('slurry_oil').withTraits(HydroCrackable),
        deasphalted_oil : new Crackable('deasphalted_oil').withTraits(HydroCrackable)
    ]

    public static oils = [
        oil: new Oil('oil', 'oily_brine'),
        oil_light: new Oil('oil_light', 'light_oily_brine'),
        oil_heavy: new Oil('oil_heavy', 'heavy_oily_brine') 
    ]
}