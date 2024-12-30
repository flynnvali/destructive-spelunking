package net.flynnvali.destructivespelunking;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyGenericReactions;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyGroupFinder;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyReactions;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyTopologies;

import com.mojang.logging.LogUtils;
import net.flynnvali.destructivespelunking.block.DSBLocks;
import net.flynnvali.destructivespelunking.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DestructiveSpelunking.MOD_ID)
public class DestructiveSpelunking {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "destructivespelunking";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    public DestructiveSpelunking(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        DSBLocks.register(modEventBus);



        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    public static void init(final FMLCommonSetupEvent event) {
        DestroyGroupFinder.register();
        DestroyTopologies.register();
        DestroyMolecules.register();
        DestroyReactions.register();
        DestroyGenericReactions.register();


    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RAW_NICKEL_NUGGET);
            event.accept(ModItems.NICKEL_NUGGET);
            event.accept(ModItems.FLUORITE_SHARD);

        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(DSBLocks.ANDESITE_FLUORITE_ORE);
            event.accept(DSBLocks.DIORITE_FLUORITE_ORE);
            event.accept(DSBLocks.GRANITE_FLUORITE_ORE);
            event.accept(DSBLocks.TUFF_FLUORITE_ORE);
            event.accept(DSBLocks.ANDESITE_NICKEL_ORE);
            event.accept(DSBLocks.DIORITE_NICKEL_ORE);
            event.accept(DSBLocks.GRANITE_NICKEL_ORE);
            event.accept(DSBLocks.TUFF_NICKEL_ORE);


        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }


}
