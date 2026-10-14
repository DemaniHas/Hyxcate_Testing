package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Hyxcate.ID, name = Hyxcate.NAME)
public class HyxcateConfig {
    @Config.LangKey("config.hyxcate.master_switches")
    @Config.Comment("Master switches for entire modules")
    public static final MasterSwitches MASTER_SWITCHES = new MasterSwitches();

    @Config.LangKey("config.hyxcate.general")
    @Config.Comment("Settings for general mechanics")
    public static final General GENERAL = new General();

    @Config.LangKey("config.hyxcate.entities")
    @Config.Comment("Settings for entities")
    public static final Entities ENTITIES = new Entities();

    @Config.LangKey("config.hyxcate.falling_stars")
    @Config.Comment("Settings for falling stars")
    public static final FallingStars FALLING_STARS = new FallingStars();

    public static class MasterSwitches {
        @Config.Name("Events: Lunar")
        @Config.Comment("If lunar events should be enabled")
        public boolean lunarEventsEnabled = true;

        @Config.Name("Events: Solar")
        @Config.Comment("If solar events should be enabled")
        public boolean solarEventsEnabled = true;

        @Config.Name("Events: Meteors")
        @Config.Comment("If meteors falling from the sky should be enabled")
        public boolean meteorEventsEnabled = true;

        @Config.Name("Events: Falling Stars")
        @Config.Comment("If falling stars (including during star showers) should be enabled")
        public boolean fallingStarEventsEnabled = true;

        @Config.Name("Enchantments")
        @Config.Comment("If enchantments should be enabled")
        public boolean enchantmentsEnabled = true;

        @Config.Name("Equipment: Beam Swords")
        @Config.Comment("If beam swords should be enabled")
        public boolean beamSwordsEnabled = true;

        @Config.Name("Equipment: Celestial Warhammer")
        @Config.Comment("If the Celestial Warhammer should be enabled")
        public boolean celestialWarhammerEnabled = true;

        @Config.Name("Equipment: Meteor Detector")
        @Config.Comment("If the Meteor Detector should be enabled")
        public boolean meteorDetectorEnabled = true;

        @Config.Name("Equipment: Meteor Gear")
        @Config.Comment("If all tools and armor made out of meteor materials (Meteorite, Frezarite, Kreknorite, and Tektite) should be enabled")
        public boolean meteorGearEnabled = true;
    }

    public static class General {
        @Config.Name("Celestial Warhammer Ability Damage")
        @Config.Comment("The amount of damage that the Celestial Warhammer deals if the maximum flight time was used")
        public int celestialWarhammerAbilityDamage = 32;

        @Config.Name("Celestial Warhammer Ability Goes Forward")
        @Config.Comment({
                "Makes the Celestial Warhammer's ability also launch you forward",
                "Disable if you prefer to launch upwards directly"})
        public boolean celestialWarhammerForwardLaunch = true;

        @Config.Name("Dynamic Moon Phase Lightmap Brightness")
        @Config.Comment({"Adjusts lightmap brightness depending on the current moon phase", "By default, Full Moon is the brightest and New Moon is the darkest"})
        public boolean dynamicMoonPhaseLightmapBrightness = true;

        @Config.Name("Easter Eggs")
        @Config.Comment("Not for the more serious lore friendly players")
        public boolean easterEggs = true;

        @Config.Name("Event Sun Brightness Transition Duration")
        @Config.Comment({
                "Controls the sun brightness transitions",
                "Duration specified in ticks. Use -1 to disable"
        })
        @Config.RangeInt(min = -1)
        @Config.RequiresMcRestart
        public int eventSunBrightnessDuration = 120;

        @Config.Name("Event Tint")
        @Config.Comment("If celestial events should tint the sky")
        public boolean eventTint = true;

        @Config.Name("Event Tint Underground")
        @Config.Comment("If celestial events should also tint underground areas (can look slightly jarring when disabled)")
        public boolean eventTintUnderground = true;

        @Config.Name("Event Tint Cloud Color Transition Duration")
        @Config.Comment({
                "Controls the cloud color transitions",
                "Duration specified in ticks. Use -1 to disable"
        })
        @Config.RangeInt(min = -1)
        @Config.RequiresMcRestart
        public int eventTintCloudColorDuration = 120;

