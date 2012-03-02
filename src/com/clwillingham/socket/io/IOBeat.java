package com.clwillingham.socket.io;

import com.clwillingham.socket.io.log.Log;
import java.util.TimerTask;

public class IOBeat extends TimerTask {
	
    private IOWebSocket socket;
    private boolean running = false;
	
    public IOBeat(IOWebSocket socket){
	this.socket = socket;
    }

    @Override
    public void run() {
	if(running) {
            try {
                socket.send("2::"); //send heartbeat;
                Log.info("HeartBeat Written to server");
            } catch (Exception e) {
                Log.error(e.getMessage());
            }
	}
    }
	
    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

}