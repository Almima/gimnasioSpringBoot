package com.example.gimnasio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendario_actividad_id", nullable = false)
    private CalendarioActividad calendarioActividad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CalendarioActividad getCalendarioActividad() {
        return calendarioActividad;
    }

    public void setCalendarioActividad(CalendarioActividad calendarioActividad) {
        this.calendarioActividad = calendarioActividad;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

}