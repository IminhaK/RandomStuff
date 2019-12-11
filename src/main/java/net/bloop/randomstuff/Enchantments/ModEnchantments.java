package net.bloop.randomstuff.Enchantments;

import net.bloop.randomstuff.RandomStuff;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Random;

@Mod.EventBusSubscriber(modid = RandomStuff.MODID)
public class ModEnchantments {

    public static Enchantment egging = new EnchantmentEgging();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event)
    {
        IForgeRegistry<Enchantment> r = event.getRegistry();

        r.register(egging);
    }
}
