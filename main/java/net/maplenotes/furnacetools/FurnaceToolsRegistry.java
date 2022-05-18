package net.maplenotes.furnacetools;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.materials.MaterialDry;
import net.maplenotes.furnacetools.materials.MaterialFurnace;
import net.maplenotes.furnacetools.materials.MaterialLava;
import net.maplenotes.furnacetools.registry.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class FurnaceToolsRegistry {
	
	private static void AddToolMaterial(Material material){
		EnumHelper.addToolMaterial(
			material.Name(), 
			material.HarvestLevel(), 
			material.MaxUses(), 
			material.Efficiency(), 
			material.Damage(), 
			material.Enchantability()
		);
	}

	static {
		FurnaceToolsRegistry.AddToolMaterial(new MaterialFurnace());
		FurnaceToolsRegistry.AddToolMaterial(new MaterialDry());
		FurnaceToolsRegistry.AddToolMaterial(new MaterialLava());
	}

	public static void RegistrationItems(IForgeRegistry<Item> registry) {
		registry.register(Items.StandardFurnaceAxe);
		registry.register(Items.StandardFurnacePickaxe);
		registry.register(Items.StandardFurnaceShovel);
		registry.register(Items.StandardFurnaceSword);
		registry.register(Items.StandardFurnaceHoe);
	}

}
