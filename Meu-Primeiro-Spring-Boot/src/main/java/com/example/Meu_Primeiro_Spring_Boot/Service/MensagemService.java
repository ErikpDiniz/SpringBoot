package com.example.Meu_Primeiro_Spring_Boot.Service;

import org.springframework.stereotype.Service;

import com.example.Meu_Primeiro_Spring_Boot.repository.MensagemRepository;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem () {
        return mensagemRepository.obterMensagem();
    }

}