package com.example.gimnasio.entidades;

import javax.persistence.*;

@Entity
@Table(name = "calendario_actividad")
public class CalendarioActividad {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendario_fecha_id", nullable = false)
    private CalendarioFecha calendarioFecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "calendario_hora_id", nullable = false)
    private CalendarioHora calendarioHora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_actividad_id", nullable = false)
    private TipoActividad tipoActividad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CalendarioFecha getCalendarioFecha() {
        return calendarioFecha;
    }

    public void setCalendarioFecha(CalendarioFecha calendarioFecha) {
        this.calendarioFecha = calendarioFecha;
    }

    public CalendarioHora getCalendarioHora() {
        return calendarioHora;
    }

    public void setCalendarioHora(CalendarioHora calendarioHora) {
        this.calendarioHora = calendarioHora;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}