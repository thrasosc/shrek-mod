package net.pixeldreamstudios.shrek;

import mod.azure.azurelib.AzureLibMod;
import mod.azure.azurelib.config.format.ConfigFormats;
import net.fabricmc.api.ModInitializer;
import net.pixeldreamstudios.shrek.helper.MobAttributes;
import net.pixeldreamstudios.shrek.registry.FabricShrekEntities;
import net.pixeldreamstudios.shrek.registry.FabricShrekItems;

public final class FabricShrekMod implements ModInitializer {

    @Override
    public void onInitialize() {
        Shrek.config = AzureLibMod.registerConfig(ShrekConfig.class, ConfigFormats.json()).getConfigInstance();
        FabricShrekEntities.init();
        MobAttributes.init();
        FabricShrekItems.init();
    }
}
