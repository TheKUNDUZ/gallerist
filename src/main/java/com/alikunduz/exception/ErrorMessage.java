package com.alikunduz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private MessageType messageType;

    // static olarak setlemek istenilen değer varsa burası kullanılır
    private String ofStatic;




    public String prepareErorMessage(){

        // ofStatic boş değilse messageType.getMessage() ile birleştirip döndürür
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if (this.ofStatic != null) {
            builder.append(this.ofStatic);
        }
        return builder.toString();
    }

}
