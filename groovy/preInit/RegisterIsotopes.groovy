/*
package preInit;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.Element;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import gregtech.api.unification.material.event.MaterialEvent;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 32000+ RESERVED FOR ELEMENTS


private void addNuclearFuelMaterials (Material materialName, int startingInt) {
    new Material.Builder(startingInt + 1, materialName.toString() + "_carbide")
            .ingot()
            .components(materialName, 1, Carbon, 1)
            .colorAverage()
            .build();

    new Material.Builder(startingInt + 2, materialName.toString() + "_oxide")
            .ingot()
            .components(materialName, 1, Oxygen, 2)
            .colorAverage()
            .build();

    new Material.Builder(startingInt + 3, materialName.toString() + "_nitride")
            .ingot()
            .components(materialName, 1, Nitrogen, 1)
            .colorAverage()
            .build();

    new Material.Builder(startingInt + 4, materialName.toString() + "_z_a")
            .ingot()
            .flags(DISABLE_DECOMPOSITION)
            .components(materialName, 1, Zirconium, 1)
            .colorAverage()
            .build();
}

eventManager.listen {
    MaterialEvent event ->

        log.infoMC("Running RegisterIsotopes.groovy...")

        log.infoMC("Groovy starting modifying elements")

        def Tc_99 = new Element(43, 55, -1, null, "Technetium-99", "Tc-99", true);

        new Material.Builder(31000, "technetium_99")
                .dust()
                .element(Tc_99)
                .color(0xa6a39a)
                .iconSet(SHINY)
                .build();

        def Po_210 = new Element(84, 126, -1, null, "Polonium-210", "Po-210", true);

        new Material.Builder(31010, "polonium_210")
                .dust()
                .element(Po_210)
                .color(0xe68a8a)
                .build();

        def At_209 = new Element(85, 124, -1, null, "Astatine-209", "At-209", true);

        new Material.Builder(31020, "astatine_209")
                .dust()
                .element(At_209)
                .color(0x91cca0)
                .build();

        def At_210 = new Element(85, 125, -1, null, "Astatine-210", "At-210", true);

        new Material.Builder(31021, "astatine_210")
                .dust()
                .element(At_210)
                .color(0x81b58e)
                .build();

        def At_211 = new Element(85, 126, -1, null, "Astatine-211", "At-211", true);

        new Material.Builder(31022, "astatine_211")
                .dust()
                .element(At_211)
                .color(0x6c9677)
                .build();

        def Fr_212 = new Element(87, 125, -1, null, "Francium-212", "Fr-212", true);

        new Material.Builder(31030, "francium_212")
                .dust()
                .element(Fr_212)
                .color(0xbfbf97)
                .build();

        def Fr_221 = new Element(87, 134, -1, null, "Francium-221", "Fr-221", true);

        new Material.Builder(31031, "francium_221")
                .dust()
                .element(Fr_221)
                .color(0xa3a381)
                .build();

        def Fr_222 = new Element(87, 135, -1, null, "Francium-222", "Fr-222", true);

        new Material.Builder(31032, "francium_222")
                .dust()
                .element(Fr_222)
                .color(0x8a8a6d)
                .build();

        def Fr_223 = new Element(87, 136, -1, null, "Francium-223", "Fr-223", true);

        new Material.Builder(31033, "francium_223")
                .dust()
                .element(Fr_223)
                .color(0x707058)
                .build();

        def Ra_223 = new Element(88, 135, -1, null, "Radium-223", "Ra-223", true);

        new Material.Builder(31040, "radium_223")
                .dust()
                .element(Ra_223)
                .color(0x96a37c)
                .build();

        def Ra_224 = new Element(88, 136, -1, null, "Radium-224", "Ra-224", true);

        new Material.Builder(31041, "radium_224")
                .dust()
                .element(Ra_224)
                .color(0x7f8a69)
                .build();

        def Ra_225 = new Element(88, 137, -1, null, "Radium-225", "Ra-225", true);

        new Material.Builder(31042, "radium_225")
                .dust()
                .element(Ra_225)
                .color(0x677055)
                .build();

        def Ra_226 = new Element(88, 138, -1, null, "Radium-226", "Ra-226", true);

        new Material.Builder(31043, "radium_226")
                .dust()
                .element(Ra_226)
                .color(0x545c46)
                .build();

        def Ra_228 = new Element(88, 140, -1, null, "Radium-228", "Ra-228", true);

        new Material.Builder(31044, "radium_228")
                .dust()
                .element(Ra_228)
                .color(0x414736)
                .build();

        def Ac_225 = new Element(89, 136, -1, null, "Actinium-225", "Ac-225", true);

        new Material.Builder(31050, "actinium_225")
                .dust()
                .element(Ac_225)
                .color(0x87a8a1)
                .build();

        def Ac_226 = new Element(89, 137, -1, null, "Actinium-226", "Ac-226", true);

        new Material.Builder(31051, "actinium_226")
                .dust()
                .element(Ac_226)
                .color(0x74918b)
                .build();

        def Ac_227 = new Element(89, 138, -1, null, "Actinium-227", "Ac-227", true);

        new Material.Builder(31052, "actinium_227")
                .dust()
                .element(Ac_227)
                .color(0x627a75)
                .build();

        def Pa_231 = new Element(91, 140, -1, null, "Protactinium-231", "Pa-231", true);

        new Material.Builder(31060, "protactinium_231")
                .dust()
                .element(Pa_231)
                .color(0x62727a)
                .build();

        def Pa_233 = new Element(91, 142, -1, null, "Protactinium-233", "Pa-233", true);

        new Material.Builder(31061, "protactinium_233")
                .dust()
                .element(Pa_233)
                .color(0x525f66)
                .build();

        def Th_232 = new Element(90, 142, -1, null, "Thorium-232", "Th-232", true);

        def Thorium232 = new Material.Builder(31285, "thorium_232")
                .ingot()
                .element(Th_232)
                .color(0x151c17)
                .build();

        def U_233 = new Element(92, 141, -1, null, "Uranium-233", "U-233", true);

        def Uranium233 = new Material.Builder(31070, "uranium_233")
                .fluid().ingot()
                .fluidTemp(1405)
                .element(U_233)
                .color(0x167514)
                .build();

        def Np_236 = new Element(93, 143, -1, null, "Neptunium-236", "Np-236", true);

        def Neptunium236 = new Material.Builder(31100, "neptunium_236")
                .fluid().ingot()
                .fluidTemp(917)
                .element(Np_236)
                .color(0x567699)
                .build();

        def Np_237 = new Element(93, 144, -1, null, "Neptunium-237", "Np-237", true);

        def Neptunium237 = new Material.Builder(31110, "neptunium_237")
                .fluid().ingot()
                .fluidTemp(917)
                .element(Np_237)
                .color(0x476280)
                .build();
        
        def Pu_238 = new Element(94, 144, -1, null, "Plutonium-238", "Pu-238", true);

        def Plutonium238 = new Material.Builder(31120, "plutonium_238")
                .fluid().ingot()
                .fluidTemp(913)
                .element(Pu_238)
                .color(0xd42f2f)
                .build();

        def Pu_242 = new Element(94, 148, -1, null, "Plutonium-242", "Pu-242", true);

        def Plutonium242 = new Material.Builder(31130, "plutonium_242")
                .fluid().ingot()
                .fluidTemp(913)
                .element(Pu_242)
                .color(0xa81111)
                .build();

        def Am_241 = new Element(95, 146, -1, null, "Americium-241", "Am-241", true);

        def Americium241 = new Material.Builder(31140, "americium_241")
                .fluid().ingot()
                .fluidTemp(1449)
                .element(Am_241)
                .color(0x0e474a)
                .build();

        def Am_242 = new Element(95, 147, -1, null, "Americium-242", "Am-242", true);

        def Americium242 = new Material.Builder(31150, "americium_242")
                .fluid().ingot()
                .fluidTemp(1449)
                .element(Am_242)
                .color(0x0a3336)
                .build();

        def Am_243 = new Element(95, 148, -1, null, "Americium-243", "Am-243", true);

        def Americium243 = new Material.Builder(31160, "americium_243")
                .fluid().ingot()
                .fluidTemp(1449)
                .element(Am_243)
                .color(0x092729)
                .build();

        def Cm_243 = new Element(96, 147, -1, null, "Curium-243", "Cm-243", true);

        def Curium243 = new Material.Builder(31170, "curium_243")
                .fluid().ingot()
                .fluidTemp(1613)
                .element(Cm_243)
                .color(0x4b0f73)
                .build();

        def Cm_245 = new Element(96, 149, -1, null, "Curium-245", "Cm-245", true);

        def Curium245 = new Material.Builder(31180, "curium_245")
                .fluid().ingot()
                .fluidTemp(1613)
                .element(Cm_245)
                .color(0x400f61)
                .build();

        def Cm_246 = new Element(96, 150, -1, null, "Curium-246", "Cm-246", true);

        def Curium246 = new Material.Builder(31190, "curium_246")
                .fluid().ingot()
                .fluidTemp(1613)
                .element(Cm_246)
                .color(0x360e52)
                .build();

        def Cm_247 = new Element(96, 151, -1, null, "Curium-247", "Cm-247", true);

        def Curium247 = new Material.Builder(31200, "curium_247")
                .fluid().ingot()
                .fluidTemp(1613)
                .element(Cm_247)
                .color(0x2c0d42)
                .build();

        def Bk_247 = new Element(97, 150, -1, null, "Berkelium-247", "Bk-247", true);

        def Berkelium247 = new Material.Builder(31210, "berkelium_247")
                .fluid().ingot()
                .fluidTemp(1257)
                .element(Bk_247)
                .color(0x63280f)
                .build();

        def Bk_248 = new Element(97, 151, -1, null, "Berkelium-248", "Bk-248", true);

        def Berkelium248 = new Material.Builder(31220, "berkelium_248")
                .fluid().ingot()
                .fluidTemp(1257)
                .element(Bk_248)
                .color(0x52230f)
                .build();

        def Cf_249 = new Element(98, 151, -1, null, "Californium-249", "Cf-249", true);

        def Californium249 = new Material.Builder(31230, "californium_249")
                .fluid().ingot()
                .fluidTemp(1171)
                .element(Cf_249)
                .color(0x631212)
                .build();

        def Cf_250 = new Element(98, 152, -1, null, "Californium-250", "Cf-250", true);

        def Californium250 = new Material.Builder(31240, "californium_250")
                .fluid().ingot()
                .fluidTemp(1171)
                .element(Cf_250)
                .color(0x521010)
                .build();

        def Cf_251 = new Element(98, 153, -1, null, "Californium-251", "Cf-251", true);

        def Californium251 = new Material.Builder(31250, "californium_251")
                .fluid().ingot()
                .fluidTemp(1171)
                .element(Cf_251)
                .color(0x451010)
                .build();

        def Cf_252 = new Element(98, 154, -1, null, "Californium-252", "Cf-252", true);

        def Californium252 = new Material.Builder(31260, "californium_252")
                .fluid().ingot()
                .fluidTemp(1171)
                .element(Cf_252)
                .color(0x401111)
                .build();

        def Cn_291 = new Element(112, 179, -1, null, "Copernicium-291", "Cn-291", true);

        def Copernicium291 = new Material.Builder(31310, "copernicium_291")
                .ingot()
                .element(Cn_291)
                .color(0xe0c653)
                .build();

        addNuclearFuelMaterials(Thorium232, 31330);

        addNuclearFuelMaterials(Uranium233, 31070);

        addNuclearFuelMaterials(Uranium235, 31080);

        addNuclearFuelMaterials(Uranium238, 31090);

        addNuclearFuelMaterials(Neptunium236, 31100);

        addNuclearFuelMaterials(Neptunium237, 31110);

        addNuclearFuelMaterials(Plutonium238, 31120);

        addNuclearFuelMaterials(Plutonium239, 31290);

        addNuclearFuelMaterials(Plutonium241, 31300);

        addNuclearFuelMaterials(Plutonium242, 31130);

        addNuclearFuelMaterials(Americium241, 31140);

        addNuclearFuelMaterials(Americium242, 31150);

        addNuclearFuelMaterials(Americium243, 31160);

        addNuclearFuelMaterials(Curium243, 31170);

        addNuclearFuelMaterials(Curium245, 31180);

        addNuclearFuelMaterials(Curium246, 31190);

        addNuclearFuelMaterials(Curium247, 31200);

        addNuclearFuelMaterials(Berkelium247, 31210);

        addNuclearFuelMaterials(Berkelium248, 31220);

        addNuclearFuelMaterials(Californium249, 31230);

        addNuclearFuelMaterials(Californium250, 31240);

        addNuclearFuelMaterials(Californium251, 31250);
        
        addNuclearFuelMaterials(Californium252, 31260);

        addNuclearFuelMaterials(Copernicium291, 31310);

        def B_10 = new Element(5, 5, -1, null, "Boron-10", "B-10", true);

        new Material.Builder(31270, "boron_10")
                .ingot()
                .element(B_10)
                .color(0x9c9c9c)
                .build();

        def B_11 = new Element(5, 6, -1, null, "Boron-11", "B-11", true);

        new Material.Builder(31271, "boron_11")
                .ingot()
                .element(B_11)
                .color(0x7a7a7a)
                .build();

        def Na_22 = new Element(11, 11, -1, null, "Sodium-22", "Na-22", true);

        new Material.Builder(31272, "sodium_22")
                .ingot()
                .element(Na_22)
                .color(0xb87f7f)
                .build();

        def Mg_24 = new Element(12, 12, -1, null, "Magnesium-24", "Mg-24", true);

        new Material.Builder(31273, "magnesium_24")
                .ingot()
                .element(Mg_24)
                .color(0xd6a1d4)
                .build();

        def Mg_26 = new Element(12, 14, -1, null, "Magnesium-26", "Mg-26", true);

        new Material.Builder(31274, "magnesium_26")
                .ingot()
                .element(Mg_26)
                .color(0xc49bc3)
                .build();

        def U_234 = new Element(92, 142, -1, null, "Uranium-234", "U-234", true);

        new Material.Builder(31275, "uranium_234")
                .ingot()
                .element(U_234)
                .color(0x10610f)
                .build();

        def Co_60 = new Element(27, 33, -1, null, "Cobalt-60", "Co-60", true);

        new Material.Builder(31276, "cobalt_60")
                .ingot()
                .element(Co_60)
                .color(0x326799)
                .build();

        def Ir_192 = new Element(77, 115, -1, null, "Iridium-192", "Ir-192", true);

        new Material.Builder(31277, "iridium_192")
                .ingot()
                .element(Ir_192)
                .color(0xb293ba)
                .build();

        def Ca_48 = new Element(20, 28, -1, null, "Calcium-48", "Ca-48", true);

        new Material.Builder(31278, "calcium_48")
                .dust().ingot()
                .element(Ca_48)
                .color(0xb8bd91)
                .build();

        def Sr_90 = new Element(38, 52, -1, null, "Strontium-90", "Sr-90", true);

        new Material.Builder(31280, "strontium_90")
                .ingot()
                .element(Sr_90)
                .color(0xa8a887)
                .build();

        def Ru_106 = new Element(44, 62, -1, null, "Ruthenium-106", "Ru-106", true);

        new Material.Builder(31281, "ruthenium_106")
                .ingot()
                .element(Ru_106)
                .color(0xdbdbcc)
                .build();

        def Cs_137 = new Element(55, 82, -1, null, "Caesium-137", "Cs-137", true);

        new Material.Builder(31282, "caesium_137")
                .ingot()
                .element(Cs_137)
                .color(0xc2c2be)
                .build();

        def Pm_147 = new Element(61, 86, -1, null, "Promethium-147", "Pm-147", true);

        new Material.Builder(31283, "promethium_147")
                .ingot()
                .element(Pm_147)
                .color(0xabdbb5)
                .build();

        def Eu_155 = new Element(63, 92, -1, null, "Europium-155", "Eu-155", true);

        new Material.Builder(31284, "europium_155")
                .ingot()
                .element(Eu_155)
                .color(0x403a24)
                .build();

        def Au_198 = new Element(79, 119, -1, null, "Gold-198", "Au-198", true);

        new Material.Builder(31321, "gold_198")
                .ingot()
                .element(Au_198)
                .color(0xa8a432)
                .build();

        log.infoMC("Groovy finished modifying elements")
}
*/