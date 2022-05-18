package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemAxe;

public class FurnaceAxe extends ItemAxe {

	static final protected String UnlocalizedItemName = "FurnaceAxe";

	public FurnaceAxe(Material material) {
		super(ToolMaterial.valueOf(material.Name()), material.AttackDamage(), material.AttackSpeed());
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceAxe.UnlocalizedItemName);
		this.setRegistryName(FurnaceTools.MODID, this.getUnlocalizedName());
	}
	
}
