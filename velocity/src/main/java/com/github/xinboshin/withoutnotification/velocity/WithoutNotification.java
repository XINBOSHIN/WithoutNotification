package com.github.xinboshin.withoutnotification.velocity;

import com.github.xinboshin.withoutnotification.config.APConfig;
import com.github.xinboshin.withoutnotification.listener.PacketEventsListener;
import com.github.xinboshin.withoutnotification.velocity.platform.VelocityPlatform;
import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.retrooper.packetevents.velocity.factory.VelocityPacketEventsBuilder;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;

@Plugin(
        id = "withoutnotification",
        name = "withoutnotification",
        authors = "xinboshin",
        version = com.github.xinboshin.withoutnotification.velocity.BuildConstants.VERSION
)
public class WithoutNotification {

    private final ProxyServer server;
    private final APConfig config;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public WithoutNotification(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) throws IOException {
        this.server = server;
        this.logger = logger;
        this.config = new APConfig(dataDirectory.toFile(), this.getClass().getClassLoader());
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        VelocityPlatform platform = new VelocityPlatform(server, config);

        PluginContainer pluginContainer = server.getPluginManager().ensurePluginContainer(this);
        PacketEvents.setAPI(VelocityPacketEventsBuilder.build(server, pluginContainer, logger, dataDirectory));
        PacketEvents.getAPI().getSettings().debug(false).checkForUpdates(false);
        PacketEvents.getAPI().load();
        PacketEvents.getAPI().getEventManager().registerListener(new PacketEventsListener(platform), PacketListenerPriority.LOW);
        PacketEvents.getAPI().init();
    }


}
