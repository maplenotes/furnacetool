package net.maplenotes.furnacetools.materials;

public abstract class Material {

	public abstract String Name();
    public abstract int HarvestLevel();
    public abstract int MaxUses();
    public abstract float Efficiency();
    public abstract float Damage();
    public abstract int Enchantability();
    public abstract float AttackDamage();
    public abstract float AttackSpeed();

}
