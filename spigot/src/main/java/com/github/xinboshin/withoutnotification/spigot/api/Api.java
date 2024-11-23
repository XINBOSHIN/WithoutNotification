package com.github.xinboshin.withoutnotifications.spigot.api;

import com.github.xinboshin.withoutnotifications.message.ConsoleMessages;
import com.github.xinboshin.withoutnotifications.spigot.withoutnotifications;
import com.github.retrooper.packetevents.PacketEvents;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class Api {

    private Api() {}

    // TODO: Refactor eventually
    /**
     * This "sets up" the plugin aka changes
     * enforce-secure-profile property in server.properties
     * to false.
     *
     * @param time Delay of the setup.
     */
    public static void setupwithoutnotifications(int time, boolean silent) {
        try {
            try (FileInputStream in = new FileInputStream(withoutnotifications.getPropertiesFile())) {
                Properties props = new Properties();
                props.load(in);
                if (Boolean.parseBoolean(props.getProperty("enforce-secure-profile"))) {
                    props.setProperty("enforce-secure-profile", String.valueOf(false));
                    try (FileOutputStream out = new FileOutputStream(withoutnotifications.getPropertiesFile())) {
                        props.store(out, "Minecraft server properties");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    ConsoleMessages.log(ConsoleMessages.SETUP_SUCCESS, getLogger()::warning);
                    WithoutNotifications.getFoliaLib().getImpl().runLater(() -> {
                        PacketEvents.getAPI().terminate();
                        getServer().spigot().restart();
                    }, time * 50L, TimeUnit.MILLISECONDS);
                } else if (!silent) {
                    getLogger().info("WithoutNotifications has been already set up.");
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
