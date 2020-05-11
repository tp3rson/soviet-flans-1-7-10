package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item$ToolMaterial;
import net.minecraft.item.ItemAnvilBlock;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor$ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemDoublePlant;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEmptyMap;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemEnderEye;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemLeaves;
import net.minecraft.item.ItemLilyPad;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemNameTag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemPiston;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSnow;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Item {

   public static final RegistryNamespaced itemRegistry = new RegistryNamespaced();
   protected static final UUID field_111210_e = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
   private CreativeTabs tabToDisplayOn;
   protected static Random itemRand = new Random();
   protected int maxStackSize = 64;
   private int maxDamage;
   protected boolean bFull3D;
   protected boolean hasSubtypes;
   private Item containerItem;
   private String potionEffect;
   private String unlocalizedName;
   protected IIcon itemIcon;
   protected String iconString;


   public static int getIdFromItem(Item var0) {
      return var0 == null?0:itemRegistry.getIDForObject(var0);
   }

   public static Item getItemById(int var0) {
      return (Item)itemRegistry.getObjectById(var0);
   }

   public static Item getItemFromBlock(Block var0) {
      return getItemById(Block.getIdFromBlock(var0));
   }

   public static void registerItems() {
      itemRegistry.addObject(256, "iron_shovel", (new ItemSpade(Item$ToolMaterial.IRON)).setUnlocalizedName("shovelIron").setTextureName("iron_shovel"));
      itemRegistry.addObject(257, "iron_pickaxe", (new ItemPickaxe(Item$ToolMaterial.IRON)).setUnlocalizedName("pickaxeIron").setTextureName("iron_pickaxe"));
      itemRegistry.addObject(258, "iron_axe", (new ItemAxe(Item$ToolMaterial.IRON)).setUnlocalizedName("hatchetIron").setTextureName("iron_axe"));
      itemRegistry.addObject(259, "flint_and_steel", (new ItemFlintAndSteel()).setUnlocalizedName("flintAndSteel").setTextureName("flint_and_steel"));
      itemRegistry.addObject(260, "apple", (new ItemFood(4, 0.3F, false)).setUnlocalizedName("apple").setTextureName("apple"));
      itemRegistry.addObject(261, "bow", (new ItemBow()).setUnlocalizedName("bow").setTextureName("bow"));
      itemRegistry.addObject(262, "arrow", (new Item()).setUnlocalizedName("arrow").setCreativeTab(CreativeTabs.tabCombat).setTextureName("arrow"));
      itemRegistry.addObject(263, "coal", (new ItemCoal()).setUnlocalizedName("coal").setTextureName("coal"));
      itemRegistry.addObject(264, "diamond", (new Item()).setUnlocalizedName("diamond").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("diamond"));
      itemRegistry.addObject(265, "iron_ingot", (new Item()).setUnlocalizedName("ingotIron").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("iron_ingot"));
      itemRegistry.addObject(266, "gold_ingot", (new Item()).setUnlocalizedName("ingotGold").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gold_ingot"));
      itemRegistry.addObject(267, "iron_sword", (new ItemSword(Item$ToolMaterial.IRON)).setUnlocalizedName("swordIron").setTextureName("iron_sword"));
      itemRegistry.addObject(268, "wooden_sword", (new ItemSword(Item$ToolMaterial.WOOD)).setUnlocalizedName("swordWood").setTextureName("wood_sword"));
      itemRegistry.addObject(269, "wooden_shovel", (new ItemSpade(Item$ToolMaterial.WOOD)).setUnlocalizedName("shovelWood").setTextureName("wood_shovel"));
      itemRegistry.addObject(270, "wooden_pickaxe", (new ItemPickaxe(Item$ToolMaterial.WOOD)).setUnlocalizedName("pickaxeWood").setTextureName("wood_pickaxe"));
      itemRegistry.addObject(271, "wooden_axe", (new ItemAxe(Item$ToolMaterial.WOOD)).setUnlocalizedName("hatchetWood").setTextureName("wood_axe"));
      itemRegistry.addObject(272, "stone_sword", (new ItemSword(Item$ToolMaterial.STONE)).setUnlocalizedName("swordStone").setTextureName("stone_sword"));
      itemRegistry.addObject(273, "stone_shovel", (new ItemSpade(Item$ToolMaterial.STONE)).setUnlocalizedName("shovelStone").setTextureName("stone_shovel"));
      itemRegistry.addObject(274, "stone_pickaxe", (new ItemPickaxe(Item$ToolMaterial.STONE)).setUnlocalizedName("pickaxeStone").setTextureName("stone_pickaxe"));
      itemRegistry.addObject(275, "stone_axe", (new ItemAxe(Item$ToolMaterial.STONE)).setUnlocalizedName("hatchetStone").setTextureName("stone_axe"));
      itemRegistry.addObject(276, "diamond_sword", (new ItemSword(Item$ToolMaterial.EMERALD)).setUnlocalizedName("swordDiamond").setTextureName("diamond_sword"));
      itemRegistry.addObject(277, "diamond_shovel", (new ItemSpade(Item$ToolMaterial.EMERALD)).setUnlocalizedName("shovelDiamond").setTextureName("diamond_shovel"));
      itemRegistry.addObject(278, "diamond_pickaxe", (new ItemPickaxe(Item$ToolMaterial.EMERALD)).setUnlocalizedName("pickaxeDiamond").setTextureName("diamond_pickaxe"));
      itemRegistry.addObject(279, "diamond_axe", (new ItemAxe(Item$ToolMaterial.EMERALD)).setUnlocalizedName("hatchetDiamond").setTextureName("diamond_axe"));
      itemRegistry.addObject(280, "stick", (new Item()).setFull3D().setUnlocalizedName("stick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("stick"));
      itemRegistry.addObject(281, "bowl", (new Item()).setUnlocalizedName("bowl").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("bowl"));
      itemRegistry.addObject(282, "mushroom_stew", (new ItemSoup(6)).setUnlocalizedName("mushroomStew").setTextureName("mushroom_stew"));
      itemRegistry.addObject(283, "golden_sword", (new ItemSword(Item$ToolMaterial.GOLD)).setUnlocalizedName("swordGold").setTextureName("gold_sword"));
      itemRegistry.addObject(284, "golden_shovel", (new ItemSpade(Item$ToolMaterial.GOLD)).setUnlocalizedName("shovelGold").setTextureName("gold_shovel"));
      itemRegistry.addObject(285, "golden_pickaxe", (new ItemPickaxe(Item$ToolMaterial.GOLD)).setUnlocalizedName("pickaxeGold").setTextureName("gold_pickaxe"));
      itemRegistry.addObject(286, "golden_axe", (new ItemAxe(Item$ToolMaterial.GOLD)).setUnlocalizedName("hatchetGold").setTextureName("gold_axe"));
      itemRegistry.addObject(287, "string", (new ItemReed(Blocks.tripwire)).setUnlocalizedName("string").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("string"));
      itemRegistry.addObject(288, "feather", (new Item()).setUnlocalizedName("feather").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("feather"));
      itemRegistry.addObject(289, "gunpowder", (new Item()).setUnlocalizedName("sulphur").setPotionEffect(PotionHelper.gunpowderEffect).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gunpowder"));
      itemRegistry.addObject(290, "wooden_hoe", (new ItemHoe(Item$ToolMaterial.WOOD)).setUnlocalizedName("hoeWood").setTextureName("wood_hoe"));
      itemRegistry.addObject(291, "stone_hoe", (new ItemHoe(Item$ToolMaterial.STONE)).setUnlocalizedName("hoeStone").setTextureName("stone_hoe"));
      itemRegistry.addObject(292, "iron_hoe", (new ItemHoe(Item$ToolMaterial.IRON)).setUnlocalizedName("hoeIron").setTextureName("iron_hoe"));
      itemRegistry.addObject(293, "diamond_hoe", (new ItemHoe(Item$ToolMaterial.EMERALD)).setUnlocalizedName("hoeDiamond").setTextureName("diamond_hoe"));
      itemRegistry.addObject(294, "golden_hoe", (new ItemHoe(Item$ToolMaterial.GOLD)).setUnlocalizedName("hoeGold").setTextureName("gold_hoe"));
      itemRegistry.addObject(295, "wheat_seeds", (new ItemSeeds(Blocks.wheat, Blocks.farmland)).setUnlocalizedName("seeds").setTextureName("seeds_wheat"));
      itemRegistry.addObject(296, "wheat", (new Item()).setUnlocalizedName("wheat").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("wheat"));
      itemRegistry.addObject(297, "bread", (new ItemFood(5, 0.6F, false)).setUnlocalizedName("bread").setTextureName("bread"));
      itemRegistry.addObject(298, "leather_helmet", (new ItemArmor(ItemArmor$ArmorMaterial.CLOTH, 0, 0)).setUnlocalizedName("helmetCloth").setTextureName("leather_helmet"));
      itemRegistry.addObject(299, "leather_chestplate", (new ItemArmor(ItemArmor$ArmorMaterial.CLOTH, 0, 1)).setUnlocalizedName("chestplateCloth").setTextureName("leather_chestplate"));
      itemRegistry.addObject(300, "leather_leggings", (new ItemArmor(ItemArmor$ArmorMaterial.CLOTH, 0, 2)).setUnlocalizedName("leggingsCloth").setTextureName("leather_leggings"));
      itemRegistry.addObject(301, "leather_boots", (new ItemArmor(ItemArmor$ArmorMaterial.CLOTH, 0, 3)).setUnlocalizedName("bootsCloth").setTextureName("leather_boots"));
      itemRegistry.addObject(302, "chainmail_helmet", (new ItemArmor(ItemArmor$ArmorMaterial.CHAIN, 1, 0)).setUnlocalizedName("helmetChain").setTextureName("chainmail_helmet"));
      itemRegistry.addObject(303, "chainmail_chestplate", (new ItemArmor(ItemArmor$ArmorMaterial.CHAIN, 1, 1)).setUnlocalizedName("chestplateChain").setTextureName("chainmail_chestplate"));
      itemRegistry.addObject(304, "chainmail_leggings", (new ItemArmor(ItemArmor$ArmorMaterial.CHAIN, 1, 2)).setUnlocalizedName("leggingsChain").setTextureName("chainmail_leggings"));
      itemRegistry.addObject(305, "chainmail_boots", (new ItemArmor(ItemArmor$ArmorMaterial.CHAIN, 1, 3)).setUnlocalizedName("bootsChain").setTextureName("chainmail_boots"));
      itemRegistry.addObject(306, "iron_helmet", (new ItemArmor(ItemArmor$ArmorMaterial.IRON, 2, 0)).setUnlocalizedName("helmetIron").setTextureName("iron_helmet"));
      itemRegistry.addObject(307, "iron_chestplate", (new ItemArmor(ItemArmor$ArmorMaterial.IRON, 2, 1)).setUnlocalizedName("chestplateIron").setTextureName("iron_chestplate"));
      itemRegistry.addObject(308, "iron_leggings", (new ItemArmor(ItemArmor$ArmorMaterial.IRON, 2, 2)).setUnlocalizedName("leggingsIron").setTextureName("iron_leggings"));
      itemRegistry.addObject(309, "iron_boots", (new ItemArmor(ItemArmor$ArmorMaterial.IRON, 2, 3)).setUnlocalizedName("bootsIron").setTextureName("iron_boots"));
      itemRegistry.addObject(310, "diamond_helmet", (new ItemArmor(ItemArmor$ArmorMaterial.DIAMOND, 3, 0)).setUnlocalizedName("helmetDiamond").setTextureName("diamond_helmet"));
      itemRegistry.addObject(311, "diamond_chestplate", (new ItemArmor(ItemArmor$ArmorMaterial.DIAMOND, 3, 1)).setUnlocalizedName("chestplateDiamond").setTextureName("diamond_chestplate"));
      itemRegistry.addObject(312, "diamond_leggings", (new ItemArmor(ItemArmor$ArmorMaterial.DIAMOND, 3, 2)).setUnlocalizedName("leggingsDiamond").setTextureName("diamond_leggings"));
      itemRegistry.addObject(313, "diamond_boots", (new ItemArmor(ItemArmor$ArmorMaterial.DIAMOND, 3, 3)).setUnlocalizedName("bootsDiamond").setTextureName("diamond_boots"));
      itemRegistry.addObject(314, "golden_helmet", (new ItemArmor(ItemArmor$ArmorMaterial.GOLD, 4, 0)).setUnlocalizedName("helmetGold").setTextureName("gold_helmet"));
      itemRegistry.addObject(315, "golden_chestplate", (new ItemArmor(ItemArmor$ArmorMaterial.GOLD, 4, 1)).setUnlocalizedName("chestplateGold").setTextureName("gold_chestplate"));
      itemRegistry.addObject(316, "golden_leggings", (new ItemArmor(ItemArmor$ArmorMaterial.GOLD, 4, 2)).setUnlocalizedName("leggingsGold").setTextureName("gold_leggings"));
      itemRegistry.addObject(317, "golden_boots", (new ItemArmor(ItemArmor$ArmorMaterial.GOLD, 4, 3)).setUnlocalizedName("bootsGold").setTextureName("gold_boots"));
      itemRegistry.addObject(318, "flint", (new Item()).setUnlocalizedName("flint").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("flint"));
      itemRegistry.addObject(319, "porkchop", (new ItemFood(3, 0.3F, true)).setUnlocalizedName("porkchopRaw").setTextureName("porkchop_raw"));
      itemRegistry.addObject(320, "cooked_porkchop", (new ItemFood(8, 0.8F, true)).setUnlocalizedName("porkchopCooked").setTextureName("porkchop_cooked"));
      itemRegistry.addObject(321, "painting", (new ItemHangingEntity(EntityPainting.class)).setUnlocalizedName("painting").setTextureName("painting"));
      itemRegistry.addObject(322, "golden_apple", (new ItemAppleGold(4, 1.2F, false)).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setUnlocalizedName("appleGold").setTextureName("apple_golden"));
      itemRegistry.addObject(323, "sign", (new ItemSign()).setUnlocalizedName("sign").setTextureName("sign"));
      itemRegistry.addObject(324, "wooden_door", (new ItemDoor(Material.wood)).setUnlocalizedName("doorWood").setTextureName("door_wood"));
      Item var0 = (new ItemBucket(Blocks.air)).setUnlocalizedName("bucket").setMaxStackSize(16).setTextureName("bucket_empty");
      itemRegistry.addObject(325, "bucket", var0);
      itemRegistry.addObject(326, "water_bucket", (new ItemBucket(Blocks.flowing_water)).setUnlocalizedName("bucketWater").setContainerItem(var0).setTextureName("bucket_water"));
      itemRegistry.addObject(327, "lava_bucket", (new ItemBucket(Blocks.flowing_lava)).setUnlocalizedName("bucketLava").setContainerItem(var0).setTextureName("bucket_lava"));
      itemRegistry.addObject(328, "minecart", (new ItemMinecart(0)).setUnlocalizedName("minecart").setTextureName("minecart_normal"));
      itemRegistry.addObject(329, "saddle", (new ItemSaddle()).setUnlocalizedName("saddle").setTextureName("saddle"));
      itemRegistry.addObject(330, "iron_door", (new ItemDoor(Material.iron)).setUnlocalizedName("doorIron").setTextureName("door_iron"));
      itemRegistry.addObject(331, "redstone", (new ItemRedstone()).setUnlocalizedName("redstone").setPotionEffect(PotionHelper.redstoneEffect).setTextureName("redstone_dust"));
      itemRegistry.addObject(332, "snowball", (new ItemSnowball()).setUnlocalizedName("snowball").setTextureName("snowball"));
      itemRegistry.addObject(333, "boat", (new ItemBoat()).setUnlocalizedName("boat").setTextureName("boat"));
      itemRegistry.addObject(334, "leather", (new Item()).setUnlocalizedName("leather").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("leather"));
      itemRegistry.addObject(335, "milk_bucket", (new ItemBucketMilk()).setUnlocalizedName("milk").setContainerItem(var0).setTextureName("bucket_milk"));
      itemRegistry.addObject(336, "brick", (new Item()).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("brick"));
      itemRegistry.addObject(337, "clay_ball", (new Item()).setUnlocalizedName("clay").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("clay_ball"));
      itemRegistry.addObject(338, "reeds", (new ItemReed(Blocks.reeds)).setUnlocalizedName("reeds").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("reeds"));
      itemRegistry.addObject(339, "paper", (new Item()).setUnlocalizedName("paper").setCreativeTab(CreativeTabs.tabMisc).setTextureName("paper"));
      itemRegistry.addObject(340, "book", (new ItemBook()).setUnlocalizedName("book").setCreativeTab(CreativeTabs.tabMisc).setTextureName("book_normal"));
      itemRegistry.addObject(341, "slime_ball", (new Item()).setUnlocalizedName("slimeball").setCreativeTab(CreativeTabs.tabMisc).setTextureName("slimeball"));
      itemRegistry.addObject(342, "chest_minecart", (new ItemMinecart(1)).setUnlocalizedName("minecartChest").setTextureName("minecart_chest"));
      itemRegistry.addObject(343, "furnace_minecart", (new ItemMinecart(2)).setUnlocalizedName("minecartFurnace").setTextureName("minecart_furnace"));
      itemRegistry.addObject(344, "egg", (new ItemEgg()).setUnlocalizedName("egg").setTextureName("egg"));
      itemRegistry.addObject(345, "compass", (new Item()).setUnlocalizedName("compass").setCreativeTab(CreativeTabs.tabTools).setTextureName("compass"));
      itemRegistry.addObject(346, "fishing_rod", (new ItemFishingRod()).setUnlocalizedName("fishingRod").setTextureName("fishing_rod"));
      itemRegistry.addObject(347, "clock", (new Item()).setUnlocalizedName("clock").setCreativeTab(CreativeTabs.tabTools).setTextureName("clock"));
      itemRegistry.addObject(348, "glowstone_dust", (new Item()).setUnlocalizedName("yellowDust").setPotionEffect(PotionHelper.glowstoneEffect).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("glowstone_dust"));
      itemRegistry.addObject(349, "fish", (new ItemFishFood(false)).setUnlocalizedName("fish").setTextureName("fish_raw").setHasSubtypes(true));
      itemRegistry.addObject(350, "cooked_fished", (new ItemFishFood(true)).setUnlocalizedName("fish").setTextureName("fish_cooked").setHasSubtypes(true));
      itemRegistry.addObject(351, "dye", (new ItemDye()).setUnlocalizedName("dyePowder").setTextureName("dye_powder"));
      itemRegistry.addObject(352, "bone", (new Item()).setUnlocalizedName("bone").setFull3D().setCreativeTab(CreativeTabs.tabMisc).setTextureName("bone"));
      itemRegistry.addObject(353, "sugar", (new Item()).setUnlocalizedName("sugar").setPotionEffect(PotionHelper.sugarEffect).setCreativeTab(CreativeTabs.tabMaterials).setTextureName("sugar"));
      itemRegistry.addObject(354, "cake", (new ItemReed(Blocks.cake)).setMaxStackSize(1).setUnlocalizedName("cake").setCreativeTab(CreativeTabs.tabFood).setTextureName("cake"));
      itemRegistry.addObject(355, "bed", (new ItemBed()).setMaxStackSize(1).setUnlocalizedName("bed").setTextureName("bed"));
      itemRegistry.addObject(356, "repeater", (new ItemReed(Blocks.unpowered_repeater)).setUnlocalizedName("diode").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("repeater"));
      itemRegistry.addObject(357, "cookie", (new ItemFood(2, 0.1F, false)).setUnlocalizedName("cookie").setTextureName("cookie"));
      itemRegistry.addObject(358, "filled_map", (new ItemMap()).setUnlocalizedName("map").setTextureName("map_filled"));
      itemRegistry.addObject(359, "shears", (new ItemShears()).setUnlocalizedName("shears").setTextureName("shears"));
      itemRegistry.addObject(360, "melon", (new ItemFood(2, 0.3F, false)).setUnlocalizedName("melon").setTextureName("melon"));
      itemRegistry.addObject(361, "pumpkin_seeds", (new ItemSeeds(Blocks.pumpkin_stem, Blocks.farmland)).setUnlocalizedName("seeds_pumpkin").setTextureName("seeds_pumpkin"));
      itemRegistry.addObject(362, "melon_seeds", (new ItemSeeds(Blocks.melon_stem, Blocks.farmland)).setUnlocalizedName("seeds_melon").setTextureName("seeds_melon"));
      itemRegistry.addObject(363, "beef", (new ItemFood(3, 0.3F, true)).setUnlocalizedName("beefRaw").setTextureName("beef_raw"));
      itemRegistry.addObject(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).setUnlocalizedName("beefCooked").setTextureName("beef_cooked"));
      itemRegistry.addObject(365, "chicken", (new ItemFood(2, 0.3F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName("chickenRaw").setTextureName("chicken_raw"));
      itemRegistry.addObject(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).setUnlocalizedName("chickenCooked").setTextureName("chicken_cooked"));
      itemRegistry.addObject(367, "rotten_flesh", (new ItemFood(4, 0.1F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setUnlocalizedName("rottenFlesh").setTextureName("rotten_flesh"));
      itemRegistry.addObject(368, "ender_pearl", (new ItemEnderPearl()).setUnlocalizedName("enderPearl").setTextureName("ender_pearl"));
      itemRegistry.addObject(369, "blaze_rod", (new Item()).setUnlocalizedName("blazeRod").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("blaze_rod"));
      itemRegistry.addObject(370, "ghast_tear", (new Item()).setUnlocalizedName("ghastTear").setPotionEffect(PotionHelper.ghastTearEffect).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("ghast_tear"));
      itemRegistry.addObject(371, "gold_nugget", (new Item()).setUnlocalizedName("goldNugget").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("gold_nugget"));
      itemRegistry.addObject(372, "nether_wart", (new ItemSeeds(Blocks.nether_wart, Blocks.soul_sand)).setUnlocalizedName("netherStalkSeeds").setPotionEffect("+4").setTextureName("nether_wart"));
      itemRegistry.addObject(373, "potion", (new ItemPotion()).setUnlocalizedName("potion").setTextureName("potion"));
      itemRegistry.addObject(374, "glass_bottle", (new ItemGlassBottle()).setUnlocalizedName("glassBottle").setTextureName("potion_bottle_empty"));
      itemRegistry.addObject(375, "spider_eye", (new ItemFood(2, 0.8F, false)).setPotionEffect(Potion.poison.id, 5, 0, 1.0F).setUnlocalizedName("spiderEye").setPotionEffect(PotionHelper.spiderEyeEffect).setTextureName("spider_eye"));
      itemRegistry.addObject(376, "fermented_spider_eye", (new Item()).setUnlocalizedName("fermentedSpiderEye").setPotionEffect(PotionHelper.fermentedSpiderEyeEffect).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("spider_eye_fermented"));
      itemRegistry.addObject(377, "blaze_powder", (new Item()).setUnlocalizedName("blazePowder").setPotionEffect(PotionHelper.blazePowderEffect).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("blaze_powder"));
      itemRegistry.addObject(378, "magma_cream", (new Item()).setUnlocalizedName("magmaCream").setPotionEffect(PotionHelper.magmaCreamEffect).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("magma_cream"));
      itemRegistry.addObject(379, "brewing_stand", (new ItemReed(Blocks.brewing_stand)).setUnlocalizedName("brewingStand").setCreativeTab(CreativeTabs.tabBrewing).setTextureName("brewing_stand"));
      itemRegistry.addObject(380, "cauldron", (new ItemReed(Blocks.cauldron)).setUnlocalizedName("cauldron").setCreativeTab(CreativeTabs.tabBrewing).setTextureName("cauldron"));
      itemRegistry.addObject(381, "ender_eye", (new ItemEnderEye()).setUnlocalizedName("eyeOfEnder").setTextureName("ender_eye"));
      itemRegistry.addObject(382, "speckled_melon", (new Item()).setUnlocalizedName("speckledMelon").setPotionEffect(PotionHelper.speckledMelonEffect).setCreativeTab(CreativeTabs.tabBrewing).setTextureName("melon_speckled"));
      itemRegistry.addObject(383, "spawn_egg", (new ItemMonsterPlacer()).setUnlocalizedName("monsterPlacer").setTextureName("spawn_egg"));
      itemRegistry.addObject(384, "experience_bottle", (new ItemExpBottle()).setUnlocalizedName("expBottle").setTextureName("experience_bottle"));
      itemRegistry.addObject(385, "fire_charge", (new ItemFireball()).setUnlocalizedName("fireball").setTextureName("fireball"));
      itemRegistry.addObject(386, "writable_book", (new ItemWritableBook()).setUnlocalizedName("writingBook").setCreativeTab(CreativeTabs.tabMisc).setTextureName("book_writable"));
      itemRegistry.addObject(387, "written_book", (new ItemEditableBook()).setUnlocalizedName("writtenBook").setTextureName("book_written").setMaxStackSize(16));
      itemRegistry.addObject(388, "emerald", (new Item()).setUnlocalizedName("emerald").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("emerald"));
      itemRegistry.addObject(389, "item_frame", (new ItemHangingEntity(EntityItemFrame.class)).setUnlocalizedName("frame").setTextureName("item_frame"));
      itemRegistry.addObject(390, "flower_pot", (new ItemReed(Blocks.flower_pot)).setUnlocalizedName("flowerPot").setCreativeTab(CreativeTabs.tabDecorations).setTextureName("flower_pot"));
      itemRegistry.addObject(391, "carrot", (new ItemSeedFood(4, 0.6F, Blocks.carrots, Blocks.farmland)).setUnlocalizedName("carrots").setTextureName("carrot"));
      itemRegistry.addObject(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.potatoes, Blocks.farmland)).setUnlocalizedName("potato").setTextureName("potato"));
      itemRegistry.addObject(393, "baked_potato", (new ItemFood(6, 0.6F, false)).setUnlocalizedName("potatoBaked").setTextureName("potato_baked"));
      itemRegistry.addObject(394, "poisonous_potato", (new ItemFood(2, 0.3F, false)).setPotionEffect(Potion.poison.id, 5, 0, 0.6F).setUnlocalizedName("potatoPoisonous").setTextureName("potato_poisonous"));
      itemRegistry.addObject(395, "map", (new ItemEmptyMap()).setUnlocalizedName("emptyMap").setTextureName("map_empty"));
      itemRegistry.addObject(396, "golden_carrot", (new ItemFood(6, 1.2F, false)).setUnlocalizedName("carrotGolden").setPotionEffect(PotionHelper.goldenCarrotEffect).setTextureName("carrot_golden"));
      itemRegistry.addObject(397, "skull", (new ItemSkull()).setUnlocalizedName("skull").setTextureName("skull"));
      itemRegistry.addObject(398, "carrot_on_a_stick", (new ItemCarrotOnAStick()).setUnlocalizedName("carrotOnAStick").setTextureName("carrot_on_a_stick"));
      itemRegistry.addObject(399, "nether_star", (new ItemSimpleFoiled()).setUnlocalizedName("netherStar").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("nether_star"));
      itemRegistry.addObject(400, "pumpkin_pie", (new ItemFood(8, 0.3F, false)).setUnlocalizedName("pumpkinPie").setCreativeTab(CreativeTabs.tabFood).setTextureName("pumpkin_pie"));
      itemRegistry.addObject(401, "fireworks", (new ItemFirework()).setUnlocalizedName("fireworks").setTextureName("fireworks"));
      itemRegistry.addObject(402, "firework_charge", (new ItemFireworkCharge()).setUnlocalizedName("fireworksCharge").setCreativeTab(CreativeTabs.tabMisc).setTextureName("fireworks_charge"));
      itemRegistry.addObject(403, "enchanted_book", (new ItemEnchantedBook()).setMaxStackSize(1).setUnlocalizedName("enchantedBook").setTextureName("book_enchanted"));
      itemRegistry.addObject(404, "comparator", (new ItemReed(Blocks.unpowered_comparator)).setUnlocalizedName("comparator").setCreativeTab(CreativeTabs.tabRedstone).setTextureName("comparator"));
      itemRegistry.addObject(405, "netherbrick", (new Item()).setUnlocalizedName("netherbrick").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("netherbrick"));
      itemRegistry.addObject(406, "quartz", (new Item()).setUnlocalizedName("netherquartz").setCreativeTab(CreativeTabs.tabMaterials).setTextureName("quartz"));
      itemRegistry.addObject(407, "tnt_minecart", (new ItemMinecart(3)).setUnlocalizedName("minecartTnt").setTextureName("minecart_tnt"));
      itemRegistry.addObject(408, "hopper_minecart", (new ItemMinecart(5)).setUnlocalizedName("minecartHopper").setTextureName("minecart_hopper"));
      itemRegistry.addObject(417, "iron_horse_armor", (new Item()).setUnlocalizedName("horsearmormetal").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("iron_horse_armor"));
      itemRegistry.addObject(418, "golden_horse_armor", (new Item()).setUnlocalizedName("horsearmorgold").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("gold_horse_armor"));
      itemRegistry.addObject(419, "diamond_horse_armor", (new Item()).setUnlocalizedName("horsearmordiamond").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setTextureName("diamond_horse_armor"));
      itemRegistry.addObject(420, "lead", (new ItemLead()).setUnlocalizedName("leash").setTextureName("lead"));
      itemRegistry.addObject(421, "name_tag", (new ItemNameTag()).setUnlocalizedName("nameTag").setTextureName("name_tag"));
      itemRegistry.addObject(422, "command_block_minecart", (new ItemMinecart(6)).setUnlocalizedName("minecartCommandBlock").setTextureName("minecart_command_block").setCreativeTab((CreativeTabs)null));
      itemRegistry.addObject(2256, "record_13", (new ItemRecord("13")).setUnlocalizedName("record").setTextureName("record_13"));
      itemRegistry.addObject(2257, "record_cat", (new ItemRecord("cat")).setUnlocalizedName("record").setTextureName("record_cat"));
      itemRegistry.addObject(2258, "record_blocks", (new ItemRecord("blocks")).setUnlocalizedName("record").setTextureName("record_blocks"));
      itemRegistry.addObject(2259, "record_chirp", (new ItemRecord("chirp")).setUnlocalizedName("record").setTextureName("record_chirp"));
      itemRegistry.addObject(2260, "record_far", (new ItemRecord("far")).setUnlocalizedName("record").setTextureName("record_far"));
      itemRegistry.addObject(2261, "record_mall", (new ItemRecord("mall")).setUnlocalizedName("record").setTextureName("record_mall"));
      itemRegistry.addObject(2262, "record_mellohi", (new ItemRecord("mellohi")).setUnlocalizedName("record").setTextureName("record_mellohi"));
      itemRegistry.addObject(2263, "record_stal", (new ItemRecord("stal")).setUnlocalizedName("record").setTextureName("record_stal"));
      itemRegistry.addObject(2264, "record_strad", (new ItemRecord("strad")).setUnlocalizedName("record").setTextureName("record_strad"));
      itemRegistry.addObject(2265, "record_ward", (new ItemRecord("ward")).setUnlocalizedName("record").setTextureName("record_ward"));
      itemRegistry.addObject(2266, "record_11", (new ItemRecord("11")).setUnlocalizedName("record").setTextureName("record_11"));
      itemRegistry.addObject(2267, "record_wait", (new ItemRecord("wait")).setUnlocalizedName("record").setTextureName("record_wait"));
      HashSet var1 = Sets.newHashSet(new Block[]{Blocks.air, Blocks.brewing_stand, Blocks.bed, Blocks.nether_wart, Blocks.cauldron, Blocks.flower_pot, Blocks.wheat, Blocks.reeds, Blocks.cake, Blocks.skull, Blocks.piston_head, Blocks.piston_extension, Blocks.lit_redstone_ore, Blocks.powered_repeater, Blocks.pumpkin_stem, Blocks.standing_sign, Blocks.powered_comparator, Blocks.tripwire, Blocks.lit_redstone_lamp, Blocks.melon_stem, Blocks.unlit_redstone_torch, Blocks.unpowered_comparator, Blocks.redstone_wire, Blocks.wall_sign, Blocks.unpowered_repeater, Blocks.iron_door, Blocks.wooden_door});
      Iterator var2 = Block.blockRegistry.getKeys().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Block var4 = (Block)Block.blockRegistry.getObject(var3);
         Object var5;
         if(var4 == Blocks.wool) {
            var5 = (new ItemCloth(Blocks.wool)).setUnlocalizedName("cloth");
         } else if(var4 == Blocks.stained_hardened_clay) {
            var5 = (new ItemCloth(Blocks.stained_hardened_clay)).setUnlocalizedName("clayHardenedStained");
         } else if(var4 == Blocks.stained_glass) {
            var5 = (new ItemCloth(Blocks.stained_glass)).setUnlocalizedName("stainedGlass");
         } else if(var4 == Blocks.stained_glass_pane) {
            var5 = (new ItemCloth(Blocks.stained_glass_pane)).setUnlocalizedName("stainedGlassPane");
         } else if(var4 == Blocks.carpet) {
            var5 = (new ItemCloth(Blocks.carpet)).setUnlocalizedName("woolCarpet");
         } else if(var4 == Blocks.dirt) {
            var5 = (new ItemMultiTexture(Blocks.dirt, Blocks.dirt, BlockDirt.field_150009_a)).setUnlocalizedName("dirt");
         } else if(var4 == Blocks.sand) {
            var5 = (new ItemMultiTexture(Blocks.sand, Blocks.sand, BlockSand.field_149838_a)).setUnlocalizedName("sand");
         } else if(var4 == Blocks.log) {
            var5 = (new ItemMultiTexture(Blocks.log, Blocks.log, BlockOldLog.field_150168_M)).setUnlocalizedName("log");
         } else if(var4 == Blocks.log2) {
            var5 = (new ItemMultiTexture(Blocks.log2, Blocks.log2, BlockNewLog.field_150169_M)).setUnlocalizedName("log");
         } else if(var4 == Blocks.planks) {
            var5 = (new ItemMultiTexture(Blocks.planks, Blocks.planks, BlockWood.field_150096_a)).setUnlocalizedName("wood");
         } else if(var4 == Blocks.monster_egg) {
            var5 = (new ItemMultiTexture(Blocks.monster_egg, Blocks.monster_egg, BlockSilverfish.field_150198_a)).setUnlocalizedName("monsterStoneEgg");
         } else if(var4 == Blocks.stonebrick) {
            var5 = (new ItemMultiTexture(Blocks.stonebrick, Blocks.stonebrick, BlockStoneBrick.field_150142_a)).setUnlocalizedName("stonebricksmooth");
         } else if(var4 == Blocks.sandstone) {
            var5 = (new ItemMultiTexture(Blocks.sandstone, Blocks.sandstone, BlockSandStone.field_150157_a)).setUnlocalizedName("sandStone");
         } else if(var4 == Blocks.quartz_block) {
            var5 = (new ItemMultiTexture(Blocks.quartz_block, Blocks.quartz_block, BlockQuartz.field_150191_a)).setUnlocalizedName("quartzBlock");
         } else if(var4 == Blocks.stone_slab) {
            var5 = (new ItemSlab(Blocks.stone_slab, Blocks.stone_slab, Blocks.double_stone_slab, false)).setUnlocalizedName("stoneSlab");
         } else if(var4 == Blocks.double_stone_slab) {
            var5 = (new ItemSlab(Blocks.double_stone_slab, Blocks.stone_slab, Blocks.double_stone_slab, true)).setUnlocalizedName("stoneSlab");
         } else if(var4 == Blocks.wooden_slab) {
            var5 = (new ItemSlab(Blocks.wooden_slab, Blocks.wooden_slab, Blocks.double_wooden_slab, false)).setUnlocalizedName("woodSlab");
         } else if(var4 == Blocks.double_wooden_slab) {
            var5 = (new ItemSlab(Blocks.double_wooden_slab, Blocks.wooden_slab, Blocks.double_wooden_slab, true)).setUnlocalizedName("woodSlab");
         } else if(var4 == Blocks.sapling) {
            var5 = (new ItemMultiTexture(Blocks.sapling, Blocks.sapling, BlockSapling.field_149882_a)).setUnlocalizedName("sapling");
         } else if(var4 == Blocks.leaves) {
            var5 = (new ItemLeaves(Blocks.leaves)).setUnlocalizedName("leaves");
         } else if(var4 == Blocks.leaves2) {
            var5 = (new ItemLeaves(Blocks.leaves2)).setUnlocalizedName("leaves");
         } else if(var4 == Blocks.vine) {
            var5 = new ItemColored(Blocks.vine, false);
         } else if(var4 == Blocks.tallgrass) {
            var5 = (new ItemColored(Blocks.tallgrass, true)).func_150943_a(new String[]{"shrub", "grass", "fern"});
         } else if(var4 == Blocks.yellow_flower) {
            var5 = (new ItemMultiTexture(Blocks.yellow_flower, Blocks.yellow_flower, BlockFlower.field_149858_b)).setUnlocalizedName("flower");
         } else if(var4 == Blocks.red_flower) {
            var5 = (new ItemMultiTexture(Blocks.red_flower, Blocks.red_flower, BlockFlower.field_149859_a)).setUnlocalizedName("rose");
         } else if(var4 == Blocks.snow_layer) {
            var5 = new ItemSnow(Blocks.snow_layer, Blocks.snow_layer);
         } else if(var4 == Blocks.waterlily) {
            var5 = new ItemLilyPad(Blocks.waterlily);
         } else if(var4 == Blocks.piston) {
            var5 = new ItemPiston(Blocks.piston);
         } else if(var4 == Blocks.sticky_piston) {
            var5 = new ItemPiston(Blocks.sticky_piston);
         } else if(var4 == Blocks.cobblestone_wall) {
            var5 = (new ItemMultiTexture(Blocks.cobblestone_wall, Blocks.cobblestone_wall, BlockWall.field_150092_a)).setUnlocalizedName("cobbleWall");
         } else if(var4 == Blocks.anvil) {
            var5 = (new ItemAnvilBlock(Blocks.anvil)).setUnlocalizedName("anvil");
         } else if(var4 == Blocks.double_plant) {
            var5 = (new ItemDoublePlant(Blocks.double_plant, Blocks.double_plant, BlockDoublePlant.field_149892_a)).setUnlocalizedName("doublePlant");
         } else {
            if(var1.contains(var4)) {
               continue;
            }

            var5 = new ItemBlock(var4);
         }

         itemRegistry.addObject(Block.getIdFromBlock(var4), var3, var5);
      }

   }

   public Item setMaxStackSize(int var1) {
      this.maxStackSize = var1;
      return this;
   }

   public int getSpriteNumber() {
      return 1;
   }

   public IIcon getIconFromDamage(int var1) {
      return this.itemIcon;
   }

   public final IIcon getIconIndex(ItemStack var1) {
      return this.getIconFromDamage(var1.getItemDamage());
   }

   public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      return false;
   }

   public float func_150893_a(ItemStack var1, Block var2) {
      return 1.0F;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
      return var1;
   }

   public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3) {
      return var1;
   }

   public int getItemStackLimit() {
      return this.maxStackSize;
   }

   public int getMetadata(int var1) {
      return 0;
   }

   public boolean getHasSubtypes() {
      return this.hasSubtypes;
   }

   protected Item setHasSubtypes(boolean var1) {
      this.hasSubtypes = var1;
      return this;
   }

   public int getMaxDamage() {
      return this.maxDamage;
   }

   protected Item setMaxDamage(int var1) {
      this.maxDamage = var1;
      return this;
   }

   public boolean isDamageable() {
      return this.maxDamage > 0 && !this.hasSubtypes;
   }

   public boolean hitEntity(ItemStack var1, EntityLivingBase var2, EntityLivingBase var3) {
      return false;
   }

   public boolean onBlockDestroyed(ItemStack var1, World var2, Block var3, int var4, int var5, int var6, EntityLivingBase var7) {
      return false;
   }

   public boolean func_150897_b(Block var1) {
      return false;
   }

   public boolean itemInteractionForEntity(ItemStack var1, EntityPlayer var2, EntityLivingBase var3) {
      return false;
   }

   public Item setFull3D() {
      this.bFull3D = true;
      return this;
   }

   public boolean isFull3D() {
      return this.bFull3D;
   }

   public boolean shouldRotateAroundWhenRendering() {
      return false;
   }

   public Item setUnlocalizedName(String var1) {
      this.unlocalizedName = var1;
      return this;
   }

   public String getUnlocalizedNameInefficiently(ItemStack var1) {
      String var2 = this.getUnlocalizedName(var1);
      return var2 == null?"":StatCollector.translateToLocal(var2);
   }

   public String getUnlocalizedName() {
      return "item." + this.unlocalizedName;
   }

   public String getUnlocalizedName(ItemStack var1) {
      return "item." + this.unlocalizedName;
   }

   public Item setContainerItem(Item var1) {
      this.containerItem = var1;
      return this;
   }

   public boolean doesContainerItemLeaveCraftingGrid(ItemStack var1) {
      return true;
   }

   public boolean getShareTag() {
      return true;
   }

   public Item getContainerItem() {
      return this.containerItem;
   }

   public boolean hasContainerItem() {
      return this.containerItem != null;
   }

   public int getColorFromItemStack(ItemStack var1, int var2) {
      return 16777215;
   }

   public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {}

   public void onCreated(ItemStack var1, World var2, EntityPlayer var3) {}

   public boolean isMap() {
      return false;
   }

   public EnumAction getItemUseAction(ItemStack var1) {
      return EnumAction.none;
   }

   public int getMaxItemUseDuration(ItemStack var1) {
      return 0;
   }

   public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4) {}

   protected Item setPotionEffect(String var1) {
      this.potionEffect = var1;
      return this;
   }

   public String getPotionEffect(ItemStack var1) {
      return this.potionEffect;
   }

   public boolean isPotionIngredient(ItemStack var1) {
      return this.getPotionEffect(var1) != null;
   }

   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {}

   public String getItemStackDisplayName(ItemStack var1) {
      return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(var1) + ".name")).trim();
   }

   public boolean hasEffect(ItemStack var1) {
      return var1.isItemEnchanted();
   }

   public EnumRarity getRarity(ItemStack var1) {
      return var1.isItemEnchanted()?EnumRarity.rare:EnumRarity.common;
   }

   public boolean isItemTool(ItemStack var1) {
      return this.getItemStackLimit() == 1 && this.isDamageable();
   }

   protected MovingObjectPosition getMovingObjectPositionFromPlayer(World var1, EntityPlayer var2, boolean var3) {
      float var4 = 1.0F;
      float var5 = var2.prevRotationPitch + (var2.rotationPitch - var2.prevRotationPitch) * var4;
      float var6 = var2.prevRotationYaw + (var2.rotationYaw - var2.prevRotationYaw) * var4;
      double var7 = var2.prevPosX + (var2.posX - var2.prevPosX) * (double)var4;
      double var9 = var2.prevPosY + (var2.posY - var2.prevPosY) * (double)var4 + 1.62D - (double)var2.yOffset;
      double var11 = var2.prevPosZ + (var2.posZ - var2.prevPosZ) * (double)var4;
      Vec3 var13 = Vec3.createVectorHelper(var7, var9, var11);
      float var14 = MathHelper.cos(-var6 * 0.017453292F - 3.1415927F);
      float var15 = MathHelper.sin(-var6 * 0.017453292F - 3.1415927F);
      float var16 = -MathHelper.cos(-var5 * 0.017453292F);
      float var17 = MathHelper.sin(-var5 * 0.017453292F);
      float var18 = var15 * var16;
      float var20 = var14 * var16;
      double var21 = 5.0D;
      Vec3 var23 = var13.addVector((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
      return var1.func_147447_a(var13, var23, var3, !var3, false);
   }

   public int getItemEnchantability() {
      return 0;
   }

   public boolean requiresMultipleRenderPasses() {
      return false;
   }

   public IIcon getIconFromDamageForRenderPass(int var1, int var2) {
      return this.getIconFromDamage(var1);
   }

   public void getSubItems(Item var1, CreativeTabs var2, List var3) {
      var3.add(new ItemStack(var1, 1, 0));
   }

   public CreativeTabs getCreativeTab() {
      return this.tabToDisplayOn;
   }

   public Item setCreativeTab(CreativeTabs var1) {
      this.tabToDisplayOn = var1;
      return this;
   }

   public boolean canItemEditBlocks() {
      return true;
   }

   public boolean getIsRepairable(ItemStack var1, ItemStack var2) {
      return false;
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon(this.getIconString());
   }

   public Multimap getItemAttributeModifiers() {
      return HashMultimap.create();
   }

   protected Item setTextureName(String var1) {
      this.iconString = var1;
      return this;
   }

   protected String getIconString() {
      return this.iconString == null?"MISSING_ICON_ITEM_" + itemRegistry.getIDForObject(this) + "_" + this.unlocalizedName:this.iconString;
   }

}
