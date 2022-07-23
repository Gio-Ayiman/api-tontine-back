package org.group.ventis.emftontine.utils;

public class ResponseMessage {

    public int code;
    public String type;
    public String message;

    public ResponseMessage(){}

    public ResponseMessage(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
