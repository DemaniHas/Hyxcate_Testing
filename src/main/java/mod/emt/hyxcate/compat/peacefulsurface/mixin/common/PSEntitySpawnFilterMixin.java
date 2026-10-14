package mod.emt.hyxcate.compat.peacefulsurface.mixin.common;

import mod.emt.hyxcate.capability.CapabilityCelestialEvent;
import lain.mods.peacefulsurface.PeacefulSurface;
import mod.emt.hyxcate.config.HyxcateModIntegrationConfig;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;

@Mixin(value = PeacefulSurface.class, remap = false)
public abstract class PSEntitySpawnFilterMixin {
    @Inject(method = "CheckSpawn", at = @At("HEAD"), cancellable = true)
    private void psCheckSpawn(LivingSpawnEvent.CheckSpawn event, CallbackInfo ci) {
        HyxcateModIntegrationConfig.PeacefulSurface config = HyxcateModIntegrationConfig.PEACEFUL_SURFACE;
        if (!config.enablePeacefulSurface) {
            return;
        }

        CapabilityCelestialEvent cap = CapabilityCelestialEvent.get(event.getWorld());
        if (cap == null) {
            return;
        }

        String[] configuredEvents = config.peacefulSurfaceEvents;
        if (configuredEvents == null || configuredEvents.length == 0) {
            return;
        }

        List<String> eventIds = Arrays.asList(configuredEvents);
        boolean solarMatches = cap.currentSolarEvent != null && eventIds.contains(cap.currentSolarEvent.name);
        boolean lunarMatches = cap.currentLunarEvent != null && eventIds.contains(cap.currentLunarEvent.name);

        if (solarMatches || lunarMatches) {
            ci.cancel();
        }
    }
}
