package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config.LangKey("cfg." + Hyxcate.ID + ".falling_stars")
@Config(
        modid = Hyxcate.ID,
        name = Hyxcate.ID + "/" + Hyxcate.NAME + " - Falling Stars"
)
public class HyxcateFallingStarsConfig {
    @Config.Name("Chance")
    @Config.Comment("The chance in percent (1 = 100%) for a falling star to appear at night for each player per minute")
    @Config.RangeDouble(min = 0.0, max = 1.0)
    public static double chanceM = 0.3;

    @Config.Name("Chance During Showers")
    @Config.Comment("The chance for a falling star to appear during a star shower for each player per minute")
    @Config.RangeDouble(min = 0.0, max = 1.0)
    public static double chanceShowerM = 1.0;

    @Config.Name("Ambient Volume")
    @Config.Comment("The volume for the falling star ambient sound")
    public static double volumeAmbient = 8.0;

    @Config.Name("Impact Volume")
    @Config.Comment("The volume for the falling star impact sound")
    public static double volumeImpact = 8.0;

    @Mod.EventBusSubscriber(modid = Hyxcate.ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Hyxcate.ID)) {
                ConfigManager.sync(Hyxcate.ID, Config.Type.INSTANCE);
                HyxcateData.initConfigLists();
            }
        }
    }
}
