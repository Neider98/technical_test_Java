package com.tech.departments.Services;


import com.tech.departments.entities.Departamento;
import com.tech.departments.entities.Empleado;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface EmpleadoService {

    List<Empleado> listar();
    Optional<Empleado> porId(Long id);
    void guardar(Empleado empleado);
    void eliminar(Long id);
    List<Departamento> listarDepartamentos();
    Optional<Departamento> porIdDepartamentos(Long id);

}
