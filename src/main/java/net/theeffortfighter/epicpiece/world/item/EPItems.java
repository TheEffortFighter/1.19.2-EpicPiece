package net.theeffortfighter.epicpiece.world.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.theeffortfighter.epicpiece.EpicPiece;

public class EPItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EpicPiece.MOD_ID);

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana", () -> new KatanaItem(new Item.Properties().tab(EPCreativeTabs.ITEMS)));
}
