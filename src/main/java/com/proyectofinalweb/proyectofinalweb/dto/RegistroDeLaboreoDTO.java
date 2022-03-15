package com.proyectofinalweb.proyectofinalweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.util.List;

@Validated
@Data
public class RegistroDeLaboreoDTO {

    @JsonIgnore
    private Integer id;

    @JoinColumn(name = "id_proyecto_de_cultivo_fk")
    private ProyectoDeCultivoDTO proyectoDeCultivo;

    private LocalDate inicioRegistro;

    private LocalDate finalizacionRegistro;

    private LaboreoDTO laboreos;

}
