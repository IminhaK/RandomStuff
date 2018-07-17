package net.bloop.randomstuff;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RandomStuff.MODID, name = RandomStuff.NAME, version = RandomStuff.VERSION)
public class RandomStuff
{
    public static final String MODID = "randomstuff";
    public static final String NAME = "Random Stuff";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
