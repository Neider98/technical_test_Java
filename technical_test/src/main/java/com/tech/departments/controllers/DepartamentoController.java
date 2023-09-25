package com.tech.departments.controllers;

import com.tech.departments.Services.DepartamentoService;
import com.tech.departments.entities.Departamento;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import lombok.Data;

import java.util.List;


@Data
@Model
public class DepartamentoController {

    private Long id;

    private Departamento departamento;

    private List<Departamento> listado;

    @Inject
    private DepartamentoService service;
    @PostConstruct
    public void init() {
        departamento = new Departamento();
        this.listado = service.listar();
    }

    public void guardar() {
        service.guardar(departamento);
        listado = service.listar();
    }

    public void editarDepartamento(Long id) {
        this.id = id;
    }

    public void borrarDepartamento(Long departamentoId) {
        service.eliminar(departamentoId);
        listado = service.listar();
    }
}
