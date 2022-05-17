package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemHoe;

public abstract class FurnaceHoe extends ItemHoe {

	static final protected String UnlocalizedItemName = "FurnaceHoe";

	protected FurnaceHoe(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceHoe.UnlocalizedItemName);
	}
	
}
