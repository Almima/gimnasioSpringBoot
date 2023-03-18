package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoTipoActividad;
import com.example.gimnasio.entidades.TipoActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ActividadController {
    @Autowired
    private DaoTipoActividad daoTipoActividad;

    @RequestMapping(value = "api/getActividadId/{id}")
    public Optional<TipoActividad> getActividadId(@PathVariable Long id){
        return daoTipoActividad.findById(id);
    }
}
