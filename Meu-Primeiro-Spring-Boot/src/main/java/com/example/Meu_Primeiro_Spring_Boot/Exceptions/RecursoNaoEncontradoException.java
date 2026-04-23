package com.example.Meu_Primeiro_Spring_Boot.Exceptions;


public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException (String mensagem) {
        super(mensagem);
    }

}
