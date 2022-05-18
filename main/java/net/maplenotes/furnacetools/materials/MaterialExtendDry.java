package net.maplenotes.furnacetools.materials;

import net.minecraft.item.Item.ToolMaterial;

public class MaterialExtendDry extends Material {
	
	private static float EnduranceRate = 6.0F * 10;
    private static final String MaterialName = "extended_dry";
	private static final String UnlocalizedCategoryName = "ExtendDry";

	@Override
	public String Name() {
		return MaterialExtendDry.MaterialName;
	}

	@Override
	public String UnlocalizedMaterialCategory() {
		return MaterialExtendDry.UnlocalizedCategoryName;
	}

	@Override
	public int HarvestLevel() {
		return ToolMaterial.STONE.getHarvestLevel();
	}

	@Override
	public int MaxUses() {
		return (int)(ToolMaterial.STONE.getHarvestLevel() * MaterialExtendDry.EnduranceRate);
	}

	@Override
	public float Efficiency() {
		return ToolMaterial.IRON.getEfficiency();
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
