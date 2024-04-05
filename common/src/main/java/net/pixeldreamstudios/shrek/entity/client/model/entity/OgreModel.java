package net.pixeldreamstudios.shrek.entity.client.model.entity;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.shrek.Shrek;
import net.pixeldreamstudios.shrek.entity.OgreEntity;

public class OgreModel extends GeoModel<OgreEntity> {

    @Override
    public ResourceLocation getModelResource(OgreEntity object) {
        return new ResourceLocation(Shrek.MOD_ID, "geo/entity/ogre.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OgreEntity object) {
        return new ResourceLocation(Shrek.MOD_ID, "textures/entity/ogre.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OgreEntity animatable) {
        return new ResourceLocation(Shrek.MOD_ID, "animations/entity/ogre.animation.json");
    }
}