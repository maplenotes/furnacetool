package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSpade;

public abstract class FurnaceShovel extends ItemSpade {
	
	protected FurnaceShovel(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
	}

}
