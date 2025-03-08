package net.flynnvali.destructivespelunking.block;

import com.petrolpark.destroy.DestroyBlocks;
import net.flynnvali.destructivespelunking.DestructiveSpelunking;
import net.flynnvali.destructivespelunking.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DSBLocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DestructiveSpelunking.MOD_ID);

    public static final RegistryObject<Block> ANDESITE_FLUORITE_ORE = registerBlock("andesite_fluorite_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.FLUORITE_ORE.get())));
    public static final RegistryObject<Block> DIORITE_FLUORITE_ORE = registerBlock("diorite_fluorite_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.FLUORITE_ORE.get())));
    public static final RegistryObject<Block> GRANITE_FLUORITE_ORE = registerBlock("granite_fluorite_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.FLUORITE_ORE.get())));
    public static final RegistryObject<Block> TUFF_FLUORITE_ORE = registerBlock("tuff_fluorite_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.DEEPSLATE_FLUORITE_ORE.get()).sound(SoundType.TUFF)));
    public static final RegistryObject<Block> ANDESITE_NICKEL_ORE = registerBlock("andesite_nickel_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.NICKEL_ORE.get())));
    public static final RegistryObject<Block> DIORITE_NICKEL_ORE = registerBlock("diorite_nickel_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.NICKEL_ORE.get())));
    public static final RegistryObject<Block> GRANITE_NICKEL_ORE = registerBlock("granite_nickel_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.NICKEL_ORE.get())));
    public static final RegistryObject<Block> TUFF_NICKEL_ORE = registerBlock("tuff_nickel_ore", () -> new Block(BlockBehaviour.Properties.copy(DestroyBlocks.DEEPSLATE_NICKEL_ORE.get()).sound(SoundType.TUFF)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block > RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
