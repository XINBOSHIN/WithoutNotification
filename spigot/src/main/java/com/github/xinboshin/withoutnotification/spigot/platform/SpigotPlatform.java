package com.github.xinboshin.withoutnotifications.spigot.platform;

import com.github.xinboshin.withoutnotifications.config.APConfig;
import com.github.xinboshin.withoutnotifications.platform.Platform;
import org.bukkit.Bukkit;

import java.util.Objects;
import java.util.UUID;

public class SpigotPlatform extends Platform {

    public SpigotPlatform(APConfig apConfig) {
        super(apConfig);
    }

    @Override
    public String getPlayerName(UUID playerUUID) {
        return Objects.requireNonNull(Bukkit.getPlayer(playerUUID)).getDisplayName();
    }

}
