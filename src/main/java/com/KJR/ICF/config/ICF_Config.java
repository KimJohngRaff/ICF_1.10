package com.KJR.ICF.config;

	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;

    import com.KJR.ICF.ICF_Global;

    import net.minecraft.client.resources.I18n;
	import net.minecraftforge.common.MinecraftForge;
	import net.minecraftforge.common.config.Configuration;
	import net.minecraftforge.common.config.Property;
	import net.minecraftforge.fml.client.event.ConfigChangedEvent;
	import net.minecraftforge.fml.common.Loader;
	import net.minecraftforge.fml.common.eventhandler.EventPriority;
	import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

	/**
	 * The main class for your configuration.
	 * Get all of your customized values here
	 *
	 */
	public class ICF_Config {
		
		/**
		 * The object which holds the actual config file
		 */
		private static Configuration config = null;
		
		/**
		 * The name of the category for our blocks
		 */
		public static final String Set_Ore_Gen = "OreGen";
		
		/**
		 * The values which are loaded from the config file
		 */
		public static boolean bGenPlatinum;
		public static boolean bGenTin;
		public static boolean bGenSilver;
		public static boolean bGenAluminum;
		public static boolean bGenCopper;
		public static boolean bGenNickel;
		public static boolean bGenSulfur;
		public static boolean bGenSaltpeter;
		
		/**
		 * Called on the server and the client setting up the config file
		 */
		public static void preInit() {
			File configFile = new File(Loader.instance().getConfigDir(), "ICF.cfg");
			config = new Configuration(configFile);
			syncFromFiles();
		}
		
		/**
		 * Receive the config object for use in the gui factory
		 * @return the config element
		 */
		public static Configuration getConfig() {
			return config;
		}
		
		/**
		 * Register our event which handles the gui factory saving the config
		 */
		public static void clientPreInit() {
			MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
		}
		
		/**
		 * Sync the config from a change in the file
		 */
		public static void syncFromFiles() {
			syncConfig(true, true);
		}
		
		/**
		 * Sync the config from a change in the gui
		 */
		public static void syncFromGui() {
			syncConfig(false, true);
		}
		
		/**
		 * Sync the config from a change in the fields
		 */
		public static void syncFromFields() {
			syncConfig(false, false);
		}
		
		/**
		 * Used internally to sync all of our properties and fields
		 * @param loadFromConfigFile Should load the actual config file?
		 * @param readFieldsFromConfig Should read the values from the config?
		 */
		private static void syncConfig(boolean loadFromConfigFile, boolean readFieldsFromConfig) {
			if(loadFromConfigFile)
				config.load();
			
			Property propertyGeneratePlatinum = config.get(Set_Ore_Gen, "Generate_Platinum_Ore", true);
			propertyGeneratePlatinum.setLanguageKey("gui.config.gen.platinum.name");

			Property propertyGenerateTin = config.get(Set_Ore_Gen, "Generate_Tin_Ore", true);
			propertyGenerateTin.setLanguageKey("gui.config.gen.tin.name");
			
			Property propertyGenerateSilver = config.get(Set_Ore_Gen, "Generate_Silver_Ore", true);
			propertyGenerateSilver.setLanguageKey("gui.config.gen.silver.name");
			
			Property propertyGenerateAluminum = config.get(Set_Ore_Gen, "Generate_Aluminum_Ore", true);
			propertyGenerateAluminum.setLanguageKey("gui.config.gen.aluminum.name");
			
			Property propertyGenerateCopper = config.get(Set_Ore_Gen, "Generate_Copper_Ore", true);
			propertyGenerateCopper.setLanguageKey("gui.config.gen.copper.name");
			
			Property propertyGenerateNickel = config.get(Set_Ore_Gen, "Generate_Nickel_Ore", true);
			propertyGenerateNickel.setLanguageKey("gui.config.gen.nickel.name");
			
			Property propertyGenerateSulfur = config.get(Set_Ore_Gen, "Generate_Sulfur_Ore", true);
			propertyGenerateSulfur.setLanguageKey("gui.config.gen.sulfur.name");
			
			Property propertyGenerateSaltpeter = config.get(Set_Ore_Gen, "Generate_Saltpeter_Ore", true);
			propertyGenerateSaltpeter.setLanguageKey("gui.config.gen.saltpeter.name");
			
			List<String> propertyOrderGen = new ArrayList<String>();
			propertyOrderGen.add(propertyGeneratePlatinum.getName());
			propertyOrderGen.add(propertyGenerateTin.getName());
			propertyOrderGen.add(propertyGenerateSilver.getName());
			propertyOrderGen.add(propertyGenerateAluminum.getName());
			propertyOrderGen.add(propertyGenerateCopper.getName());
			propertyOrderGen.add(propertyGenerateNickel.getName());
			propertyOrderGen.add(propertyGenerateSulfur.getName());
			propertyOrderGen.add(propertyGenerateSaltpeter.getName());

			config.setCategoryPropertyOrder(Set_Ore_Gen, propertyOrderGen);
			
			if(readFieldsFromConfig) {
				bGenPlatinum = propertyGeneratePlatinum.getBoolean();
				bGenTin = propertyGenerateTin.getBoolean();
				bGenSilver = propertyGenerateSilver.getBoolean();
				bGenAluminum = propertyGenerateAluminum.getBoolean();
				bGenCopper = propertyGenerateCopper.getBoolean();
				bGenNickel = propertyGenerateNickel.getBoolean();
				bGenSulfur = propertyGenerateSulfur.getBoolean();
				bGenSaltpeter = propertyGenerateSaltpeter.getBoolean();
			}
			
			propertyGeneratePlatinum.set(bGenPlatinum);
			propertyGenerateTin.set(bGenTin);
			propertyGenerateSilver.set(bGenSilver);
			propertyGenerateAluminum.set(bGenAluminum);
			propertyGenerateCopper.set(bGenCopper);
			propertyGenerateNickel.set(bGenNickel);
			propertyGenerateSulfur.set(bGenSulfur);
			propertyGenerateSaltpeter.set(bGenSaltpeter);
			
			if(config.hasChanged())
				config.save();
		}
		
		/**
		 * Handles the updating of the config from the gui factory
		 *
		 */
		public static class ConfigEventHandler {
			
			/**
			 * Syncs the update from the gui factory
			 */
			@SubscribeEvent(priority = EventPriority.LOWEST)
			public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
				if(event.getModID().equals(ICF_Global.modID)) {
					syncFromGui();
				}
			}
			
		}

	}
