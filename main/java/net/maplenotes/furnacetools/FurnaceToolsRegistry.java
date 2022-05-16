package net.maplenotes.furnacetools;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.materials.MaterialFurnace;
import net.minecraftforge.common.util.EnumHelper;

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
	}

}
