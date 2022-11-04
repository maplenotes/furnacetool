package net.maplenotes.furnacetools.registry;

import net.maplenotes.furnacetools.FurnaceTools;
import net.maplenotes.furnacetools.materials.MaterialDry;
import net.maplenotes.furnacetools.materials.MaterialExtendDry;
import net.maplenotes.furnacetools.materials.MaterialExtendFurnace;
import net.maplenotes.furnacetools.materials.MaterialFurnace;
import net.maplenotes.furnacetools.materials.MaterialLava;
import net.maplenotes.furnacetools.tools.FurnaceAxe;
import net.maplenotes.furnacetools.tools.FurnaceHoe;
import net.maplenotes.furnacetools.tools.FurnacePickaxe;
import net.maplenotes.furnacetools.tools.FurnaceShovel;
import net.maplenotes.furnacetools.tools.FurnaceSword;
import net.maplenotes.furnacetools.tools.extendcut.ExtendCutHoe;
import net.maplenotes.furnacetools.tools.extendcut.ExtendCutPickaxe;
import net.maplenotes.furnacetools.tools.extendcut.ExtendCutShovel;
import net.maplenotes.furnacetools.tools.smelting.SmeltingAxe;
import net.maplenotes.furnacetools.tools.smelting.SmeltingHoe;
import net.maplenotes.furnacetools.tools.smelting.SmeltingPickaxe;
import net.maplenotes.furnacetools.tools.smelting.SmeltingShovel;
import net.maplenotes.furnacetools.tools.smelting.SmeltingSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Items {

    public static Item MaterialDry = new Item()
        .setUnlocalizedName("DryFurnaceMaterial")
        .setRegistryName(FurnaceTools.MODID, "material_item_dry")
        .setCreativeTab(CreativeTabs.MATERIALS);

    public static Item MaterialExtensionalStone = new Item()
        .setUnlocalizedName("ExtensionalStone")
        .setRegistryName(FurnaceTools.MODID, "material_extensional_stone")
        .setCreativeTab(CreativeTabs.MATERIALS);

    public static Item StandardFurnaceAxe = new FurnaceAxe(new MaterialFurnace());
    public static Item StandardFurnacePickaxe = new FurnacePickaxe(new MaterialFurnace());
    public static Item StandardFurnaceShovel = new FurnaceShovel(new MaterialFurnace());
    public static Item StandardFurnaceSword = new FurnaceSword(new MaterialFurnace());
    public static Item StandardFurnaceHoe = new FurnaceHoe(new MaterialFurnace());

    public static Item DryFurnaceAxe = new SmeltingAxe(new MaterialDry());
    public static Item DryFurnacePickaxe = new SmeltingPickaxe(new MaterialDry());
    public static Item DryFurnaceShovel = new SmeltingShovel(new MaterialDry());
    public static Item DryFurnaceSword = new SmeltingSword(new MaterialDry());
    public static Item DryFurnaceHoe = new SmeltingHoe(new MaterialDry());

    public static Item LavaFurnaceAxe = new SmeltingAxe(new MaterialLava());
    public static Item LavaFurnacePickaxe = new SmeltingPickaxe(new MaterialLava());
    public static Item LavaFurnaceShovel = new SmeltingShovel(new MaterialLava());
    public static Item LavaFurnaceSword = new SmeltingSword(new MaterialLava());
    public static Item LavaFurnaceHoe = new SmeltingHoe(new MaterialLava());

    public static Item ExtendFurnacePickaxe = new ExtendCutPickaxe(new MaterialExtendFurnace());
    public static Item ExtendFurnaceShovel = new ExtendCutShovel(new MaterialExtendFurnace());
    public static Item ExtendFurnaceHoe = new ExtendCutHoe(new MaterialExtendFurnace());

    public static Item ExtendDryFurnacePickaxe = new ExtendCutPickaxe(new MaterialExtendDry());
    public static Item ExtendDryFurnaceShovel = new ExtendCutShovel(new MaterialExtendDry());
    public static Item ExtendDryFurnaceHoe = new ExtendCutHoe(new MaterialExtendDry());
}
