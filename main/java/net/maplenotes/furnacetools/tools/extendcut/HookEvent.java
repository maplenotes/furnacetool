package net.maplenotes.furnacetools.tools.extendcut;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HookEvent {
    
    // package access
    static boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos orig, EntityLivingBase entityLiving) {

        if(!(entityLiving instanceof EntityPlayer)) {
            return true;
        }

        // プレイヤーがブロックを破壊したとき、どの面に対してツールを当てていたかを調べる
        NBTTagCompound nbt = stack.getTagCompound();
        if(nbt == null) {
            return true;
        }

        // クワ = 小麦のみに対して 範囲 5, ショベル or つるはし = 範囲 3
        Item heldItem = stack.getItem();
        int range = (heldItem instanceof ItemHoe) ? 5 : 3;

        // 方向 0, 1 = (上下面) 2, 3 = (南北面) 4, 5 = (東西面)
        int direction = (heldItem instanceof ItemHoe) ? 0 : nbt.getInteger("direction");

        // 回収対象ブロックを 3x3 (5x5) の範囲で特定する
        List<BlockPos> targets = getTargetBlockPoses(orig, getDirection(direction), range);

        int damage = 0;
        Block centerBlock = state.getBlock();
        for(BlockPos target: targets) {
            
            Block targetBlock = worldIn.getBlockState(target).getBlock();
            IBlockState targetState = worldIn.getBlockState(target);

            // 破壊対象(ツールで破壊しようとしているブロック)と同種のブロックは周辺ブロックとしての回収対象になる。
            // また、スニーキングして回収しようとしている場合、同種のブロックであるかに関わらずに回収対象になる。
            if((centerBlock == targetBlock && centerBlock.getMetaFromState(state) == targetBlock.getMetaFromState(targetState)) || entityLiving.isSneaking()) {

                EntityPlayer player = (EntityPlayer)entityLiving;
                
                boolean harvestable = targetBlock.canHarvestBlock(worldIn, target, player);
                
                // クワ特殊化 (クワで収穫した時、完全に成長しきった小麦/ジャガイモ/人参のみが収穫対象となる)
                if(heldItem instanceof ItemHoe){
                    if (!(targetBlock == Blocks.WHEAT || targetBlock == Blocks.POTATOES || targetBlock == Blocks.CARROTS)) {
                        continue;
                    }
                    if(targetBlock.getMetaFromState(targetState) != 7) {
                        continue;
                    }
                }

                // 破壊処理
                targetBlock.removedByPlayer(targetState, worldIn, target, player, harvestable);
                if(harvestable) {
                    targetBlock.harvestBlock(worldIn, player, target, targetState, worldIn.getTileEntity(target), stack);
                }

                // 耐久値減少処理
                if(targetState.getBlockHardness(worldIn, target) != 0.0D) {
                    if(((ItemTool)stack.getItem()).getDestroySpeed(stack, targetState) <= 1.0F) {
                        damage += 2;
                    } else {
                        damage += 1;
                    }
                }
            } 
        }
        
        stack.damageItem(damage, entityLiving);

        return true;
    }

    private static EnumAxis getDirection(int directionIndex) {
        if(directionIndex == 0 || directionIndex == 1) {
            // axis Y
            return EnumAxis.Y;
        } else if (directionIndex == 2 || directionIndex == 3) {
            return EnumAxis.Z;
        } else if (directionIndex == 4 || directionIndex == 5) {
            return EnumAxis.X;
        }
        return EnumAxis.NONE;
    }

    private static List<BlockPos> getTargetBlockPoses(BlockPos originPos, EnumAxis axis, int diameter) {
        List<BlockPos> targets = new ArrayList<>();

        int radius = (diameter - 1) / 2;
        int start = 0 - radius;
        int end = 0 + radius;

        for(int i = start; i <= end; i++) {
            for(int j = start; j <= end; j++) {
                BlockPos target = null;
                switch(axis){ 
                    case X:
                        target = new BlockPos(originPos.getX(), originPos.getY() + i, originPos.getZ() + j);
                        break;
                    case Y:
                        target = new BlockPos(originPos.getX() + i, originPos.getY(), originPos.getZ() + j);
                        break;
                    case Z:
                        target = new BlockPos(originPos.getX() + i, originPos.getY() + j, originPos.getZ());
                        break;
                    default:
                        break;
                }
                targets.add(target);
            }
        }

        return targets;
    }

}
