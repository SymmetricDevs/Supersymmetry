#priority 999

import mods.devtech.machines.RegisterMachine;
import mods.devtech.machines.Overlays;
import mods.devtech.IRecipeMap;
import mods.devtech.GUITextures;
import mods.devtech.TextureArea;
import mods.devtech.OverlaySlot;
import mods.devtech.OverlayRenderer;
import mods.devtech.OverlayFace;
import mods.devtech.MoveType;
import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;
import mods.gregtech.material.MaterialCasting;
import crafttweaker.item.IItemDefinition;
import crafttweaker.item.IIngredient;
import scripts.gregtech_globals.intCircuit;

val tiers as string[] = ["ulv", "lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv"];

var fluid_de_compressor = IRecipeMap.recipeMapBuilder("fluid_de_compressor")
    .minInputs(0)
    .maxInputs(0)
    .minOutputs(0)
    .maxOutputs(0)
    .minFluidInputs(1)
    .maxFluidInputs(1)
    .minFluidOutputs(1)
    .maxFluidOutputs(1)
    .setOverlaySlots(OverlaySlot.newOverlaySlot(false, true, true, GUITextures.get("canister_overlay")),
					OverlaySlot.newOverlaySlot(true, true, true, GUITextures.get("canister_overlay")))
    .setProgressBar(TextureArea.fullImage("gregtech:textures/gui/progress_bar/progress_bar_fluid_de_compressor.png"), MoveType.HORIZONTAL)
    .build();
	
var weapons_factory = IRecipeMap.recipeMapBuilder("weapons_factory")
    .minInputs(1)
    .maxInputs(9)
    .minOutputs(0)
    .maxOutputs(1)
    .minFluidInputs(0)
    .maxFluidInputs(2)
    .minFluidOutputs(0)
    .maxFluidOutputs(0)
    .setOverlaySlots(OverlaySlot.newOverlaySlot(false, false, false, GUITextures.get("in_slot_overlay")),
					OverlaySlot.newOverlaySlot(false, false, true, GUITextures.get("in_slot_overlay")),
					OverlaySlot.newOverlaySlot(false, true, false, GUITextures.get("canister_overlay")),
					OverlaySlot.newOverlaySlot(false, true, true, GUITextures.get("canister_overlay")),
					OverlaySlot.newOverlaySlot(true, false, true, GUITextures.get("out_slot_overlay")))
    .setProgressBar(TextureArea.fullImage("gregtech:textures/gui/progress_bar/progress_bar_weapons_factory.png"), MoveType.HORIZONTAL)
    .build();
	
for i in 1 to 9 {
	RegisterMachine.CreateSimpleMachine((15999 + i), "fluid_de_compressor." + tiers[i], fluid_de_compressor, Overlays.get("electromagnetic_separator"), i);
	RegisterMachine.CreateSimpleMachine((16008 + i), "weapons_factory." + tiers[i], weapons_factory, Overlays.get("assembler"), i);
}