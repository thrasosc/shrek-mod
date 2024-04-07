package net.pixeldreamstudios.shrek.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.pixeldreamstudios.shrek.Shrek;
import net.pixeldreamstudios.shrek.entity.OgreEntity;

import java.util.LinkedList;
import java.util.List;

public record FabricShrekEntities() {
    public static List<EntityType<? extends Entity>> ENTITY_TYPES = new LinkedList<>();

    /**
     * Mobs
     */
    public static EntityType<OgreEntity> OGRE;

    private static <T extends Entity> EntityType<T> mob(String id, EntityType.EntityFactory<T> factory, float height, float width) {
        final var type = FabricEntityTypeBuilder.create(MobCategory.MISC, factory)
                .dimensions(EntityDimensions.scalable(height, width))
                .build();
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Shrek.modResource(id), type);

        return type;
    }

    public static void init() {
        OGRE = mob("ogre", OgreEntity::new, 1.25f, 2.5f);
    }
}
