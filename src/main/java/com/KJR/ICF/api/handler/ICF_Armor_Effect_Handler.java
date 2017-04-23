package com.KJR.ICF.api.handler;

import com.KJR.ICF.registry.ICF_Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ICF_Armor_Effect_Handler {
	
	public int heal_counter = 0;
	
	@SubscribeEvent
    public void LivingUpdate(LivingUpdateEvent event) {
		if(event.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.getEntity();
			
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ICF_Items.endimandiumHelmet){
				this.waterbreathing(player);
				this.saturate(player);
			}
			else if(player.inventory.armorItemInSlot(3) == null || player.inventory.armorItemInSlot(3).getItem() != ICF_Items.endimandiumHelmet){
			
			}
			if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ICF_Items.endimandiumChestplate){
				this.turnFlightOn(player);
			}
			else if(player.inventory.armorItemInSlot(2) == null || player.inventory.armorItemInSlot(2).getItem() != ICF_Items.endimandiumChestplate){
				this.turnFlightOff(player);
			}
			if (player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ICF_Items.endimandiumLeggings){
				this.setSpeedFast(player);
			}
			else if(player.inventory.armorItemInSlot(1) == null || player.inventory.armorItemInSlot(1).getItem() != ICF_Items.endimandiumLeggings){
				this.setSpeedDefault(player);
			}
			if (player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				this.setStepHigh(player);
			}
			else if(player.inventory.armorItemInSlot(0) == null || player.inventory.armorItemInSlot(0).getItem() != ICF_Items.endimandiumBoots){
				this.setStepDefault(player);
			}
			if (this.isWearingFullSet(player, ICF_Items.endimandiumHelmet, ICF_Items.endimandiumChestplate, ICF_Items.endimandiumLeggings, ICF_Items.endimandiumBoots)){
				this.regenerate(player);
			}
			else{
			
			}
		}
    }
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event){
		if(event.getEntity() instanceof EntityPlayer){
			if (((EntityPlayer)event.getEntity()).inventory.armorItemInSlot(0) != null && ((EntityPlayer)event.getEntity()).inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				event.getEntityLiving().motionY += 0.3;
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event){
		if(event.getEntity() instanceof EntityPlayer){
			if (((EntityPlayer)event.getEntity()).inventory.armorItemInSlot(0) != null && ((EntityPlayer)event.getEntity()).inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				if(event.getDistance() < 8){
					event.setDistance(1);
				}
				else{
					event.setDamageMultiplier((float) (event.getDamageMultiplier() * 0.25));
				}
			}
		}
	}
	
	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
	}
	
	private void regenerate(EntityPlayer player) {
		this.heal_counter = this.heal_counter + 1;
		if (player.getHealth() < player.getMaxHealth() && this.heal_counter >= 5){
            player.heal(0.25F);
            this.heal_counter = 0;
        }
	}

	private void saturate(EntityPlayer player){
		if (player.getFoodStats().getFoodLevel() < 20){
            player.getFoodStats().addStats(1, 0.0F);
		}
	}
	
	private void waterbreathing(EntityPlayer player){
		if (player.getAir() < 285){
			player.setAir(player.getAir()+10);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void turnFlightOn(EntityPlayer player){
		if(player.capabilities.allowFlying != true){
			player.capabilities.allowFlying = true;
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void turnFlightOff(EntityPlayer player){
		if(player.capabilities.allowFlying != false){
			player.capabilities.allowFlying = false;
		}
		if(player.capabilities.isFlying == true && player.capabilities.isCreativeMode == false){
			player.capabilities.isFlying = false;
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void setSpeedFast(EntityPlayer player){
		if(player.capabilities.getWalkSpeed() != 0.17F){
			player.capabilities.setPlayerWalkSpeed(0.17F);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void setSpeedDefault(EntityPlayer player){
		if(player.capabilities.getWalkSpeed() != 0.1F){
			player.capabilities.setPlayerWalkSpeed(0.1F);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void setStepHigh(EntityPlayer player){
		if (player.isSneaking()){
			player.stepHeight = 0.50001F;
		}
		else player.stepHeight = 1F;
	}
	
	@SideOnly(Side.CLIENT)
	private void setStepDefault(EntityPlayer player){
		player.stepHeight = 0.5F;
	}
}
