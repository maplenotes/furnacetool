package net.maplenotes.furnacetools.event;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class ExtendCutBehavior {
    
    public static void onHarvest(HarvestDropsEvent event) {

    }

    // Item breaking event
    public static void onInteract(LeftClickBlock event) {

        ItemStack heldItem = event.getItemStack();
        
        if(heldItem == ItemStack.EMPTY) {
            return;
        }
        if(!(heldItem.getItem() instanceof ItemTool || heldItem.getItem() instanceof ItemHoe)) {
            return;
        }

        setDirectionToToolNBT(event.getItemStack(), event.getFace());
    }

    private static void setDirectionToToolNBT(ItemStack heldItem, EnumFacing facing) {
        
        NBTTagCompound nbt = heldItem.getTagCompound();
        if(nbt == null) {
            nbt = new NBTTagCompound();
            heldItem.setTagCompound(nbt);
        }
        nbt.setInteger("direction", facing.getIndex());

    }

}
