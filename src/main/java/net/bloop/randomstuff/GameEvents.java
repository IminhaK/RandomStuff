package net.bloop.randomstuff;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class GameEvents {

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent event)
    {
        if(ModConfig.fireworkBreaking) {
            BlockPos pos = event.getPos();
            World world = event.getPlayer().getEntityWorld();
            ItemStack stack = new ItemStack(Items.FIREWORKS);
            stack.setTagCompound(new NBTTagCompound());

            NBTTagCompound explosion = new NBTTagCompound();
            int[] color = new int[1];
            color[0] = event.getState().getBlock().getMapColor(event.getState(), world, pos).colorValue;
            explosion.setIntArray("Colors", color);
            explosion.setByte("Type", (byte) 1);

            NBTTagList explosions = new NBTTagList();
            explosions.appendTag(explosion);

            NBTTagCompound fireworkTag = new NBTTagCompound();
            fireworkTag.setTag("Explosions", explosions);
            fireworkTag.setByte("Flight", (byte) 0);
            fireworkTag.setByte("LifeTime", (byte) 1);
            stack.setTagInfo("Fireworks", fireworkTag);

            world.spawnEntity(new EntityFireworkRocket(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, stack));
        }
    }

    @SubscribeEvent
    public static void pickupTNT(EntityItemPickupEvent event)
    {
        World world = event.getItem().getEntityWorld();
        EntityItem item = event.getItem();
        if(item.getItem().getItem() == Item.getItemFromBlock(Blocks.TNT) && ModConfig.pickupExplosions)
        {
            EntityTNTPrimed tnt = new EntityTNTPrimed(world, item.posX, item.posY, item.posZ, event.getEntityLiving());
            tnt.setFuse(0);

            world.spawnEntity(tnt);
        }
    }

    @SubscribeEvent
    public static void onWeather(BlockEvent event)
    {
        World world = event.getWorld();
        WorldInfo worldInfo = world.getWorldInfo();
        if(!ModConfig.weatherEnabled && !world.isRemote && (worldInfo.isRaining() || worldInfo.isThundering()))
        {
            worldInfo.setRainTime(0);
            worldInfo.setThunderTime(0);
            worldInfo.setRaining(false);
            worldInfo.setThundering(false);
        }
    }

    @SubscribeEvent
    public static void swapPositions(ProjectileImpactEvent.Throwable event)
    {
        EntityThrowable throwable = event.getThrowable();
        Entity hit = event.getRayTraceResult().entityHit;
        EntityLivingBase thrower = event.getThrowable().getThrower();
        boolean playerNeeded = !ModConfig.swapPearlPlayerOnly || hit instanceof EntityPlayer;
        if(throwable instanceof EntityEnderPearl && playerNeeded && ModConfig.swapPearl && thrower instanceof EntityPlayer)
        {
            BlockPos hitLocation = hit.getPosition();
            hit.setPosition(thrower.posX, thrower.posY, thrower.posZ);
            thrower.setPosition(hitLocation.getX(), hitLocation.getY(), hitLocation.getZ());
        }
    }

    //Lightning does not trigger EntityJoinWorldEvent
    /* @SubscribeEvent
    public static void lightnightScaresPlayers(EntityJoinWorldEvent event)
    {
        Entity entity = event.getEntity();

        if(entity instanceof EntityLightningBolt && ModConfig.lightningScaresPlayers)
        {
            event.getWorld().playerEntities.forEach(p -> {
                if(p.isPlayerSleeping())
                {
                    p.wakeUpPlayer(true, true, false);
                }});
        }
    }*/
}
