package net.bloop.randomstuff.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block {

    private String name;

    public BlockMod(Material mat, String blockname)
    {
        super(mat);
        name = blockname;
        setRegistryName(blockname);
        setUnlocalizedName(blockname);
    }
}
