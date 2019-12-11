package net.bloop.randomstuff.Enchantments;

import net.bloop.randomstuff.ModConfig;
import net.bloop.randomstuff.RandomStuff;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber(modid = RandomStuff.MODID)
public class EnchantmentEgging extends Enchantment {

    public EnchantmentEgging()
    {
        super(Rarity.COMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        setRegistryName("egging");
        setName("egging");
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }

    @SubscribeEvent
    public static void eggingDropEgg(LivingDeathEvent event)
    {
        Entity attacker = event.getSource().getTrueSource();
        Entity victim = event.getEntityLiving();
        World world = victim.world;

        if(attacker instanceof EntityPlayer && (new Random().nextInt(101) <= ModConfig.eggingChance) && !world.isRemote)
        {
            EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
            ItemStack weapon = player.getHeldItemMainhand();
            if(!(EnchantmentHelper.getEnchantments(weapon).get(ModEnchantments.egging) == null))
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
