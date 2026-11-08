package org.biblioteca.biblioteca.controller;

import org.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", autores);
        return "autores/inicio";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping
    public String cadastroAutor(@ModelAttribute Autor autor) {
        autores.add(autor);
        int id = autores.size() - 1;
        return "redirect:/autores/confirmacao/" + id;
    }

    @GetMapping("/confirmacao/{id}")
    public String confirmacaoAutor(@PathVariable int id, Model model) {
        model.addAttribute("autor", autores.get(id));
        return "autores/confirmacao";
    }
}
