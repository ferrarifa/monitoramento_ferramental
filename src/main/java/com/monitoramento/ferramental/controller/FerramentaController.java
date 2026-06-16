/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monitoramento.ferramental.controller;

import ch.qos.logback.core.model.Model;
import com.monitoramento.ferramental.model.FerramentaDTO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class FerramentaController {
    
    @Autowired
    FerramentaDTO d;
    
    @GetMapping("/")
    public String home(){
        return "index";
        
    }
    
    @GetMapping("/ferramentas")
    public String ferramenta(Model model){
        List<FerramentaDTO> lista = d.listaFerramenta();
        model.addAttribute("lista", lista);
        return "ferramentas";
           
        
    }
    
    @PostMapping("/ferramentas/salvar")
    public String ferramentasSalvar(){
        return "redirect:/ferramentas";
    }
    
}
