package com.KJR.ICF.proxy;

import com.KJR.ICF.api.handler.ICF_Armor_Effect_Handler;
import com.KJR.ICF.api.handler.ICF_Crafting_Handler;
import com.KJR.ICF.api.handler.ICF_Drops_Handler;
import com.KJR.ICF.api.handler.ICF_Fuel_Handler;
import com.KJR.ICF.config.ICF_Config;
import com.KJR.ICF.registry.ICF_Blocks;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.OreRegistry;
import com.KJR.ICF.registry.Recipes;
import com.KJR.ICF.registry.SwineRegistry;
import com.KJR.ICF.world.ICF_WorldGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent){
		
		ICF_Config.preInit();
		ICF_Blocks.initBlocks();
		ICF_Items.initItems();
		
	}
	
	public void init(FMLInitializationEvent event){
		
		Recipes.init();
		OreRegistry.OreRegistration();
		GameRegistry.registerWorldGenerator(new ICF_WorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new ICF_Armor_Effect_Handler());
		MinecraftForge.EVENT_BUS.register(new ICF_Drops_Handler());
		MinecraftForge.EVENT_BUS.register(new ICF_Crafting_Handler());
		GameRegistry.registerFuelHandler(new ICF_Fuel_Handler());
		SwineRegistry.registerSwineables();
		
	}
	
	public void postInit(FMLPostInitializationEvent postEvent){
		
	}
	
}
