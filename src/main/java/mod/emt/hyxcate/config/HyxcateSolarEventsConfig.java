package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config.LangKey("cfg." + Hyxcate.ID + ".solar_events")
@Config(
        modid = Hyxcate.ID,
        name = Hyxcate.ID + "/" + Hyxcate.NAME + " - Solar Events"
)
public class HyxcateSolarEventsConfig {
    @Config.LangKey("config.hyxcate.grim_eclipse")
    @Config.Comment("Grim Eclipse settings")
    public static final GrimEclipse GRIM_ECLIPSE = new GrimEclipse();

    @Config.LangKey("config.hyxcate.red_giant")
    @Config.Comment("Red Giant settings")
    public static final RedGiant RED_GIANT = new RedGiant();

    @Config.Name("Allowed Dimensions")
    @Config.Comment("The numeric IDs of the dimensions that solar events should occur in")
    public static Integer[] allowedDimensions = new Integer[]{0};

    public static class GrimEclipse {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) of the Grim Eclipse occurring")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chance = 0.05;

        @Config.Name("Start Day")
        @Config.Comment("The amount of days that should pass before the Grim Eclipse occurs for the first time")
        @Config.RangeInt(min = 0)
        public int startDay = 0;

        @Config.Name("Day Interval")
        @Config.Comment({"The interval in days at which the Grim Eclipse should occur", "Overrides chance setting if set to a value greater than 0"})
        @Config.RangeInt(min = 0)
        public int dayInterval = 0;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of days that should pass until the Grim Eclipse happens again")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 8;

        @Config.Name("Exclusive Spawns")
        @Config.Comment({"The registry names of hostile entities that should spawn exclusively on the surface during the event (whitelist)", "Leave empty to allow all hostile entities to spawn"})
        public String[] spawnsExclusive = new String[]{};

        @Config.Name("Extra Spawns")
        @Config.Comment({"The registry names of entities that should spawn additionally alongside other entities during the event", "Syntax: originalEntity;extraEntity"})
        public String[] spawnsExtra = new String[]{
                "minecraft:zombie;hyxcate:eyezor"
        };

        @Config.Name("Extra Spawns Chance")
        @Config.Comment({"The chance for an additional mob to be spawned when a mob spawns during the event", "The higher the number, the less likely", "Set to 0 to disable"})
        @Config.RangeInt(min = 0, max = 1000)
        public int spawnsExtraChance = 10;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Grim Eclipse's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0x131311;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Grim Eclipse's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0x0F0F09;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Grim Eclipse's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0x131311;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Grim Eclipse's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0x0F0F09;

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{};
    }

    public static class RedGiant {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) of the Red Giant occurring")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chance = 0.05;

        @Config.Name("Start Day")
        @Config.Comment("The amount of days that should pass before the Red Giant occurs for the first time")
        @Config.RangeInt(min = 0)
        public int startDay = 0;

        @Config.Name("Day Interval")
        @Config.Comment({"The interval in days at which the Red Giant should occur", "Overrides chance setting if set to a value greater than 0"})
        @Config.RangeInt(min = 0)
        public int dayInterval = 0;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of days that should pass until the Red Giant happens again")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 15;

        @Config.Name("Exclusive Spawns")
        @Config.Comment({"The registry names of hostile entities that should spawn exclusively on the surface during the event (whitelist)", "Leave empty to allow all hostile entities to spawn"})
        public String[] spawnsExclusive = new String[]{};

        @Config.Name("Extra Spawns")
        @Config.Comment({"The registry names of entities that should spawn additionally alongside other entities during the event", "Syntax: originalEntity;extraEntity"})
        public String[] spawnsExtra = new String[]{
                "minecraft:zombie;hyxcate:eyezor"
        };

        @Config.Name("Extra Spawns Chance")
        @Config.Comment({"The chance for an additional mob to be spawned when a mob spawns during the event", "The higher the number, the less likely", "Set to 0 to disable"})
        @Config.RangeInt(min = 0, max = 1000)
        public int spawnsExtraChance = 10;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Red Giant's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0x420d03;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Red Giant's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0x420d03;

        @Config.Name("Hardcore Exposure")
        @Config.Comment("Allows the Red Giant to damage anything exposed to the sky")
        public boolean hardcoreExposure = false;

        @Config.Name("Hardcore Exposure Chance")
        @Config.Comment({"The chance per tick for the Red Giant to deal damage", "A number of 20 would be a 1/20 chance per tick"})
        public int hardcoreExposureChance = 20;

        @Config.Name("Hardcore Exposure Damage")
        @Config.Comment("The amount of damage dealt by the Red Giant")
        public double hardcoreExposureDamage = 4.0;

        @Config.Name("Hardcore Exposure Invincibility Frames")
        @Config.Comment({"The amount of invincibility frames set when getting damaged by the Red Giant", "0 will ignore all invincibility frames and 30 is the default amount"})
        public int hardcoreExposureInvincibilityFrames = 0;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Red Giant's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0x420d03;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Red Giant's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0x420d03;

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{
                "minecraft:zombie;minecraft:husk",
                "minecraft:skeleton;minecraft:wither_skeleton",
                "minecraft:slime;minecraft:magma_cube"
        };
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
