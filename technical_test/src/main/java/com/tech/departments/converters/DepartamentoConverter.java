package com.tech.departments.converters;

import com.tech.departments.Services.EmpleadoService;
import com.tech.departments.entities.Departamento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@RequestScoped
@Named("departamentoConverter")
public class DepartamentoConverter implements Converter<Departamento> {

    @Inject
    private EmpleadoService service;

    @Override
    public Departamento getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if (id == null) {
            return null;
        }
        Optional<Departamento> departamentoOptional = service.porIdDepartamentos(Long.valueOf(id));
        if (departamentoOptional.isPresent()) {
            return departamentoOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Departamento departamento) {
        if (departamento == null) {
            return "0";
        }
        return departamento.getId().toString();
    }
}
