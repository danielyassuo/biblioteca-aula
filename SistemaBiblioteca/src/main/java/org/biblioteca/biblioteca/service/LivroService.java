package org.biblioteca.biblioteca.service;


import org.biblioteca.biblioteca.model.Autor;
import org.biblioteca.biblioteca.model.Livro;
import org.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro salvarLivro (Livro livro){
        return repository.save(livro);
    }

    public void deletaLivrorPorId (Long id) {
        repository.deleteById(id);
    }

    public List<Livro> listarLivro() {
        return repository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
