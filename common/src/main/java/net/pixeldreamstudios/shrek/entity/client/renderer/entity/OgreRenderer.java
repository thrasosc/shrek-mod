package net.pixeldreamstudios.shrek.entity.client.renderer.entity;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.shrek.Shrek;
import net.pixeldreamstudios.shrek.entity.OgreEntity;
import net.pixeldreamstudios.shrek.entity.client.model.entity.OgreModel;

public class OgreRenderer  extends GeoEntityRenderer<OgreEntity> {
    public OgreRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new OgreModel());
        this.shadowRadius = 0.75f;
    }

    @Override
    public ResourceLocation getTextureLocation(OgreEntity animatable) {
        return new ResourceLocation(Shrek.MOD_ID, "textures/entity/ogre.png");
    }
}