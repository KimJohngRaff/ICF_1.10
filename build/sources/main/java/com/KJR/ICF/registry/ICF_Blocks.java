package com.KJR.ICF.registry;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.blocks.Block_ICF_Metal;
import com.KJR.ICF.blocks.Block_ICF_Ore;
import com.KJR.ICF.blocks.Block_of_ICF;
import com.KJR.ICF.blocks.Compressed_Cactus;
import com.KJR.ICF.itemBlocks.ICF_ItemBlock_String;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ICF_Blocks {
	
	//declare blocks
	public static Block icfBlock;
	public static Block compressedCactus;
	public static Block icfOre;
	public static Block icfMetalBlock;
	
	//string array declarations
	public static final String[] icfBlock_names = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "lgray", "gray", "pink", "lime", "yellow", "lblue", "magenta", "orange", "white"};
	public static final String[] icfOre_names = new String[] {"platinum", "tin", "silver", "aluminum", "copper", "nickel", "sulfur", "saltpeter"};
	public static final String[] icfMetalBlock_names = new String[] {"blockplatinum", "blocktin", "blocksilver", "blockaluminum", "blockcopper", "blocknickel", "blockbronze", "blockenderium", "blockendimandium", "blockweakenedquartz", "blockenderiumpaste"};
	
	//initialize blocks
	public static void initBlocks() {
		registerBlock(icfBlock = new Block_of_ICF("icfBlock", Material.ROCK, icfBlock_names, 3.0F, 15.0F, "icfBlock"));
		registerBlock(compressedCactus = new Compressed_Cactus("compressedCactus", Material.ROCK, icfBlock_names, 3.0F, 15.0F, "compressedCactus"));
		registerBlock(icfOre = new Block_ICF_Ore("icfOre", Material.ROCK, icfOre_names, 3.0F, 15.0F, "icfOre"));
		registerBlock(icfMetalBlock = new Block_ICF_Metal("icfMetalBlock", Material.IRON, icfMetalBlock_names, 5, 15.0F, "icfMetalBlock"));
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ICF_ItemBlock_String(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	//register block variants
	public static void registerBlockItemVariants() {
		for (int i = 0; i < 16; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfBlock), new ModelResourceLocation(ICF_Global.modID + ":foam" + icfBlock_names[i], "type=" + icfBlock_names[i]));
		}
		for (int i = 0; i < 16; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(compressedCactus), new ModelResourceLocation(ICF_Global.modID + ":cactus" + icfBlock_names[i], "type=" + icfBlock_names[i]));
		}
		for (int i = 0; i < icfOre_names.length; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfOre), new ModelResourceLocation(ICF_Global.modID + ":" + icfOre_names[i] + "Ore", "type=" + icfOre_names[i]));
		}
		for (int i = 0; i < icfMetalBlock_names.length; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfMetalBlock), new ModelResourceLocation(ICF_Global.modID + ":" + icfMetalBlock_names[i], "type=" + icfMetalBlock_names[i]));
		}	
	}
	
	//render blocks
	public static void renderBlocks() {
		for (int i = 0; i < 16; i++) {
			registerRenders(icfBlock, i, "foam" + icfBlock_names[i]);
		}
		for (int i = 0; i < 16; i++) {
			registerRenders(compressedCactus, i, "cactus" + icfBlock_names[i]);
		}
		for (int i = 0; i < icfOre_names.length; i++) {
			registerRenders(icfOre, i, icfOre_names[i] + "Ore");
		}
		for (int i = 0; i < icfMetalBlock_names.length; i++) {
			registerRenders(icfMetalBlock, i, icfMetalBlock_names[i]);
		}
	}
    
	//create methods to be used in this class
	public static void registerRenders(Block block, int meta, String texture_name) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,  new ModelResourceLocation(ICF_Global.modID + ":" + texture_name, "type=" + texture_name));
	}

}