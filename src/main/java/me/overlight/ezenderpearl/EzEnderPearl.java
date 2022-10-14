package me.overlight.ezenderpearl;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class EzEnderPearl extends JavaPlugin {

    public static EzEnderPearl plugin;
    public static HashMap<String, Location> EnderPearlLocation = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new ProjectileDoEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
