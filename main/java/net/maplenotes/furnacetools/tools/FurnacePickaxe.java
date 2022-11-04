package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemPickaxe;

public class FurnacePickaxe extends ItemPickaxe {

	static final protected String UnlocalizedItemName = "FurnacePickaxe";
	
	public FurnacePickaxe(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnacePickaxe.UnlocalizedItemName);
		this.setRegistryName(FurnaceTools.MODID, (material.Name() + "_" + FurnacePickaxe.UnlocalizedItemName).toLowerCase());
	}

}
