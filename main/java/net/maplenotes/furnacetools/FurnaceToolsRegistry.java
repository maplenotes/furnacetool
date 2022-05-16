package net.maplenotes.furnacetools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraftforge.common.util.EnumHelper;

public class FurnaceToolsRegistry {
	
	public static void AddToolMaterial(Material material){

		EnumHelper.addToolMaterial(
			material.Name(), 
			material.HarvestLevel(), 
			material.MaxUses(), 
			material.Efficiency(), 
			material.Damage(), 
			material.Enchantability()
		);

	}

}
