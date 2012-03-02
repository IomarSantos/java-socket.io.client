package com.clwillingham.socket.io.log;

public class Log {
    public static LogAdapter logger;
    
    public static LogAdapter getInstance() {
        if (logger == null) {
            logger = new DefaultLog();
        }
        return logger;
    }
    
    public static void setInstance(LogAdapter adapter) {
        logger = adapter;
    }
    
    public static void info(String message) {
        getInstance().info(message);
    }
    
    public static void warning(String message) {
        getInstance().warning(message);
    }
    
    public static void error(String message) {
        getInstance().error(message);
    }
}
