package com.KJR.ICF;

import com.KJR.ICF.config.ICF_Config;
import com.KJR.ICF.proxy.CommonProxy;
import com.KJR.ICF.registry.ICF_Blocks;
import com.KJR.ICF.registry.ICF_Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = ICF_Global.modID , name = ICF_Global.modName, version = ICF_Global.version, guiFactory = ICF_Global.guiFactory )
public class Main {
	
	@Instance(ICF_Global.modID)
	public static Main instance;
	
	@SidedProxy(clientSide = ICF_Global.ICF_Client_Proxy, serverSide = ICF_Global.ICF_Common_Proxy)
	public static CommonProxy proxy;
	
	public static CreativeTabs tabImitationConstructionFoam = new CreativeTabs("Tab_ICF") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return new ItemStack(ICF_Items.icfMisc_1, 0, 1).getItem();
		}
	};
	
//	   public static ICFWorldGen eventWorldGen = new ICFWorldGen();
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){
		
		this.proxy.preInit(preEvent);
		
//		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler()); ----------------------------------------------------------

//		BlocksICF.init();
//		ItemsICF.init();
//		FoodICF.init();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){

		this.proxy.init(event);
		
//		OreRegistry.OreRegistration();
//		SwineRegistry.registerSmashables();
//		Recipes.init();
//		GameRegistry.registerWorldGenerator(eventWorldGen, 1);
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
		this.proxy.postInit(postEvent);
		
	}
}
