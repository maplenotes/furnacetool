package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSword;

public abstract class FurnaceSword extends ItemSword {

	static final protected String UnlocalizedItemName = "FurnaceSword";

	protected FurnaceSword(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceSword.UnlocalizedItemName);
	}
	
}
