package com.KJR.ICF.api.handler;

import java.util.Random;

import com.KJR.ICF.items.Item_ICF_SwineHammer;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ICF_Drops_Handler {

	@SubscribeEvent
	public void addBlockDrop (HarvestDropsEvent event) {
		if (SwineRegistry.swineableItems.contains(Item.getItemFromBlock(event.getState().getBlock()))){
			ItemStack holding = event.getHarvester().inventory.getStackInSlot(event.getHarvester().inventory.currentItem);
			if (holding != null  && holding.getItem() instanceof Item_ICF_SwineHammer) {
				event.getDrops().clear();
			}
		}
	}
	
	@SubscribeEvent
	public void addEntityDrop (LivingDropsEvent event) {
		if (event.getEntity() instanceof EntityPig) {
			Random rand = new Random();
			if(rand.nextInt(3) <= 1){
			}
			else {
				ItemStack itemstack = new ItemStack(ICF_Items.pork_back, 1);
				event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, itemstack));
			}
		}
	}
	
}
