package com.tech.departments.controllers;


import com.tech.departments.Services.EmpleadoService;
import com.tech.departments.entities.Departamento;
import com.tech.departments.entities.Empleado;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import lombok.Data;

import java.util.List;

@Data
@Model
public class EmpleadoController {

    private Long id;

    private Empleado empleado;

    private List<Empleado> listadoEmpleados;

    @Inject
    private EmpleadoService service;

    @PostConstruct
    public void init(){
        empleado = new Empleado();
        listadoEmpleados = service.listar();
    }

    @Produces
    @Model
    public String tittle() {
        return "Modulo Empleados";
    }

    @Produces
    @Model
    public List<Departamento> listadoDepartamentos() {
        return service.listarDepartamentos();
    }

    public void guardarEmpleado() {
        service.guardar(empleado);
        listadoEmpleados = service.listar();
    }

    public void editarEmpleado(Long id) {
        this.id = id;
    }


    public void borrarEmpleado(Long empleadoId) {
        service.eliminar(empleadoId);
        listadoEmpleados = service.listar();
    }

}
