package com.KJR.ICF.items.armor;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;
import com.KJR.ICF.registry.ICF_Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.Instance;

public class Item_ICF_EndimandiumArmor extends ItemArmor {

	public Item_ICF_EndimandiumArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String registryName) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}	
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack) {
		if (itemstack.getItem() == ICF_Items.endimandiumHelmet) {
			
		}
		if (itemstack.getItem() == ICF_Items.endimandiumChestplate) {
			
		}
		if (itemstack.getItem() == ICF_Items.endimandiumLeggings) {
			
		}
		if (itemstack.getItem() == ICF_Items.endimandiumBoots) {

		}
		
		if (this.isWearingFullSet(player, ICF_Items.endimandiumHelmet, ICF_Items.endimandiumChestplate, ICF_Items.endimandiumLeggings, ICF_Items.endimandiumBoots)) {
			
		}
	}
	
	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
	}
	
	
}


