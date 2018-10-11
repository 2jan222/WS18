package com.github._2jan222;

import java.io.Serializable;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class Protocol implements Serializable {
    private ProtocolType type;
    private Object data;

    public Protocol(ProtocolType type, Object data) {
        this.type = type;
        this.data = data;
    }

    public ProtocolType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public enum ProtocolType {
        GET_LIST,PUT_RESERVATION,FREE,ERROR;
    }
}
