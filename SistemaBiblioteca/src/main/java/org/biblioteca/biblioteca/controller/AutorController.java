package org.biblioteca.biblioteca.controller;

import org.biblioteca.biblioteca.model.Autor;
import org.biblioteca.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", service.listarAutor());
        return "autores/inicio";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping
    public String cadastroAutor(@ModelAttribute Autor autor) {
        Autor salvo = service.salvarAutor(autor);
        return "redirect:/autores/confirmacao/" + salvo.getId();
    }

    @GetMapping("/confirmacao/{id}")
    public String confirmacaoAutor(@PathVariable Long id, Model model) {
        model.addAttribute("autor", service.buscarAutorPorId(id));
        return "autores/confirmacao";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAutor(@PathVariable Long id) {
        service.deletaAutorPorId(id);
        return "redirect:/autores";
    }
}
