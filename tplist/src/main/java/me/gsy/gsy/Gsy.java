package me.gsy.gsy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Gsy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("tplist").setExecutor(new tplist());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
