/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monitoramento.ferramental.service;

import com.monitoramento.ferramental.model.FerramentaDTO;
import com.monitoramento.ferramental.repository.FerramentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class FerramentaService {
    
    @Autowired
    private FerramentaRepository repository;
    
    public List<FerramentaDTO> listaFerramenta (){
        return repository.listaFerramenta();
    }
    
    public void criar(FerramentaDTO f){
        if(f.getNome().equals("")){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Nome não preenchido!");
        }
        
        if(f.getVidaUtilMaxima() <= 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Vida util invalida");
        }
        if(f.getHorasUso() < 0){
            f.setHorasUso(0);
            
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Horas de uso não preenchido!");
        }
        int linhas = repository.update(f);
        if(linhas == 0){
           throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao adicionar no Banco de dados");
        }
    }
    
    
    
}
