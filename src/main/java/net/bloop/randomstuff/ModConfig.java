package net.bloop.randomstuff;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RandomStuff.MODID)
@Config.LangKey("randomstuff.config.title")
public class ModConfig {

    @Config.Comment("Can weather occur?")
    public static boolean weatherEnabled = true;

    @Config.Comment("Does TnT explode when picked up?")
    public static boolean pickupExplosions = true;

    @Config.Comment("Do fireworks spawn whenever a block is broken?")
    public static boolean fireworkBreaking = true;

    @Mod.EventBusSubscriber(modid = RandomStuff.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(RandomStuff.MODID)) {
                ConfigManager.sync(RandomStuff.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
