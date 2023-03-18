package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoTipoActividad;
import com.example.gimnasio.entidades.Instructor;
import com.example.gimnasio.entidades.TipoActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ActividadController {
    @Autowired
    private DaoTipoActividad daoTipoActividad;

    @RequestMapping(value = "api/getActividadById/{id}")
    public Optional<TipoActividad> getActividadById(@PathVariable Long id){
        return daoTipoActividad.findById(id);
    }

    @RequestMapping(value = "api/getActividades")
    public Iterable<TipoActividad> getActividades(){
        return daoTipoActividad.findAll();
    }
    @RequestMapping(value = "api/registraActividad", method = RequestMethod.POST)
    public void registraActividad(@RequestBody TipoActividad tipoActividad){
    }
    @RequestMapping(value = "api/eliminaActividadById/{id}", method = RequestMethod.DELETE)
    public void  eliminaActividadById(Long id){
        daoTipoActividad.deleteById(id);
    }
}
