package net.maplenotes.furnacetools.tools.extendcut;

import java.util.ArrayList;
import java.util.List;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.tools.FurnacePickaxe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class ExtendCutPickaxe extends FurnacePickaxe {

    public ExtendCutPickaxe(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos orig, EntityLivingBase entityLiving) {
        return HookEvent.onBlockDestroyed(stack, worldIn, state, orig, entityLiving);
    }

}
