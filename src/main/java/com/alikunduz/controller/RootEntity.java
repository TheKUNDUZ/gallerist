package com.alikunduz.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private Integer status;

    private T payload;

    private String erorMessage;


    public static  <T> RootEntity<T> ok(T payload) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setStatus(200);
        rootEntity.setPayload(payload);
        rootEntity.setErorMessage(null);
        return rootEntity;
    }

    public static <T> RootEntity<T> eror(String erorMessage){
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setStatus(500);
        rootEntity.setPayload(null);
        rootEntity.setErorMessage(erorMessage);
        return rootEntity;

    }


}
