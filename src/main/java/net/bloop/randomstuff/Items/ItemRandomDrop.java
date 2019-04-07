package net.bloop.randomstuff.Items;

import com.google.common.collect.Lists;
import net.bloop.randomstuff.RegistryEvents;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemRandomDrop extends ItemMod {

    public ItemRandomDrop()
    {
        super("itemrandomdrop");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {

        ItemStack stack = playerIn.getHeldItem(handIn);
        ItemStack randomItem = new ItemStack(Lists.newArrayList(ForgeRegistries.ITEMS).get(new Random().nextInt(Lists.newArrayList(ForgeRegistries.ITEMS).size())));
        if(!worldIn.isRemote)
            worldIn.spawnEntity(new EntityItem(worldIn, playerIn.posX, playerIn.posY + 1, playerIn.posZ, randomItem));

        if(!playerIn.capabilities.isCreativeMode)
            stack.shrink(1);

        return new ActionResult(EnumActionResult.PASS, stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Grants a random item.");
        tooltip.add("§8§oHas potential to crash the game,");
        tooltip.add("§8§oYou have been warned.");
    }
}
