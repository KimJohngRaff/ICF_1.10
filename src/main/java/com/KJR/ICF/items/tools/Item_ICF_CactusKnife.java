package com.KJR.ICF.items.tools;

import java.util.ArrayList;
import java.util.Iterator;

import com.KJR.ICF.Main;
import com.KJR.ICF.api.helpers.Swineable;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Item_ICF_CactusKnife extends ItemSword{

	public Item_ICF_CactusKnife(ToolMaterial material) {
		super(material);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		Item Tool = stack.getItem();
		Block block = state.getBlock();


		if (block == Blocks.CACTUS && Tool == ICF_Items.toolHeavyCactusKnife){
			return 2.0F;					
		}
		else if (block == Blocks.CACTUS && Tool == ICF_Items.toolCactusKnife){
			return 1.0F;					
		}
		return 0.8F;
	}
	
//	@Override		
//	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase playerIn)
//	{
//		Block block = state.getBlock();
//		Item itemFromBlock = Item.getItemFromBlock(block);
//		int blockMeta = state.getBlock().getMetaFromState(state);
//		boolean valid = false;
//		boolean bottomCactus;
//		int i = 1;
//		int x;
//		int z;
//		int y;
//		BlockPos pos0;
//		BlockPos pos1;
//
//		
//		if(block == Blocks.CACTUS && playerIn instanceof EntityPlayer)
//		{
//			EntityPlayer player = (EntityPlayer) playerIn;
//			if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() == ICF_Items.toolCactusKnife){
//				for(x = -2; x <= 2; x = x+2){
//					for(z = -2; z <= 2; z = z+2){
//						
//						bottomCactus = false;
//						i = 1;
//						
//						pos0 = new BlockPos(pos.getX()+x, (pos.getY()-1) , pos.getZ()+z);
//						if (worldIn.getBlockState(pos0).getBlock() == Blocks.SAND)
//						{
//							bottomCactus = true;
//						}
//						
//						while(i < 64)
//						{
//							pos0 = new BlockPos(pos.getX()+x, (pos.getY()+i) , pos.getZ()+z);
//							if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS)
//							{
//								i = i+1;
//							}
//							else
//							{
//								break;
//							}
//						}
//						
//						pos1 = new BlockPos(pos.getX()+x, (pos.getY()) , pos.getZ()+z);
//						if (worldIn.getBlockState(pos1).getBlock() != Blocks.CACTUS || bottomCactus){
//							i = i-1;
//						}
//					
//						for(y = i-1; y >= 0; y--){
//							if(bottomCactus)
//							{
//								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y+1) , pos.getZ()+z);
//								worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
//							}
//							else
//							{
//								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y) , pos.getZ()+z);
//								worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
//							}
//						}
//
//						player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.CACTUS), i, 0));
//					
//						valid = true;
//					}
//				}	
//			}
//			
//			if(player.inventory.getStackInSlot(player.inventory.currentItem).getItem() == ICF_Items.toolHeavyCactusKnife){
//				for(x = -10; x <= 10; x = x+2){
//					for(z = -10; z <= 10; z = z+2){
//
//						bottomCactus = false;
//						i = 1;
//						
//						pos0 = new BlockPos(pos.getX()+x, (pos.getY()-1) , pos.getZ()+z);
//						if (worldIn.getBlockState(pos0).getBlock() == Blocks.SAND)
//						{
//							bottomCactus = true;
//						}
//						
//						while(i < 64)
//						{
//							pos0 = new BlockPos(pos.getX()+x, (pos.getY()+i) , pos.getZ()+z);
//							if (worldIn.getBlockState(pos0).getBlock() == Blocks.CACTUS)
//							{
//								i = i+1;
//							}
//							else
//							{
//								break;
//							}
//						}
//						
//						pos1 = new BlockPos(pos.getX()+x, (pos.getY()) , pos.getZ()+z);
//						if (worldIn.getBlockState(pos1).getBlock() != Blocks.CACTUS || bottomCactus){
//							i = i-1;
//						}
//					
//						for(y = i; y >= 0; y--){
//							if(bottomCactus)
//							{
//								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y+1) , pos.getZ()+z);
//								worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
//							}
//							else
//							{
//								pos0 = new BlockPos(pos.getX()+x, (pos.getY()+y) , pos.getZ()+z);
//								worldIn.setBlockState(pos0, Blocks.AIR.getDefaultState());
//							}
//						}
//						
//						player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.CACTUS), i, 0));
//											
//						valid = true;
//					}
//				}	
//			}
//			
//		}
//		else
//		{
//			if ((state.getMaterial().isToolNotRequired() || state.getBlock().getHarvestTool(state) == null))
//			{
//				return false;
//			}
//		}
//
//		stack.damageItem(i, playerIn);
//		
//		pos0 = new BlockPos(pos.getX(), (pos.getY()-1) , pos.getZ());
//		if(worldIn.getBlockState(pos0).getBlock() == Blocks.SAND)
//		{
//		worldIn.setBlockState(pos, Blocks.CACTUS.getDefaultState());
//		}
//
//		return valid;
//	}
}
