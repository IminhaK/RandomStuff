package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber(modid = RandomStuff.MODID)
public class BlockRegistry {

    public static BlockTest blockTest;
    public static ItemBlock itemBlockTest;

    @SubscribeEvent
    static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        blockTest = (BlockTest)(new BlockTest().setUnlocalizedName("blocktest"));
        registerBlock("blocktest", blockTest);
        registerItemBlock(itemBlockTest, blockTest, "blocktest");
    }

    private static void registerBlock(String blockName, Block varName)
    {
        varName.setRegistryName(blockName);
        ForgeRegistries.BLOCKS.register(varName);
    }

    private static void registerItemBlock(ItemBlock varItemBlockName, Block varBlockName, String varName)
    {
        varItemBlockName = new ItemBlock(varBlockName);
        varItemBlockName.setRegistryName(varBlockName.getRegistryName());
        ForgeRegistries.ITEMS.register(varItemBlockName);
        ModelLoader.setCustomModelResourceLocation(varItemBlockName, 0, new ModelResourceLocation("randomstuff:" + varName, "inventory"));
    }
}
