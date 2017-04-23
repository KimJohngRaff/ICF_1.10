package com.KJR.ICF.api.helpers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Swineable {
	public Item itemSource;
	public int sourceMeta;
	public Item item;
	public int meta;
	public int rewardAmount;
	public ItemStack stackSource;

	public Swineable(ItemStack stackSource, Item itemSource, int sourceMeta, Item item, int meta, int rewardAmount) {
		this.itemSource = itemSource;
		this.sourceMeta = sourceMeta;
		this.item = item;
		this.meta = meta;
		this.rewardAmount = rewardAmount;
		this.stackSource = stackSource;
	}
}