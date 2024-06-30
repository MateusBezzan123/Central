package com.invext.central;

public class Request {
    private String id;
    private String type;
    private String customerId;

    public Request(String id, String type, String customerId) {
        this.id = id;
        this.type = type;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCustomerId() {
        return customerId;
    }
}