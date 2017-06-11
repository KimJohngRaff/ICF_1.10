package com.KJR.ICF.config;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

    import com.KJR.ICF.ICF_Global;

    import net.minecraft.client.Minecraft;
	import net.minecraft.client.gui.GuiScreen;
	import net.minecraft.client.resources.I18n;
	import net.minecraftforge.common.config.ConfigElement;
	import net.minecraftforge.common.config.Configuration;
    import net.minecraftforge.fml.client.IModGuiFactory;
    import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
	import net.minecraftforge.fml.client.config.GuiConfig;
	import net.minecraftforge.fml.client.config.GuiConfigEntries;
	import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
	import net.minecraftforge.fml.client.config.IConfigElement;

	/**
	 * The in game view of the config file
	 *
	 */
	public class ICF_Config_GUI_Factory  implements IModGuiFactory {

		/**
		 * Used to initialize values from the user's minecraft instance
		 * We don't use this
		 */
		@Override
		public void initialize(Minecraft minecraftInstance) {
		}

		/**
		 * The actual class which is the gui
		 */
		@Override
		public Class<? extends GuiScreen> mainConfigGuiClass() {
			return ICF_ConfigGui.class;
		}

		/**
		 * Ggets the runtime gui categories which change in game
		 */
		@Override
		public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
			return null;
		}

		/**
		 * Used to change the colour of the properties
		 */
		@Override
		public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
			return null;
		}
		
		/**
		 * The gui for the config
		 *
		 */
		public static class ICF_ConfigGui extends GuiConfig {
			
			/**
			 * Settting up the screen
			 * @param parentScreen The prior screen
			 */
			public ICF_ConfigGui(GuiScreen parentScreen) {
				super(parentScreen, getConfigElements(), ICF_Global.modID, false, false, I18n.format("gui.config.title"));
			}

			/**
			 * Get all of the different categories
			 * @return a list of the different categories
			 */
			private static List<IConfigElement> getConfigElements() {
				List<IConfigElement> list = new ArrayList<IConfigElement>();
				list.add(new DummyCategoryElement(I18n.format("gui.config.category.gen"), "gui.config.category.gen", CategoryEntryGen.class)); //Add another one of these for any other categories
				return list;
			}
			
			/**
			 * The category for the blocks
			 *
			 */
			public static class CategoryEntryGen extends CategoryEntry {

				/**
				 * Default constructor
				 */
				public CategoryEntryGen(GuiConfig owningScreen, GuiConfigEntries owningEntryList,
						IConfigElement configElement) {
					super(owningScreen, owningEntryList, configElement);
				}
				
				/**
				 * Puts all of the properties on the screen from the category
				 */
				@Override
				protected GuiScreen buildChildScreen() {
					Configuration config = ICF_Config.getConfig();
					ConfigElement categoryGen = new ConfigElement(config.getCategory(ICF_Config.Set_Ore_Gen));
					List<IConfigElement> propertiesOnScreen = categoryGen.getChildElements();
					String windowTitle = I18n.format("gui.config.category.gen");
					return new GuiConfig(owningScreen, propertiesOnScreen, owningScreen.modID, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
				}
				
			}
			
		}


//		@Override
//		public boolean hasConfigGui() {
//			return true;
//		}
//
//		@Override
//		public GuiScreen createConfigGui(GuiScreen parentScreen) {
//			return new ICF_ConfigGui(parentScreen);
//		}

	}