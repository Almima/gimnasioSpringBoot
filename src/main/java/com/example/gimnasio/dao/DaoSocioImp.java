package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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
    @Override
    public Socio obtenerSocioPorCredenciales(Socio socio) {
        String query = "FROM Socio WHERE email = :email";
        List<Socio> lista = entityManager.createQuery(query)
                .setParameter("email", socio.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).clave();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, socio.clave())) {
            return lista.get(0);
        }
        return null;
    }
}
