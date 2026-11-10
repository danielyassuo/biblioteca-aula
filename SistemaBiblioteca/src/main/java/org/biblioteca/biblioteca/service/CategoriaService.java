package org.biblioteca.biblioteca.service;


import org.biblioteca.biblioteca.model.Categoria;
import org.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria salvarCategoria (Categoria categoria){
        return repository.save(categoria);
    }

    public void deletaCategoriaPorId (Long id) {
        repository.deleteById(id);
    }

    public List<Categoria> listarCategorias () {
        return repository.findAll();
    }






}
