package net.maplenotes.furnacetools;

import net.maplenotes.furnacetools.event.EventFacade;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

	@SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event){
        FurnaceToolsRegistry.RegistrationModels();
    }

    @SubscribeEvent
    public void onBlockHarvest(HarvestDropsEvent event){
        EventFacade.onHarvest(event);
    }

}
