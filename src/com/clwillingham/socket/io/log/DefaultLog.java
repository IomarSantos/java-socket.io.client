package com.clwillingham.socket.io.log;

public class DefaultLog implements LogAdapter {

    @Override
    public void info(String message) {
        System.out.println("INFO: " + message);
    }

    @Override
    public void warning(String message) {
        System.out.println("WARNING: " + message);
    }

    @Override
    public void error(String message) {
        System.err.println("ERROR: " + message);
    }
    
}
