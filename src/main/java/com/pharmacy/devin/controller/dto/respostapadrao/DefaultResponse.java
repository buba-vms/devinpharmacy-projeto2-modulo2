package com.pharmacy.devin.controller.dto.respostapadrao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse <T>{
    private int status;
    private String message;
    private T data;

    public DefaultResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
