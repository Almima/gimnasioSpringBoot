package com.example.gimnasio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "instructor")
public class Instructor {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="INSTRUCTOR_ID_GENERATOR", sequenceName="seq_instructor_id",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTOR_ID_GENERATOR")
    @Column(name = "instructor_id", nullable = false)
    private Integer id;

    @Column(name = "nombre_instructor", nullable = false, length = 50)
    private String nombreInstructor;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_actividad_id", nullable = false)
    private TipoActividad tipoActividad;
}
