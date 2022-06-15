package net.maplenotes.furnacetools.event;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class ExtendCutBehavior {
    
    public static void onHarvest(HarvestDropsEvent event) {

    }

    public static void onInteract(LeftClickBlock event) {

        ItemStack heldItem = event.getItemStack();
        
        if(heldItem == ItemStack.EMPTY) {
            return;
        }
        if(!(heldItem.getItem() instanceof ItemTool)) {
            return;
        }
        
        NBTTagCompound nbt = heldItem.getTagCompound();
        if(nbt == null) {
            nbt = new NBTTagCompound();
            heldItem.setTagCompound(nbt);
        }
        nbt.setInteger("direction", event.getFace().getIndex());

    }

}
