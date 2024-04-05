package net.pixeldreamstudios.shrek;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.pixeldreamstudios.shrek.entity.client.renderer.entity.OgreRenderer;
import net.pixeldreamstudios.shrek.registry.FabricShrekEntities;

@Environment(EnvType.CLIENT)
public class ClientListener implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        initMobRenders();
    }

    public void initMobRenders() {
        EntityRendererRegistry.register(FabricShrekEntities.OGRE, OgreRenderer::new);
    }
}
