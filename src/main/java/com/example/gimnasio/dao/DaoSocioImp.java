package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class DaoSocioImp implements DaoSocio {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Socio> getSocio() {
        String query = "FROM Socio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarSocio(int id) {
        Socio socio = entityManager.find(Socio.class, id);
        entityManager.remove(socio);
    }

    @Override
    public void registrarSocio(@RequestBody Socio socio) {
        socio.setFechaAlta(LocalDate.now());
        socio.setEstadoAlta(true);
        entityManager.merge(socio);
    }

    @Override
    public void modificaSocio(Socio socio) {
        entityManager.merge(socio);
    }
}
