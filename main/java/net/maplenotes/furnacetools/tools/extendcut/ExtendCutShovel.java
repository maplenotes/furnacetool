package net.maplenotes.furnacetools.tools.extendcut;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.tools.FurnaceShovel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExtendCutShovel extends FurnaceShovel {

    public ExtendCutShovel(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos orig, EntityLivingBase entityLiving) {
        return HookEvent.onBlockDestroyed(stack, worldIn, state, orig, entityLiving);
    }
	
}
