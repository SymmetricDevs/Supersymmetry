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
        def getCatalyticallyCracked(int amount) {
            return fluid('catalytically_cracked_' + this.name) * amount
        }

        def getCatalyticallyCrackedMix(int amount) {
            return fluid('catalytically_cracked_' + this.name + '_mix') * amount
        }
    }

    trait ThermalCrackable {
        thermal_crackable = true

        def getThermallyCracked(int amount) {
            return fluid('thermally_cracked_' + this.name) * amount
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
        String thermal_crackable = false

        OilFraction(String name) {
            this.name = name
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static class OilFractionCrackable extends OilFraction {

        OilFractionCrackable(String name){
            super(name)
        }

        def getLightlyHydro(int amount) {
            return fluid('lightly_hydrocracked_' + this.name) * amount
        }

        def getSeverelyHydro(int amount) {
            return fluid('severely_hydrocracked_' + this.name) * amount
        }

        def getLightlySteam(int amount) {
            return fluid('lightly_steamcracked_' + this.name) * amount
        }

        def getSeverelySteam(int amount) {
            return fluid('severely_steamcracked_' + this.name) * amount
        }

        def getLightlyHydroMix(int amount) {
        return fluid('lightly_hydrocracked_' + this.name + '_mix') * amount
        }

        def getSeverelyHydroMix(int amount) {
            return fluid('severely_hydrocracked_' + this.name + '_mix') * amount
        }

        def getLightlySteamMix(int amount) {
            return fluid('lightly_steamcracked_' + this.name + '_mix') * amount
        }

        def getSeverelySteamMix(int amount) {
            return fluid('severely_steamcracked_' + this.name + '_mix') * amount
        }

    }

    public static fractions = [
        vacuum_oil_residue : new OilFraction('vacuum_oil_residue').withTraits(CatalyticCrackable, ThermalCrackable),
        atmospheric_oil_residue : new OilFraction('atmospheric_oil_residue').withTraits(CatalyticCrackable, ThermalCrackable),
        lubricating_oil : new OilFraction('lubricating_oil').withTraits(Sulfuric, Crude),
        heavy_gas_oil : new OilFraction('heavy_gas_oil').withTraits(CatalyticCrackable, Sulfuric, Heatable, Strippable),
        light_gas_oil : new OilFraction('light_gas_oil').withTraits(Sulfuric, Heatable, Strippable),
        kerosene : new OilFractionCrackable('kerosene').withTraits(Sulfuric, Heatable, Strippable),
        heavy_naphtha : new OilFractionCrackable('heavy_naphtha').withTraits(Sulfuric, Heatable),
        naphtha : new OilFractionCrackable('naphtha').withTraits(Crude),
        light_naphtha : new OilFractionCrackable('light_naphtha').withTraits(Sulfuric, Heatable),
        refinery_gas : new OilFraction('refinery_gas').withTraits(Sulfuric)
    ]

    public static oils = [
        oil: new Oil('oil', 'oily_brine'),
        oil_light: new Oil('oil_light', 'light_oily_brine'),
        oil_heavy: new Oil('oil_heavy', 'heavy_oily_brine') 
    ]
}