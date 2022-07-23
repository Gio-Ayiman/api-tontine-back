package org.group.ventis.emftontine.utils;

public class ApiResponse {

    public ResponseMessage responseMessage;

    public ApiResponse(){};
    public ApiResponse(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }
}
