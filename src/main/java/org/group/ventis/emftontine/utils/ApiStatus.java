package org.group.ventis.emftontine.utils;

public enum ApiStatus {
    NULL_ENTITY_ID (402, "NULL_ENTITY_ID", "l'identifiant est nulle");

    private final int code;
    private final String type;
    private final String message;

    ApiStatus(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
