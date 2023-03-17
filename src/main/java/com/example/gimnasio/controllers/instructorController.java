package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoInstructor;
import com.example.gimnasio.dao.DaoTipoActividad;
import com.example.gimnasio.entidades.Instructor;
import com.example.gimnasio.entidades.TipoActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class instructorController {
    @Autowired
    private DaoTipoActividad daoTipoActividad;
    @Autowired
    private DaoInstructor daoInstructor;
    @RequestMapping(value = "api/getInstructores", method = RequestMethod.GET)
    public List <Instructor> getInstructores() {return daoInstructor.getInstructores();};

    @RequestMapping(value = "api/registraInstructor", method = RequestMethod.POST)
    public void registraInstructor(@RequestBody Instructor instructor){
        daoInstructor.registraInstructor(instructor);
    }
    @RequestMapping(value ="api/instructor/{id}", method = RequestMethod.DELETE)
    public void eliminarInstructor(@PathVariable int id){
        daoInstructor.eliminaInstructor(id);
    }
}
