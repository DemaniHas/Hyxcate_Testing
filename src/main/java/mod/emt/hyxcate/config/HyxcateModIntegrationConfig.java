package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config.LangKey("cfg." + Hyxcate.ID + ".mod_integration")
@Config(
        modid = Hyxcate.ID,
        name = Hyxcate.ID + "/" + Hyxcate.NAME + " - Mod Integration"
)
public class HyxcateModIntegrationConfig {
    @Config.LangKey("config.hyxcate.simple_difficulty")
    @Config.Comment("SimpleDifficulty settings")
    public static final SimpleDifficulty SIMPLE_DIFFICULTY = new SimpleDifficulty();

    @Config.LangKey("config.hyxcate.tan")
    @Config.Comment("Tough As Nails settings")
    public static final TAN TAN = new TAN();

    @Config.Name("Construct's Armory Integration")
    @Config.Comment({"Enables Construct's Armory integration", "Requires Tinkers' Construct integration to be enabled"})
    public static boolean constructsArmoryIntegration = true;

    @Config.Name("Tinkers' Construct Integration")
    @Config.Comment("Enables Tinkers' Construct integration")
    public static boolean tinkersConstructIntegration = true;

    @Config.Name("Peaceful Surface Integration")
    @Config.Comment({"Enables Peaceful Surface integration", "Mobs will spawn on the surface during events when enabled"})
    public static boolean peacefulSurfaceIntegration = true;

    @Config.Name("Game Stages Integration")
    @Config.Comment({"Enables Game Stages integration", "See wiki for details: https://github.com/Elite-Modding-Team/Hyxcate/wiki/Game-Stages"})
    public static boolean gameStagesIntegration = false;

    public static class SimpleDifficulty {
        @Config.Name("Enable SimpleDifficulty Integration")
        @Config.Comment("Enables SimpleDifficulty integration")
        public boolean enableSimpleDifficulty = true;

        @Config.Name("Red Giant Temperature")
        @Config.Comment("The temperature level during an active Red Giant event")
        public int redGiantTemperature = 10;
    }

    public static class TAN {
        @Config.Name("Enable Tough As Nails Integration")
        @Config.Comment("Enables Tough As Nails integration")
        public boolean enableTAN = true;

        @Config.Name("Red Giant Temperature")
        @Config.Comment("The temperature level during an active Red Giant event")
        public int redGiantTemperature = 22;
    }

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
