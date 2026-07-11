package classes

import baubles.api.BaubleType
import gregtech.integration.baubles.BaubleBehavior
import gregtech.api.GregTechAPI
import gregtech.api.GTValues
import gregtech.api.capability.GregtechCapabilities
import gregtech.api.capability.IElectricItem
import gregtech.api.items.metaitem.ElectricStats
import gregtech.api.items.metaitem.StandardMetaItem
import gregtech.api.unification.material.MarkerMaterials
import gregtech.api.unification.ore.OrePrefix

class Battery {
    String name
    int tier
    long capacity

    Battery(String name, int tier, int secs) {
        this.name = name
        this.tier = tier
        this.capacity = secs * GTValues.V[tier] * 20
    }

    public String fetchMetaname() { "battery.$name" }
    public ItemStack fetchMetaitem() { metaitem(fetchMetaname()) }

    public ItemStack imprintCapacity(ItemStack tool) {
        IElectricItem eiTool = tool?.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null)
        eiTool?.setMaxChargeOverride(capacity)
        return tool
    }

    public void register(StandardMetaItem customMetaItem, int metaId) {
        def getMarkerTier = { int t ->
            switch (t) {
                case GTValues.LV: return MarkerMaterials.Tier.LV
                case GTValues.MV: return MarkerMaterials.Tier.MV
                case GTValues.HV: return MarkerMaterials.Tier.HV
                case GTValues.EV: return MarkerMaterials.Tier.EV
                case GTValues.IV: return MarkerMaterials.Tier.IV
                // continue when needed
                default: return MarkerMaterials.Tier.LV
            }
        }

        customMetaItem.addItem(metaId, fetchMetaname())
            .addComponents(ElectricStats.createRechargeableBattery(capacity, tier), new BaubleBehavior(BaubleType.TRINKET))
            .setUnificationData(OrePrefix.battery, getMarkerTier(tier))
            .setModelAmount(8)
            .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
    }
}
