package com.github.xinboshin.withoutnotification.message;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsoleMessages {

    private ConsoleMessages() {}

    public static final String[] BLOCKING_REPORTS_UNSUPPORTED = {
            "Блокировка сообщений в чате была включена, но ваш сервер",
            "Версия не поддерживает это. Завершаем работу"
    };

    public static final String[] ASK_SETUP = {
            "----------------------[ ПРОЧТИ МЕНЯ ]----------------------",
            " Это ваш первый запуск с withoutnotification.",
            "Запустите команду 'withoutnotification setup', чтобы отключить",
            "примените безопасный профиль для улучшения взаимодействия",
            "Это не заставит игроков подписывать свои сообщения",
            "Спасибо за использование withoutnotification!",
            "-------------------------------------------------------"
    };

    public static final String[] ASK_BSTATS = {
            "------------------------[ ПРОЧТИ МНЕ ]------------------------",
            " Это твой первый запуск с помощью WithoutnNotification.",
            "Я хотел бы убедительно попросить вас включить bstats,",
            "значение конфигурации поможет мне улучшить withoutnotification.",
            "Спасибо за использование WithoutnNotification! (вы больше этого не увидите)",
            "-----------------------------------------------------------"
    };

    public static final String[] SETUP_SUCCESS = {
            "-----------------[ ПРОЧТИ МЕНЯ ]-----------------",
            " Теперь плагин полностью настроен. Мы изменили значение",
            "enforce-secure-chat в server.properties.",
            "Сервер перезагрузится через пять секунд.",
            "---------------------------------------------"
    };

    public static final String[] EXPERIMENTAL_SUPPORT = {
            "Включена экспериментальная поддержка версии 1.20.2!",
            "Сообщайте о любых проблемах на github!"
    };

    public static void log(String[] lines, Consumer<String> lambda) {
        Arrays.stream(lines).forEach(lambda);
    }

}
