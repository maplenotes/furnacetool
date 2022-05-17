package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSword;

public abstract class FurnaceSword extends ItemSword {

	protected FurnaceSword(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
	}
	
}
