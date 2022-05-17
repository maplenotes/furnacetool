package net.maplenotes.furnacetools.tools;

import net.maplenotes.furnacetools.materials.Material;
import net.minecraft.item.ItemAxe;

public abstract class FurnaceAxe extends ItemAxe {

	static final protected String UnlocalizedItemName = "FurnaceAxe";

	protected FurnaceAxe(Material material) {
		super(ToolMaterial.valueOf(material.Name()), material.AttackDamage(), material.AttackSpeed());
		this.setUnlocalizedName(material.UnlocalizedMaterialCategory() + FurnaceAxe.UnlocalizedItemName);
	}
	
}
