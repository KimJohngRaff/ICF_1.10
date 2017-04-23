package com.KJR.ICF.items;

import net.minecraft.item.ItemFood;

import com.KJR.ICF.Main;



public class Item_ICF_Food extends ItemFood {
	
	public Item_ICF_Food(String name, int amount, float saturation, boolean isWolfFood, String registryName) {
		super(amount, saturation, isWolfFood);
		
		this.setUnlocalizedName(name);
		setRegistryName(registryName);
		setCreativeTab(Main.tabImitationConstructionFoam);
    }

}