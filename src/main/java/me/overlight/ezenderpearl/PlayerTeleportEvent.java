package me.overlight.ezenderpearl;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerTeleportEvent
        implements Listener {
    @EventHandler
    public void teleport(org.bukkit.event.player.PlayerTeleportEvent e){
        if(e.getCause() != org.bukkit.event.player.PlayerTeleportEvent.TeleportCause.PLUGIN)
            return;
        e.getPlayer().getLocation().setPitch(e.getFrom().getPitch());
        e.getPlayer().getLocation().setYaw(e.getFrom().getYaw());
        e.getPlayer().getLocation().setDirection(e.getFrom().getDirection());
    }
}
