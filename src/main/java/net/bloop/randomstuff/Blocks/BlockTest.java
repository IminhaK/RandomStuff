package net.bloop.randomstuff.Blocks;

import net.bloop.randomstuff.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BlockTest extends Block {

    public BlockTest()
    {
        super(Material.IRON);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setHardness(0.5f);
        this.setSoundType(SoundType.METAL);
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if(entityIn instanceof EntityLivingBase && EventHandler.timer == 200)
        {
            ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 0, false, true));
            worldIn.scheduleUpdate(pos, this, tickRate(worldIn));

            EventHandler.timer = 0;
        }
        //this isnt responding anymore
    }

}
