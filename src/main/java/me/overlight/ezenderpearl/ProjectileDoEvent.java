package me.overlight.ezenderpearl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileDoEvent
        implements Listener {
    @EventHandler
    public void projectile(ProjectileHitEvent e) {
        if(e.getEntity().getType() != EntityType.ENDER_PEARL)
            return;
        Player player = (Player) e.getEntity().getShooter();
        Location fall = e.getEntity().getLocation();
        if(player == null)
            return;
        float yaw = player.getLocation().getYaw(), pitch = player.getLocation().getPitch();
        fall.setPitch(pitch);
        fall.setYaw(yaw);
        fall.setDirection(player.getLocation().getDirection());
        player.teleport(new Location(fall.getWorld(), fall.getX(), fall.getWorld().getHighestBlockYAt(fall) + 1, fall.getZ()));
        for(int i = 0; i < 10; i++)
            player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 50, 1.22, 1, 1.22, 5);
    }
}
