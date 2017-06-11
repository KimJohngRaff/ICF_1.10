package com.KJR.ICF.blocks;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Block_ICF_Base extends Block {
	
	public Block_ICF_Base(String unlocalizedName, Material material, float hardness, float resistance, String registryName){
		super(material);
		
		this.setCreativeTab(Main.tabImitationConstructionFoam);
		this.setUnlocalizedName(ICF_Global.modID + "." + unlocalizedName);
		this.setRegistryName(registryName);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

}
