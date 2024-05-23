package net.pixeldreamstudios.shrek;

import mod.azure.azurelib.config.Config;
import mod.azure.azurelib.config.Configurable;

@Config(id = Shrek.MOD_ID)
public class ShrekConfig {
    @Configurable
    public double ogreHealth = 100;
    @Configurable
    public double ogreAttackDamage = 100;
}
