package net.pixeldreamstudios.shrek;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pixeldreamstudios.shrek.registry.NeoShrekEntities;

@Mod.EventBusSubscriber
@Mod(Shrek.MOD_ID)
public final class NeoForgeShrekMod {

    public static NeoForgeShrekMod instance;

    public NeoForgeShrekMod() {
        instance = this;
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        NeoShrekEntities.ENTITY_TYPES.register(modEventBus);
    }
}
