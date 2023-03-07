package me.rafael5gr2.debugger;

import me.rafael5gr2.debugger.listeners.EntityDeathListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Debugger extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityDeathListener(this), this);
    }
}
