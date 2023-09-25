package com.tech.departments.Services.Impl;


import com.tech.departments.Services.DepartamentoService;
import com.tech.departments.entities.Departamento;
import com.tech.departments.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class DepartamentoServiceImpl implements DepartamentoService {

    @Inject
    private CrudRepository<Departamento> repository;


    @Override
    public List<Departamento> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Departamento> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Departamento departamento) {
        repository.guardar(departamento);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
