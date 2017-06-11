package com.KJR.ICF;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialsICF {

	//Armor
	//TODO edit armor materials to include values for final two arguments in function
	public static ArmorMaterial ALUMINUMARMOR = EnumHelper.addArmorMaterial("ALUMINUMARMOR", ICF_Global.modID + ":" + "aluminum", 12, new int[]{2, 5, 4, 1}, 12, null, 1.0f);
	public static ArmorMaterial ENDIMANDIUMARMOR = EnumHelper.addArmorMaterial("ENDIMANDIUMARMOR", ICF_Global.modID + ":" + "endimandium", 80, new int[]{5, 10, 8, 5}, 40, null, 6.0f);
	public static ArmorMaterial CACTUSARMOR = EnumHelper.addArmorMaterial("CACTUSARMOR", ICF_Global.modID + ":" + "catus", 25, new int[]{3, 6, 5, 2}, 40, null, 3.0f);
	public static ArmorMaterial HEAVYCACTUSARMOR = EnumHelper.addArmorMaterial("HEAVYCACTUSARMOR", ICF_Global.modID + ":" + "heavycactus", 35, new int[]{4, 7, 6, 2}, 40, null, 4.0f);
	public static ArmorMaterial CACTUSROBES = EnumHelper.addArmorMaterial("CACTUSROBES", ICF_Global.modID + ":" + "robes", 15, new int[]{1, 1, 1, 1}, 40, null, 2.0f);
	
	//Swine
	public static ToolMaterial EndimandiumSwineMaterial = EnumHelper.addToolMaterial("EndimandiumSwineMaterial", 4, 3500, 27.0F, 7.0F, 22);
	public static ToolMaterial AluminumSwineMaterial = EnumHelper.addToolMaterial("AluminumSwineMaterial", 4, 200, 7.0F, 3.0F, 12);
	public static ToolMaterial BronzeSwineMaterial = EnumHelper.addToolMaterial("BronzeSwineMaterial", 4, 650, 13.0F, 3.0F, 10);
	
	//Tools
	public static ToolMaterial AluminumToolMaterial = EnumHelper.addToolMaterial("AluminumToolMaterial", 2, 175, 6.0F, 2.0F, 12);
	public static ToolMaterial CactusToolMaterial = EnumHelper.addToolMaterial("CactusToolMaterial", 2, 500, 7.0F, 4.0F, 22);
	public static ToolMaterial HeavyCactusToolMaterial = EnumHelper.addToolMaterial("HeavyCactusToolMaterial", 2, 1500, 13.0F, 7.0F, 22);
	
}

