package com.KJR.ICF;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialsICF {

	//Armor
	//TODO edit armor materials to include values for final two arguments in function
	public static ArmorMaterial ALUMINUMARMOR = EnumHelper.addArmorMaterial("ALUMINUMARMOR", ICF_Global.modID + ":" + "aluminum", 12, new int[]{2, 5, 4, 1}, 12, null, 0);
	public static ArmorMaterial ENDIMANDIUMARMOR = EnumHelper.addArmorMaterial("ENDIMANDIUMARMOR", ICF_Global.modID + ":" + "endimandium", 80, new int[]{5, 10, 8, 5}, 40, null, 0);
	
	//Swine
	public static ToolMaterial EndimandiumSwineMaterial = EnumHelper.addToolMaterial("EndimandiumSwineMaterial", 4, 3500, 27.0F, 7.0F, 22);
	public static ToolMaterial AluminumSwineMaterial = EnumHelper.addToolMaterial("AluminumSwineMaterial", 4, 200, 7.0F, 3.0F, 12);
	public static ToolMaterial BronzeSwineMaterial = EnumHelper.addToolMaterial("BronzeSwineMaterial", 4, 650, 13.0F, 3.0F, 10);
	
	//Tools
	public static ToolMaterial AluminumToolMaterial = EnumHelper.addToolMaterial("AluminumToolMaterial", 2, 175, 6.0F, 2.0F, 12);
	
}

