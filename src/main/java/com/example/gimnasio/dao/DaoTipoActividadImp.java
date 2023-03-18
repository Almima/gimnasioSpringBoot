package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Instructor;
import com.example.gimnasio.entidades.TipoActividad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class DaoTipoActividadImp implements DaoTipoActividad{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public <S extends TipoActividad> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TipoActividad> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TipoActividad> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TipoActividad> findAll() {
        return null;
    }

    @Override
    public Iterable<TipoActividad> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TipoActividad entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TipoActividad> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
