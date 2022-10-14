package me.overlight.ezenderpearl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.projectiles.ProjectileSource;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteractEvent
        implements Listener {
    @EventHandler
    public void interact(org.bukkit.event.player.PlayerInteractEvent e){
        if(e.getItem() == null)
            return;
        if(e.getItem().getType() != Material.ENDER_PEARL)
            return;
        if(e.getAction() != Action.RIGHT_CLICK_AIR)
            return;
        if(e.getClickedBlock() != null)
            return;
        if(e.getPlayer().getLocation().getY() > 10000){
            e.setCancelled(true);
            return;
        }
        for(int i = e.getPlayer().getLocation().getBlockY(); i > 0; i--){
            Location loc = new Location(e.getPlayer().getWorld(), e.getPlayer().getLocation().getX(), i, e.getPlayer().getLocation().getZ());
            if(loc.getBlock().getType() == Material.SOUL_SAND){
                List<Boolean> waters = new ArrayList<>();
                for(int x = i; x < e.getPlayer().getWorld().getHighestBlockYAt(loc); x++){
                    waters.add(new Location(e.getPlayer().getWorld(), e.getPlayer().getLocation().getX(), i, e.getPlayer().getLocation().getZ()).getBlock().getType() != Material.WATER);
                }
                if(waters.contains(true)) {
                    return;
                }
            }
        }
        for(int i = 0; i < 10; i++)
            e.getPlayer().getWorld().spawnParticle(Particle.PORTAL, e.getPlayer().getLocation(), 50, 1.22, 1, 1.22, 5);
        Bukkit.getScheduler().scheduleSyncDelayedTask(EzEnderPearl.plugin, () -> {
            e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), e.getPlayer().getLocation().getX(), e.getPlayer().getLocation().getY() + 100000, e.getPlayer().getLocation().getZ()));
        }, 3);
    }
}
