package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.Blocks.TileEntity.TileTestTE;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockTestTE extends BlockTEMod<TileTestTE> {

    public BlockTestTE()
    {
        super(Material.WOOD, "blocktestte");
        setHardness(1.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z)
    {
        if(hand == EnumHand.OFF_HAND)
            return false;
        if(player.isCreative())
            return false;

        ItemStack holding = player.getHeldItem(hand);
        if(!world.isRemote)
        {
            TileTestTE tile = getTileEntity(world, pos);
            ItemStack inserted = tile.items.insertItem(0, holding, false);
            player.setHeldItem(hand, inserted);
        }
        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
    {
        if(!world.isRemote)
        {
            TileTestTE tile = getTileEntity(world, pos);
            if(!player.isSneaking())
                spawnAsEntity(world, pos.add(0, 1, 0), tile.items.extractItem(0, 64, false));
            else
                spawnAsEntity(world, pos.add(0, 1, 0), tile.items.extractItem(0, 1, false));
        }
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if(!worldIn.isRemote)
        {
            TileTestTE tile = getTileEntity(worldIn, pos);
            spawnAsEntity(worldIn, pos, tile.items.extractItem(0,64,false));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("§8§oHolds up to 1 stack of any item");
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileTestTE();
    }
}
