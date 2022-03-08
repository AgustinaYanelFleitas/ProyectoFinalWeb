package com.proyectofinalweb.proyectofinalweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Validated
@Data
public class EstadoDeCampoDTO {

    @JsonIgnore
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "La descrpcion no puede ser Nula")
    @Size(min = 2, message = "La descripcion debe tener al menos dos caracteres")
    private String descripcion;


}
