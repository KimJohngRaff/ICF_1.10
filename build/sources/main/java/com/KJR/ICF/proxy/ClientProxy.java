package com.KJR.ICF.proxy;

import com.KJR.ICF.api.handler.ICF_Armor_Effect_Handler;
import com.KJR.ICF.api.handler.ICF_Crafting_Handler;
import com.KJR.ICF.api.handler.ICF_Drops_Handler;
import com.KJR.ICF.config.ICF_Config;
import com.KJR.ICF.registry.ICF_Blocks;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.OreRegistry;
import com.KJR.ICF.registry.Recipes;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	
	public void preInit(FMLPreInitializationEvent preEvent){
		
		super.preInit(preEvent);
		
//		ICF_Blocks.registerBlockItemVariants();
//		ICF_Items.registerItemVariants();	
		
		ICF_Config.clientPreInit();
		ICF_Blocks.renderBlocks();
		ICF_Items.renderItems();
		
	}
	
	
	public void init(FMLInitializationEvent event){
		
		super.init(event);	
		
	}
	
	
	public void postInit(FMLPostInitializationEvent postEvent){
		
		super.postInit(postEvent);
		
	}
	
}