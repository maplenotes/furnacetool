package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSpade;

public abstract class FurnaceShovel extends ItemSpade {

	static final protected String UnlocalizedItemName = "FurnaceShovel";
	
	protected FurnaceShovel(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceShovel.UnlocalizedItemName);
	}

}
