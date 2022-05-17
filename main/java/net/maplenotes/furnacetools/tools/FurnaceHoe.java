package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemHoe;

public abstract class FurnaceHoe extends ItemHoe {

	protected FurnaceHoe(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
	}
	
}
