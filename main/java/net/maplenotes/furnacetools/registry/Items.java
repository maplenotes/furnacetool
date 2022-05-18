package net.maplenotes.furnacetools.registry;

import net.maplenotes.furnacetools.materials.MaterialFurnace;
import net.maplenotes.furnacetools.tools.FurnaceAxe;
import net.maplenotes.furnacetools.tools.FurnaceHoe;
import net.maplenotes.furnacetools.tools.FurnacePickaxe;
import net.maplenotes.furnacetools.tools.FurnaceShovel;
import net.maplenotes.furnacetools.tools.FurnaceSword;
import net.minecraft.item.Item;

public class Items {
    
    public static Item StandardFurnaceAxe = new FurnaceAxe(new MaterialFurnace());
    public static Item StandardFurnacePickaxe = new FurnacePickaxe(new MaterialFurnace());
    public static Item StandardFurnaceShovel = new FurnaceShovel(new MaterialFurnace());
    public static Item StandardFurnaceSword = new FurnaceSword(new MaterialFurnace());
    public static Item StandardFurnaceHoe = new FurnaceHoe(new MaterialFurnace());

}
