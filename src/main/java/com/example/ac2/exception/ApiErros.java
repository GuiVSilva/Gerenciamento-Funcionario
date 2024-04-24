package com.example.ac2.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErros {
    @Getter
    private List<String> erros;

    public ApiErros(String msgErro){
        erros = Arrays.asList(msgErro);
    }
}
