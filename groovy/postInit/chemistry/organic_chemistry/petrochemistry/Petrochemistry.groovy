package petrochemistry

class Petrochemistry = {

    public static void main (String[] args) {}

    public static class Oil {
        String name

        Oil(String name) {
            this.name = name
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

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static class OilFraction {
        String name
        Boolean isUpgradable = false
        String upgrade_name = ""

        OilFraction(String name) {
            this.name = name
        }

        OilFraction(String name, String upgrade_name) {
            this.name = name
            this.isUpgradable = true
            this.upgrade_name = upgrade_name
        }

        def getCrude(int amount) {
            return fluid('crude_' + this.name) * amount
        }

        def getTreatedSulfuric(int amount) {
            return fluid('treated_sulfuric_' + this.name) * amount
        }

        def getSulfuric(int amount) {
            return fluid('sulfuric_' + this.name) * amount
        }

        def getHeated(int amount) {
            return fluid('heated_' + this.name) * amount
        }

        def getUpgraded(int amount) {
            return fluid(this.upgrade_name) * amount
        }

        def getUpgradedMix(int amount) {
            return fluid('upgraded_' + this.name + '_mix') * amount
        }

        def get(int amount) {
            return fluid(this.name) * amount
        }
    }

    public static class OilFractionCrackable extends OilFraction {

        OilFractionCrackable(String name){
            super(name)
        }

        OilFractionCrackable(String name, String upgrade_name){
            super(name, upgrade_name)
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
        heavy_fuel_oil : new OilFraction('heavy_fuel_oil', 'light_fuel_oil'),
        light_fuel_oil : new OilFraction('light_fuel_oil', 'kerosene'),
        kerosene : new OilFractionCrackable('kerosene', 'naphtha'),
        naphtha : new OilFractionCrackable('naphtha', 'gasoline'),
        gasoline : new OilFractionCrackable('gasoline'),
        refinery_gas : new OilFraction('refinery_gas'),
        natural_gas : new OilFraction('natural_gas')
    ]

    public static oils = [
        oil: new Oil('oil'),
        oil_light: new Oil('oil_light'),
        oil_heavy: new Oil('oil_heavy') 
    ]
}