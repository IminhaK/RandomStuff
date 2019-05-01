package net.bloop.randomstuff.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTall extends BlockMod {

    public BlockTall()
    {
        super(Material.GLASS, "blocktall");
        this.setHardness(0.5f);
        this.setSoundType(SoundType.GLASS);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos.add(0,1,0), BlockRegistry.blockTallTop.getDefaultState());
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.getBlockState(pos.add(0,1,0)).getBlock().isReplaceable(worldIn, pos.add(0,1,0));
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        BlockPos oppositeBlock = pos.add(0,1,0);

        worldIn.setBlockToAir(oppositeBlock);
        if(!worldIn.isRemote && !player.isCreative())
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockRegistry.blockTall)));
    }
}
