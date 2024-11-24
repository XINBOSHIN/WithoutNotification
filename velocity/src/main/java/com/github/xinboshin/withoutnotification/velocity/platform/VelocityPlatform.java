package com.github.xinboshin.withoutnotification.velocity.platform;

import com.github.xinboshin.withoutnotification.config.APConfig;
import com.github.xinboshin.withoutnotification.platform.Platform;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.Server;
import com.velocitypowered.api.proxy.events.PlayerLoginEvent;
import com.velocitypowered.api.proxy.events.PlayerDisconnectEvent;
import com.velocitypowered.api.event.Event;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.event.PlayerEvent;

import java.util.UUID;
import java.util.Optional;

public class VelocityPlatform extends Platform {

    private final ProxyServer server;

    public VelocityPlatform(ProxyServer server, APConfig apConfig) {
        super(apConfig);
        this.server = server;
    }

    @Override
    public String getPlayerName(UUID playerUUID) {
        return server.getPlayer(playerUUID)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"))
                .getUsername();
    }

    @Override
    public boolean isPlayerOnline(UUID playerUUID) {
        return server.getPlayer(playerUUID).isPresent();
    }

    @Override
    public void sendMessage(UUID playerUUID, String message) {
        Optional<Player> player = server.getPlayer(playerUUID);
        player.ifPresent(p -> p.sendMessage(message));
    }

    @Override
    public void kickPlayer(UUID playerUUID, String reason) {
        Optional<Player> player = server.getPlayer(playerUUID);
        player.ifPresent(p -> p.disconnect(reason));
    }

    @Override
    public void broadcastMessage(String message) {
        server.getAllPlayers().forEach(player -> player.sendMessage(message));
    }

    public void onPlayerLogin(PlayerLoginEvent event) {
        // Handle player login event
        Player player = event.getPlayer();
        System.out.println(player.getUsername() + " has logged in.");
    }

    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        // Handle player disconnect event
        Player player = event.getPlayer();
        System.out.println(player.getUsername() + " has disconnected.");
    }

    public void registerEvents() {
        // Register events
        server.getEventManager().register(this, new PlayerLoginEventListener());
        server.getEventManager().register(this, new PlayerDisconnectEventListener());
    }

    // Example event listener classes for login and disconnect
    public class PlayerLoginEventListener {
        @Subscribe
        public void onLogin(PlayerLoginEvent event) {
            onPlayerLogin(event);
        }
    }

    public class PlayerDisconnectEventListener {
        @Subscribe
        public void onDisconnect(PlayerDisconnectEvent event) {
            onPlayerDisconnect(event);
        }
    }

    @Override
    public int getOnlinePlayerCount() {
        return server.getPlayerCount();
    }

    @Override
    public UUID getPlayerUUID(String playerName) {
        Optional<Player> player = server.getPlayer(playerName);
        return player.map(Player::getUniqueId).orElseThrow(() -> new IllegalArgumentException("Player not found"));
    }
}
