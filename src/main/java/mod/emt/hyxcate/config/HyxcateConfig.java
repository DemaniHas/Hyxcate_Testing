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

    @Config.LangKey("config.hyxcate.meteors")
    @Config.Comment("Settings for meteors")
    public static final Meteors METEORS = new Meteors();

    @Config.LangKey("config.hyxcate.mod_integration")
    @Config.Comment("Settings for mod integration")
    public static final ModIntegration MOD_INTEGRATION = new ModIntegration();

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

    public static class Meteors {
        @Config.Name("Chance")
        @Config.Comment("The chance of a meteor spawning every minute, during the day")
        @Config.RangeDouble(min = 0.0)
        public double chanceM = 0.0042;

        @Config.Name("Chance At Night")
        @Config.Comment("The chance of a meteor spawning every minute, during nighttime")
        @Config.RangeDouble(min = 0.0)
        public double chanceNightM = 0.0072;

        @Config.Name("Gate Dimension")
        @Config.Comment("The dimension that needs to be entered to increase the spawning of meteors")
        public int gateDimension = 1;

        @Config.Name("Chance After Gate Visit")
        @Config.Comment("The chance of a meteor spawning every minute, during the day, after the gate dimension has been entered once")
        @Config.RangeDouble(min = 0.0)
        public double chanceAfterGateM = 0.006;

        @Config.Name("Chance After Gate Visit At Night")
        @Config.Comment("The chance of a meteor spawning every minute, during the night, after the gate dimension has been entered once")
        @Config.RangeDouble(min = 0.0)
        public double chanceAfterGateNightM = 0.09;

        @Config.Name("Chance During Star Showers")
        @Config.Comment("The chance of a meteor spawning every minute, during a star shower")
        @Config.RangeDouble(min = 0.0)
        public double chanceStarShowerM = 0.144;

        @Config.Name("Chance In The End")
        @Config.Comment("The chance of a meteor spawning every minute, in the end dimension")
        @Config.RangeDouble(min = 0.0)
        public double chanceEndM = 0.09;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of days that should pass after world creation until meteors can fall")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 0;

        @Config.Name("Spawn Radius")
        @Config.Comment("The amount of blocks a meteor can spawn away from the nearest player")
        public int spawnRadius = 1000;

        @Config.Name("Disallow Radius")
        @Config.Comment("The radius in chunks that should be marked as invalid for meteor spawning around each player")
        public int disallowRadius = 14;

        @Config.Name("Disallow Time")
        @Config.Comment("The amount of ticks that need to pass for each player until the chance of a meteor spawning in the area is halved (and then halved again, and so on)")
        public int disallowTime = 12000;

        @Config.Name("Chat Message")
        @Config.Comment("If fallen meteors should be announced in chat on impact")
        public boolean message = true;

        @Config.Name("Chat Message Verbose")
        @Config.Comment("If chat messages for meteor impacts should include coordinates")
        public boolean messageVerbose = false;

        @Config.Name("Meteor Blocks: Meteorite")
        @Config.Comment({"Main blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] meteorBlocksMeteorite = new String[]{
                "hyxcate:meteorite_rock_hot",
                "hyxcate:meteorite_rock"
        };

        @Config.Name("Meteor Blocks: Frezarite")
        @Config.Comment({"Main blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] meteorBlocksFrezarite = new String[]{
                "hyxcate:frezarite_rock",
                "minecraft:packed_ice"
        };

        @Config.Name("Meteor Blocks: Kreknorite")
        @Config.Comment({"Main blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] meteorBlocksKreknorite = new String[]{
                "hyxcate:kreknorite_rock",
                "minecraft:obsidian"
        };

        @Config.Name("Meteor Blocks: Unknown")
        @Config.Comment({"Main blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] meteorBlocksUnknown = new String[]{
                "hyxcate:meteorite_rock_hot",
                "hyxcate:meteorite_rock",
                "hyxcate:frezarite_rock",
                "hyxcate:kreknorite_rock",
                "minecraft:packed_ice",
                "minecraft:obsidian"
        };

        @Config.Name("Filler Blocks: Meteorite")
        @Config.Comment({"Subsidiary blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] fillerBlocksMeteorite = new String[]{
                "minecraft:magma"
        };

        @Config.Name("Filler Blocks: Frezarite")
        @Config.Comment({"Subsidiary blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] fillerBlocksFrezarite = new String[]{
                "minecraft:packed_ice"
        };

        @Config.Name("Filler Blocks: Kreknorite")
        @Config.Comment({"Subsidiary blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] fillerBlocksKreknorite = new String[]{
                "minecraft:magma"
        };

        @Config.Name("Filler Blocks: Unknown")
        @Config.Comment({"Subsidiary blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] fillerBlocksUnknown = new String[]{
                "minecraft:magma",
                "minecraft:packed_ice"
        };

        @Config.Name("Liquid Blocks: Meteorite")
        @Config.Comment({"Fluid blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] liquidBlocksMeteorite = new String[]{
                "minecraft:air"
        };

        @Config.Name("Liquid Blocks: Frezarite")
        @Config.Comment({"Fluid blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] liquidBlocksFrezarite = new String[]{
                "minecraft:water"
        };

        @Config.Name("Liquid Blocks: Kreknorite")
        @Config.Comment({"Fluid blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] liquidBlocksKreknorite = new String[]{
                "minecraft:lava"
        };

        @Config.Name("Liquid Blocks: Unknown")
        @Config.Comment({"Fluid blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
        public String[] liquidBlocksUnknown = new String[]{
                "minecraft:lava",
                "minecraft:water"
        };

        @Config.Name("Meteor Sizes")
        @Config.Comment({"Sizes of meteors that are allowed to spawn", "1 = Small", "2 = Medium", "3 = Large"})
        public Integer[] meteorSizes = new Integer[]{1, 2, 3};

        @Config.Name("Meteor Types")
        @Config.Comment({"Types of meteors that are allowed to spawn", "1 = Meteorite", "2 = Frezarite", "3 = Kreknorite", "4 = Unknown"})
        public Integer[] meteorTypes = new Integer[]{1, 2, 3, 4};
    }

    public static class ModIntegration {
        @Config.LangKey("config.hyxcate.simple_difficulty")
        @Config.Comment("SimpleDifficulty settings")
        public final ModIntegration.SimpleDifficulty SIMPLE_DIFFICULTY = new ModIntegration.SimpleDifficulty();

        @Config.LangKey("config.hyxcate.tan")
        @Config.Comment("Tough As Nails settings")
        public final ModIntegration.TAN TAN = new ModIntegration.TAN();

        @Config.Name("Construct's Armory Integration")
        @Config.Comment({"Enables Construct's Armory integration", "Requires Tinkers' Construct integration to be enabled"})
        public boolean constructsArmoryIntegration = true;

        @Config.Name("Tinkers' Construct Integration")
        @Config.Comment("Enables Tinkers' Construct integration")
        public boolean tinkersConstructIntegration = true;

        @Config.Name("Peaceful Surface Integration")
        @Config.Comment({"Enables Peaceful Surface integration", "Mobs will spawn on the surface during events when enabled"})
        public boolean peacefulSurfaceIntegration = true;

        @Config.Name("Game Stages Integration")
        @Config.Comment({"Enables Game Stages integration", "See wiki for details: https://github.com/Elite-Modding-Team/Hyxcate/wiki/Game-Stages"})
        public boolean gameStagesIntegration = false;

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
