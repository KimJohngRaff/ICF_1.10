package com.KJR.ICF.registry;

import com.KJR.ICF.items.Item_ICF_Ingot;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
	
	public static void init() {
		int x = OreDictionary.WILDCARD_VALUE;
		
		//smelting ores
		for (int i = 0; i < 6; i++) {
			GameRegistry.addSmelting(new ItemStack(ICF_Blocks.icfOre, 1, i), new ItemStack(ICF_Items.icfIngot, 1, i), 1.0F);
		}
		
		//smelting dust
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addSmelting(new ItemStack(ICF_Items.icfDust_Metal, 1, i), new ItemStack(ICF_Items.icfIngot, 1, i), 1.0F);
		}
		
		//other smelting
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 1), new ItemStack(ICF_Blocks.icfBlock, 1, 7), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 3), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 8), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 4), new ItemStack(ICF_Items.icfMisc_1, 1, 5), 1.0F);
		
		//ICF coloring
		String[] colors = new String[] {"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple","dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
		for (int j = 0; j < ICF_Blocks.icfBlock_names.length; j++) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfBlock, 8, j), "iii", "idi", "iii", 'i', new ItemStack(ICF_Blocks.icfBlock, 1, x), 'd', colors[j]));
		}
		
		//food
		GameRegistry.addSmelting(new ItemStack(Items.EGG), new ItemStack(ICF_Items.fried_egg), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.slice_of_raw_bacon), new ItemStack(ICF_Items.slice_of_cooked_bacon), 1.0F);
		GameRegistry.addSmelting(new ItemStack(Items.MILK_BUCKET), new ItemStack(ICF_Items.cheese_wheel), 1.0F); // subject to change
		GameRegistry.addShapelessRecipe(new ItemStack(ICF_Items.slice_of_bread, 8, 0), new ItemStack(ICF_Items.silver_knife, 1, x), Items.BREAD);
		GameRegistry.addShapelessRecipe(new ItemStack(ICF_Items.slice_of_cheese, 8, 0), new ItemStack(ICF_Items.silver_knife, 1, x), ICF_Items.cheese_wheel);
		GameRegistry.addShapelessRecipe(new ItemStack(ICF_Items.slice_of_raw_bacon, 16, 0), new ItemStack(ICF_Items.silver_knife, 1, x), ICF_Items.pork_back);
		GameRegistry.addShapelessRecipe(new ItemStack(ICF_Items.cheese_sandwich, 1, 0), ICF_Items.slice_of_cheese, ICF_Items.slice_of_bread, ICF_Items.slice_of_cheese, ICF_Items.slice_of_bread);
		GameRegistry.addShapelessRecipe(new ItemStack(ICF_Items.bacon_egg_cheese, 1, 0), ICF_Items.slice_of_cheese, ICF_Items.slice_of_bread, ICF_Items.slice_of_cheese, ICF_Items.slice_of_bread, ICF_Items.slice_of_cooked_bacon, ICF_Items.slice_of_cooked_bacon, ICF_Items.slice_of_cooked_bacon, ICF_Items.slice_of_cooked_bacon, ICF_Items.fried_egg);
		
		//ingots to block
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, i), "iii", "iii", "iii", 'i', "ingot" + Item_ICF_Ingot.names[i].substring(0, 1).toUpperCase() + Item_ICF_Ingot.names[i].substring(1)));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 9), Blocks.QUARTZ_BLOCK , new ItemStack(ICF_Items.icfMisc_1, 1, 4), new ItemStack(Items.WATER_BUCKET)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 9), Items.QUARTZ, Items.QUARTZ, Items.QUARTZ, Items.QUARTZ, new ItemStack(ICF_Items.icfMisc_1, 1, 4), Items.WATER_BUCKET));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), "iii", "iii", "iii", 'i', new ItemStack(ICF_Items.icfMisc_1, 1, 7)));
		
		//block to ingots
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfIngot, 9, i), new ItemStack(ICF_Blocks.icfMetalBlock, 1, i)));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 7), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10)));
		
		//other crafting
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 0), "s s", "s s", "sss", 's', "slabWood"));
		GameRegistry.addShapedRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 1), "scs", "gwg", "gig", 's', new ItemStack(Blocks.SAND), 'c', new ItemStack(Blocks.CLAY), 'g', new ItemStack(Blocks.GRAVEL), 'w', new ItemStack(Items.WATER_BUCKET), 'i', new ItemStack(ICF_Items.icfMisc_1, 1, 0));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfDust_Metal, 1, 6), "dustCopper", "dustCopper", "dustCopper", "dustTin"));
		
		//swine hammers
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumSwineHammer, " ii", "ssi", " ii", 'i', "ingotAluminum", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolBronzeSwineHammer, " ii", "ssi", " ii", 'i', "ingotBronze", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolEndimandiumSwineHammer, " ii", "ssi", " ii", 'i', "ingotEndimandium", 's', Items.BLAZE_ROD));
		
		//tools
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumPickaxe, "iii", " s ", " s ", 'i', "ingotAluminum", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumAxe, " ii", " si", " s ", 'i', "ingotAluminum", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumShovel, " i ", " s ", " s ", 'i', "ingotAluminum", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumHoe, " ii", " s ", " s ", 'i', "ingotAluminum", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.toolAluminumSword, " i ", " i ", " s ", 'i', "ingotAluminum", 's', "stickWood"));
		
		//Armor
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.aluminumHelmet, "iii", "i i", "   ", 'i', "ingotAluminum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.aluminumChestplate, "i i", "iii", "iii", 'i', "ingotAluminum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.aluminumLeggings, "iii", "i i", "i i", 'i', "ingotAluminum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.aluminumBoots, "   ", "i i", "i i", 'i', "ingotAluminum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.endimandiumHelmet, "iii", "i i", "   ", 'i', "ingotEndimandium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.endimandiumChestplate, "i i", "iii", "iii", 'i', "ingotEndimandium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.endimandiumLeggings, "iii", "i i", "i i", 'i', "ingotEndimandium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ICF_Items.endimandiumBoots, "   ", "i i", "i i", 'i', "ingotEndimandium"));
		
		//acid stuff
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 4), "iii", "nsn", "iii", 'i', "dustSulfur", 'n', "dustSaltpeter", 's', Items.WATER_BUCKET));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 3), "isi", "isi", "igi", 'i', "dustDiamond", 's', "blockEnderiumpaste", 'g', new ItemStack(ICF_Items.icfMisc_1, 1, 0)));
		GameRegistry.addSmelting(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 7), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 6), new ItemStack(ICF_Items.icfIngot, 1, 7), 1.0F);
		
		ItemStack e = new ItemStack(Items.ENDER_PEARL);
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 7), e, e, e, e, "dustPlatinum", "dustSilver", "dustTin", "dustTin", new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 4, 6), Items.REDSTONE, Items.BLAZE_POWDER, "dustCoal", "dustSulfur", new ItemStack(ICF_Items.icfMisc_1, 1, 7)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 4, 6), "ingotEnderium", new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), new ItemStack(ICF_Items.icfMisc_1, 1, 4), "blockEnderium"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.NETHERRACK, 8, 0), "iii", "isi", "iii", 'i', Items.NETHERBRICK, 's', new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.CLAY_BALL, 8, 0), "iii", "isi", "iii", 'i', Items.BRICK, 's', new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
	}
}
