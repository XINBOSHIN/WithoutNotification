package com.github.xinboshin.withoutnotification.spigot.hook;

import com.github.xinboshin.withoutnotification.spigot.WithoutNotification;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class HookManager {

    private final List<Hook> hooks;

    public HookManager() {
        this.hooks = new ArrayList<>();
    }

    public void addHook(Hook hook) {
        hooks.add(hook);
    }

    public void load() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        for (Hook hook : hooks) {
            if (pluginManager.isPluginEnabled(hook.getPluginName())) {
                WithoutNotification.getInstance().getLogger().info("Loaded a hook for " + hook.getPluginName() + ".");
                hook.register();
            }
        }
    }

}
