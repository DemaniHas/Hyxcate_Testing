package mod.emt.hyxcate.config;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HyxcateData {
    public static final List<Integer> ALLOWED_DIMENSIONS_LUNAR = new ArrayList<>();
    public static final List<Integer> ALLOWED_DIMENSIONS_SOLAR = new ArrayList<>();

    public static final List<Integer> ALLOWED_METEOR_SIZES = new ArrayList<>();
    public static final List<Integer> ALLOWED_METEOR_TYPES = new ArrayList<>();

    public static final List<IBlockState> METEOR_BLOCKS_METEORITE = new ArrayList<>();
    public static final List<IBlockState> METEOR_BLOCKS_FREZARITE = new ArrayList<>();
    public static final List<IBlockState> METEOR_BLOCKS_KREKNORITE = new ArrayList<>();
    public static final List<IBlockState> METEOR_BLOCKS_UNKNOWN = new ArrayList<>();

    public static final List<IBlockState> FILLER_BLOCKS_METEORITE = new ArrayList<>();
    public static final List<IBlockState> FILLER_BLOCKS_FREZARITE = new ArrayList<>();
    public static final List<IBlockState> FILLER_BLOCKS_KREKNORITE = new ArrayList<>();
    public static final List<IBlockState> FILLER_BLOCKS_UNKNOWN = new ArrayList<>();

    public static final List<IBlockState> LIQUID_BLOCKS_METEORITE = new ArrayList<>();
    public static final List<IBlockState> LIQUID_BLOCKS_FREZARITE = new ArrayList<>();
    public static final List<IBlockState> LIQUID_BLOCKS_KREKNORITE = new ArrayList<>();
    public static final List<IBlockState> LIQUID_BLOCKS_UNKNOWN = new ArrayList<>();

    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_BLOOD_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_BLUE_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_FULL_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_STAR_SHOWER = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_GRIM_ECLIPSE = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> EXTRA_SPAWNS_RED_GIANT = new Object2ObjectOpenHashMap<>();

    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_BLOOD_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_BLUE_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_FULL_MOON = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_STAR_SHOWER = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_GRIM_ECLIPSE = new Object2ObjectOpenHashMap<>();
    public static final Map<ResourceLocation, List<ResourceLocation>> REPLACEMENT_SPAWNS_RED_GIANT = new Object2ObjectOpenHashMap<>();

    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_BLOOD_MOON = new ArrayList<>();
    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_BLUE_MOON = new ArrayList<>();
    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_FULL_MOON = new ArrayList<>();
    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_STAR_SHOWER = new ArrayList<>();
    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_GRIM_ECLIPSE = new ArrayList<>();
    public static final List<ResourceLocation> EXCLUSIVE_SPAWNS_RED_GIANT = new ArrayList<>();

    public static void initConfigLists() {
        ALLOWED_DIMENSIONS_LUNAR.clear();
        ALLOWED_DIMENSIONS_LUNAR.addAll(Arrays.asList(HyxcateLunarEventsConfig.allowedDimensions));
        ALLOWED_DIMENSIONS_SOLAR.clear();
        ALLOWED_DIMENSIONS_SOLAR.addAll(Arrays.asList(HyxcateSolarEventsConfig.allowedDimensions));

        ALLOWED_METEOR_SIZES.clear();
        ALLOWED_METEOR_SIZES.addAll(Arrays.asList(HyxcateMeteorsConfig.meteorSizes));
        ALLOWED_METEOR_TYPES.clear();
        ALLOWED_METEOR_TYPES.addAll(Arrays.asList(HyxcateMeteorsConfig.meteorTypes));

        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.meteorBlocksMeteorite, METEOR_BLOCKS_METEORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.meteorBlocksFrezarite, METEOR_BLOCKS_FREZARITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.meteorBlocksKreknorite, METEOR_BLOCKS_KREKNORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.meteorBlocksUnknown, METEOR_BLOCKS_UNKNOWN);

        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.fillerBlocksMeteorite, FILLER_BLOCKS_METEORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.fillerBlocksFrezarite, FILLER_BLOCKS_FREZARITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.fillerBlocksKreknorite, FILLER_BLOCKS_KREKNORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.fillerBlocksUnknown, FILLER_BLOCKS_UNKNOWN);

        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.liquidBlocksMeteorite, LIQUID_BLOCKS_METEORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.liquidBlocksFrezarite, LIQUID_BLOCKS_FREZARITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.liquidBlocksKreknorite, LIQUID_BLOCKS_KREKNORITE);
        readBlockStatesFromConfigAsList(HyxcateMeteorsConfig.liquidBlocksUnknown, LIQUID_BLOCKS_UNKNOWN);

        readEntitiesFromConfigAsList(HyxcateLunarEventsConfig.BLOOD_MOON.spawnsExclusive, EXCLUSIVE_SPAWNS_BLOOD_MOON);
        readEntitiesFromConfigAsList(HyxcateLunarEventsConfig.BLUE_MOON.spawnsExclusive, EXCLUSIVE_SPAWNS_BLUE_MOON);
        readEntitiesFromConfigAsList(HyxcateLunarEventsConfig.FULL_MOON.spawnsExclusive, EXCLUSIVE_SPAWNS_FULL_MOON);
        readEntitiesFromConfigAsList(HyxcateLunarEventsConfig.STAR_SHOWER.spawnsExclusive, EXCLUSIVE_SPAWNS_STAR_SHOWER);
        readEntitiesFromConfigAsList(HyxcateSolarEventsConfig.GRIM_ECLIPSE.spawnsExclusive, EXCLUSIVE_SPAWNS_GRIM_ECLIPSE);
        readEntitiesFromConfigAsList(HyxcateSolarEventsConfig.RED_GIANT.spawnsExclusive, EXCLUSIVE_SPAWNS_RED_GIANT);

        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.BLOOD_MOON.spawnsExtra, EXTRA_SPAWNS_BLOOD_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.BLUE_MOON.spawnsExtra, EXTRA_SPAWNS_BLUE_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.FULL_MOON.spawnsExtra, EXTRA_SPAWNS_FULL_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.STAR_SHOWER.spawnsExtra, EXTRA_SPAWNS_STAR_SHOWER);
        readEntitiesFromConfigAsMap(HyxcateSolarEventsConfig.GRIM_ECLIPSE.spawnsExtra, EXTRA_SPAWNS_GRIM_ECLIPSE);
        readEntitiesFromConfigAsMap(HyxcateSolarEventsConfig.RED_GIANT.spawnsExtra, EXTRA_SPAWNS_RED_GIANT);

        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.BLOOD_MOON.spawnsReplacement, REPLACEMENT_SPAWNS_BLOOD_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.BLUE_MOON.spawnsReplacement, REPLACEMENT_SPAWNS_BLUE_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.FULL_MOON.spawnsReplacement, REPLACEMENT_SPAWNS_FULL_MOON);
        readEntitiesFromConfigAsMap(HyxcateLunarEventsConfig.STAR_SHOWER.spawnsReplacement, REPLACEMENT_SPAWNS_STAR_SHOWER);
        readEntitiesFromConfigAsMap(HyxcateSolarEventsConfig.GRIM_ECLIPSE.spawnsReplacement, REPLACEMENT_SPAWNS_GRIM_ECLIPSE);
        readEntitiesFromConfigAsMap(HyxcateSolarEventsConfig.RED_GIANT.spawnsReplacement, REPLACEMENT_SPAWNS_RED_GIANT);
    }

    public static void applyPotionEffects(EntityLivingBase entity, String[] configuredEffects, double chance) {
        if (entity == null || configuredEffects == null || configuredEffects.length == 0 || chance <= 0.0) {
            return;
        }

        chance = Math.min(chance, 100.0);
        if (entity.world.rand.nextDouble() * 100.0 >= chance) {
            return;
        }

        List<PotionEffect> validEffects = new ArrayList<>();
        for (String entry : configuredEffects) {
            if (entry == null || entry.trim().isEmpty()) {
                continue;
            }

            String[] parts = entry.split(";", -1);
            if (parts.length < 1 || parts.length > 3) {
                continue;
            }

            try {
                ResourceLocation id = new ResourceLocation(parts[0].trim());
                Potion potion = Potion.REGISTRY.getObject(id);

                if (potion == null) {
                    continue;
                }

                int duration = Integer.MAX_VALUE;
                int amplifier = 0;

                if (parts.length >= 2 && !parts[1].trim().isEmpty()) {
                    String durationString = parts[1].trim();
                    duration = durationString.equals("*") ? Integer.MAX_VALUE : Integer.parseInt(durationString);
                }

                if (parts.length >= 3 && !parts[2].trim().isEmpty()) {
                    amplifier = Integer.parseInt(parts[2].trim());
                }

                if (duration <= 0 || amplifier < 0) {
                    continue;
                }
                validEffects.add(new PotionEffect(potion, duration, amplifier));
            } catch (IllegalArgumentException ignored) {
            }
        }

        if (!validEffects.isEmpty()) {
            PotionEffect selected = validEffects.get(entity.world.rand.nextInt(validEffects.size()));
            entity.addPotionEffect(selected);
        }
    }

    public static boolean isPotionEffectEntityAllowed(EntityLivingBase entity, String[] entityList, HyxcateLunarEventsConfig.EnumLists mode) {
        if (entity == null) {
            return false;
        }

        ResourceLocation entityId = EntityList.getKey(entity);

        if (entityId == null) {
            return false;
        }

        boolean listed = false;

        if (entityList != null) {
            for (String entry : entityList) {
                if (entry == null || entry.trim().isEmpty()) {
                    continue;
                }
                try {
                    if (new ResourceLocation(entry.trim()).equals(entityId)) {
                        listed = true;
                        break;
                    }
                } catch (IllegalArgumentException ignored) {
                }
            }
        }
        return (mode == HyxcateLunarEventsConfig.EnumLists.WHITELIST) == listed;
    }

    private static void readBlockStatesFromConfigAsList(String[] array, List<IBlockState> list) {
        list.clear();
        for (String string : array) {
            String[] split = string.split(":");
            if (split.length == 3) {
                int meta = Integer.parseInt(split[2]);
                list.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(split[0], split[1])).getStateFromMeta(meta));
            } else {
                list.add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string)).getDefaultState());
            }
        }
    }

    private static void readEntitiesFromConfigAsList(String[] array, List<ResourceLocation> list) {
        list.clear();
        for (String string : array) {
            list.add(new ResourceLocation(string));
        }
    }

    private static void readEntitiesFromConfigAsMap(String[] array, Map<ResourceLocation, List<ResourceLocation>> map) {
        map.clear();
        map.putAll(Arrays.stream(array)
                .map(string -> string.split(";"))
                .filter(subStrings -> subStrings.length == 2)
                .collect(Collectors.groupingBy(
                        subStrings -> new ResourceLocation(subStrings[0]),
                        Collectors.mapping(subStrings -> new ResourceLocation(subStrings[1]), Collectors.toList()))));
    }
}
