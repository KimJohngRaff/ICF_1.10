package com.KJR.ICF.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ICF_EntityLivingBase extends EntityLivingBase{

	public ICF_EntityLivingBase(World worldIn) {
		super(worldIn);
	}
	
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
}
