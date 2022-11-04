package net.maplenotes.furnacetools.materials;

import net.minecraft.item.Item.ToolMaterial;

public class MaterialExtendFurnace extends Material {
	
	private static float EnduranceRate = 8.0F * 10;
    public static final String MaterialName = "extended_furnace";
	private static final String UnlocalizedCategoryName = "Extend";

	@Override
	public String Name() {
		return MaterialExtendFurnace.MaterialName;
	}

	@Override
	public String UnlocalizedMaterialCategory() {
		return MaterialExtendFurnace.UnlocalizedCategoryName;
	}

	@Override
	public int HarvestLevel() {
		return ToolMaterial.STONE.getHarvestLevel();
	}

	@Override
	public int MaxUses() {
		return (int)(ToolMaterial.STONE.getMaxUses() * MaterialExtendFurnace.EnduranceRate);
	}

	@Override
	public float Efficiency() {
		return ToolMaterial.STONE.getEfficiency();
	}

	@Override
	public float Damage() {
		return ToolMaterial.STONE.getAttackDamage();
	}

	@Override
	public int Enchantability() {
		return 0;
	}

	@Override
	public float AttackDamage() {
		return 8.0F;
	}

	@Override
	public float AttackSpeed() {
		return -3.2F;
	}

}
