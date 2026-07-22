package com.alikunduz.exception;

public class BaseExcepiton extends RuntimeException {

    // ErrorMessage tipinde bir obje alıcak ve alınan değeri super ile üst sınıfın constructer a vericek
    //yani RuntimeException a vericek
    public BaseExcepiton(ErrorMessage errorMessage) {
        super(errorMessage.prepareErorMessage());
    }
}
