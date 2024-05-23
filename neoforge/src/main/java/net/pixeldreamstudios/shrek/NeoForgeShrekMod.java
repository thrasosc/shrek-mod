package net.pixeldreamstudios.shrek;

import mod.azure.azurelib.AzureLibMod;
import mod.azure.azurelib.config.format.ConfigFormats;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pixeldreamstudios.shrek.registry.NeoShrekEntities;
import net.pixeldreamstudios.shrek.registry.NeoShrekItems;

@Mod.EventBusSubscriber
@Mod(Shrek.MOD_ID)
public final class NeoForgeShrekMod {

    public static NeoForgeShrekMod instance;

    public NeoForgeShrekMod() {
        instance = this;
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Shrek.config = AzureLibMod.registerConfig(ShrekConfig.class, ConfigFormats.json()).getConfigInstance();
        NeoShrekEntities.ENTITY_TYPES.register(modEventBus);
        NeoShrekItems.ITEMS.register(modEventBus);
    }
}
