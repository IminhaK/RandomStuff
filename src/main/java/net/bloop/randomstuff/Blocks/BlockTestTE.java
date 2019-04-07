package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.Blocks.TileEntity.TileTestTE;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockTestTE extends BlockTEMod<TileTestTE> {

    public BlockTestTE()
    {
        super(Material.ROCK, "blocktestte");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z)
    {
        if(!world.isRemote)
        {
            TileTestTE tile = getTileEntity(world, pos);
            tile.increaseCount();
            player.sendMessage(new TextComponentString("Counter: " + tile.getCount()));
        }
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileTestTE();
    }
}
