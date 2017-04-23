package com.KJR.ICF.api.handler;

import com.KJR.ICF.registry.ICF_Items;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class ICF_Crafting_Handler {
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			
			if(event.craftMatrix.getStackInSlot(i) != null) {
				
				//silver_knife
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if(item0 != null && item0.getItem() == ICF_Items.silver_knife) {
					ItemStack k = new ItemStack(ICF_Items.silver_knife, 2, (item0.getItemDamage() + 1));
					
					if(k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				
			}
		}
	}
}
