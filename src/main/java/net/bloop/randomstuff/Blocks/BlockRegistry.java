package net.bloop.randomstuff.Blocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockRegistry {

    public static BlockTest blockTest;
    public static ItemBlock itemBlockTest;

    public static void registerBlocks()
    {
        blockTest = (BlockTest)(new BlockTest().setUnlocalizedName("blocktest"));
        blockTest.setRegistryName("blocktest");
        ForgeRegistries.BLOCKS.register(blockTest);

        itemBlockTest = new ItemBlock(blockTest);
        itemBlockTest.setRegistryName(blockTest.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlockTest);
        ModelLoader.setCustomModelResourceLocation(itemBlockTest,0, new ModelResourceLocation("randomstuff:blocktest","inventory"));
    }
}
