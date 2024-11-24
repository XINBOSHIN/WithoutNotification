package com.github.xinboshin.withoutnotification.platform;

import com.github.xinboshin.withoutnotification.config.APConfig;

import java.util.UUID;

public abstract class Platform {

    private final APConfig apConfig;

    protected Platform(APConfig apConfig) {
        this.apConfig = apConfig;
    }

    public APConfig getApConfig() {
        return apConfig;
    }

    public abstract String getPlayerName(UUID playerUUID);

}
