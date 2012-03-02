package com.clwillingham.socket.io.log;

public interface LogAdapter {
    public void info(String message);
    public void warning(String message);
    public void error(String message);
}
