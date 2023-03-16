package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Instructor;
import com.example.gimnasio.entidades.TipoActividad;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class DaoIntructorImp implements DaoInstructor{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Instructor> getInstructores() {
        String query = "FROM Instructor";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registraInstructor(@RequestBody Instructor instructor) {
        TipoActividad tipoActividad = TipoActividad.getId();
        instructor.setTipoActividad(tipoActividad);
        entityManager.merge(instructor);
    }

    @Override
    public void eliminaInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);

    }
}
