package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Socio;

import java.util.List;

public interface DaoSocio {
    List <Socio> getSocio();
    void eliminarSocio(int id);

    void registrarSocio(Socio socio);
    void modificaSocio(Socio socio);
}
