package com.example.gimnasio.controllers;

import com.example.gimnasio.dao.DaoSocio;
import com.example.gimnasio.entidades.Socio;
import com.example.gimnasio.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    private DaoSocio daosocio;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Socio socio) {

        Socio socioLogueado = DaoSocio.obtenerSocioPorCredenciales(socio);
        if (socioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(socioLogueado.getId()), socioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
}
