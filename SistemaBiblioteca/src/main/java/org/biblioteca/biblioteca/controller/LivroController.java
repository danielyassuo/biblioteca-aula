package org.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.biblioteca.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String inicio(){
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model){
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastroLivro(@ModelAttribute Livro livro, Model model){
        model.addAttribute("livro", livro);
        return "livros/confirmacao";
    }
}