package org.socketio.chat;

import com.clwillingham.socket.io.IOSocket;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class Chat extends Thread {
    private IOSocket socket;
    private ChatCallback callback;
    
    public Chat(ChatCallbackAdapter callback) {
        this.callback = new ChatCallback(callback);
    }
    
    @Override
    public void run() {
        socket = new IOSocket("http://localhost:3000", callback);
        socket.connect();
    }
    
    public void sendMessage(String message) {
        try {
            JSONObject json = new JSONObject();
            json.putOpt("message", message);
            socket.emit("user message", json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    
    public void join(String nickname) {
        try {
            JSONObject json = new JSONObject();
            json.putOpt("nickname", nickname);
            socket.emit("nickname", json, callback);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
