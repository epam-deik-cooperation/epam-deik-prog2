package com.epam.training.designpatterns.singleton;

import java.time.LocalDateTime;

public class Logger {

    private static Logger instance;

    private Logger() {

    }

    public void debug(String message) {
        log(Severity.DEBUG, message);
    }

    public void info(String message) {
        log(Severity.INFO, message);
    }

    public void warn(String message) {
        log(Severity.WARN, message);
    }

    public void error(String message) {
        log(Severity.ERROR, message);
    }

    private void log(Severity severity, String message) {
        String logLine = new StringBuilder()
            .append("[")
            .append(severity)
            .append("] at ")
            .append(LocalDateTime.now())
            .append(": ")
            .append(message)
            .toString();
        System.out.println(logLine);
    }

    private enum Severity {
        DEBUG, INFO, WARN, ERROR
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

}
