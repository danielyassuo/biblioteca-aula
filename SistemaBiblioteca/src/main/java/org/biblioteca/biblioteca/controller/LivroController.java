package org.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.biblioteca.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {
    List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio(Model model){
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model){
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastroLivro(@ModelAttribute Livro livro){
        livros.add(livro);
        int id = livros.size() - 1;
        return "redirect:/livros/confirmacao/" + id;
    }

    @GetMapping("/confirmacao/{id}")
    public String confirmacaoLivro(@PathVariable int id, Model model){
        model.addAttribute("livro", livros.get(id));
        return "livros/confirmacao";
    }

    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable int id, Model model){
        model.addAttribute("livro", livros.get(id));
        model.addAttribute("id", id);
        return "livros/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarLivro(@PathVariable int id, @ModelAttribute Livro livro){
        livros.set(id, livro);
        return "redirect:/livros";
    }

    @GetMapping("/deletar/{id}")
    public String deletarLivroPorIndice(@PathVariable int id) {
        livros.remove(id);
        return "redirect:/livros";
    }
}
