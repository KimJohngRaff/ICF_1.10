package com.KJR.ICF.items.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;

import com.KJR.ICF.Main;
import com.KJR.ICF.registry.ICF_Items;

public class Item_ICF_AluminumArmor extends ItemArmor {

	public Item_ICF_AluminumArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registryName) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}	
	
	
}
