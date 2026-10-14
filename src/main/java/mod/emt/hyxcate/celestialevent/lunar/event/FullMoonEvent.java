package mod.emt.hyxcate.celestialevent.lunar.event;

import mod.emt.hyxcate.capability.CapabilityCelestialEvent;
import mod.emt.hyxcate.celestialevent.lunar.LunarEventFullMoon;
import mod.emt.hyxcate.config.HyxcateData;
import mod.emt.hyxcate.config.HyxcateLunarEventsConfig;
import mod.emt.hyxcate.util.helpers.ConfigHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FullMoonEvent {
    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        EntityLivingBase entity = event.getEntityLiving();
        CapabilityCelestialEvent Hyxcate = CapabilityCelestialEvent.get(entity.world);
        if (Hyxcate == null || !(entity instanceof IMob || entity instanceof EntityMob)) return;
        if (event.getSpawner() == null && entity.world.canSeeSky(entity.getPosition())) {
            ResourceLocation name = EntityList.getKey(entity);
            if (Hyxcate.currentLunarEvent instanceof LunarEventFullMoon) {
                if (!HyxcateData.EXCLUSIVE_SPAWNS_FULL_MOON.isEmpty() && !HyxcateData.EXCLUSIVE_SPAWNS_FULL_MOON.contains(name)) {
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }

    @SubscribeEvent
    public void onSpawn(LivingSpawnEvent.SpecialSpawn event) {
        EntityLivingBase entity = event.getEntityLiving();
        CapabilityCelestialEvent Hyxcate = CapabilityCelestialEvent.get(entity.world);
        if (Hyxcate == null) return;
        if (Hyxcate.currentLunarEvent instanceof LunarEventFullMoon) {
            if (HyxcateLunarEventsConfig.FULL_MOON.spawnsExtraChance > 0 && entity.world.rand.nextInt(HyxcateLunarEventsConfig.FULL_MOON.spawnsExtraChance) == 0) {
                ConfigHelper.handleExtraSpawn(entity, "full_moon_spawn", HyxcateData.EXTRA_SPAWNS_FULL_MOON);
            }
            event.setCanceled(ConfigHelper.handleReplacementSpawn(entity, "full_moon_spawn", HyxcateData.REPLACEMENT_SPAWNS_FULL_MOON));
            if (HyxcateLunarEventsConfig.FULL_MOON.mobPotionEffects && HyxcateData.isPotionEffectEntityAllowed(entity, HyxcateLunarEventsConfig.mobPotionEffectsEntityList, HyxcateLunarEventsConfig.mobPotionEffectListMode)) {
                HyxcateData.applyPotionEffects(entity, HyxcateLunarEventsConfig.FULL_MOON.mobPotionEffectsList, HyxcateLunarEventsConfig.FULL_MOON.mobPotionEffectsChance);
            }
        }
    }
}
