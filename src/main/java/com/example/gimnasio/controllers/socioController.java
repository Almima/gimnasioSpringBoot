package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoSocio;
import com.example.gimnasio.entidades.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class socioController {
    @Autowired
    private DaoSocio daoSocio;

    @RequestMapping(value = "api/getUsuarios", method = RequestMethod.GET)
    public List <Socio> getSocio() {return daoSocio.getSocio();};

    @RequestMapping(value = "api/registraSocio", method = RequestMethod.POST)
    public void registraSocio(@RequestBody Socio socio){
        daoSocio.registrarSocio(socio);
    }
    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id){
        daoSocio.eliminarSocio(id);
    }
}
