package com.swp.websocket.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swp.websocket.model.dto.SocketMsgDTO;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 描述:webSocket
 *
 * @outhor ios
 * @create 2019-01-11 11:13 AM
 */
@ServerEndpoint(value = "/websocket/{nickname}")
@Component
public class MyWebSocket {

    // 用于存放每个用户对应带的webSocket
    private static CopyOnWriteArraySet<MyWebSocket> arraySet = new CopyOnWriteArraySet<MyWebSocket>();

    // 用户发送数据
    private Session session;
    // 用户昵称
    private String nickname;
    // 保存sessionId和session的绑定
    private static Map<String, Session> map = new HashMap<>();

    // 连接成功
    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname){
        this.session = session;
        this.nickname = nickname;
        map.put(session.getId(), session);

        arraySet.add(this);
        System.out.println(nickname + " 连接成功 sessionID " + session.getId()+  " ,当前在线人数 ： " + arraySet.size());
        this.session.getAsyncRemote().sendText(nickname + " 已经连接成功，频道号： " + session.getId());
    }

    // 断开连接
    @OnClose
    public void onClose(Session session){
        arraySet.remove(this);
        System.out.println("有一个连接断开，当前在线人数 : " + arraySet.size());
    }

    // 接受到消息
    @OnMessage
    public void onMessage(Session session, String message, @PathParam("nickname") String nickname) {
        System.out.println("客户端消息 : " + message);

        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsgDTO msgDTO;

        try {
            msgDTO = objectMapper.readValue(message, SocketMsgDTO.class);
            if (msgDTO.getType() == 1) {
                // 单聊
                msgDTO.setFromUser(session.getId()); // 发送者

                Session fromSession = map.get(msgDTO.getFromUser());
                Session toSession = map.get(msgDTO.getToUser());

                if (toSession != null) {
                    fromSession.getAsyncRemote().sendText(nickname + ":" +msgDTO.getMsg());
                    toSession.getAsyncRemote().sendText(nickname + ":" +msgDTO.getMsg());
                } else {
                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或用户不存在");
                }

            }else {
                groupMessage(message, nickname);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // 发生错误
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误 : " + error.getMessage());
        error.printStackTrace();
    }

    // 群发消息
    public void groupMessage(String message, String nickname) {
        for (MyWebSocket websocket : arraySet) {
            websocket.session.getAsyncRemote().sendText(nickname + " : " + message);
        }
    }




}
