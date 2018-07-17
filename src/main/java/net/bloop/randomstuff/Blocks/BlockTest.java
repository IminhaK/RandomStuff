package net.bloop.randomstuff.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTest extends Block {
    public BlockTest()
    {
        super(Material.IRON);
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
