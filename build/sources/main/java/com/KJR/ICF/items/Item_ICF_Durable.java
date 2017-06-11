package com.KJR.ICF.items;

import net.minecraft.item.Item;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;


public class Item_ICF_Durable extends Item {

    public Item_ICF_Durable(String name, int maxDamage, String registryName) {	
    	super();
		maxStackSize = 1;
		setNoRepair();
        setCreativeTab(Main.tabImitationConstructionFoam);
        setUnlocalizedName(ICF_Global.modID + ".durable." + name);
        setRegistryName(registryName);
        setMaxDamage(maxDamage);
    }
    
}