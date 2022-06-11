package net.maplenotes.furnacetools.event;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
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

        // シルクタッチがあるときは、精錬回収できない
        if(event.isSilkTouching()) {
            return;
        }

        ItemStack heldItem = player.getHeldItem(player.getActiveHand());
        IBlockState state = event.getState();
        ItemStack targetBlock = new ItemStack(state.getBlock(), 1);

        // 特殊実装:例外判定 焼き石を回収した時、(丸石ではなく)焼き石をドロップする
        if((state.getBlock() instanceof BlockStone) && state.getBlock().getMetaFromState(state) == 0 && (heldItem.getItem() instanceof ItemPickaxe)) {
            event.getDrops().removeIf(x -> x.getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE));
            event.getDrops().add(new ItemStack(Blocks.STONE, 1, 0));
            return;
        }

        // 回収対象ブロックが精錬レシピに存在するか確認する
        // 精錬レシピにない場合、 ItemStack.EMPTY が返る
        ItemStack smeltingResult = FurnaceRecipes.instance().getSmeltingResult(targetBlock);

        if(smeltingResult == ItemStack.EMPTY) {
            return;
        }
        
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

        event.getDrops().removeIf(x -> x.getItem() == Item.getItemFromBlock(state.getBlock()) && x.getMetadata() == state.getBlock().getMetaFromState(state));
        event.getDrops().add(targetBlock);
        heldItem.damageItem(1, player);
    }

}
