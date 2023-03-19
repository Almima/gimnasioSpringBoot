package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoSocio;
import com.example.gimnasio.entidades.Socio;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, socio.getClave().getBytes());
        socio.setClave(hash);
        daoSocio.registrarSocio(socio);
    }
    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarSocio(@PathVariable int id){
        daoSocio.eliminarSocio(id);
    }

}
