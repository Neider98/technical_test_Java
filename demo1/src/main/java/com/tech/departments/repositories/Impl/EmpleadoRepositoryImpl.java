package com.tech.departments.repositories.Impl;

import com.tech.departments.repositories.CrudRepository;
import com.tech.departments.entities.Empleado;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class EmpleadoRepositoryImpl implements CrudRepository<Empleado> {

    @Inject
    private EntityManager em;


    @Override
    public List<Empleado> listar() {
        return em.createQuery("select e from Empleado e left outer join fetch e.departamento", Empleado.class).getResultList();
    }

    @Override
    public Empleado porId(Long id) {
        return em.createQuery("select e from Empleado e left outer join fetch e.departamento where e.id=:id", Empleado.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void guardar(Empleado empleado) {
        if (empleado.getId() != null && empleado.getId() > 0) {
            em.merge(empleado);
        } else {
            em.persist(empleado);
        }
    }

    @Override
    public void eliminar(Long id) {
        Empleado empleado = porId(id);
        em.remove(empleado);
    }
}
