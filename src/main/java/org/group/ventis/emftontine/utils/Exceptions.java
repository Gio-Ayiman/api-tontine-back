package org.group.ventis.emftontine.utils;

public final class Exceptions extends Throwable {

    static class NullEntityId extends RuntimeException {
        final ApiResponse apiResponse = new ApiResponse();

        public NullEntityId(long id) {
            ApiStatus status = ApiStatus.NULL_ENTITY_ID;

            ResponseMessage responseMessage = new ResponseMessage();

            responseMessage.code = status.getCode();
            responseMessage.type = status.getType();
            responseMessage.message = status.getMessage();

            this.apiResponse.setResponseMessage(responseMessage);
        }



    }


}
