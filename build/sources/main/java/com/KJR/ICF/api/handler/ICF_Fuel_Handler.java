package com.KJR.ICF.api.handler;

import com.KJR.ICF.registry.ICF_Blocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ICF_Fuel_Handler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == Item.getItemFromBlock(ICF_Blocks.compressedCactus)) return 2400;
		
		return 0;
	}
}
