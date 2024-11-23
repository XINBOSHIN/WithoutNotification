package com.github.xinboshin.withoutnotification.spigot.nms;

import org.bukkit.entity.Player;

public interface PacketInjector {

    void inject(Player player);

    void uninject(Player player);

}
