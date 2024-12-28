package net.flynnvali.destructivespelunking.item;

import net.flynnvali.destructivespelunking.DestructiveSpelunking;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DestructiveSpelunking.MOD_ID);
    public static final RegistryObject<Item> RAW_NICKEL_NUGGET = ITEMS.register("raw_nickel_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
