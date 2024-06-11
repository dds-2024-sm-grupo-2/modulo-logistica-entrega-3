package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.facades.dtos.EstadoTrasladoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class Traslado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String qrVianda;
    @Transient
    private final Ruta ruta;
    private EstadoTrasladoEnum estado;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaTraslado;
    private final Long collaboratorId;

    public Traslado(String qrVianda, Ruta ruta, EstadoTrasladoEnum estado, LocalDateTime fechaTraslado) {
        this.qrVianda = qrVianda;
        this.ruta = ruta;
        this.estado = estado;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaTraslado = fechaTraslado;
        this.collaboratorId = ruta.getColaboradorId();
    }

}