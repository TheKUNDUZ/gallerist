package com.alikunduz.handler;

import com.alikunduz.exception.BaseExcepiton;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BaseExcepiton.class)
    public ResponseEntity<ApiEror<?>> handleBaseException(BaseExcepiton ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiEror(ex.getMessage(), request));
    }

    // yukarıdaki BaseException validation excepitonları yakalamayacağı için bu methodu kullanmalıyız
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiEror<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> map = new HashMap<>();
        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            String fieldName= ((FieldError)objError).getField();

            if (map.containsKey(fieldName)) {
                map.put(fieldName, addValue(map.get(fieldName), objError.getDefaultMessage()));
            }
            else {
                map.put(fieldName, addValue(new ArrayList<>(), objError.getDefaultMessage()));
            }

        }
        return ResponseEntity.badRequest().body(createApiEror(map, request));

    }



    private List<String> addValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    private String getHostName() {
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public <E> ApiEror<E> createApiEror(E message, WebRequest request) {
        ApiEror<E> apiEror = new ApiEror<>();
        apiEror.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();
        exception.setPath(request.getDescription(false).substring(4));
        exception.setCreateTime(new Date());
        exception.setMessage(message);
        exception.setHostName(getHostName());

        apiEror.setException(exception);

        return apiEror;
    }


}
