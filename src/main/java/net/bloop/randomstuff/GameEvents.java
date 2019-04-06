package net.bloop.randomstuff;

import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class GameEvents {

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent event)
    {
        BlockPos pos = event.getPos();
        World world = event.getPlayer().getEntityWorld();
        ItemStack stack = new ItemStack(Items.FIREWORKS);
        stack.setTagCompound(new NBTTagCompound());

        NBTTagCompound explosion = new NBTTagCompound();
        int[] color = new int[1];
        color[0] = event.getState().getBlock().getMapColor(event.getState(), world, pos).colorValue;
        explosion.setIntArray("Colors", color);
        explosion.setByte("Type", (byte)1);

        NBTTagList explosions = new NBTTagList();
        explosions.appendTag(explosion);

        NBTTagCompound fireworkTag = new NBTTagCompound();
        fireworkTag.setTag("Explosions", explosions);
        fireworkTag.setByte("Flight", (byte)0);
        fireworkTag.setByte("LifeTime", (byte) 1);
        stack.setTagInfo("Fireworks", fireworkTag);

        world.spawnEntity(new EntityFireworkRocket(world, pos.getX(), pos.getY(), pos.getZ(), stack));
    }
}