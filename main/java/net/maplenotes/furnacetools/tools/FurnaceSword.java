package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSword;

public class FurnaceSword extends ItemSword {

	static final protected String UnlocalizedItemName = "FurnaceSword";

	public FurnaceSword(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceSword.UnlocalizedItemName);
		this.setRegistryName(FurnaceTools.MODID, (material.Name() + "_" + FurnaceSword.UnlocalizedItemName).toLowerCase());
	}
	
}
