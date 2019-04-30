package net.bloop.randomstuff.Blocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class TileTestTE extends TileEntity {

    public ItemStackHandler items = new ItemStackHandler();

    public TileTestTE()
    {
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        items.deserializeNBT(nbt.getCompoundTag("items"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setTag("items", items.serializeNBT());
        return nbt;
    }
}
