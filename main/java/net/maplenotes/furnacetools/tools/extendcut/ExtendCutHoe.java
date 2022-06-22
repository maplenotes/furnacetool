package net.maplenotes.furnacetools.tools.extendcut;

import java.util.ArrayList;
import java.util.List;

import net.maplenotes.furnacetools.materials.Material;
import net.maplenotes.furnacetools.materials.MaterialExtendDry;
import net.maplenotes.furnacetools.materials.MaterialExtendFurnace;
import net.maplenotes.furnacetools.tools.FurnaceHoe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class ExtendCutHoe extends FurnaceHoe {

	public ExtendCutHoe(Material material) {
		super(material);
	}
	
	@Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos orig, EntityLivingBase entityLiving) {
        return HookEvent.onBlockDestroyed(stack, worldIn, state, orig, entityLiving);
    }

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		List<BlockPos> targets = HookEvent.getTargetBlockPoses(pos, EnumAxis.Y, 5);

		if(worldIn.getBlockState(pos).getBlock() == Blocks.FARMLAND) {
			this.placeSeed(player, worldIn, pos, hand, targets);
		}
		else {
			for(BlockPos targetPos: targets) {
				super.onItemUse(player, worldIn, targetPos, hand, facing, hitX, hitY, hitZ);
			}
		}

		return EnumActionResult.SUCCESS;
	}

	// when right click to dirt block, seed will be placed
	private void placeSeed(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, List<BlockPos> targetArea) {
		ItemStack stack = player.getHeldItem(hand);
		Item item = stack.getItem();
		if(item instanceof ItemHoe) {
			ItemHoe tool = (ItemHoe)item;
			if(tool.getMaterialName().equals(MaterialExtendFurnace.MaterialName) || tool.getMaterialName().equals(MaterialExtendDry.MaterialName)) {
				
				List<BlockPos> sowingTarget = this.getPlantableBlocks(targetArea, worldIn);
				int sowingAreaSize = sowingTarget.size();
				Item willPlanting = null;

				if(this.playerHasSatisfyPlantableItem(player, Items.WHEAT_SEEDS, sowingAreaSize)) {
					willPlanting = Items.WHEAT_SEEDS;
				} else if(this.playerHasSatisfyPlantableItem(player, Items.POTATO, sowingAreaSize)) {
					willPlanting = Items.POTATO;
				} else if(this.playerHasSatisfyPlantableItem(player, Items.CARROT, sowingAreaSize)) {
					willPlanting = Items.CARROT;
				}

				if(willPlanting == null) {
					return;
				}

				// sow
				this.plantingSeeds(player, willPlanting, sowingTarget, worldIn);
			}
		}
	}

	// in target areas, how many dirt block
	private List<BlockPos> getPlantableBlocks(List<BlockPos> blockPos, World world) {
		List<BlockPos> result = new ArrayList<BlockPos>();
		for(BlockPos pos: blockPos) {
			if(world.getBlockState(pos).getBlock() == Blocks.FARMLAND && world.isAirBlock(pos.up())) {
				result.add(pos);
			}
		}
		return result;
	}

	// check player has satisfy plantable item or not
	private boolean playerHasSatisfyPlantableItem(EntityPlayer player, Item item, int amount) {
		List<ItemStack> playerInventory = player.inventory.mainInventory;
		int playerHas = 0;
		for (ItemStack stack : playerInventory) {
			if (stack.getItem() == item) {
				playerHas += stack.getCount();
			}
		}
		return playerHas >= amount;
	}

	// planting seeds
	private void plantingSeeds(EntityPlayer player, Item targetItem, List<BlockPos> targetPos, World world) {
		if(!(targetItem instanceof IPlantable)){
			return;
		}
		IPlantable plantable = (IPlantable)targetItem;

		for(BlockPos pos: targetPos) {
			if(world.getBlockState(pos).getBlock() == Blocks.FARMLAND) {
				
				// check if player has enough item and consume it
				if(!decrementItemFromPlayerInventory(player, targetItem)) {
					break;
				}

				// plant seed on dirt block
				world.setBlockState(pos.up(), plantable.getPlant(world, pos));
			}
		}
	}

	// decrement item from player inventory, return true if success
	private boolean decrementItemFromPlayerInventory(EntityPlayer player, Item item) {
		List<ItemStack> playerInventory = player.inventory.mainInventory;
		for (ItemStack stack : playerInventory) {
			if (stack.getItem() == item) {
				stack.setCount(stack.getCount() - 1);
				return true;
			}
		}
		return false;
	}

}
