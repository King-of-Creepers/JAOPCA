package thelm.jaopca.api.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import thelm.jaopca.api.EnumOreType;
import thelm.jaopca.api.IOreEntry;
import thelm.jaopca.api.JAOPCAApi;

public class Utils {

	public static final HashMap<String,ItemStack> CACHE = Maps.<String,ItemStack>newHashMap();
	public static final HashMap<String,FluidStack> CACHE1 = Maps.<String,FluidStack>newHashMap();
	public static final ArrayList<String> MOD_IDS = Lists.<String>newArrayList();

	public static ItemStack getOreStack(String name, int amount) {
		if(CACHE.containsKey(name)) {
			ItemStack ret = CACHE.get(name).copy();
			ret.setCount(amount);
			return ret;
		}

		ItemStack ret = ItemStack.EMPTY;
		if(!OreDictionary.getOres(name, false).isEmpty()) {
			List<ItemStack> list = OreDictionary.getOres(name, false);
			ret = getPreferredStack(list);
		}

		if(!ret.isEmpty()) {
			CACHE.put(name, ret.copy());
			ret.setCount(amount);
		}

		return ret;
	}

	public static ItemStack getOreStack(String prefix, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getOreName())) {
			ItemStack ret = CACHE.get(prefix+entry.getOreName()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getOreName())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getOreName());
			CACHE.put(prefix+entry.getOreName(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getOreName())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getOreName());
			CACHE.put(prefix+entry.getOreName(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStack(prefix+entry.getOreName(), amount);
	}

	public static ItemStack getJAOPCAOrOreStack(String prefix, String fallback, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getOreName())) {
			ItemStack ret = CACHE.get(prefix+entry.getOreName()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getOreName())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getOreName());
			CACHE.put(prefix+entry.getOreName(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getOreName())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getOreName());
			CACHE.put(prefix+entry.getOreName(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStack(fallback, entry, amount);
	}

	public static ItemStack getOreStackExtra(String prefix, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getExtra())) {
			ItemStack ret = CACHE.get(prefix+entry.getExtra()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getExtra())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getExtra());
			CACHE.put(prefix+entry.getExtra(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getExtra())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getExtra());
			CACHE.put(prefix+entry.getExtra(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStack(prefix+entry.getExtra(), amount);
	}

	public static ItemStack getJAOPCAOrOreStackExtra(String prefix, String fallback, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getExtra())) {
			ItemStack ret = CACHE.get(prefix+entry.getExtra()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getExtra())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getExtra());
			CACHE.put(prefix+entry.getExtra(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getExtra())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getExtra());
			CACHE.put(prefix+entry.getExtra(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStackExtra(fallback, entry, amount);
	}

	public static ItemStack getOreStackSecondExtra(String prefix, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getSecondExtra())) {
			ItemStack ret = CACHE.get(prefix+entry.getSecondExtra()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE.put(prefix+entry.getSecondExtra(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE.put(prefix+entry.getSecondExtra(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStack(prefix+entry.getSecondExtra(), amount);
	}

	public static ItemStack getJAOPCAOrOreStackSecondExtra(String prefix, String fallback, IOreEntry entry, int amount) {
		if(CACHE.containsKey(prefix+entry.getSecondExtra())) {
			ItemStack ret = CACHE.get(prefix+entry.getSecondExtra()).copy();
			ret.setCount(amount);
			return ret;
		}

		if(JAOPCAApi.BLOCKS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Block b = JAOPCAApi.BLOCKS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE.put(prefix+entry.getSecondExtra(), new ItemStack(b, 1, 0));
			return new ItemStack(b, amount, 0);
		}

		if(JAOPCAApi.ITEMS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Item i = JAOPCAApi.ITEMS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE.put(prefix+entry.getSecondExtra(), new ItemStack(i, 1, 0));
			return new ItemStack(i, amount, 0);
		}

		return getOreStackSecondExtra(fallback, entry, amount);
	}



	public static FluidStack getFluidStack(String name, int amount) {
		if(CACHE1.containsKey(name)) {
			FluidStack ret = CACHE1.get(name).copy();
			ret.amount = amount;
			return ret;
		}

		FluidStack ret = FluidRegistry.getFluidStack(name, 1);
		if(ret != null) {
			CACHE1.put(name, ret.copy());
			ret.amount = amount;
		}

		return ret;
	}

	public static FluidStack getFluidStack(String prefix, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getOreName());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getOreName())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getOreName());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStack(s, amount);
	}

	public static FluidStack getFluidStackExtra(String prefix, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getExtra());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getExtra())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getExtra());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStack(s, amount);
	}

	public static FluidStack getFluidStackSecondExtra(String prefix, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getSecondExtra());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStack(s, amount);
	}

	public static FluidStack getJAOPCAOrFluidStack(String prefix, String fallback, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getOreName());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getOreName())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getOreName());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStack(fallback, entry, amount);
	}

	public static FluidStack getJAOPCAOrFluidStackExtra(String prefix, String fallback, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getExtra());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getExtra())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getExtra());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStackExtra(fallback, entry, amount);
	}

	public static FluidStack getJAOPCAOrFluidStackSecondExtra(String prefix, String fallback, IOreEntry entry, int amount) {
		String s = (prefix.isEmpty()?"":toLowerCase(prefix)+'_')+to_under_score(entry.getSecondExtra());

		if(CACHE1.containsKey(s)) {
			FluidStack ret = CACHE1.get(s).copy();
			ret.amount = amount;
			return ret;
		}

		if(JAOPCAApi.FLUIDS_TABLE.contains(prefix, entry.getSecondExtra())) {
			Fluid f = JAOPCAApi.FLUIDS_TABLE.get(prefix, entry.getSecondExtra());
			CACHE1.put(s, new FluidStack(f, 1));
			return new FluidStack(f, amount);
		}

		return getFluidStackSecondExtra(fallback, entry, amount);
	}

	public static int energyI(IOreEntry entry, double energy) {
		return (int)(energy*entry.getEnergyModifier());
	}

	public static float energyF(IOreEntry entry, double energy) {
		return (float)(energy*entry.getEnergyModifier());
	}

	public static int energyReciprocalI(IOreEntry entry, double energy) {
		return (int)(energy/entry.getEnergyModifier());
	}

	public static float energyReciprocalF(IOreEntry entry, double energy) {
		return (float)(energy/entry.getEnergyModifier());
	}

	public static int rarityI(IOreEntry entry, double rarity) {
		return (int)(rarity*entry.getRarity());
	}

	public static float rarityF(IOreEntry entry, double rarity) {
		return (float)(rarity*entry.getRarity());
	}

	public static int rarityReciprocalI(IOreEntry entry, double rarity) {
		return (int)(rarity/entry.getRarity());
	}

	public static float rarityReciprocalF(IOreEntry entry, double rarity) {
		return (float)(rarity/entry.getRarity());
	}

	public static void addSmelting(ItemStack input, ItemStack output, float xp) {
		if(FurnaceRecipes.instance().getSmeltingResult(input).isEmpty()) {
			GameRegistry.addSmelting(input.copy(), output.copy(), xp);
		}
	}

	public static ItemStack resizeStack(ItemStack stack, int size) {
		if(!stack.isEmpty()) {
			ItemStack ret = stack.copy();
			ret.setCount(size);
			return ret;
		}
		return ItemStack.EMPTY;
	}

	public static boolean doesOreNameExist(String name) {
		return !OreDictionary.getOres(name, false).isEmpty();
	}

	public static ItemStack getPreferredStack(Iterable<ItemStack> itemList) {
		ItemStack ret = ItemStack.EMPTY;
		int index = Integer.MAX_VALUE;

		for(ItemStack stack : itemList) {
			if(stack.isEmpty()) {
				continue;
			}

			String modId = stack.getItem().getRegistryName().getResourceDomain();
			int idex = MOD_IDS.indexOf(modId);

			if(idex < index) {
				index = idex;
				ret = stack;
			}
		}

		return ret.copy();
	}

	public static String to_under_score(String camelCase) {
		if(StringUtils.isEmpty(camelCase)) {
			return "";
		}

		String[] strings = StringUtils.splitByCharacterTypeCamelCase(camelCase);
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < strings.length; i++) {
			ret.append(StringUtils.uncapitalize(strings[i]));
			if(i < strings.length-1) {
				ret.append('_');
			}
		}
		return ret.toString();
	}

	public static String toLowerCase(String s) {
		return s.toLowerCase(Locale.US);
	}

	public static String toSpaceSeparated(String camelCase) {
		if(StringUtils.isEmpty(camelCase)) {
			return "";
		}

		String[] strings = StringUtils.splitByCharacterTypeCamelCase(camelCase);
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < strings.length; i++) {
			ret.append(StringUtils.capitalize(strings[i]));
			if(i < strings.length-1) {
				if(!strings[i].equals("_") && !strings[i+1].equals("_")) {
					ret.append(' ');
				}
			}
		}
		return ret.toString();
	}

	public static ItemStack parseItemStack(String input) {
		if(input.startsWith("ore:")) {
			return ItemStack.EMPTY;
		}

		try {
			Item item;
			int meta=0, amount=1;
			String[] split0 = input.split("@");
			item = Item.REGISTRY.getObject(new ResourceLocation(split0[0]));
			if(split0.length == 2) {
				String[] split1 = split0[1].split("x");
				meta = Integer.parseInt(split1[0]);
				if(split1.length == 2) {
					amount = Integer.parseInt(split1[1]);
				}
			}
			return new ItemStack(item, amount, meta);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemStack.EMPTY;
	}

	public static EnumOreType oreNameToType(String oreName) {
		return JAOPCAApi.ORE_ENTRY_LIST.stream().filter(entry->entry.getOreName().equals(oreName)).findAny().get().getOreType();
	}

	public static void addShapedOreRecipe(ItemStack output, Object... input) {
		ResourceLocation location = getNameForRecipe(output, input);
		ShapedOreRecipe recipe = new ShapedOreRecipe(output.getItem().getRegistryName(), output, input);
		recipe.setRegistryName(location);
		ForgeRegistries.RECIPES.register(recipe);
	}

	public static void addShapelessOreRecipe(ItemStack output, Object... input) {
		ResourceLocation location = getNameForRecipe(output, input);
		ShapelessOreRecipe recipe = new ShapelessOreRecipe(output.getItem().getRegistryName(), output, input);
		recipe.setRegistryName(location);
		ForgeRegistries.RECIPES.register(recipe);
	}

	public static ResourceLocation getNameForRecipe(ItemStack output, Object... input) {
		ModContainer activeContainer = Loader.instance().activeModContainer();
		ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
		ResourceLocation recipeLoc = baseLoc;
		recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath()+"_"+Integer.toUnsignedString(Arrays.deepToString(input).hashCode(), 32));
		return recipeLoc;
	}
}
