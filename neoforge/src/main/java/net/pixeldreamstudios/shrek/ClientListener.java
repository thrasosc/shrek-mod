package net.pixeldreamstudios.shrek;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.pixeldreamstudios.shrek.entity.client.renderer.entity.OgreRenderer;
import net.pixeldreamstudios.shrek.registry.NeoShrekEntities;

@EventBusSubscriber(modid = Shrek.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientListener {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(NeoShrekEntities.OGRE.get(), OgreRenderer::new);
    }
}
