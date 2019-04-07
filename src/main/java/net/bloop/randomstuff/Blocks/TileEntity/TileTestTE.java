package net.bloop.randomstuff.Blocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileTestTE extends TileEntity {

    private int count;

    public TileTestTE(){}

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        count = nbt.getInteger("count");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("count", count);
        return nbt;
    }

    public int getCount()
    {
        return count;
    }

    public void increaseCount()
    {
        count++;
        markDirty();
    }
}
