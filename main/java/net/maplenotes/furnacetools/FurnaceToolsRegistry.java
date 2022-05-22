package net.maplenotes.furnacetools;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.materials.MaterialDry;
import net.maplenotes.furnacetools.materials.MaterialFurnace;
import net.maplenotes.furnacetools.materials.MaterialLava;
import net.maplenotes.furnacetools.registry.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class FurnaceToolsRegistry {

	private static final String VARIANT_INVENTRY = "inventory";
	
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
		registry.register(Items.MaterialDry);

		registry.register(Items.StandardFurnaceAxe);
		registry.register(Items.StandardFurnacePickaxe);
		registry.register(Items.StandardFurnaceShovel);
		registry.register(Items.StandardFurnaceSword);
		registry.register(Items.StandardFurnaceHoe);

		registry.register(Items.DryFurnaceAxe);
		registry.register(Items.DryFurnacePickaxe);
		registry.register(Items.DryFurnaceShovel);
		registry.register(Items.DryFurnaceSword);
		registry.register(Items.DryFurnaceHoe);

		registry.register(Items.LavaFurnaceAxe);
		registry.register(Items.LavaFurnacePickaxe);
		registry.register(Items.LavaFurnaceShovel);
		registry.register(Items.LavaFurnaceSword);
		registry.register(Items.LavaFurnaceHoe);
	}

	public static void RegistrationModels() {
		ModelLoader.setCustomModelResourceLocation(Items.MaterialDry, 0, new ModelResourceLocation(Items.MaterialDry.getRegistryName(), VARIANT_INVENTRY));

		ModelLoader.setCustomModelResourceLocation(Items.StandardFurnaceAxe, 0, new ModelResourceLocation(Items.StandardFurnaceAxe.getRegistryName(), VARIANT_INVENTRY));
		ModelLoader.setCustomModelResourceLocation(Items.StandardFurnacePickaxe, 0, new ModelResourceLocation(Items.StandardFurnacePickaxe.getRegistryName(), VARIANT_INVENTRY));
		ModelLoader.setCustomModelResourceLocation(Items.StandardFurnaceShovel, 0, new ModelResourceLocation(Items.StandardFurnaceShovel.getRegistryName(), VARIANT_INVENTRY));
		ModelLoader.setCustomModelResourceLocation(Items.StandardFurnaceSword, 0, new ModelResourceLocation(Items.StandardFurnaceSword.getRegistryName(), VARIANT_INVENTRY));
		ModelLoader.setCustomModelResourceLocation(Items.StandardFurnaceHoe, 0, new ModelResourceLocation(Items.StandardFurnaceHoe.getRegistryName(), VARIANT_INVENTRY));
	}

}
