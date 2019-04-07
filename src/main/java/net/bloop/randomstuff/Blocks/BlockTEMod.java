package net.bloop.randomstuff.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTEMod<T extends TileEntity> extends BlockMod {

    public BlockTEMod(Material mat, String name)
    {
        super(mat, name);
    }

    public T getTileEntity(IBlockAccess world, BlockPos pos)
    {
        return (T)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
