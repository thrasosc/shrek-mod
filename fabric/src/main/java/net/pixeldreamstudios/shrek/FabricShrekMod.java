package net.pixeldreamstudios.shrek;

import net.fabricmc.api.ModInitializer;
import net.pixeldreamstudios.shrek.helper.MobAttributes;
import net.pixeldreamstudios.shrek.registry.FabricShrekEntities;

public final class FabricShrekMod implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricShrekEntities.init();
        MobAttributes.init();
    }
}
