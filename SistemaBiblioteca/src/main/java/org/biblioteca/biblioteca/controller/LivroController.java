package org.biblioteca.biblioteca.controller;

import org.biblioteca.biblioteca.model.Livro;
import org.biblioteca.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public String inicio(Model model){
        model.addAttribute("livros", service.listarLivro());
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model){
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastroLivro(@ModelAttribute Livro livro){
        Livro salvo = service.salvarLivro(livro);
        return "redirect:/livros/confirmacao/" + salvo.getId();
    }

    @GetMapping("/confirmacao/{id}")
    public String confirmacaoLivro(@PathVariable Long id, Model model){
        model.addAttribute("livro", service.buscarLivroPorId(id));
        return "livros/confirmacao";
    }

    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model){
        model.addAttribute("livro", service.buscarLivroPorId(id));
        model.addAttribute("id", id);
        return "livros/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livro){
        livro.setId(id);
        service.salvarLivro(livro);
        return "redirect:/livros";
    }

    @GetMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id) {
        service.deletaLivrorPorId(id);
        return "redirect:/livros";
    }
}
