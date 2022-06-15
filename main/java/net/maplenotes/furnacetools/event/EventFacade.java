package net.maplenotes.furnacetools.event;

import net.maplenotes.furnacetools.materials.MaterialDry;
import net.maplenotes.furnacetools.materials.MaterialExtendDry;
import net.maplenotes.furnacetools.materials.MaterialExtendFurnace;
import net.maplenotes.furnacetools.materials.MaterialLava;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class EventFacade {
    
    // ブロックを何らかの方法で破壊してドロップが発生した時に発生するイベント
    public static void onHarvest(HarvestDropsEvent event) {
        
        EntityPlayer harvester = event.getHarvester();

        if(harvester == null) {
            return;
        }

        ItemStack heldItemStack = harvester.getHeldItem(harvester.getActiveHand());

        if(!(heldItemStack.getItem() instanceof ItemTool)) {
            return;
        }

        ItemTool tool = (ItemTool)heldItemStack.getItem();
        String materialName = tool.getToolMaterialName();

        switch(materialName) {
            case MaterialDry.MaterialName:
                // fall through
            case MaterialLava.MaterialName:
                SmeltingBehavior.onHarvest(event);
                break;

            case MaterialExtendFurnace.MaterialName:
                // fall through
            case MaterialExtendDry.MaterialName:
                ExtendCutBehavior.onHarvest(event);
                break;

            default:
                // nothing to do.
        }

    }

}
