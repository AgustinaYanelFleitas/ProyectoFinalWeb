package com.proyectofinalweb.proyectofinalweb.repository;


import com.proyectofinalweb.proyectofinalweb.model.Lote;
import com.proyectofinalweb.proyectofinalweb.model.ProyectoDeCultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyectoDeCultivoRepository extends JpaRepository<ProyectoDeCultivo, Integer> {


    ProyectoDeCultivo findById(int id);

    @Query("SELECT pc FROM ProyectosCultivos pc WHERE pc.id_lote_fk = :lote ")
    List<ProyectoDeCultivo> findProyectoDeCultivoByLote(@Param("lote") String lote);

}
