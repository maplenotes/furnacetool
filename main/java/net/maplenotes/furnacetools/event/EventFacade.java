package net.maplenotes.furnacetools.event;

import net.maplenotes.furnacetools.materials.MaterialDry;
import net.maplenotes.furnacetools.materials.MaterialExtendDry;
import net.maplenotes.furnacetools.materials.MaterialExtendFurnace;
import net.maplenotes.furnacetools.materials.MaterialLava;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class EventFacade {
    
    // ブロックを何らかの方法で破壊してドロップが発生した時に発生するイベント
    public static void onHarvest(HarvestDropsEvent event) {
        
        EntityPlayer harvester = event.getHarvester();

        if(harvester == null) {
            return;
        }

        ItemStack heldItemStack = harvester.getHeldItem(harvester.getActiveHand());

        if(!(heldItemStack.getItem() instanceof ItemTool || heldItemStack.getItem() instanceof ItemHoe)) {
            return;
        }

        String materialName = "";
        if(heldItemStack.getItem() instanceof ItemTool) {
            materialName = ((ItemTool)heldItemStack.getItem()).getToolMaterialName();
        } else {
            materialName = ((ItemHoe)heldItemStack.getItem()).getMaterialName();
        }

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

    // プレイヤーがブロックを破壊しようとするなどして左ボタンを押し続けている間呼ばれるイベント
    public static void onInteract(LeftClickBlock event) {

        ItemStack stack = event.getItemStack();

        if(!(stack.getItem() instanceof ItemTool || stack.getItem() instanceof ItemHoe)) {
            return;
        }

        String materialName = "";
        if(stack.getItem() instanceof ItemTool) {
            materialName = ((ItemTool)stack.getItem()).getToolMaterialName();
        } else {
            materialName = ((ItemHoe)stack.getItem()).getMaterialName();
        }

        switch(materialName) {
            case MaterialDry.MaterialName:
                // fall through
            case MaterialLava.MaterialName:
                break;

            case MaterialExtendFurnace.MaterialName:
                // fall through
            case MaterialExtendDry.MaterialName:
                ExtendCutBehavior.onInteract(event);
                break;

            default:
                // nothing to do.
        }
    }

}
