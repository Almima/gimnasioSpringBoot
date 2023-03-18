package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Instructor;
import com.example.gimnasio.entidades.TipoActividad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoTipoActividad extends CrudRepository<TipoActividad, Long> {
}
