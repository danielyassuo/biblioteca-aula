package org.biblioteca.biblioteca.controller;

import org.biblioteca.biblioteca.model.Categoria;
import org.biblioteca.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categorias", service.listarCategorias());
        return "categorias/inicio";
    }

    @GetMapping("/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute Categoria categoria) {
        service.salvarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id) {
        service.deletaCategoriaPorId(id);
        return "redirect:/categorias";
    }
}
