package net.bloop.randomstuff.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTallTop extends BlockMod {

    public BlockTallTop()
    {
        super(Material.GLASS, "blocktalltop");
        this.setHardness(0.5f);
        this.setSoundType(SoundType.GLASS);
        this.setCreativeTab(null);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        BlockPos oppositeBlock = pos.add(0,-1,0);

        worldIn.setBlockToAir(oppositeBlock);
        if(!worldIn.isRemote && !player.isCreative())
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockRegistry.blockTall)));
    }
}
