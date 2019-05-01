package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.Blocks.TileEntity.TileTestTE;
import net.bloop.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = RandomStuff.MODID)
public class BlockRegistry {

    private static String modid = RandomStuff.MODID;

    public static Block blockTest = new BlockTest();
    public static Block blockTestTE = new BlockTestTE();
    public static Block blockTall = new BlockTall();
    public static Block blockTallTop = new BlockTallTop();

    @SubscribeEvent
    static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> r = event.getRegistry();

        r.register(blockTest);
        r.register(blockTestTE);
        GameRegistry.registerTileEntity(TileTestTE.class, new ResourceLocation(modid + ":tiletestte"));
        r.register(blockTall);
        r.register(blockTallTop);
    }

    @SubscribeEvent
    static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> r = event.getRegistry();

        r.register(new ItemBlock(blockTest).setRegistryName("blocktest"));
        r.register(new ItemBlock(blockTestTE).setRegistryName("blocktestte"));
        r.register(new ItemBlock(blockTall).setRegistryName("blocktall"));
        r.register(new ItemBlock(blockTallTop).setRegistryName("blocktalltop"));
    }

    @SubscribeEvent
    static void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockTest), 0, new ModelResourceLocation(modid + ":blocktest"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockTestTE), 0, new ModelResourceLocation(modid + ":blocktestte"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockTall), 0, new ModelResourceLocation(modid + ":blocktall"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockTallTop), 0, new ModelResourceLocation(modid + ":blocktalltop"));
    }
}
