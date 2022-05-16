package net.maplenotes.furnacetools;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = FurnaceTools.MODID, version = FurnaceTools.VERSION, name = FurnaceTools.NAME)
public class FurnaceTools {

	public static final String MODID = "furnacetools";
	public static final String VERSION = "1.0";
	public static final String NAME = "Furnace Tools";

	@Instance(FurnaceTools.MODID)
    public static FurnaceTools INSTANCE;

}
