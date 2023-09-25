package com.tech.departments.repositories.Impl;


import com.tech.departments.repositories.CrudRepository;
import com.tech.departments.entities.Departamento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@RequestScoped
public class DepartamentoRepositoryImpl implements CrudRepository<Departamento> {

    @Inject
    private EntityManager em;


    @Override
    public List<Departamento> listar() {
        TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
        return query.getResultList();
    }

    @Override
    public Departamento porId(Long id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public void guardar(Departamento departamento) {
        if (departamento.getId() != null && departamento.getId() > 0) {
            em.merge(departamento);
        } else {
            em.persist(departamento);
        }
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
