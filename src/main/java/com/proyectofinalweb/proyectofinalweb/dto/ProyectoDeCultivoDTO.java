package com.proyectofinalweb.proyectofinalweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectofinalweb.proyectofinalweb.model.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@Data
public class ProyectoDeCultivoDTO {

    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_lote_fk")
    private Lote lote;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El numeroProyecto no puede ser Nulo")
    @Size(min = 2, message = "El numeroProyecto debe tener al menos dos caracteres")
    private String numeroProyecto;

    @ManyToOne
    private Cultivo cultivo;

    @ManyToOne
    private EstadoDeProyecto estadoDeProyecto;

    @OneToMany(mappedBy = "proyectoDeCultivo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RegistroDeLaboreo> registroDeLaboreos;


}
