package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config.LangKey("cfg." + Hyxcate.ID + ".lunar_events")
@Config(
        modid = Hyxcate.ID,
        name = Hyxcate.ID + "/" + Hyxcate.NAME + " - Lunar Events"
)
public class HyxcateLunarEventsConfig {
    @Config.LangKey("config.hyxcate.blood_moon")
    @Config.Comment("Blood Moon settings")
    public static final BloodMoon BLOOD_MOON = new BloodMoon();

    @Config.LangKey("config.hyxcate.blue_moon")
    @Config.Comment("Blue Moon settings")
    public static final BlueMoon BLUE_MOON = new BlueMoon();

    @Config.LangKey("config.hyxcate.full_moon")
    @Config.Comment("Full Moon settings")
    public static final FullMoon FULL_MOON = new FullMoon();

    @Config.LangKey("config.hyxcate.star_shower")
    @Config.Comment("Star Shower settings")
    public static final StarShower STAR_SHOWER = new StarShower();

    @Config.Name("Allowed Dimensions")
    @Config.Comment("The numeric IDs of the dimensions that lunar events should occur in")
    public static Integer[] allowedDimensions = new Integer[]{0};

    @Config.Name("Mob Potion Effect Entity List")
    public static String[] mobPotionEffectsEntityList = new String[] {
            "minecraft:creeper"
    };

    @Config.Name("Mob Potion Effect Entity List Mode")
    @Config.Comment({
            "Blacklist Mode: Entities in the list will not receive potion effects",
            "Whitelist Mode: Only entities in the list will receive potion effects"
    })
    public static EnumLists mobPotionEffectListMode = EnumLists.BLACKLIST;

    public enum EnumLists {
        WHITELIST,
        BLACKLIST
    }

    public static class BloodMoon {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) of the Blood Moon occurring")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chance = 0.05;

        @Config.Name("Start Night")
        @Config.Comment("The amount of nights that should pass before the Blood Moon occurs for the first time")
        @Config.RangeInt(min = 0)
        public int startNight = 0;

        @Config.Name("Night Interval")
        @Config.Comment({"The interval in nights at which the Blood Moon should occur", "Overrides chance setting if set to a value greater than 0"})
        @Config.RangeInt(min = 0)
        public int nightInterval = 0;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of nights that should pass until the Blood Moon happens again")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 8;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Blood Moon's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0x420d03;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Blood Moon's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0x420d03;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Blood Moon's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0x420d03;

        @Config.Name("Mob Potion Effects")
        @Config.Comment("If mobs spawned during a Blood Moon should have random potion effects applied to them (similarly to spiders in the base game)")
        public boolean mobPotionEffects = false;

        @Config.Name("Mob Potion Effect List")
        @Config.Comment({"The list of potion effects that spawned mobs can have during a Blood Moon", "Using `*` for the duration will cause the effect to be infinite with no timer instead", "Syntax: effect;duration;amplifier"})
        public String[] mobPotionEffectsList = {
                "minecraft:invisibility;*;0",
                "minecraft:regeneration;*;0",
                "minecraft:speed;*;0",
                "minecraft:strength;*;0"
        };

        @Config.Name("Mob Potion Effect Chance")
        @Config.Comment("The chance for a spawned mob to be applied with a potion effect during the Blood Moon")
        public double mobPotionEffectsChance = 10.0;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Blood Moon's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0x110300;

        @Config.Name("On Full Moon")
        @Config.Comment("If the Blood Moon should only occur on full moon nights")
        public boolean onFullMoon = false;

        @Config.Name("Sleeping")
        @Config.Comment("If sleeping is allowed during a Blood Moon")
        public boolean sleeping = false;

        @Config.Name("Spawn Multiplier")
        @Config.Comment("The multiplier with which mobs should spawn during the Blood Moon (eg 2 means 2 mobs spawn instead of 1)")
        @Config.RangeInt(min = 1, max = 1000)
        public int spawnMultiplier = 2;

        @Config.Name("Spawn Radius")
        @Config.Comment({"The closest distance that mobs can spawn away from a player during the Blood Moon", "Vanilla value is 24"})
        public int spawnRadius = 20;

