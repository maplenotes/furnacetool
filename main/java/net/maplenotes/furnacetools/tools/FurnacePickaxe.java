package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemPickaxe;

public abstract class FurnacePickaxe extends ItemPickaxe {
	
	protected FurnacePickaxe(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
	}

}
