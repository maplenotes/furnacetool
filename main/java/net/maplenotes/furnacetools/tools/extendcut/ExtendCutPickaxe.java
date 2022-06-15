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
        
        if(!(entityLiving instanceof EntityPlayer)) {
            return true;
        }

        // プレイヤーがブロックを破壊したとき、どの面に対してツールを当てていたかを調べる
        NBTTagCompound nbt = stack.getTagCompound();
        if(nbt == null) {
            return true;
        }
        // 方向 0, 1 = (上下面) 2, 3 = (南北面) 4, 5 = (東西面)
        int direction = nbt.getInteger("direction");

        // 回収対象ブロックを 3x3 の範囲で特定する
        List<BlockPos> targets = new ArrayList<>();

        // 各軸が -1 ～ 1 の範囲で変動する
        for(int i = -1; i <= 1; i++ ) {
            for(int j = -1; j <= 1; j++) {   
                BlockPos target = null;

                if(direction == 0 || direction == 1) {
                    // Y軸は固定
                    target = new BlockPos(orig.getX() + i, orig.getY(), orig.getZ() + j);
                } 
                else if (direction == 2 || direction == 3) {
                    // z軸は固定
                    target = new BlockPos(orig.getX() + i, orig.getY() + j, orig.getZ());
                }
                else {
                    // x軸は固定
                    target = new BlockPos(orig.getX(), orig.getY() + i, orig.getZ() + j);
                }

                targets.add(target);
            }
        }

        int damage = 0;
        Block centerBlock = state.getBlock();
        for(BlockPos target: targets) {
            
            Block targetBlock = worldIn.getBlockState(target).getBlock();

            // 破壊対象(ツールで破壊しようとしているブロック)と同種のブロックは周辺ブロックとしての回収対象になる。
            // また、スニーキングして回収しようとしている場合、同種のブロックであるかに関わらずに回収対象になる。
            if(centerBlock == targetBlock || entityLiving.isSneaking()) {

                EntityPlayer player = (EntityPlayer)entityLiving;
                
                boolean harvestable = targetBlock.canHarvestBlock(worldIn, target, player);
                
                // 破壊処理
                targetBlock.removedByPlayer(state, worldIn, target, player, harvestable);
                if(harvestable) {
                    targetBlock.harvestBlock(worldIn, player, target, state, worldIn.getTileEntity(target), stack);
                }

                // 耐久値減少処理
                if(state.getBlockHardness(worldIn, target) != 0.0D) {
                    if(((ItemTool)stack.getItem()).getDestroySpeed(stack, state) <= 1.0F) {
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

}
