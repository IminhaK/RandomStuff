package net.bloop.randomstuff.Items;

import net.bloop.randomstuff.RandomStuff;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid= RandomStuff.MODID)
public class ItemRegistry {

    public static Item itemRandomDrop = new ItemRandomDrop();

    @SubscribeEvent
    static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> r = event.getRegistry();

        r.register(itemRandomDrop);
    }

    @SubscribeEvent
    static void registerModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(itemRandomDrop, 0, new ModelResourceLocation(RandomStuff.MODID + ":itemrandomdrop"));
    }
}
