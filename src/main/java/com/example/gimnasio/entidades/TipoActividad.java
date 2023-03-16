package com.example.gimnasio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_actividad")
public class TipoActividad {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre_actividad", nullable = false, length = 50)
    private String nombreActividad;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}