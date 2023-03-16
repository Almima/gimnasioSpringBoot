package com.example.gimnasio.dao;

import com.example.gimnasio.entidades.Instructor;

import java.util.List;

public interface DaoInstructor {
    List <Instructor> getInstructores();

    void registraInstructor(Instructor instructor);

    void eliminaInstructor(int id);
}
