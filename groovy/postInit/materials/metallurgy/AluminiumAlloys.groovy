import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 6061 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10144)
    .inputs(metaitem('dustTinyMagnesium') * 8)
    .inputs(metaitem('dustTinySilicon') * 4)
    .inputs(metaitem('dustTinyCopper') * 1)
    .inputs(metaitem('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_6061') * 10368)
    .material("Alumina")
    .EUt(VA[MV])
    .duration(1440)
    .buildAndRegister()

// 7075 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10848)
    .inputs(metaitem('dustTinyZinc') * 17)
    .inputs(metaitem('dustTinyMagnesium') * 20)
    .inputs(metaitem('dustTinyCopper') * 4)
    .inputs(metaitem('dustTinyChrome') * 1)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 11520)
    .material("Alumina")
    .duration(1600)
    .EUt(VA[MV])
    .buildAndRegister()

// 2219 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 26576)
    .inputs(ore('dustTinyCopper') * 45)
    .inputs(ore('dustTinyManganese') * 18)
    .inputs(ore('dustTinyVanadium') * 1)
    .inputs(ore('dustTinyZirconium') * 2)
    .inputs(ore('dustTinyTitanium') * 1)
    .fluidOutputs(fluid('aluminium_alloy_2219') * 27648)
    .material("Alumina")
    .duration(3840)
    .EUt(VA[MV])
    .buildAndRegister()

// 2195 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 32192)
    .inputs(ore('dustTinyCopper') * 36)
    .inputs(ore('dustTinyLithium') * 90)
    .inputs(ore('dustTinyManganese') * 18)
    .inputs(ore('dustTinySilver') * 3)
    .inputs(ore('dustTinyZirconium') * 1)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 34560)
    .material("Alumina")
    .duration(4800)
    .EUt(VA[MV])
    .buildAndRegister()

// Mg 6 Aluminium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 7472)
    .inputs(ore('dustTinyMagnesium') * 30)
    .inputs(ore('dustTinyManganese') * 3)
    .fluidOutputs(fluid('aluminium_alloy_mg_6') * 8000)
    .material("Alumina")
    .duration(1120)
    .EUt(VA[MV])
    .buildAndRegister()

// Magnalium
INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('ingotAluminium') * 19)
    .inputs(metaitem('ingotMagnesium'))
    .fluidOutputs(fluid('magnalium') * 2880)
    .material("Alumina")
    .EUt(VA[LV])
    .duration(1600)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('aluminium') * 2736)
    .inputs(metaitem('ingotMagnesium'))
    .fluidOutputs(fluid('magnalium') * 2880)
    .material("Alumina")
    .EUt(VA[LV])
    .buildAndRegister()

// Aluminium-Scandium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 15920)
    .inputs(ore('dustTinyScandium') * 2)
    .inputs(ore('dustTinyZirconium') * 2)
    .inputs(ore('dustTinyErbium') * 1)
    .fluidInputs(fluid('argon') * 4000)
    .fluidOutputs(fluid('scandium_alloy') * 16000)
    .material("Alumina")
    .duration(4440)
    .EUt(VA[EV])
    .buildAndRegister()

// Al–50Si Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 144)
    .inputs(ore('dustSilicon')) // Lumps
    .fluidOutputs(fluid('aluminium_50_silicon') * 288)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium'))
    .inputs(ore('dustSilicon')) // Lumps
    .fluidOutputs(fluid('aluminium_50_silicon') * 288)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–30Cu Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 1584)
    .inputs(ore('ingotCopper') * 2)
    .fluidOutputs(fluid('aluminium_30_copper') * 1872)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('ingotAluminium') * 11)
    .inputs(ore('ingotCopper') * 2)
    .fluidOutputs(fluid('aluminium_30_copper') * 1872)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Cr Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2448)
    .inputs(ore('dustChrome')) // Lumps
    .fluidOutputs(fluid('aluminium_10_chromium') * 2592)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 17)
    .inputs(ore('dustChrome')) // Lumps
    .fluidOutputs(fluid('aluminium_10_chromium') * 2592)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–50Mg Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('aluminium') * 1008)
    .inputs(ore('ingotMagnesium') * 8)
    .fluidOutputs(fluid('aluminium_50_magnesium') * 2160)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(3)
    .inputs(ore('ingotAluminium') * 7)
    .inputs(ore('ingotMagnesium') * 8)
    .fluidOutputs(fluid('aluminium_50_magnesium') * 2160)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–25Mn Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 864)
    .inputs(ore('ingotManganese')) // Briquettes
    .fluidOutputs(fluid('aluminium_25_manganese') * 1008)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 6)
    .inputs(ore('ingotManganese')) // Briquettes
    .fluidOutputs(fluid('aluminium_25_manganese') * 1008)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10V Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 5376)
    .inputs(ore('dustVanadiumPentoxide'))
    .fluidOutputs(fluid('aluminium_10_vanadium') * 5184)
    // .fluidOutputs(fluid('alumina_flux'))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Zr Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 4320)
    .inputs(metaitem('sponge.zirconium'))
    .fluidOutputs(fluid('aluminium_10_zirconium') * 4464)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 30)
    .inputs(metaitem('sponge.zirconium'))
    .fluidOutputs(fluid('aluminium_10_zirconium') * 4464)
    .duration(460)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Ti Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2304)
    .inputs(metaitem('sponge.titanium'))
    .fluidOutputs(fluid('aluminium_10_titanium') * 2448)
    .duration(30)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 16)
    .inputs(metaitem('sponge.titanium'))
    .fluidOutputs(fluid('aluminium_10_titanium') * 2448)
    .duration(254)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Li Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 1008)
    .inputs(ore('ingotLithium') * 3)
    .fluidOutputs(fluid('aluminium_10_lithium') * 1440)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 7)
    .inputs(ore('ingotLithium') * 3)
    .fluidOutputs(fluid('aluminium_10_lithium') * 1440)
    .EUt(VA[LV])
    .buildAndRegister();
