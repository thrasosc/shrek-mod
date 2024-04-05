package mod.azure.renameme;

import net.minecraftforge.fml.common.Mod;
import mod.azure.renameme.CommonMod;

@Mod.EventBusSubscriber
@Mod(CommonMod.MOD_ID)
public final class NeoForgeMod {

    public static NeoForgeMod instance;

    public NeoForgeMod() {
        instance = this;
    }
}
