/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items;

import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.armor.ZGArmor;
import zollerngalaxy.items.armor.ZGArmorMats;
import zollerngalaxy.items.crops.ZGItemSeedFood;
import zollerngalaxy.items.food.IceCream;
import zollerngalaxy.items.food.ItemSweetFood;
import zollerngalaxy.items.food.PopcornBowl;
import zollerngalaxy.items.food.ZGItemFood;
import zollerngalaxy.items.healing.ItemHeart;
import zollerngalaxy.items.healing.ItemHeartForce;
import zollerngalaxy.items.healing.ItemMedkit;
import zollerngalaxy.items.tools.ItemBedrockBreaker;
import zollerngalaxy.items.tools.ItemOmnitool;
import zollerngalaxy.items.tools.ItemTunneler;
import zollerngalaxy.items.tools.ZGItemAxe;
import zollerngalaxy.items.tools.ZGItemHoe;
import zollerngalaxy.items.tools.ZGItemPickaxe;
import zollerngalaxy.items.tools.ZGItemShovel;
import zollerngalaxy.items.tools.ZGItemSword;
import zollerngalaxy.items.tools.ZGToolMats;
import zollerngalaxy.items.tools.keys.ItemKeyZG;
import zollerngalaxy.items.tools.power.ItemEnderSword;
import zollerngalaxy.items.tools.power.ItemFireSword;
import zollerngalaxy.items.tools.power.ItemIceSword;
import zollerngalaxy.items.tools.power.ItemLightSword;
import zollerngalaxy.items.tools.power.ItemThorSword;
import zollerngalaxy.items.tools.power.ItemWitherSword;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGItems {
	
	private static int totalItems = 0;
	
	public static final Item heartium = new ZGItemBase("heartofzol");
	public static final Item zolCrystal = new ZGItemBase("zolluscrystal");
	public static final Item kriffCrystal = new ZGItemBase("kriffoncrystal");
	public static final Item purgCrystal = new ZGItemBase("purgotcrystal");
	public static final Item edenCrystal = new ZGItemBase("edencrystal");
	public static final Item purgEssence = new ZGItemBase("purgotessence");
	public static final Item prometheanCrystal = new ZGItemBase("prometheancrystal");
	public static final Item plutoniumCrystal = new ZGItemBase("plutoniumcrystal");
	public static final Item azurite = new ZGItemBase("azurite");
	public static final Item ascendium = new ZGItemBase("ascendium");
	public static final Item rokkite = new ZGItemBase("rokkite");
	public static final Item stormCrystal = new ZGItemBase("stormcrystalgem");
	
	public static final Item perdGlowdust = new ZGItemBase("perdglowstonedust");
	public static final Item perdDiamond = new ZGItemBase("perddiamond");
	public static final Item perdEtrium = new ZGItemBase("etrium");
	
	// Gems
	public static final Item amber = new ZGItemBase("amber");
	public static final Item topaz = new ZGItemBase("topaz");
	public static final Item opal = new ZGItemBase("opal");
	public static final Item aquamarine = new ZGItemBase("aquamarine");
	public static final Item garnet = new ZGItemBase("garnet");
	public static final Item ruby = new ZGItemBase("ruby");
	public static final Item sapphire = new ZGItemBase("sapphire");
	public static final Item amberStatic = new ZGItemBase("staticamber");
	public static final Item garnetFire = new ZGItemBase("firegarnet");
	public static final Item aquamarineIcy = new ZGItemBase("icyaqua");
	public static final Item witherite = new ZGItemBase("witherite");
	public static final Item netheridium = new ZGItemBase("netheridium");
	public static final Item radium = new ZGItemBase("radium");
	
	// Dust
	public static final Item dustVirinium = new ZGItemBase("rawviri");
	public static final Item dustCobalt = new ZGItemBase("cobaltdust");
	public static final Item dustEvenium = new ZGItemBase("eveniumdust");
	public static final Item dustFueltonium = new ZGItemBase("fueltoniumraw");
	public static final Item dustDiamond = new ZGItemBase("diamonddust");
	public static final Item dustEmerald = new ZGItemBase("emeralddust");
	public static final Item dustBrightstone = new ZGItemBase("brightstonedust");
	public static final Item dustShinestone = new ZGItemBase("shinestonedust");
	public static final Item dustShinium = new ZGItemBase("shiniumdust");
	public static final Item dustChargium = new ZGItemBase("chargiumdust");
	public static final Item dustAmaranth = new ZGItemBase("amaranthdust");
	public static final Item dustZollernium = new ZGItemBase("zollerniumdust");
	public static final Item dustZinc = new ZGItemBase("zincdust");
	public static final Item dustZucrite = new ZGItemBase("zucritedust");
	public static final Item dustRhodium = new ZGItemBase("rhodiumdust");
	public static final Item dustPlutonium = new ZGItemBase("plutoniumdust");
	public static final Item dustEnrichment = new ZGItemBase("enrichmentdust");
	public static final Item dustObsidian = new ZGItemBase("obsidiandust");
	
	// Ingots
	public static final Item ingotVirinium = new ZGItemBase("ingotviri");
	public static final Item ingotCobalt = new ZGItemBase("ingotcobalt");
	public static final Item ingotEvenium = new ZGItemBase("ingotevenium");
	public static final Item ingotFueltonium = new ZGItemBase("fueltoniumingot");
	public static final Item ingotShinestone = new ZGItemBase("shinestoneingot");
	public static final Item ingotShinium = new ZGItemBase("shiniumingot");
	public static final Item ingotChargium = new ZGItemBase("chargiumingot");
	public static final Item ingotLapis = new ZGItemBase("lapisingot");
	public static final Item ingotAmaranth = new ZGItemBase("amaranthingot");
	public static final Item ingotAscendantAmaranth = new ZGItemBase("ascendantamaranthingot");
	public static final Item ingotZollernium = new ZGItemBase("zollerniumingot");
	public static final Item ingotZinc = new ZGItemBase("zincingot");
	public static final Item ingotEtrium = new ZGItemBase("etriumingot");
	public static final Item ingotZucrite = new ZGItemBase("zucriteingot");
	public static final Item ingotRhodium = new ZGItemBase("rhodiumingot");
	public static final Item ingotRadium = new ZGItemBase("radiumingot");
	public static final Item ingotPlutonium = new ZGItemBase("plutoniumingot");
	public static final Item ingotObsidian = new ZGItemBase("obsidianingot");
	
	public static final Item hud = new ItemHUD();
	public static final Item alienStone = new ZGItemBase("alienstone");
	
	public static final Item superChargedCoal = new ItemFuelBase("superchargedcoal", 12800);
	public static final Item powerStick = new ZGItemBase("powerstick");
	public static final Item lapisStick = new ZGItemBase("lapisstick");
	
	public static final Item mudClayBall = new ZGItemBase("mudclayball");
	
	// Compressed Metals
	public static final Item compressedCobalt = new ZGItemBase("compressedcobalt");
	public static final Item compressedDiamond = new ZGItemBase("compresseddiamond");
	public static final Item compressedEmerald = new ZGItemBase("compressedemerald");
	public static final Item compressedEvenium = new ZGItemBase("compressedevenium");
	public static final Item compressedGold = new ZGItemBase("compressedgold");
	public static final Item compressedHeartium = new ZGItemBase("compressedheartium");
	public static final Item compressedKriffonium = new ZGItemBase("compressedkriffonium");
	public static final Item compressedVirinium = new ZGItemBase("compressedvirinium");
	public static final Item compressedVyrex = new ZGItemBase("compressedvyrex");
	public static final Item compressedPromethean = new ZGItemBase("compressedpromethean");
	public static final Item compressedSuperChargedCoal = new ZGItemBase("compressedsuperchargedcoal");
	public static final Item compressedRiven = new ZGItemBase("compressedriven");
	public static final Item compressedAmaranth = new ZGItemBase("compressedamaranth");
	public static final Item compressedAzurite = new ZGItemBase("compressedazurite");
	public static final Item compressedZollernium = new ZGItemBase("compressedzollernium");
	public static final Item compressedZucrite = new ZGItemBase("compressedzucrite");
	public static final Item compressedRhodium = new ZGItemBase("compressedrhodium");
	public static final Item compressedAscendantAmaranth = new ZGItemBase("compressedascendantamaranth");
	
	// Foods
	public static final Item rawAlienBacon = new ZGItemFood("alienbaconraw", 2, 1.5F, true);
	public static final Item rawAlienBeef = new ZGItemFood("alienbeefraw", 2, 1.5F, true);
	public static final Item cookedAlienBacon = new ZGItemFood("alienbaconcooked", 6, 4.0F, true);
	public static final Item cookedAlienBeef = new ZGItemFood("alienbeefcooked", 6, 4.0F, true);
	public static final Item edenFruit = new ZGItemFood("fruitofeden", 4, 2.5F, false);
	public static final Item perdBerry = new ZGItemFood("perdberry", 8, 3.6F, false);
	public static final Item perdPeach = new ZGItemFood("perdpeach", 13, 8.2F, false);
	//
	public static final Item cherry = new ZGItemFood("cherry", 4, 4.2F, false);
	public static final Item banana = new ZGItemFood("banana", 6, 8.4F, false);
	public static final Item guava = new ZGItemFood("guava", 8, 10.4F, false);
	public static final Item peach = new ZGItemFood("peach", 10, 8.4F, false);
	public static final Item grapefruit = new ZGItemFood("grapefruit", 14, 13.4F, false);
	public static final Item orange = new ZGItemFood("orange", 7, 6.5F, false);
	public static final Item lemon = new ZGItemFood("lemon", 6, 7.5F, false);
	public static final Item lime = new ZGItemFood("lime", 6, 7.5F, false);
	public static final Item limon = new ZGItemFood("limon", 8, 9.2F, false);
	public static final Item pea = new ZGItemFood("pea", 2, 0.5F, false);
	public static final Item cornKernel = new ZGItemFood("cornkernel", 1, 0.3F, false);
	public static final Item popcorn = new ZGItemFood("popcorn", 3, 0.9F, false);
	public static final Item popcornBowl = new PopcornBowl();
	//
	public static final Item rawBlubberFish = new ZGItemFood("rawblubberfish", 1, 0.2F, false);
	public static final Item rawBladeFish = new ZGItemFood("rawbladefish", 1, 0.2F, false);
	public static final Item rawGypsyFish = new ZGItemFood("rawgypsyfish", 1, 0.2F, false);
	public static final Item cookedBlubberFish = new ZGItemFood("cookedblubberfish", 6, 2.4F, false);
	public static final Item cookedBladeFish = new ZGItemFood("cookedbladefish", 6, 2.4F, false);
	public static final Item cookedGypsyFish = new ZGItemFood("cookedgypsyfish", 6, 2.4F, false);
	
	public static final Item perdReed = new ZGItemSpecial("perdreed", ZGBlocks.perdReeds);
	
	public static final Item darkEssence = new ZGItemBase("shadowessence");
	
	// Sweet Foods
	public static final Item creamBall = new ZGItemBase("creamball");
	public static final Item chocolateRaw = new ZGItemBase("rawchocolate");
	public static final Item chocolateBar = new ItemSweetFood("chocolatebar", MobEffects.JUMP_BOOST);
	public static final Item brownie = new ItemSweetFood("brownie", MobEffects.RESISTANCE);
	public static final Item candyApple = new ItemSweetFood("candyapple", MobEffects.SPEED);
	public static final Item iceCreamSandwich = new ItemSweetFood("icecreamsandwich", MobEffects.STRENGTH);
	public static final Item iceCream = new IceCream();
	public static final Item chocolateStrawberry = new ItemSweetFood("strawberry_chocolate", MobEffects.ABSORPTION);
	
	// Dungeon Keys
	public static final Item edenDungeonKey = new ZGItemBase("edendungeonkey");
	public static final Item shadeKey = new ZGItemBase("shadekey");
	public static final Item tlalocDungeonKey = new ItemKeyZG("tlalocdungeonkey", 10);
	
	// Shark Stuff
	public static final Item shagreen = new ZGItemBase("shagreen");
	public static final Item sharkTooth = new ZGItemBase("sharktooth");
	public static final Item shadowBone = new ZGItemBase("shadowbone");
	
	// Stargates
	public static final Item starGateTier1 = new ItemStargate(1);
	public static final Item starGateTier2 = new ItemStargate(2);
	public static final Item starGateTier3 = new ItemStargate(3);
	public static final Item starGateTier4 = new ItemStargate(4);
	public static final Item starGateTier5 = new ItemStargate(5);
	public static final Item starGateTier6 = new ItemStargate(6);
	public static final Item starGateTier7 = new ItemStargate(7);
	public static final Item starGateTier8 = new ItemStargate(8);
	public static final Item starGateTier9 = new ItemStargate(9);
	public static final Item starGateTier10 = new ItemStargate(10);
	public static final Item starGateCandy = new ItemStargate(918);
	
	// Tools
	public static final Item OMNITOOL = new ItemOmnitool();
	public static final Item BEDROCK_BREAKER = new ItemBedrockBreaker();
	
	// Pickaxes
	public static final Item pickaxeCobalt = new ZGItemPickaxe("cobalt", ZGToolMats.COBALT);
	public static final Item pickaxeEvenium = new ZGItemPickaxe("evenium", ZGToolMats.EVENIUM);
	public static final Item pickaxeVirinium = new ZGItemPickaxe("virinium", ZGToolMats.VIRINIUM);
	public static final Item pickaxeAmaranth = new ZGItemPickaxe("amaranth", ZGToolMats.AMARANTH);
	public static final Item pickaxeAzurite = new ZGItemPickaxe("azurite", ZGToolMats.AZURITE);
	public static final Item pickaxeZollernium = new ZGItemPickaxe("zollernium", ZGToolMats.ZOLLERNIUM);
	public static final Item pickaxeRuby = new ZGItemPickaxe("ruby", ZGToolMats.RUBY);
	public static final Item pickaxeSapphire = new ZGItemPickaxe("sapphire", ZGToolMats.SAPPHIRE);
	
	// Shovels
	public static final Item shovelCobalt = new ZGItemShovel("cobalt", ZGToolMats.COBALT);
	public static final Item shovelEvenium = new ZGItemShovel("evenium", ZGToolMats.EVENIUM);
	public static final Item shovelVirinium = new ZGItemShovel("virinium", ZGToolMats.VIRINIUM);
	public static final Item shovelAmaranth = new ZGItemShovel("amaranth", ZGToolMats.AMARANTH);
	public static final Item shovelAzurite = new ZGItemShovel("azurite", ZGToolMats.AZURITE);
	public static final Item shovelZollernium = new ZGItemShovel("zollernium", ZGToolMats.ZOLLERNIUM);
	public static final Item shovelRuby = new ZGItemShovel("ruby", ZGToolMats.RUBY);
	public static final Item shovelSapphire = new ZGItemShovel("sapphire", ZGToolMats.SAPPHIRE);
	
	// Axes
	public static final Item axeCobalt = new ZGItemAxe("cobalt", ZGToolMats.COBALT);
	public static final Item axeEvenium = new ZGItemAxe("evenium", ZGToolMats.EVENIUM);
	public static final Item axeVirinium = new ZGItemAxe("virinium", ZGToolMats.VIRINIUM);
	public static final Item axeAmaranth = new ZGItemAxe("amaranth", ZGToolMats.AMARANTH);
	public static final Item axeAzurite = new ZGItemAxe("azurite", ZGToolMats.AZURITE);
	public static final Item axeZollernium = new ZGItemAxe("zollernium", ZGToolMats.ZOLLERNIUM);
	public static final Item axeRuby = new ZGItemAxe("ruby", ZGToolMats.RUBY);
	public static final Item axeSapphire = new ZGItemAxe("sapphire", ZGToolMats.SAPPHIRE);
	
	// Hoes
	public static final Item hoeCobalt = new ZGItemHoe("cobalt", ZGToolMats.COBALT);
	public static final Item hoeEvenium = new ZGItemHoe("evenium", ZGToolMats.EVENIUM);
	public static final Item hoeVirinium = new ZGItemHoe("virinium", ZGToolMats.VIRINIUM);
	public static final Item hoeAmaranth = new ZGItemHoe("amaranth", ZGToolMats.AMARANTH);
	public static final Item hoeAzurite = new ZGItemHoe("azurite", ZGToolMats.AZURITE);
	public static final Item hoeZollernium = new ZGItemHoe("zollernium", ZGToolMats.ZOLLERNIUM);
	public static final Item hoeRuby = new ZGItemHoe("ruby", ZGToolMats.RUBY);
	public static final Item hoeSapphire = new ZGItemHoe("sapphire", ZGToolMats.SAPPHIRE);
	
	// Swords
	public static final Item swordCobalt = new ZGItemSword("cobalt", ZGToolMats.COBALT);
	public static final Item swordEvenium = new ZGItemSword("evenium", ZGToolMats.EVENIUM);
	public static final Item swordVirinium = new ZGItemSword("virinium", ZGToolMats.VIRINIUM);
	public static final Item swordAmaranth = new ZGItemSword("amaranth", ZGToolMats.AMARANTH);
	public static final Item swordAzurite = new ZGItemSword("azurite", ZGToolMats.AZURITE);
	public static final Item swordZollernium = new ZGItemSword("zollernium", ZGToolMats.ZOLLERNIUM);
	public static final Item swordRuby = new ZGItemSword("ruby", ZGToolMats.RUBY);
	public static final Item swordSapphire = new ZGItemSword("sapphire", ZGToolMats.SAPPHIRE);
	public static final Item swordWither = new ItemWitherSword();
	public static final Item swordFire = new ItemFireSword();
	public static final Item swordThor = new ItemThorSword();
	public static final Item swordEnder = new ItemEnderSword();
	public static final Item swordIce = new ItemIceSword();
	public static final Item swordLight = new ItemLightSword();
	
	// Tunnelers
	public static final Item tunnelerCopper = new ItemTunneler("copper", 1000);
	public static final Item tunnelerGold = new ItemTunneler("gold", 2000);
	public static final Item tunnelerAmaranth = new ItemTunneler("amaranth", 4000);
	
	// Armor (Helmets)
	public static final Item helmetWood = new ZGArmor(ZGArmorMats.WOOD, 1, EntityEquipmentSlot.HEAD, "woodhelmet");
	public static final Item helmetStone = new ZGArmor(ZGArmorMats.STONE, 1, EntityEquipmentSlot.HEAD, "stonehelmet");
	public static final Item helmetAmaranth = new ZGArmor(ZGArmorMats.AMARANTH, 1, EntityEquipmentSlot.HEAD, "amaranthhelmet");
	public static final Item helmetZollernium = new ZGArmor(ZGArmorMats.ZOLLERNIUM, 1, EntityEquipmentSlot.HEAD, "zollerniumhelmet");
	public static final Item helmetAzurite = new ZGArmor(ZGArmorMats.AZURITE, 1, EntityEquipmentSlot.HEAD, "azuritehelmet");
	public static final Item helmetRadium = new ZGArmor(ZGArmorMats.RADIUM, 1, EntityEquipmentSlot.HEAD, "radiumhelmet");
	public static final Item helmetRuby = new ZGArmor(ZGArmorMats.RUBY, 1, EntityEquipmentSlot.HEAD, "rubyhelmet");
	public static final Item helmetSapphire = new ZGArmor(ZGArmorMats.SAPPHIRE, 1, EntityEquipmentSlot.HEAD, "sapphirehelmet");
	
	// Armor (Chestplates)
	public static final Item chestWood = new ZGArmor(ZGArmorMats.WOOD, 1, EntityEquipmentSlot.CHEST, "woodchestplate");
	public static final Item chestStone = new ZGArmor(ZGArmorMats.STONE, 1, EntityEquipmentSlot.CHEST, "stonechestplate");
	public static final Item chestAmaranth = new ZGArmor(ZGArmorMats.AMARANTH, 1, EntityEquipmentSlot.CHEST, "amaranthchestplate");
	public static final Item chestZollernium = new ZGArmor(ZGArmorMats.ZOLLERNIUM, 1, EntityEquipmentSlot.CHEST, "zollerniumchestplate");
	public static final Item chestAzurite = new ZGArmor(ZGArmorMats.AZURITE, 1, EntityEquipmentSlot.CHEST, "azuritechestplate");
	public static final Item chestRadium = new ZGArmor(ZGArmorMats.RADIUM, 1, EntityEquipmentSlot.CHEST, "radiumchestplate");
	public static final Item chestRuby = new ZGArmor(ZGArmorMats.RUBY, 1, EntityEquipmentSlot.CHEST, "rubychestplate");
	public static final Item chestSapphire = new ZGArmor(ZGArmorMats.SAPPHIRE, 1, EntityEquipmentSlot.CHEST, "sapphirechestplate");
	
	// Armor (Leggings)
	public static final Item legsWood = new ZGArmor(ZGArmorMats.WOOD, 2, EntityEquipmentSlot.LEGS, "woodleggings");
	public static final Item legsStone = new ZGArmor(ZGArmorMats.STONE, 2, EntityEquipmentSlot.LEGS, "stoneleggings");
	public static final Item legsAmaranth = new ZGArmor(ZGArmorMats.AMARANTH, 2, EntityEquipmentSlot.LEGS, "amaranthleggings");
	public static final Item legsZollernium = new ZGArmor(ZGArmorMats.ZOLLERNIUM, 2, EntityEquipmentSlot.LEGS, "zollerniumleggings");
	public static final Item legsAzurite = new ZGArmor(ZGArmorMats.AZURITE, 2, EntityEquipmentSlot.LEGS, "azuriteleggings");
	public static final Item legsRadium = new ZGArmor(ZGArmorMats.RADIUM, 2, EntityEquipmentSlot.LEGS, "radiumleggings");
	public static final Item legsRuby = new ZGArmor(ZGArmorMats.RUBY, 2, EntityEquipmentSlot.LEGS, "rubyleggings");
	public static final Item legsSapphire = new ZGArmor(ZGArmorMats.SAPPHIRE, 2, EntityEquipmentSlot.LEGS, "sapphireleggings");
	
	// Armor (Boots)
	public static final Item bootsWood = new ZGArmor(ZGArmorMats.WOOD, 1, EntityEquipmentSlot.FEET, "woodboots");
	public static final Item bootsStone = new ZGArmor(ZGArmorMats.STONE, 1, EntityEquipmentSlot.FEET, "stoneboots");
	public static final Item bootsAmaranth = new ZGArmor(ZGArmorMats.AMARANTH, 1, EntityEquipmentSlot.FEET, "amaranthboots");
	public static final Item bootsZollernium = new ZGArmor(ZGArmorMats.ZOLLERNIUM, 1, EntityEquipmentSlot.FEET, "zollerniumboots");
	public static final Item bootsAzurite = new ZGArmor(ZGArmorMats.AZURITE, 1, EntityEquipmentSlot.FEET, "azuriteboots");
	public static final Item bootsRadium = new ZGArmor(ZGArmorMats.RADIUM, 1, EntityEquipmentSlot.FEET, "radiumboots");
	public static final Item bootsRuby = new ZGArmor(ZGArmorMats.RUBY, 1, EntityEquipmentSlot.FEET, "rubyboots");
	public static final Item bootsSapphire = new ZGArmor(ZGArmorMats.SAPPHIRE, 2, EntityEquipmentSlot.LEGS, "sapphireboots");
	
	// Blueprints
	public static final Item blueprintCorruption = new ItemBlueprint("corruption").setTooltipText("tooltips.blueprint_corruption");
	public static final Item blueprintThermalHot = new ItemBlueprint("scorch").setTooltipText("tooltips.blueprint_scorch");
	public static final Item blueprintThermalCold = new ItemBlueprint("freeze").setTooltipText("tooltips.blueprint_freeze");
	
	// Healing Items
	public static final Item healingHeart = new ItemHeart();
	public static final Item healingHeartForce = new ItemHeartForce();
	
	// Amulets
	public static final Item amuletStorm = new ZGItemAmulet("storm");
	
	// Oxygen Tanks
	public static final Item oxygenTankTier4 = new ZGOxygenTank("oxygentank_tier4", 4);
	public static final Item oxygenTankTier5 = new ZGOxygenTank("oxygentank_tier5", 5);
	public static final Item oxygenTankTier6 = new ZGOxygenTank("oxygentank_tier6", 6);
	
	public static final Item alcohol = new ZGItemBase("alcohol");
	public static final Item gauze = new ZGItemBase("gauze");
	public static final Item medkit = new ItemMedkit();
	public static final Item nail = new ZGItemBase("nail");
	public static final Item nailGroup = new ZGItemBase("nailgroup");
	public static final Item woodBox = new ZGItemBase("woodbox");
	public static final Item metalParts = new ZGItemBase("metalparts");
	
	public static final Item dough = new ZGItemBase("dough");
	public static final Item flour = new ZGItemBase("flour");
	public static final Item doughCooked = new ZGItemBase("cookeddough");
	
	// Crops
	public static final Item strawberry = new ZGItemSeedFood("strawberry", 8, 1.7F, ZGBlocks.cropStrawberry);
	public static final Item blackberry = new ZGItemSeedFood("blackberry", 5, 0.4F, ZGBlocks.cropBlackberry);
	public static final Item blueberry = new ZGItemSeedFood("blueberry", 4, 0.5F, ZGBlocks.cropBlueberry);
	public static final Item grape = new ZGItemSeedFood("grape", 5, 0.8F, ZGBlocks.cropGrape);
	public static final Item tomato = new ZGItemSeedFood("tomato", 14, 2.0F, ZGBlocks.cropTomato);
	public static final Item corn = new ZGItemSeedFood("corn", 20, 4.0F, ZGBlocks.cropCorn);
	public static final Item cucumber = new ZGItemSeedFood("cucumber", 16, 4.5F, ZGBlocks.cropCucumber);
	public static final Item radish = new ZGItemSeedFood("radish", 10, 3.6F, ZGBlocks.cropRadish);
	public static final Item onion = new ZGItemSeedFood("onion", 14, 3.8F, ZGBlocks.cropOnion);
	public static final Item peas = new ZGItemSeedFood("peas", 5, 2.6F, ZGBlocks.cropPea);
	public static final Item garlic = new ZGItemSeedFood("garlic", 10, 1.5F, ZGBlocks.cropGarlic);
	
	// Thermal Armor
	// public static final Item thermalClothTier3 = new ZGItemBase("thermal_cloth_t3");
	// public static final Item thermalArmorTier3 = new ZGThermalArmor("zgthermal_padding_t3");
	
	public static void init() {
		ZGItems.registerItems(heartium, zolCrystal, kriffCrystal, purgCrystal, edenCrystal, purgEssence, prometheanCrystal, plutoniumCrystal, azurite, ascendium, rokkite, perdGlowdust, perdDiamond,
				perdEtrium, amber, topaz, opal, aquamarine, garnet, ruby, amberStatic, aquamarineIcy, garnetFire, witherite, netheridium, sapphire, stormCrystal, mudClayBall);
		//
		ZGItems.registerItems(dustBrightstone, dustShinestone, dustVirinium, dustEvenium, dustCobalt, dustFueltonium, dustShinium, dustChargium, dustDiamond, dustEmerald, dustAmaranth, dustZollernium,
				dustZinc, dustZucrite, dustRhodium, dustPlutonium, dustEnrichment, dustObsidian, ingotVirinium, ingotCobalt, ingotEvenium, ingotShinestone, ingotShinium, ingotChargium,
				ingotFueltonium, ingotLapis, ingotAmaranth, ingotAscendantAmaranth, ingotZollernium, ingotZinc, ingotEtrium, ingotZucrite, ingotRhodium, ingotRadium, ingotPlutonium, ingotObsidian,
				hud, alienStone, compressedCobalt, compressedDiamond, compressedEmerald, compressedEvenium, compressedGold, compressedHeartium, compressedKriffonium, compressedVirinium,
				compressedVyrex, compressedPromethean, compressedSuperChargedCoal, compressedRiven, compressedAmaranth, compressedAzurite, compressedZollernium, compressedZucrite, compressedRhodium,
				compressedAscendantAmaranth, rawAlienBacon, cookedAlienBacon, rawAlienBeef, cookedAlienBeef, edenFruit, perdBerry, perdPeach, rawBlubberFish, cookedBlubberFish, rawBladeFish,
				cookedBladeFish, rawGypsyFish, cookedGypsyFish, creamBall, chocolateRaw, chocolateBar, brownie, candyApple, iceCreamSandwich, iceCream, chocolateStrawberry, edenDungeonKey, shadeKey,
				tlalocDungeonKey, perdReed, shagreen, sharkTooth, shadowBone, darkEssence, radium, superChargedCoal, powerStick, lapisStick, starGateTier1, starGateTier2, starGateTier3, starGateTier4,
				starGateTier5, starGateTier6, starGateTier7, starGateTier8, starGateTier9, starGateTier10, starGateCandy, OMNITOOL, BEDROCK_BREAKER, pickaxeCobalt, pickaxeEvenium, pickaxeVirinium,
				pickaxeAmaranth, pickaxeAzurite, pickaxeZollernium, pickaxeRuby, pickaxeSapphire, shovelCobalt, shovelEvenium, shovelVirinium, shovelAmaranth, shovelAzurite, shovelZollernium,
				shovelRuby, shovelSapphire, axeCobalt, axeEvenium, axeVirinium, axeAmaranth, axeAzurite, axeZollernium, axeRuby, axeSapphire, hoeCobalt, hoeEvenium, hoeVirinium, hoeAmaranth,
				hoeAzurite, hoeZollernium, hoeRuby, hoeSapphire, swordCobalt, swordEvenium, swordVirinium, swordAmaranth, swordAzurite, swordZollernium, swordRuby, swordSapphire, swordWither,
				swordFire, swordThor, swordEnder, swordIce, swordLight, tunnelerCopper, tunnelerGold, tunnelerAmaranth, helmetWood, helmetStone, helmetAmaranth, helmetZollernium, helmetAzurite,
				helmetRadium, helmetRuby, helmetSapphire, chestWood, chestStone, chestAmaranth, chestZollernium, chestAzurite, chestRadium, chestRuby, chestSapphire, legsWood, legsStone, legsAmaranth,
				legsZollernium, legsAzurite, legsRadium, legsRuby, legsSapphire, bootsWood, bootsStone, bootsAmaranth, bootsZollernium, bootsAzurite, bootsRadium, bootsRuby, bootsSapphire,
				blueprintCorruption, blueprintThermalHot, blueprintThermalCold, healingHeart, healingHeartForce, amuletStorm, oxygenTankTier4, oxygenTankTier5, oxygenTankTier6);
		//
		//
		ZGItems.registerItems(alcohol, gauze, medkit, nail, nailGroup, woodBox, metalParts, dough, doughCooked, flour);
		//
		// Crops & Fruits
		ZGItems.registerItems(strawberry, blackberry, blueberry, grape, tomato, corn, cucumber, radish, onion, peas, garlic, cherry, banana, guava, peach, grapefruit, orange, lemon, lime, limon, pea,
				cornKernel, popcorn, popcornBowl);
		//
		//
		ZGHelper.Log("Loaded a total of " + totalItems + " new items.");
	}
	
	private static void addItem(Item item) {
		CommonZGRegisterHelper.registerItem(item);
		totalItems++;
	}
	
	private static void registerItems(Item... items) {
		for (Item i : items) {
			ZGItems.addItem(i);
		}
	}
	
}