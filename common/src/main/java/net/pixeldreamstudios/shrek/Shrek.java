package net.pixeldreamstudios.shrek;

import net.minecraft.resources.ResourceLocation;

public class Shrek {
    public static final String MOD_ID = "shrek";

    public static final ResourceLocation modResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
