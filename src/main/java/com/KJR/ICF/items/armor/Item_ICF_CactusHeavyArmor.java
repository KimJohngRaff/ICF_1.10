package com.KJR.ICF.items.armor;

import com.KJR.ICF.Main;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class Item_ICF_CactusHeavyArmor extends ItemArmor {

	public Item_ICF_CactusHeavyArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registryName) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}	
	
	
}
