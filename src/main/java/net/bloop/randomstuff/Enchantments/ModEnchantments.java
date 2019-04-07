package net.bloop.randomstuff.Enchantments;

import net.bloop.randomstuff.RandomStuff;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
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

    @SubscribeEvent
    public static void eggingDropEgg(LivingDeathEvent event)
    {
        Entity attacker = event.getSource().getTrueSource();
        Entity victim = event.getEntityLiving();
        World world = victim.world;

        if(attacker instanceof EntityPlayer && /*(new Random().nextInt(101) > 90) &&*/ !world.isRemote)
        {
            EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
            ItemStack weapon = player.getHeldItemMainhand();
            if(!(EnchantmentHelper.getEnchantments(weapon).get(egging) == null))
            {
                ItemStack egg = new ItemStack(Items.SPAWN_EGG);
                NBTTagCompound entitydata = new NBTTagCompound();
                entitydata.setString("id", victim.getName());

                egg.setTagInfo("EntityTag", entitydata);
                world.spawnEntity(new EntityItem(world, victim.posX, victim.posY, victim.posZ, egg));
            }
        }
    }
}
