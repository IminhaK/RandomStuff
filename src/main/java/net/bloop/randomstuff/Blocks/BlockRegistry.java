package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = RandomStuff.MODID)
public class BlockRegistry {

    public static Block blockTest = new BlockTest();

    @SubscribeEvent
    static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> r = event.getRegistry();

        r.register(blockTest);
    }

    @SubscribeEvent
    static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> r = event.getRegistry();

        r.register(new ItemBlock(blockTest).setRegistryName("blocktest"));
    }

    @SubscribeEvent
    static void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockTest), 0, new ModelResourceLocation(RandomStuff.MODID + ":blocktest"));
    }
}
