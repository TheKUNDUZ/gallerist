package com.alikunduz.exception;

public class BaseException extends RuntimeException {

    // ErrorMessage tipinde bir obje alıcak ve alınan değeri super ile üst sınıfın constructer a vericek
    //yani RuntimeException a vericek
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErorMessage());
    }
}
