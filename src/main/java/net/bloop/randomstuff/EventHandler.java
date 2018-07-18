package net.bloop.randomstuff;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = RandomStuff.MODID)
public class EventHandler {

    public static int timer = 0;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event)
    {
        timer++;
        System.out.println(timer);
    }
}
