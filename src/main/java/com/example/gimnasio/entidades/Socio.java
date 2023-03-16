package com.example.gimnasio.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Setter
@Getter
@Entity
@Table(name = "socio")
public class Socio {
    @Id
    @SequenceGenerator(name="SOCIO_ID_GENERATOR", sequenceName="SEQ_SOCIO_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOCIO_ID_GENERATOR")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Setter @Getter @Column(name = "codbarras", length = 7)
    private String codbarras;

    @Setter @Getter @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Setter @Getter @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Setter @Getter @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Setter @Getter @Column(name = "telefono", nullable = false, length = 13)
    private String telefono;

    @Setter @Getter @Column(name = "clave", nullable = false, length = 32)
    private String clave;

    @Setter @Getter @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;
    @Setter @Getter @Column(name = "estado_alta", nullable = false)
    private Boolean estadoAlta = false;


}