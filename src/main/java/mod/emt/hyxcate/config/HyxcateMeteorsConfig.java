package mod.emt.hyxcate.config;

import mod.emt.hyxcate.Hyxcate;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config.LangKey("cfg." + Hyxcate.ID + ".meteors")
@Config(
        modid = Hyxcate.ID,
        name = Hyxcate.ID + "/" + Hyxcate.NAME + " - Meteors"
)
public class HyxcateMeteorsConfig {
    @Config.Name("Chance")
    @Config.Comment("The chance of a meteor spawning every minute, during the day")
    @Config.RangeDouble(min = 0.0)
    public static double chanceM = 0.0042;

    @Config.Name("Chance At Night")
    @Config.Comment("The chance of a meteor spawning every minute, during nighttime")
    @Config.RangeDouble(min = 0.0)
    public static double chanceNightM = 0.0072;

    @Config.Name("Gate Dimension")
    @Config.Comment("The dimension that needs to be entered to increase the spawning of meteors")
    public static int gateDimension = 1;

    @Config.Name("Chance After Gate Visit")
    @Config.Comment("The chance of a meteor spawning every minute, during the day, after the gate dimension has been entered once")
    @Config.RangeDouble(min = 0.0)
    public static double chanceAfterGateM = 0.006;

    @Config.Name("Chance After Gate Visit At Night")
    @Config.Comment("The chance of a meteor spawning every minute, during the night, after the gate dimension has been entered once")
    @Config.RangeDouble(min = 0.0)
    public static double chanceAfterGateNightM = 0.09;

    @Config.Name("Chance During Star Showers")
    @Config.Comment("The chance of a meteor spawning every minute, during a star shower")
    @Config.RangeDouble(min = 0.0)
    public static double chanceStarShowerM = 0.144;

    @Config.Name("Chance In The End")
    @Config.Comment("The chance of a meteor spawning every minute, in the end dimension")
    @Config.RangeDouble(min = 0.0)
    public static double chanceEndM = 0.09;

    @Config.Name("Grace Period")
    @Config.Comment("The amount of days that should pass after world creation until meteors can fall")
    @Config.RangeInt(min = 0)
    public static int gracePeriod = 0;

    @Config.Name("Spawn Radius")
    @Config.Comment("The amount of blocks a meteor can spawn away from the nearest player")
    public static int spawnRadius = 1000;

    @Config.Name("Disallow Radius")
    @Config.Comment("The radius in chunks that should be marked as invalid for meteor spawning around each player")
    public static int disallowRadius = 14;

    @Config.Name("Disallow Time")
    @Config.Comment("The amount of ticks that need to pass for each player until the chance of a meteor spawning in the area is halved (and then halved again, and so on)")
    public static int disallowTime = 12000;

    @Config.Name("Chat Message")
    @Config.Comment("If fallen meteors should be announced in chat on impact")
    public static boolean message = true;

    @Config.Name("Chat Message Verbose")
    @Config.Comment("If chat messages for meteor impacts should include coordinates")
    public static boolean messageVerbose = false;

    @Config.Name("Meteor Blocks: Meteorite")
    @Config.Comment({"Main blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] meteorBlocksMeteorite = new String[]{
            "hyxcate:meteorite_rock_hot",
            "hyxcate:meteorite_rock"
    };

    @Config.Name("Meteor Blocks: Frezarite")
    @Config.Comment({"Main blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] meteorBlocksFrezarite = new String[]{
            "hyxcate:frezarite_rock",
            "minecraft:packed_ice"
    };

    @Config.Name("Meteor Blocks: Kreknorite")
    @Config.Comment({"Main blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] meteorBlocksKreknorite = new String[]{
            "hyxcate:kreknorite_rock",
            "minecraft:obsidian"
    };

    @Config.Name("Meteor Blocks: Unknown")
    @Config.Comment({"Main blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] meteorBlocksUnknown = new String[]{
            "hyxcate:meteorite_rock_hot",
            "hyxcate:meteorite_rock",
            "hyxcate:frezarite_rock",
            "hyxcate:kreknorite_rock",
            "minecraft:packed_ice",
            "minecraft:obsidian"
    };

    @Config.Name("Filler Blocks: Meteorite")
    @Config.Comment({"Subsidiary blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] fillerBlocksMeteorite = new String[]{
            "minecraft:magma"
    };

    @Config.Name("Filler Blocks: Frezarite")
    @Config.Comment({"Subsidiary blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] fillerBlocksFrezarite = new String[]{
            "minecraft:packed_ice"
    };

    @Config.Name("Filler Blocks: Kreknorite")
    @Config.Comment({"Subsidiary blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] fillerBlocksKreknorite = new String[]{
            "minecraft:magma"
    };

    @Config.Name("Filler Blocks: Unknown")
    @Config.Comment({"Subsidiary blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] fillerBlocksUnknown = new String[]{
            "minecraft:magma",
            "minecraft:packed_ice"
    };

    @Config.Name("Liquid Blocks: Meteorite")
    @Config.Comment({"Fluid blocks that are spawned on impact of regular meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] liquidBlocksMeteorite = new String[]{
            "minecraft:air"
    };

    @Config.Name("Liquid Blocks: Frezarite")
    @Config.Comment({"Fluid blocks that are spawned on impact of cold meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] liquidBlocksFrezarite = new String[]{
            "minecraft:water"
    };

    @Config.Name("Liquid Blocks: Kreknorite")
    @Config.Comment({"Fluid blocks that are spawned on impact of hot meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] liquidBlocksKreknorite = new String[]{
            "minecraft:lava"
    };

    @Config.Name("Liquid Blocks: Unknown")
    @Config.Comment({"Fluid blocks that are spawned on impact of mixed meteors", "Syntax: modid:block or modid:block:meta"})
    public static String[] liquidBlocksUnknown = new String[]{
            "minecraft:lava",
            "minecraft:water"
    };

    @Config.Name("Meteor Sizes")
    @Config.Comment({"Sizes of meteors that are allowed to spawn", "1 = Small", "2 = Medium", "3 = Large"})
    public static Integer[] meteorSizes = new Integer[]{1, 2, 3};

    @Config.Name("Meteor Types")
    @Config.Comment({"Types of meteors that are allowed to spawn", "1 = Meteorite", "2 = Frezarite", "3 = Kreknorite", "4 = Unknown"})
    public static Integer[] meteorTypes = new Integer[]{1, 2, 3, 4};

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
