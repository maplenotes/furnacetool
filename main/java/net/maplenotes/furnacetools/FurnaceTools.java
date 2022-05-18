package net.maplenotes.furnacetools;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = FurnaceTools.MODID, version = FurnaceTools.VERSION, name = FurnaceTools.NAME)
public class FurnaceTools {

	public static final String MODID = "furnacetools";
	public static final String VERSION = "1.0";
	public static final String NAME = "Furnace Tools";

	@Instance(FurnaceTools.MODID)
    public static FurnaceTools INSTANCE;

	@EventHandler
    public void bootstrap(FMLConstructionEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }

	@SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
		FurnaceToolsRegistry.RegistrationItems(event.getRegistry());
	}

}
