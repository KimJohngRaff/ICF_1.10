package com.KJR.ICF.items;

import java.util.List;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item_ICF_Single_Stack extends Item {

    public static String[] names = {"CactusBook"};

    public Item_ICF_Single_Stack() {
        super();

        setCreativeTab(Main.tabImitationConstructionFoam);
        setUnlocalizedName(ICF_Global.modID + ".SingleStack.");
        setRegistryName("icfSingleStack");
        setHasSubtypes(true);
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, List<ItemStack> list)
    {
        for (int i = 0; i < names.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName(stack) + names[stack.getItemDamage()];
    }
}