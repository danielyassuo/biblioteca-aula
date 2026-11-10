package org.biblioteca.biblioteca.service;


import org.biblioteca.biblioteca.model.Autor;
import org.biblioteca.biblioteca.model.Categoria;
import org.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor salvarAutor (Autor autor){
        return repository.save(autor);
    }

    public void deletaAutorPorId (Long id) {
        repository.deleteById(id);
    }

    public List<Autor> listarAutor() {
        return repository.findAll();
    }

    public Autor buscarAutorPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


}