        @Config.Name("Event Tint Fog Color Transition Duration")
        @Config.Comment({
                "Controls the fog color transitions",
                "Duration specified in ticks. Use -1 to disable"
        })
        @Config.RangeInt(min = -1)
        @Config.RequiresMcRestart
        public int eventTintFogColorDuration = 120;

        @Config.Name("Event Tint Lightmap Transition Duration")
        @Config.Comment({
                "Controls the lightmap color transitions",
                "Duration specified in ticks. Use -1 to disable"
        })
        @Config.RangeInt(min = -1)
        @Config.RequiresMcRestart
        public int eventTintLightmapDuration = 120;

        @Config.Name("Event Tint Sky Color Transition Duration")
        @Config.Comment({
                "Controls the sky color transitions",
                "Duration specified in ticks. Use -1 to disable"
        })
        @Config.RangeInt(min = -1)
        @Config.RequiresMcRestart
        public int eventTintSkyColorDuration = 120;

        @Config.Name("Event Notifications")
        @Config.Comment("If celestial events should be announced in chat when they start")
        public boolean eventNotifications = true;

        @Config.Name("Event Notifications Verbose")
        @Config.Comment("If effects of celestial events should be additionally announced in chat when they start")
        public boolean eventNotificationsVerbose = false;

        @Config.Name("Event Intro Sounds")
        @Config.Comment("If celestial events should play a unique sound when they start")
        public boolean eventIntroSounds = true;

        @Config.Name("Event Sun Growth Animation")
        @Config.Comment("If the sun should emit a growth animation when its size gets changed by events")
        public boolean eventSunGrowthAnimation = true;

        @Config.Name("F3 Info")
        @Config.Comment("Displays the current active event on the F3 screen")
        public boolean f3Info = true;

        @Config.Name("Lunar Edge Damage: Base")
        @Config.Comment("The amount of base Lunar Damage received (when first applying Lunar Edge)")
        public double lunarEdgeDamageBase = 0.5D;

        @Config.Name("Lunar Edge Damage: Subsequent")
        @Config.Comment("The amount of additional Lunar Damage applied (per level of Lunar Edge) after the base damage")
        public double lunarEdgeDamageSubsequent = 0.5D;

        @Config.Name("Lunar Shield Ward: Base")
        @Config.Comment("The amount of Lunar Ward received (when first applying Lunar Shield)")
        public double lunarShieldWardBase = 0.01D;

        @Config.Name("Lunar Shield Ward: Subsequent")
        @Config.Comment("The amount of Lunar Ward received (per level of Lunar Shield) after the base ward")
        public double lunarShieldWardSubsequent = 0.01D;

        @Config.Name("Solar Edge Damage: Base")
        @Config.Comment("The amount of base Solar Damage received (when first applying Lunar Edge)")
        public double solarEdgeDamageBase = 0.5D;

        @Config.Name("Solar Edge Damage: Subsequent")
        @Config.Comment("The amount of additional Solar Damage applied (per level of Solar Edge) after the base damage")
        public double solarEdgeDamageSubsequent = 0.5D;

        @Config.Name("Solar Shield Ward: Base")
        @Config.Comment("The amount of Solar Ward received (when first applying Solar Shield)")
        public double solarShieldWardBase = 0.01D;

        @Config.Name("Solar Shield Ward: Subsequent")
        @Config.Comment("The amount of Solar Ward received (per level of Solar Shield) after the base ward")
        public double solarShieldWardSubsequent = 0.01D;
    }

    public static class Entities {
        @Config.LangKey("config.hyxcate.eyezor")
        @Config.Comment("Eyezor settings")
        public final Eyezor EYEZOR = new Eyezor();

        public static class Eyezor {
            @Config.Name("Laser Color")
            @Config.Comment("The hex code of the Eyezor's laser color")
            public int laserColor = 0x6231FD;
        }
    }

    public static class FallingStars {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) for a falling star to appear at night for each player per minute")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chanceM = 0.3;

        @Config.Name("Chance During Showers")
        @Config.Comment("The chance for a falling star to appear during a star shower for each player per minute")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chanceShowerM = 1.0;

        @Config.Name("Ambient Volume")
        @Config.Comment("The volume for the falling star ambient sound")
        public double volumeAmbient = 8.0;

        @Config.Name("Impact Volume")
        @Config.Comment("The volume for the falling star impact sound")
        public double volumeImpact = 8.0;
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
