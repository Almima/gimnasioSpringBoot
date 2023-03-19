package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoSocio;
import com.example.gimnasio.entidades.Socio;
import com.example.gimnasio.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class socioController {
    @Autowired
    private DaoSocio daoSocio;
    @Autowired
    private JWTUtil jwtUtil;
    private boolean validarToken(String token){
        String socio_id=jwtUtil.getKey(token);
        return socio_id!=null;
    }
    @RequestMapping(value = "api/getUsuarios", method = RequestMethod.GET)
    public List <Socio> getSocio() {return daoSocio.getSocio();};
    @RequestMapping(value = "api/getUsuarios", method = RequestMethod.GET)
    public List<Socio> getSocio(@RequestHeader(value="Authorization") String token){
        // Si devuelves null generas un problema en el front porque espera una lista
        if (!validarToken(token)) return new ArrayList<>();
        return daoSocio.getSocio();
    }
    @RequestMapping(value = "api/registraSocio", method = RequestMethod.POST)
    public void registraSocio(@RequestBody Socio socio){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1, socio.clave());
        socio.clave(hash);
        daoSocio.registrarSocio(socio);
    }
    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarSocio (@RequestHeader(value="Authorization") String token,
                               @PathVariable int id){
        daoSocio.eliminarSocio(id);
    }

}
