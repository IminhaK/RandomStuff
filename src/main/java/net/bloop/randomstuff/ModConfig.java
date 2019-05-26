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

    @Config.RangeInt(min = 0, max = 100)
    @Config.Comment("% chance for the egging enchantment to drop an egg.")
    public static int eggingChance = 10;

    @Config.Comment("Hitting a player with an enter pearl swaps locations")
    public static boolean swapPearl = true;

    @Config.Comment("If true, enderpearls will only swap with players.")
    public static boolean swapPearlPlayerOnly = true;

    //@Config.Comment("Lightning strikes have a chance to scare the player out of bed.")
    //public static boolean lightningScaresPlayers = true;

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
