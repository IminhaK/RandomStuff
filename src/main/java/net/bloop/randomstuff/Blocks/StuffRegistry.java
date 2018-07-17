package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.Items.ItemBlockBase;
import net.bloop.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = RandomStuff.MODID)
public class StuffRegistry {

    private static void registerBlock(RegistryEvent.Register<Block> event, String name, Block block)
    {
        block.setRegistryName(RandomStuff.MODID, name);
        block.setUnlocalizedName(name);
        block.setCreativeTab(CreativeTabs.MISC);
        event.getRegistry().register(block);
    }

    private static void registerItem(RegistryEvent.Register<Item> event, String name, Item item)
    {
        item.setRegistryName(RandomStuff.MODID, name);
        item.setUnlocalizedName(name);
        item.setCreativeTab(CreativeTabs.MISC);
        event.getRegistry().register(item);
    }

    @SubscribeEvent
    static void onBlockRegistry(RegistryEvent.Register<Block> event)
    {
        registerBlock(event, "blocktest", new BlockTest());
    }

    @SubscribeEvent
    static void onItemRegistry(RegistryEvent.Register<Item> event)
    {
        registerItem(event, "blocktest", new ItemBlockBase(StuffBlocks.BLOCK_TEST));
    }
}
