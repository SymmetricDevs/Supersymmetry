import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// 6061 Aluminium Alloy - Magnesium master alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10800)
    .inputs(ore('ingotAluminium50Magnesium') * 2)
    .inputs(ore('ingotAluminium50Silicon'))
    .inputs(ore('ingotAluminium20Copper'))
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_6061') * 11520)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 75)
    .inputs(ore('ingotAluminium50Magnesium') * 2)
    .inputs(ore('ingotAluminium50Silicon'))
    .inputs(ore('ingotAluminium20Copper'))
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_6061') * 11520)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 6061 Aluminium Alloy - Pure magnesium
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 10224)
    .inputs(ore('ingotMagnesium'))
    .inputs(ore('ingotAluminium50Silicon'))
    .inputs(ore('ingotAluminium20Copper'))
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_6061') * 10800)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 71)
    .inputs(ore('ingotMagnesium'))
    .inputs(ore('ingotAluminium50Silicon'))
    .inputs(ore('ingotAluminium20Copper'))
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_6061') * 10800)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 7075 Aluminium Alloy - Pure magnesium and copper
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 15120)
    .inputs(ore('ingotZinc') * 3)
    .inputs(ore('ingotMagnesium') * 3)
    .inputs(ore('ingotCopper'))
    .inputs(ore('ingotAluminium10Chromium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 16416)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 105)
    .inputs(ore('ingotZinc') * 3)
    .inputs(ore('ingotMagnesium') * 3)
    .inputs(ore('ingotCopper'))
    .inputs(ore('ingotAluminium10Chromium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 16416)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 7075 Aluminium Alloy - Magnesium master alloy and pure copper
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 14688)
    .inputs(ore('ingotZinc') * 3)
    .inputs(ore('ingotAluminium50Magnesium') * 6)
    .inputs(ore('ingotCopper'))
    .inputs(ore('ingotAluminium10Chromium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 16416)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 102)
    .inputs(ore('ingotZinc') * 3)
    .inputs(ore('ingotAluminium50Magnesium') * 6)
    .inputs(ore('ingotCopper'))
    .inputs(ore('ingotAluminium10Chromium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_7075') * 16416)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 7075 Aluminium Alloy - Pure magnesium and copper master alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 4752)
    .inputs(ore('ingotZinc'))
    .inputs(ore('ingotMagnesium'))
    .inputs(ore('ingotAluminium20Copper') * 3)
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_7075') * 5616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 33)
    .inputs(ore('ingotZinc'))
    .inputs(ore('ingotMagnesium'))
    .inputs(ore('ingotAluminium20Copper') * 3)
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_7075') * 5616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 7075 Aluminium Alloy - Magnesium and copper master alloys
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 4608)
    .inputs(ore('ingotZinc'))
    .inputs(ore('ingotAluminium50Magnesium') * 2)
    .inputs(ore('ingotAluminium20Copper') * 3)
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_7075') * 5616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 32)
    .inputs(ore('ingotZinc'))
    .inputs(ore('ingotAluminium50Magnesium') * 2)
    .inputs(ore('ingotAluminium20Copper') * 3)
    .inputs(ore('ingotAluminium10Chromium'))
    .fluidOutputs(fluid('aluminium_alloy_7075') * 5616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2219 Aluminium Alloy - Pure copper
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 8640)
    .inputs(ore('ingotCopper') * 2)
    .inputs(ore('ingotAluminium10Manganese') * 2)
    .inputs(ore('ingotAluminium10Vanadium'))
    .inputs(ore('ingotAluminium5Zirconium'))
    .inputs(ore('ingotAluminium5Titanium'))
    .fluidOutputs(fluid('aluminium_alloy_2219') * 9648)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 60)
    .inputs(ore('ingotCopper') * 2)
    .inputs(ore('ingotAluminium10Manganese') * 2)
    .inputs(ore('ingotAluminium10Vanadium'))
    .inputs(ore('ingotAluminium5Zirconium'))
    .inputs(ore('ingotAluminium5Titanium'))
    .fluidOutputs(fluid('aluminium_alloy_2219') * 9648)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2219 Aluminium Alloy - Copper master alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 5184)
    .inputs(ore('ingotAluminium20Copper') * 14)
    .inputs(ore('ingotAluminium10Manganese'))
    .inputs(ore('ingotAluminium10Vanadium'))
    .inputs(ore('ingotAluminium5Zirconium'))
    .inputs(ore('ingotAluminium5Titanium'))
    .fluidOutputs(fluid('aluminium_alloy_2219') * 7776)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 36)
    .inputs(ore('ingotAluminium20Copper') * 14)
    .inputs(ore('ingotAluminium10Manganese'))
    .inputs(ore('ingotAluminium10Vanadium'))
    .inputs(ore('ingotAluminium5Zirconium'))
    .inputs(ore('ingotAluminium5Titanium'))
    .fluidOutputs(fluid('aluminium_alloy_2219') * 7776)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2195 Aluminium Alloy - Copper master alloy and pure silver
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 68400)
    .inputs(ore('ingotAluminium20Copper') * 105)
    .inputs(ore('ingotAluminium10Lithium') * 70)
    .inputs(ore('ingotAluminium50Magnesium') * 4)
    .inputs(ore('ingotSilver'))
    .inputs(ore('ingotAluminium5Zirconium') * 10)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 95760)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 475)
    .inputs(ore('ingotAluminium20Copper') * 105)
    .inputs(ore('ingotAluminium10Lithium') * 70)
    .inputs(ore('ingotAluminium50Magnesium') * 4)
    .inputs(ore('ingotSilver'))
    .inputs(ore('ingotAluminium5Zirconium') * 10)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 95760)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2195 Aluminium Alloy - Pure copper and silver
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 81792)
    .inputs(ore('ingotCopper') * 11)
    .inputs(ore('ingotAluminium10Lithium') * 70)
    .inputs(ore('ingotAluminium50Magnesium') * 4)
    .inputs(ore('ingotSilver'))
    .inputs(ore('ingotAluminium5Zirconium') * 10)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 95616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 568)
    .inputs(ore('ingotCopper') * 11)
    .inputs(ore('ingotAluminium10Lithium') * 70)
    .inputs(ore('ingotAluminium50Magnesium') * 4)
    .inputs(ore('ingotSilver'))
    .inputs(ore('ingotAluminium5Zirconium') * 10)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 95616)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2195 Aluminium Alloy - Pure copper and silver master alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 12960)
    .inputs(ore('ingotCopper') * 2)
    .inputs(ore('ingotAluminium10Lithium') * 12)
    .inputs(ore('ingotAluminium50Magnesium'))
    .inputs(ore('ingotAluminium10Silver') * 3)
    .inputs(ore('ingotAluminium5Zirconium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 15840)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 90)
    .inputs(ore('ingotCopper') * 2)
    .inputs(ore('ingotAluminium10Lithium') * 12)
    .inputs(ore('ingotAluminium50Magnesium'))
    .inputs(ore('ingotAluminium10Silver') * 3)
    .inputs(ore('ingotAluminium5Zirconium') * 2)
    .fluidOutputs(fluid('aluminium_alloy_2195') * 15840)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// 2195 Aluminium Alloy - Copper and silver master alloys
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 5760)
    .inputs(ore('ingotAluminium20Copper') * 10)
    .inputs(ore('ingotAluminium10Lithium') * 7)
    .inputs(ore('ingotAluminium50Magnesium'))
    .inputs(ore('ingotAluminium10Silver') * 2)
    .inputs(ore('ingotAluminium5Zirconium'))
    .fluidOutputs(fluid('aluminium_alloy_2195') * 8784)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 40)
    .inputs(ore('ingotAluminium20Copper') * 10)
    .inputs(ore('ingotAluminium10Lithium') * 7)
    .inputs(ore('ingotAluminium50Magnesium'))
    .inputs(ore('ingotAluminium10Silver') * 2)
    .inputs(ore('ingotAluminium5Zirconium'))
    .fluidOutputs(fluid('aluminium_alloy_2195') * 8784)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// AMg6 Aluminium Alloy - Pure magnesium
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 26496)
    .inputs(ore('ingotMagnesium') * 14)
    .inputs(ore('ingotAluminium10Manganese') * 10)
    .inputs(ore('ingotAluminium5Titanium'))
    .inputs(ore('ingotAluminium1Beryllium'))
    .fluidOutputs(fluid('aluminium_alloy_mg_6') * 30240)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 184)
    .inputs(ore('ingotMagnesium') * 14)
    .inputs(ore('ingotAluminium10Manganese') * 10)
    .inputs(ore('ingotAluminium5Titanium'))
    .inputs(ore('ingotAluminium1Beryllium'))
    .fluidOutputs(fluid('aluminium_alloy_mg_6') * 30240)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

