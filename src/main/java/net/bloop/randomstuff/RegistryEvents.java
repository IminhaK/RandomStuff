package net.bloop.randomstuff;

import net.bloop.randomstuff.Items.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RegistryEvents {

    public static final CreativeTabs RStab = (new CreativeTabs("tabRS") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemRegistry.itemRandomDrop);
        }
    });
}
