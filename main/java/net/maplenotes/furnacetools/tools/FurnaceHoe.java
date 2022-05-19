package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemHoe;

public class FurnaceHoe extends ItemHoe {

	static final protected String UnlocalizedItemName = "FurnaceHoe";

	public FurnaceHoe(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceHoe.UnlocalizedItemName);
		this.setRegistryName(FurnaceTools.MODID, (material.Name() + "_" + FurnaceHoe.UnlocalizedItemName).toLowerCase());
	}
	
}
