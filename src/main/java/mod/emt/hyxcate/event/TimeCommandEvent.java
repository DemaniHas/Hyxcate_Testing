package mod.emt.hyxcate.event;

import mod.emt.hyxcate.capability.CapabilityCelestialEvent;
import mod.emt.hyxcate.network.HyxcatePacketHandler;
import mod.emt.hyxcate.network.HyxcatePacketWorld;
import net.minecraft.command.CommandTime;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TimeCommandEvent {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onTimeCommand(CommandEvent event) {
        if (event.getCommand() instanceof CommandTime || event.getCommand().getName().contains("time")) {
            ICommandSender sender = event.getSender();
            if (sender == null) return;
            World world = sender.getEntityWorld();
            if (world == null || world.isRemote) return;
            CapabilityCelestialEvent cap = CapabilityCelestialEvent.get(world);
            if (cap == null) return;
            for (EntityPlayer player : world.playerEntities)
                HyxcatePacketHandler.sendTo(player, new HyxcatePacketWorld(cap));
        }
    }
}
