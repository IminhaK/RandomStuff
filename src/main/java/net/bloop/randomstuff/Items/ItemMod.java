package net.bloop.randomstuff.Items;

import net.bloop.randomstuff.RegistryEvents;
import net.minecraft.item.Item;

public class ItemMod extends Item {

    private String name;

    public ItemMod(String itemname) {
        name = itemname;
        setRegistryName(itemname);
        setUnlocalizedName(itemname);
        setCreativeTab(RegistryEvents.RStab);
    }
}
