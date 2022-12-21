package com.pharmacy.devin.controller.dto.respostapadrao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorResponse {
    private int status;
    private String message;
    private Throwable cause;
    private Exception error;


}
