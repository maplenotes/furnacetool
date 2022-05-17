package net.maplenotes.furnacetools.materials;

import net.minecraft.item.Item.ToolMaterial;

public class MaterialLava extends Material {

	private static float EnduranceRate = 4.0F;
    public static final String MaterialName = "lava";

	@Override
	public String Name() {
		return MaterialFurnace.MaterialName;
	}

	@Override
	public int HarvestLevel() {
		return ToolMaterial.IRON.getHarvestLevel();
	}

	@Override
	public int MaxUses() {
		return (int)(ToolMaterial.STONE.getHarvestLevel() * MaterialLava.EnduranceRate);
	}

	@Override
	public float Efficiency() {
		return ToolMaterial.DIAMOND.getEfficiency();
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
