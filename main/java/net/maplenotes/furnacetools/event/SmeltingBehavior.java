package net.maplenotes.furnacetools.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class SmeltingBehavior {
    
    public static void onHarvest(HarvestDropsEvent event) {

        EntityPlayer player = event.getHarvester();

        // スニーキング状態での回収のみ、精錬回収が発動できる
        if(!player.isSneaking()) {
            return;
        }

        IBlockState state = event.getState();

        // 回収対象ブロックが精錬レシピに存在するか確認する
        // 精錬レシピにない場合、 ItemStack.EMPTY が返る
        ItemStack targetBlock = new ItemStack(state.getBlock(), 1);
        ItemStack smeltingResult = FurnaceRecipes.instance().getSmeltingResult(targetBlock);

        if(smeltingResult == ItemStack.EMPTY) {
            return;
        }
        
        ItemStack heldItem = player.getHeldItem(player.getActiveHand());

        if(heldItem == ItemStack.EMPTY) {
            return;
        }
        if(!(heldItem.getItem() instanceof ItemTool)) {
            return;
        }

        ItemTool tool = (ItemTool)heldItem.getItem();

        // ツールが得意としていないブロックを回収しようとしていた場合、精錬回収は発動しない
        if(tool.getDestroySpeed(heldItem, state) <= 1.0F) {
            return;
        }

        event.getDrops().clear();
        event.getDrops().add(new ItemStack(smeltingResult.getItem(), 1));
        heldItem.damageItem(1, player);
    }

}
