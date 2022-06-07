package net.maplenotes.furnacetools.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class SmeltingBehavior {
    
    public static void onHarvest(HarvestDropsEvent event) {
        IBlockState state = event.getState();

        // 回収対象ブロックが精錬レシピに存在するか確認する
        // 精錬レシピにない場合、 ItemStack.EMPTY が返る
        ItemStack targetBlock = new ItemStack(state.getBlock(), 1);
        ItemStack smeltingResult = FurnaceRecipes.instance().getSmeltingResult(targetBlock);

        if(smeltingResult == ItemStack.EMPTY) {
            return;
        }

        event.getDrops().clear();
        event.getDrops().add(new ItemStack(smeltingResult.getItem(), 1));
    }

}
