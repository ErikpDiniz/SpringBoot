package com.example.Meu_Primeiro_Spring_Boot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Meu_Primeiro_Spring_Boot.Service.MensagemService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        return mensagemService.obterMensagem();
    }
    

}
