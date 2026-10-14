package mod.emt.hyxcate.celestialevent.lunar;

import mod.emt.hyxcate.Hyxcate;
import mod.emt.hyxcate.api.celestialevent.HyxcateLunarEvent;
import mod.emt.hyxcate.capability.CapabilityCelestialEvent;
import mod.emt.hyxcate.config.HyxcateGeneralConfig;
import mod.emt.hyxcate.config.HyxcateLunarEventsConfig;
import mod.emt.hyxcate.init.HyxcateSoundEvents;
import mod.emt.hyxcate.util.WorldUtil;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

import java.util.Iterator;

public class LunarEventBlueMoon extends HyxcateLunarEvent {

    private final ConfigImpl config = new ConfigImpl(HyxcateLunarEventsConfig.BLUE_MOON.chance, HyxcateLunarEventsConfig.BLUE_MOON.startNight, HyxcateLunarEventsConfig.BLUE_MOON.gracePeriod, HyxcateLunarEventsConfig.BLUE_MOON.nightInterval);

    public LunarEventBlueMoon(CapabilityCelestialEvent HyxcateWorld) {
        super("blue_moon", HyxcateWorld);
    }

    @Override
    public ITextComponent getStartMessage() {
        String key = "info." + Hyxcate.ID + "." + this.name;
        ITextComponent text = new TextComponentTranslation(key).setStyle(new Style().setColor(TextFormatting.BLUE).setItalic(true));
        if (HyxcateGeneralConfig.GENERAL.eventNotificationsVerbose) {
            key += "_verbose";
            text.appendText("\n");
            text.appendSibling(new TextComponentTranslation(key));
        }
        return text;
    }

    @Override
    public SoundEvent getStartSound() {
        return HyxcateSoundEvents.EVENT_BLUE_MOON_START.getSoundEvent();
    }

    @Override
    public boolean shouldStart(boolean lastDaytime) {
        if (HyxcateLunarEventsConfig.BLUE_MOON.onFullMoon && this.world.getCurrentMoonPhaseFactor() < 1) return false;
        if (!lastDaytime || WorldUtil.isDaytime(this.world)) return false;
        return this.config.canStart(true);
    }

    @Override
    public boolean shouldStop(boolean lastDaytime) {
        return WorldUtil.isDaytime(this.world);
    }

    @Override
    public int getFogColor() {
        return HyxcateLunarEventsConfig.BLUE_MOON.fogColor;
    }

    @Override
    public int getSkyColor() {
        return HyxcateLunarEventsConfig.BLUE_MOON.skyColor;
    }

    @Override
    public int getCloudColor() {
        return HyxcateLunarEventsConfig.BLUE_MOON.cloudColor;
    }

    @Override
    public int getLightmapColor() {
        return HyxcateLunarEventsConfig.BLUE_MOON.lightmapColor;
    }

    @Override
    public String getMoonTexture() {
        return "blue_moon";
    }

    @Override
    public void update(boolean lastDaytime) {
        this.config.update(lastDaytime);

        if (this.world.isRemote || this.hyxcateWorld.currentLunarEvent != this || HyxcateLunarEventsConfig.BLUE_MOON.growAmount <= 0)
            return;
        if (this.world.getTotalWorldTime() % HyxcateLunarEventsConfig.BLUE_MOON.growInterval != 0) return;
        Iterator<Chunk> chunks = this.world.getPersistentChunkIterable(((WorldServer) this.world).getPlayerChunkMap().getChunkIterator());
        while (chunks.hasNext()) {
            Chunk chunk = chunks.next();
            for (int i = 0; i < HyxcateLunarEventsConfig.BLUE_MOON.growAmount; i++) {
                int x = this.world.rand.nextInt(16);
                int z = this.world.rand.nextInt(16);
                int y = chunk.getHeightValue(x, z);
                BlockPos pos = new BlockPos(chunk.x * 16 + x, y, chunk.z * 16 + z);
                IBlockState state = chunk.getBlockState(pos);
                Block block = state.getBlock();
                if (!(block instanceof IGrowable) || block instanceof BlockGrass || block instanceof BlockTallGrass || block instanceof BlockDoublePlant)
                    continue;
                try {
                    IGrowable growable = (IGrowable) block;
                    if (growable.canGrow(this.world, pos, state, false))
                        growable.grow(this.world, this.world.rand, pos, state);
                } catch (Exception ignored) {
                }
            }
        }
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return this.config.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.config.deserializeNBT(nbt);
    }
}