// AMg6 Aluminium Alloy - Magnesium master alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 24768)
    .inputs(ore('ingotAluminium50Magnesium') * 26)
    .inputs(ore('ingotAluminium10Manganese') * 10)
    .inputs(ore('ingotAluminium5Titanium'))
    .inputs(ore('ingotAluminium1Beryllium'))
    .fluidOutputs(fluid('aluminium_alloy_mg_6') * 30240)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 172)
    .inputs(ore('ingotAluminium50Magnesium') * 26)
    .inputs(ore('ingotAluminium10Manganese') * 10)
    .inputs(ore('ingotAluminium5Titanium'))
    .inputs(ore('ingotAluminium1Beryllium'))
    .fluidOutputs(fluid('aluminium_alloy_mg_6') * 30240)
    .material("Alumina")
    .EUt(VA[MV])
    .buildAndRegister();

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

// Al–20Cu Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('aluminium') * 1296)
    .inputs(ore('ingotCopper'))
    .fluidOutputs(fluid('aluminium_20_copper') * 1440)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('ingotAluminium') * 9)
    .inputs(ore('ingotCopper'))
    .fluidOutputs(fluid('aluminium_20_copper') * 1440)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Ag Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('aluminium') * 4752)
    .inputs(ore('ingotSilver'))
    .fluidOutputs(fluid('aluminium_10_silver') * 4896)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('ingotAluminium') * 33)
    .inputs(ore('ingotSilver'))
    .fluidOutputs(fluid('aluminium_10_silver') * 4896)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Cr Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2304)
    .inputs(ore('dustChrome')) // Lumps
    .fluidOutputs(fluid('aluminium_10_chromium') * 2448)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 16)
    .inputs(ore('dustChrome')) // Lumps
    .fluidOutputs(fluid('aluminium_10_chromium') * 2448)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10Mn Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 2448)
    .inputs(ore('ingotManganese')) // Briquettes
    .fluidOutputs(fluid('aluminium_10_manganese') * 2592)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 17)
    .inputs(ore('ingotManganese')) // Briquettes
    .fluidOutputs(fluid('aluminium_10_manganese') * 2592)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–10V Master Alloy
