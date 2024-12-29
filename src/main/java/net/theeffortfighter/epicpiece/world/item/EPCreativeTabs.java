package net.theeffortfighter.epicpiece.world.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.theeffortfighter.epicpiece.EpicPiece;

public class EPCreativeTabs {
    public static final CreativeModeTab ITEMS = new CreativeModeTab(EpicPiece.MOD_ID + ".items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(EPItems.KATANA.get());
        }
    };
}

