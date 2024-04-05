package net.pixeldreamstudios.shrek.helper;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.pixeldreamstudios.shrek.entity.OgreEntity;
import net.pixeldreamstudios.shrek.registry.FabricShrekEntities;

public record MobAttributes() {
    public static void init() {
        FabricDefaultAttributeRegistry.register(FabricShrekEntities.OGRE, OgreEntity.createMobAttributes());
    }
}
