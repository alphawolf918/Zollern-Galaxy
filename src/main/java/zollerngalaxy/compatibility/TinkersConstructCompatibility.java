/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compatibility;

import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ArrowShaftMaterialStats;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.ProjectileMaterialStats;
import slimeknights.tconstruct.library.modifiers.IModifier;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.compatibility.tconstruct.traits.TraitCorrupted;
import zollerngalaxy.compatibility.tconstruct.traits.TraitEnlightened;
import zollerngalaxy.compatibility.tconstruct.traits.TraitInfection;
import zollerngalaxy.lib.helpers.ZGHelper;

public class TinkersConstructCompatibility {
	
	public static int totalMaterials;
	
	public static TraitInfection traitInfection = new TraitInfection();
	public static TraitEnlightened traitRadiance = new TraitEnlightened();
	public static TraitCorrupted traitCorrupted = new TraitCorrupted();
	
	public static Material materialRadium = new Material("materialRadium".toLowerCase(), 0xffff00);
	public static Material materialCorruption = new Material("materialCorruption".toLowerCase(), 0x8b008b);
	
	static {
		materialRadium.addItem("oreRadium", 1, Material.VALUE_Ore());
		materialRadium.setFluid(ZGFluids.fluidRadium);
		materialRadium.addCommonItems("Radium");
		materialRadium.setCastable(true);
		materialRadium.setCraftable(true);
		materialRadium.setRepresentativeItem("gemRadium");
		materialRadium.addTrait(traitRadiance);
		materialRadium.addStats(new HeadMaterialStats(180, 16F, 26F, 8));
		materialRadium.addStats(new HandleMaterialStats(8F, 80));
		materialRadium.addStats(new ExtraMaterialStats(80));
		materialRadium.addStats(new BowMaterialStats(28F, 8F, 14F));
		materialRadium.addStats(new ArrowShaftMaterialStats(15F, 45));
		materialRadium.addStats(new ProjectileMaterialStats());
		
		materialCorruption.addItem("oreAscendium", 1, Material.VALUE_Ore());
		// materialCorruption.setFluid(ZGFluids.fluidCorruption);
		materialCorruption.addCommonItems("Corruption");
		materialCorruption.setCastable(true);
		materialCorruption.setCraftable(true);
		materialCorruption.setRepresentativeItem("gemAscendium");
		materialCorruption.addTrait(traitCorrupted);
		materialCorruption.addStats(new HeadMaterialStats(90, 8F, 16F, 8));
		materialCorruption.addStats(new HandleMaterialStats(8F, 80));
		materialCorruption.addStats(new ExtraMaterialStats(90));
		materialCorruption.addStats(new BowMaterialStats(27F, 8F, 11F));
		materialCorruption.addStats(new ArrowShaftMaterialStats(9F, 26));
		materialCorruption.addStats(new ProjectileMaterialStats());
	}
	
	public static void init() {
		TinkersConstructCompatibility.registerMaterials(materialRadium, "Radium");
		TinkersConstructCompatibility.registerMaterials(materialCorruption, "Corruption");
		
		ZGHelper.Log("Loaded a total of " + totalMaterials + " new Tinker's Construct materials.");
		ZGHelper.Log("Initialized IMC with Tinker's Construct.");
	}
	
	private static void registerModifier(IModifier... mod) {
		for (IModifier i : mod) {
			TinkersConstructCompatibility.registerModifier(i);
		}
	}
	
	private static void registerMaterials(Material Material, String suffix) {
		TinkersConstructCompatibility.addMaterial(Material, Material.getFluid(), suffix);
	}
	
	public static void registerMaterial(Material material, Fluid fluid, String suffix) {
		if (fluid != null) {
			TinkersConstructCompatibility.integrate(material, fluid, suffix);
		} else {
			TinkerRegistry.addMaterial(material);
		}
	}
	
	private static MaterialIntegration add(MaterialIntegration integration) {
		return TinkerRegistry.integrate(integration);
	}
	
	private static MaterialIntegration integrate(Material material, Fluid fluid, String suffix) {
		return TinkersConstructCompatibility.add(new MaterialIntegration(material, fluid, suffix));
	}
	
	private static void addMaterial(Material material, Fluid fluid, String suffix) {
		TinkersConstructCompatibility.registerMaterial(material, fluid, suffix);
		totalMaterials++;
	}
}