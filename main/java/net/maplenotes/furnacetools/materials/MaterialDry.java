package net.maplenotes.furnacetools.materials;

import net.minecraft.item.Item.ToolMaterial;

public class MaterialDry extends Material {

	private static float EnduranceRate = 6.0F;
    public static final String MaterialName = "dry";
	private static final String UnlocalizedCategoryName = "Dry";

	@Override
	public String Name() {
		return MaterialDry.MaterialName;
	}

	@Override
	public String UnlocalizedMaterialCategory() {
		return MaterialDry.UnlocalizedCategoryName;
	}

	@Override
	public int HarvestLevel() {
		return ToolMaterial.STONE.getHarvestLevel();
	}

	@Override
	public int MaxUses() {
		return (int)(ToolMaterial.STONE.getMaxUses() * MaterialDry.EnduranceRate);
	}

	@Override
	public float Efficiency() {
		return ToolMaterial.IRON.getEfficiency();
	}

	@Override
	public float Damage() {
		return ToolMaterial.IRON.getAttackDamage();
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
