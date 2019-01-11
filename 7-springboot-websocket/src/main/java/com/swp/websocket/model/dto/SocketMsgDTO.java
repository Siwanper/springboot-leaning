package com.swp.websocket.model.dto;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-11 2:50 PM
 */
public class SocketMsgDTO {

    private int type; // 聊天类型 0 ：群聊， 1 ： 单聊
    private String fromUser;
    private String toUser;
    private String msg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
