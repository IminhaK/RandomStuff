package net.bloop.randomstuff.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

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
}
