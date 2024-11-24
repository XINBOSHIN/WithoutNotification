package com.github.xinboshin.withoutnotification.velocity.platform;

import com.github.xinboshin.withoutnotification.config.APConfig;
import com.github.xinboshin.withoutnotification.platform.Platform;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.UUID;

public class VelocityPlatform extends Platform {

    private final ProxyServer server;

    public VelocityPlatform(ProxyServer server, APConfig apConfig) {
        super(apConfig);
        this.server = server;
    }

    @Override
    public String getPlayerName(UUID playerUUID) {
        return server.getPlayer(playerUUID).orElseThrow().getUsername();
    }

}
