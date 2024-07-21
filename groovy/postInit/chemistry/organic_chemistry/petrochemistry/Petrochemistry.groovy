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
        String upgrade_name = ""

        def getUpgraded(int amount) {
            return fluid(this.upgrade_name) * amount
        }

        def getUpgradedMix(int amount) {
            return fluid('upgraded_' + this.name + '_mix') * amount
        }
    }

    trait Heatable {
        def getHeated(int amount) {
            return fluid('heated_' + this.name) * amount
        }
    }

    trait Sulfuric {
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

    public static class OilFraction {
        String name

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
        lubricating_oil : new OilFraction('lubricating_oil').withTraits(Sulfuric)
        heavy_fuel_oil : new OilFraction('heavy_fuel_oil').withTraits(CatalyticCrackable, Sulfuric, Heatable).tap { upgrade_name = 'light_fuel_oil' },
        light_fuel_oil : new OilFraction('light_fuel_oil').withTraits(CatalyticCrackable, Sulfuric, Heatable).tap { upgrade_name = 'kerosene' },
        kerosene : new OilFractionCrackable('kerosene').withTraits(CatalyticCrackable, Sulfuric, Heatable).tap { upgrade_name = 'naphtha' },
        naphtha : new OilFractionCrackable('naphtha').withTraits(Crude),
        light_naphtha : new OilFractionCrackable('light_naphtha').withTraits(Sulfuric, Heatable),
        heavy_naphtha : new OilFractionCrackable('heavy_naphtha').withTraits(Sulfuric, Heatable),
        refinery_gas : new OilFraction('refinery_gas')
    ]

    public static oils = [
        oil: new Oil('oil', 'oily_brine'),
        oil_light: new Oil('oil_light', 'light_oily_brine'),
        oil_heavy: new Oil('oil_heavy', 'heavy_oily_brine') 
    ]
}