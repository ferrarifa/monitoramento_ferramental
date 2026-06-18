/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monitoramento.ferramental.controller;

import com.monitoramento.ferramental.model.FerramentaDTO;
import com.monitoramento.ferramental.service.FerramentaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class FerramentaController {

    @Autowired
    private FerramentaService service;

    @GetMapping("/")
    public String index() {
        return "redirect://ferramentas";

    }

    @GetMapping("/ferramentas")
    public String listarFerramentas(Model model) {
        List<FerramentaDTO> lista = service.listaFerramenta();
        model.addAttribute("ferramentas", lista);

        return "ferramentas";

    }

    @PostMapping("/ferramentas/salvar")
    public String ferramentasSalvar() {
        return "redirect:/ferramentas";
    }

}
