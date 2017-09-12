package com.tierzero.stacksonstacks.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class OreDictUtil {

	public static List<ItemStack> findWithPrefix(String prefix) {
		List<ItemStack> foundStacks = new ArrayList<ItemStack>();
		String[] oreNames = OreDictionary.getOreNames();

		for (String oreName : oreNames) {
			if(oreName.startsWith(prefix)) {
				foundStacks.addAll(OreDictionary.getOres(oreName));
			}
		}
		
		return foundStacks;
	}
	
}
