package org.socketio.chat;

import com.clwillingham.socket.io.AckCallback;
import com.clwillingham.socket.io.MessageCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatCallback extends AckCallback implements MessageCallback {
    private ChatCallbackAdapter callback;
    
    public ChatCallback(ChatCallbackAdapter callback) {
        this.callback = callback;
    }

    @Override
    public void callback(JSONArray data) throws JSONException {
        callback.callback(data);
    }

    @Override
    public void on(String event, JSONObject... data) {
        callback.on(event, data);
    }

    @Override
    public void onMessage(String message) {
        callback.onMessage(message);
    }

    @Override
    public void onMessage(JSONObject json) {
        callback.onMessage(json);
    }

    @Override
    public void onConnect() {
        callback.onConnect();
    }

    @Override
    public void onDisconnect() {
        callback.onDisconnect();
    }

    @Override
    public void onConnectFailure() {
        callback.onConnectFailure();
    }
    
}
