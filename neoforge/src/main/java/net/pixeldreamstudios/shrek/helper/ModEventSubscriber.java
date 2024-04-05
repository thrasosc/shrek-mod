package net.pixeldreamstudios.shrek.helper;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.pixeldreamstudios.shrek.Shrek;
import net.pixeldreamstudios.shrek.entity.OgreEntity;
import net.pixeldreamstudios.shrek.registry.NeoShrekEntities;

@EventBusSubscriber(modid = Shrek.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(NeoShrekEntities.OGRE.get(), OgreEntity.createMobAttributes().build());
    }
}
