package com.KJR.ICF.items.tools;

import com.KJR.ICF.Main;

import net.minecraft.item.ItemAxe;


public class Item_ICF_AluminumAxe extends ItemAxe{

	public Item_ICF_AluminumAxe(ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}

}