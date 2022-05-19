package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemSpade;

public class FurnaceShovel extends ItemSpade {

	static final protected String UnlocalizedItemName = "FurnaceShovel";
	
	public FurnaceShovel(Material material) {
		super(ToolMaterial.valueOf(material.Name()));
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceShovel.UnlocalizedItemName);
		this.setRegistryName(FurnaceTools.MODID, (material.Name() + "_" + FurnaceShovel.UnlocalizedItemName).toLowerCase());
	}

}