        @Config.Name("Mobs Vanish")
        @Config.Comment("If mobs spawned by the Blood Moon should die at sunrise")
        public boolean mobsVanish = true;

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

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{};
    }

    public static class BlueMoon {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) of the Blue Moon occurring")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chance = 0.05;

        @Config.Name("Start Night")
        @Config.Comment("The amount of nights that should pass before the Blue Moon occurs for the first time")
        @Config.RangeInt(min = 0)
        public int startNight = 0;

        @Config.Name("Night Interval")
        @Config.Comment({"The interval in nights at which the Blue Moon should occur", "Overrides chance setting if set to a value greater than 0"})
        @Config.RangeInt(min = 0)
        public int nightInterval = 0;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of nights that should pass until the Blue Moon happens again")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 8;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Blue Moon's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0x3f3fc0;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Blue Moon's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0x3f3fc0;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Blue Moon's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0x3f3fc0;

        @Config.Name("Mob Potion Effects")
        @Config.Comment("If mobs spawned during a Blue Moon should have random potion effects applied to them (similarly to spiders in the base game)")
        public boolean mobPotionEffects = false;

        @Config.Name("Mob Potion Effect List")
        @Config.Comment({"The list of potion effects that spawned mobs can have during a Blue Moon", "Using `*` for the duration will cause the effect to be infinite with no timer instead", "Syntax: effect;duration;amplifier"})
        public String[] mobPotionEffectsList = {
                "minecraft:invisibility;*;0",
                "minecraft:regeneration;*;0",
                "minecraft:speed;*;0",
                "minecraft:strength;*;0"
        };

        @Config.Name("Mob Potion Effect Chance")
        @Config.Comment("The chance for a spawned mob to be applied with a potion effect during the Blue Moon")
        public double mobPotionEffectsChance = 10.0;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Blue Moon's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0x000319;

        @Config.Name("On Full Moon")
        @Config.Comment("If the Blue Moon should only occur on full moon nights")
        public boolean onFullMoon = false;

        @Config.Name("Grow Amount")
        @Config.Comment("The amount of plants that should be grown per chunk during the Blue Moon")
        @Config.RangeInt(min = 0, max = 100)
        public int growAmount = 15;

        @Config.Name("Grow Interval")
        @Config.Comment("The amount of ticks that should pass before plants are grown again during the Blue Moon")
        @Config.RangeInt(min = 1, max = 100)
        public int growInterval = 10;

        @Config.Name("Exclusive Spawns")
        @Config.Comment({"The registry names of hostile entities that should spawn exclusively on the surface during the event (whitelist)", "Leave empty to allow all hostile entities to spawn"})
        public String[] spawnsExclusive = new String[]{
                "minecraft:slime"
        };

        @Config.Name("Extra Spawns")
        @Config.Comment({"The registry names of entities that should spawn additionally alongside other entities during the event", "Syntax: originalEntity;extraEntity"})
        public String[] spawnsExtra = new String[]{};

        @Config.Name("Extra Spawns Chance")
        @Config.Comment({"The chance for an additional mob to be spawned when a mob spawns during the event", "The higher the number, the less likely", "Set to 0 to disable"})
        @Config.RangeInt(min = 0, max = 1000)
        public int spawnsExtraChance = 10;

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{};
    }

    public static class FullMoon {
        @Config.Name("Act As Event")
        @Config.Comment("If the vanilla Full Moon should be considered a proper lunar event")
        public boolean actAsEvent = true;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Full Moon's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Full Moon's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Full Moon's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0;

        @Config.Name("Mob Potion Effects")
        @Config.Comment("If mobs spawned during a Full Moon should have random potion effects applied to them (similarly to spiders in the base game)")
        public boolean mobPotionEffects = true;

        @Config.Name("Mob Potion Effect List")
        @Config.Comment({"The list of potion effects that spawned mobs can have during a Full Moon", "Using `*` for the duration will cause the effect to be infinite with no timer instead", "Syntax: effect;duration;amplifier"})
        public String[] mobPotionEffectsList = {
                "minecraft:invisibility;*;0",
                "minecraft:regeneration;*;0",
                "minecraft:speed;*;0",
                "minecraft:strength;*;0"
        };

        @Config.Name("Mob Potion Effect Chance")
        @Config.Comment("The chance for a spawned mob to be applied with a potion effect during the Full Moon")
        public double mobPotionEffectsChance = 10.0;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Full Moon's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0;

        @Config.Name("Exclusive Spawns")
        @Config.Comment({"The registry names of hostile entities that should spawn exclusively on the surface during the event (whitelist)", "Leave empty to allow all hostile entities to spawn"})
        public String[] spawnsExclusive = new String[]{};

        @Config.Name("Extra Spawns")
        @Config.Comment({"The registry names of entities that should spawn additionally alongside other entities during the event", "Syntax: originalEntity;extraEntity"})
        public String[] spawnsExtra = new String[]{
                "minecraft:zombie;minecraft:zombie",
                "minecraft:skeleton;minecraft:skeleton",
                "minecraft:creeper;minecraft:creeper",
                "minecraft:spider;minecraft:spider"
        };

        @Config.Name("Extra Spawns Chance")
        @Config.Comment({"The chance for an additional mob to be spawned when a mob spawns during the event", "The higher the number, the less likely", "Set to 0 to disable"})
        @Config.RangeInt(min = 0, max = 1000)
        public int spawnsExtraChance = 10;

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{};
    }

    public static class StarShower {
        @Config.Name("Chance")
        @Config.Comment("The chance in percent (1 = 100%) of Star Showers occurring")
        @Config.RangeDouble(min = 0.0, max = 1.0)
        public double chance = 0.05;

        @Config.Name("Start Night")
        @Config.Comment("The amount of nights that should pass before Star Showers occurs for the first time")
        @Config.RangeInt(min = 0)
        public int startNight = 0;

        @Config.Name("Night Interval")
        @Config.Comment({"The interval in nights at which Star Showers should occur", "Overrides chance setting if set to a value greater than 0"})
        @Config.RangeInt(min = 0)
        public int nightInterval = 0;

        @Config.Name("Grace Period")
        @Config.Comment("The amount of nights that should pass until Star Showers happen again")
        @Config.RangeInt(min = 0)
        public int gracePeriod = 15;

        @Config.Name("Cloud Color")
        @Config.Comment({"The hex code of the Star Shower's cloud color", "Set to 0 to completely disable this feature"})
        public int cloudColor = 0xdec25f;

        @Config.Name("Fog Color")
        @Config.Comment({"The hex code of the Star Shower's fog color", "Set to 0 to completely disable this feature"})
        public int fogColor = 0xdec25f;

        @Config.Name("Lightmap Color")
        @Config.Comment({"The hex code of the Star Shower's lightmap color", "Set to 0 to completely disable this feature"})
        public int lightmapColor = 0xdec25f;

        @Config.Name("Mob Potion Effects")
        @Config.Comment("If mobs spawned during a Star Shower should have random potion effects applied to them (similarly to spiders in the base game)")
        public boolean mobPotionEffects = false;

        @Config.Name("Mob Potion Effect List")
        @Config.Comment({"The list of potion effects that spawned mobs can have during a Star Shower", "Using `*` for the duration will cause the effect to be infinite with no timer instead", "Syntax: effect;duration;amplifier"})
        public String[] mobPotionEffectsList = {
                "minecraft:invisibility;*;0",
                "minecraft:regeneration;*;0",
                "minecraft:speed;*;0",
                "minecraft:strength;*;0"
        };

        @Config.Name("Mob Potion Effect Chance")
        @Config.Comment("The chance for a spawned mob to be applied with a potion effect during the Star Shower")
        public double mobPotionEffectsChance = 10.0;

        @Config.Name("Sky Color")
        @Config.Comment({"The hex code of the Star Shower's sky color", "Set to 0 to completely disable this feature"})
        public int skyColor = 0x2D2508;

        @Config.Name("On Full Moon")
        @Config.Comment("If the Star Shower should only occur on full moon nights")
        public boolean onFullMoon = false;

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

        @Config.Name("Replacement Spawns")
        @Config.Comment({"The registry names of entities that should replace other entities during the event", "Syntax: originalEntity;replacementEntity"})
        public String[] spawnsReplacement = new String[]{};
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
