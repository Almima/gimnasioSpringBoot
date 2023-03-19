package com.example.gimnasio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "tipo_actividad")
public class TipoActividad {
    @Id
    @SequenceGenerator(name="ACTIVIDAD_ID_GENERATOR", sequenceName="seq_tipo_actividad_id",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVIDAD_ID_GENERATOR")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_actividad", nullable = false, length = 50)
    private String nombreActividad;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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