package com.github.xinboshin.withoutnotification.spigot.platform;

import com.github.xinboshin.withoutnotification.config.APConfig;
import com.github.xinboshin.withoutnotification.platform.Platform;
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
