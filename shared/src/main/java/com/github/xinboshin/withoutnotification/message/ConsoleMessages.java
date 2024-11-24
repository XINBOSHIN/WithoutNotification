package com.github.xinboshin.withoutnotification.message;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsoleMessages {

    private ConsoleMessages() {}

    public static final String[] BLOCKING_REPORTS_UNSUPPORTED = {
            "Blocking chat reports was enabled but your server",
            "version doesn't support it. Exiting."
    };

    public static final String[] ASK_SETUP = {
            "----------------------[ READ ME ]----------------------",
            "This is your first startup with withoutnotification.",
            "Run command 'withoutnotification setup' to disable",
            "enforce-secure-profile for better experience.",
            "This will not force players to sign their messages.",
            "Thanks for using withoutnotification!",
            "-------------------------------------------------------"
    };

    public static final String[] ASK_BSTATS = {
            "------------------------[ READ ME ]------------------------",
            "This is your first startup with withoutnotification.",
            "I would like to kindly ask you to enable bstats",
            "configuration value to help me improve withoutnotification.",
            "Because I respect your freedom it's disabled by default.",
            "Thanks for using withoutnotification! (you will not see this again)",
            "-----------------------------------------------------------"
    };

    public static final String[] SETUP_SUCCESS = {
            "-----------------[ READ ME ]-----------------",
            "Plugin is set up fully now. We changed value",
            "of enforce-secure-chat in server.properties.",
            "Server will restart in five seconds.",
            "---------------------------------------------"
    };

    public static final String[] EXPERIMENTAL_SUPPORT = {
            "Enabling experimental 1.20.2 support!",
            "Report any issues on github!"
    };

    public static void log(String[] lines, Consumer<String> lambda) {
        Arrays.stream(lines).forEach(lambda);
    }

}