// Assumes one dustVanadiumPentoxide is one V2O5 formula-equivalent.
// Aluminium input includes the aluminium consumed in oxide reduction.
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 5088)
    .inputs(ore('dustVanadiumPentoxide'))
    .fluidOutputs(fluid('aluminium_10_vanadium') * 4896)
// .fluidOutputs(fluid('alumina_flux') * 240)
    .duration(200)
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

// Al–5Zr Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 8496)
    .inputs(metaitem('sponge.zirconium'))
    .fluidOutputs(fluid('aluminium_5_zirconium') * 8640)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 59)
    .inputs(metaitem('sponge.zirconium'))
    .fluidOutputs(fluid('aluminium_5_zirconium') * 8640)
    .duration(460)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–5Ti Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 4464)
    .inputs(metaitem('sponge.titanium'))
    .fluidOutputs(fluid('aluminium_5_titanium') * 4608)
    .duration(30)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 31)
    .inputs(metaitem('sponge.titanium'))
    .fluidOutputs(fluid('aluminium_5_titanium') * 4608)
    .duration(254)
    .EUt(VA[LV])
    .buildAndRegister();

// Al–1Be Master Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 4464)
    .inputs(ore('ingotBeryllium'))
    .fluidOutputs(fluid('aluminium_1_beryllium') * 4608)
    .EUt(VA[LV])
    .buildAndRegister();

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('ingotAluminium') * 31)
    .inputs(ore('ingotBeryllium'))
    .fluidOutputs(fluid('aluminium_1_beryllium') * 4608)
    .EUt(VA[LV])
    .buildAndRegister();
