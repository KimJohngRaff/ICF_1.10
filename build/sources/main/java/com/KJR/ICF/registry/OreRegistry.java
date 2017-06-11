package com.KJR.ICF.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.KJR.ICF.items.Item_ICF_Dust_Metal;
import com.KJR.ICF.items.Item_ICF_Dust_Other;
import com.KJR.ICF.items.Item_ICF_Ingot;

public class OreRegistry {
	
	
	
	public static void OreRegistration() {
		
		//blocks
		for (int i = 0; i < ICF_Blocks.icfOre_names.length; i++) {
			OreDictionary.registerOre("ore" + ICF_Blocks.icfOre_names[i].substring(0, 1).toUpperCase() + ICF_Blocks.icfOre_names[i].substring(1) , new ItemStack(ICF_Blocks.icfOre, 1, i));
		}
		for (int i = 0; i < ICF_Blocks.icfMetalBlock_names.length; i++) {
			if (i == 9){
				OreDictionary.registerOre("blockWeakenedQuartz", new ItemStack(ICF_Blocks.icfMetalBlock, 1, 9));
			}
			else {
				OreDictionary.registerOre(ICF_Blocks.icfMetalBlock_names[i].substring(0, 5) + ICF_Blocks.icfMetalBlock_names[i].substring(5, 6).toUpperCase() + ICF_Blocks.icfMetalBlock_names[i].substring(6) , new ItemStack(ICF_Blocks.icfMetalBlock, 1, i));
			}
		}
		
		//items
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
				OreDictionary.registerOre("ingot" + Item_ICF_Ingot.names[i].substring(0, 1).toUpperCase() + Item_ICF_Ingot.names[i].substring(1) , new ItemStack(ICF_Items.icfIngot, 1, i));
		}
		for (int i = 0; i < Item_ICF_Dust_Metal.names.length; i++) {
			OreDictionary.registerOre("dust" + Item_ICF_Dust_Metal.names[i].substring(0, 1).toUpperCase() + Item_ICF_Dust_Metal.names[i].substring(1) , new ItemStack(ICF_Items.icfDust_Metal, 1, i));
		}
		for (int i = 0; i < Item_ICF_Dust_Other.names.length; i++) {
			OreDictionary.registerOre("dust" + Item_ICF_Dust_Other.names[i].substring(0, 1).toUpperCase() + Item_ICF_Dust_Other.names[i].substring(1) , new ItemStack(ICF_Items.icfDust_Other, 1, i));
		}
		OreDictionary.registerOre("itemSilicon", new ItemStack(ICF_Items.icfMisc_1, 1, 2));
	
	}
}
