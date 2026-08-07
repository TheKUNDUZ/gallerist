package com.alikunduz.controller;

public class RestBaseController {

    public <T> RootEntity<T> ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T> RootEntity<T> eror(String erorMessage) {
        return RootEntity.eror(erorMessage);
    }

}
