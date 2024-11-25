package com.github.xinboshin.withoutnotification.velocity.platform;

import com.github.xinboshin.withoutnotification.config.APConfig;
import com.github.xinboshin.withoutnotification.platform.Platform;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.UUID;

public class VelocityPlatform extends Platform {

@@ -17,7 +25,74 @@ public VelocityPlatform(ProxyServer server, APConfig apConfig) {

    @Override
    public String getPlayerName(UUID playerUUID) {
        return server.getPlayer(playerUUID).orElseThrow().getUsername();
    }
