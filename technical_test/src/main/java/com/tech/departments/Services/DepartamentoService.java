package com.tech.departments.Services;


import com.tech.departments.entities.Departamento;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface DepartamentoService {

    List<Departamento> listar();
    Optional<Departamento> porId(Long id);
    void guardar(Departamento departamento);
    void eliminar(Long id);


}