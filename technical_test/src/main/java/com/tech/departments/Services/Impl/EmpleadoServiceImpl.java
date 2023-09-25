package com.tech.departments.Services.Impl;


import com.tech.departments.Services.EmpleadoService;
import com.tech.departments.entities.Departamento;
import com.tech.departments.entities.Empleado;
import com.tech.departments.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService {

    @Inject
    private CrudRepository<Empleado> repository;

    @Inject
    private CrudRepository<Departamento> departamentoRepository;


    @Override
    public List<Empleado> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Empleado> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Empleado empleado) {
        repository.guardar(empleado);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.listar();
    }

    @Override
    public Optional<Departamento> porIdDepartamentos(Long id) {
        return Optional.ofNullable(departamentoRepository.porId(id));
    }
}
