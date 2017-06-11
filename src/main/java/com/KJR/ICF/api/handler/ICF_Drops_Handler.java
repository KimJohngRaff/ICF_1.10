package com.KJR.ICF.api.handler;

import java.util.Random;

import com.KJR.ICF.items.Item_ICF_SwineHammer;
import com.KJR.ICF.items.tools.Item_ICF_CactusKnife;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ICF_Drops_Handler {

	@SubscribeEvent
	public void addBlockDrop (HarvestDropsEvent event) {
		if (SwineRegistry.swineableItems.contains(Item.getItemFromBlock(event.getState().getBlock()))  && event.getHarvester() instanceof EntityPlayer){
			ItemStack holding = event.getHarvester().inventory.getStackInSlot(event.getHarvester().inventory.currentItem);
			if (holding != null  && holding.getItem() instanceof Item_ICF_SwineHammer) {
				event.getDrops().clear();
			}
		}
		
		if (Blocks.CACTUS == event.getState().getBlock() && event.getHarvester() instanceof EntityPlayer){
			ItemStack holding = event.getHarvester().inventory.getStackInSlot(event.getHarvester().inventory.currentItem);
			if (holding != null  && holding.getItem() instanceof Item_ICF_CactusKnife) {
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
	
	@SubscribeEvent
	public void onBreakBlock(BreakEvent event) {
			BlockPos pos = event.getPos();
			World worldIn = event.getWorld();
			EntityPlayer player = event.getPlayer();
			IBlockState state = event.getState();
			Block block = state.getBlock();
			Item itemFromBlock = Item.getItemFromBlock(block);
			int blockMeta = state.getBlock().getMetaFromState(state);
			boolean bottomCactus;
			int i = 1;
			int x;
			int z;
			int y;
			BlockPos pos0;
			BlockPos pos1;

			
			if(block == Blocks.CACTUS && player.inventory.getStackInSlot(player.inventory.currentItem) != null)
			{
				if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() == ICF_Items.toolCactusKnife){
					for(x = -2; x <= 2; x++){
						for(z = -2; z <= 2; z++){
							
							bottomCactus = false;
							i = 1;
							
							pos0 = new BlockPos(pos.getX()+x, (pos.getY()-1) , pos.getZ()+z);
							if (worldIn.getBlockState(pos0).getBlock() == Blocks.SAND)
							{
								bottomCactus = true;
							}
							
							while(i < 64)
							{
								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+i) , pos.getZ()+z);
								if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS)
								{
									i = i+1;
								}
								else
								{
									break;
								}
							}
							
							pos1 = new BlockPos(pos.getX()+x, (pos.getY()) , pos.getZ()+z);
							if (worldIn.getBlockState(pos1).getBlock() != Blocks.CACTUS || bottomCactus){
								i = i-1;
							}
						
							for(y = i-1; y >= 0; y--){
								if(bottomCactus)
								{
									pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y+1) , pos.getZ()+z);
									if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS){
										worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
									}
								}
								else
								{
									pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y) , pos.getZ()+z);
									if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS){
										worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
									}
								}
							}

							player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.CACTUS), i, 0));
						
						}
					}	
				}
				
				if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() == ICF_Items.toolHeavyCactusKnife){
					for(x = -10; x <= 10; x++){
						for(z = -10; z <= 10; z++){

							bottomCactus = false;
							i = 1;
							
							pos0 = new BlockPos(pos.getX()+x, (pos.getY()-1) , pos.getZ()+z);
							if (worldIn.getBlockState(pos0).getBlock() == Blocks.SAND)
							{
								bottomCactus = true;
							}
							
							while(i < 64)
							{
								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+i) , pos.getZ()+z);
								if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS)
								{
									i = i+1;
								}
								else
								{
									break;
								}
							}
							
							pos1 = new BlockPos(pos.getX()+x, (pos.getY()) , pos.getZ()+z);
							if (worldIn.getBlockState(pos1).getBlock() != Blocks.CACTUS || bottomCactus){
								i = i-1;
							}
						
							for(y = i; y >= 0; y--){
								if(bottomCactus)
								{
									pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y+1) , pos.getZ()+z);
									if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS){
										worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
									}
								}
								else
								{
									pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y) , pos.getZ()+z);
									if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS){
										worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
									}
								}
							}
							
							player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.CACTUS), i, 0));
												
						}
					}	
				}
				pos0 = new BlockPos(pos.getX(), (pos.getY()-1) , pos.getZ());
				if(worldIn.getBlockState(pos0).getBlock() == Blocks.SAND){
					if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() instanceof Item_ICF_CactusKnife && block == Blocks.CACTUS){
						event.setCanceled(true);
					}
				}
			}
	}
		
}
