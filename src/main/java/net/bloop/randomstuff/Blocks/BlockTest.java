package net.bloop.randomstuff.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTest extends BlockMod {

    public BlockTest()
    {
        super(Material.IRON, "blocktest");
        this.setHardness(0.5f);
        this.setSoundType(SoundType.METAL);
    }

}
