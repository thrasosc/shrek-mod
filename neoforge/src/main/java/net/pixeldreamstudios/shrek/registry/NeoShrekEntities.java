package net.pixeldreamstudios.shrek.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixeldreamstudios.shrek.Shrek;
import net.pixeldreamstudios.shrek.entity.OgreEntity;

public class NeoShrekEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Shrek.MOD_ID);

    /**
     * Mobs
     */
    public static final RegistryObject<EntityType<OgreEntity>> OGRE = ENTITY_TYPES.register("ogre",
            () -> EntityType.Builder.of(OgreEntity::new, MobCategory.MISC)
                    .sized(1.25f, 2.5f)
                    .build(new ResourceLocation(Shrek.MOD_ID, "ogre").toString()));
}
