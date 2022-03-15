package com.proyectofinalweb.proyectofinalweb.repository;

import com.proyectofinalweb.proyectofinalweb.model.RegistroDeLaboreo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDeLaboreoRepository extends JpaRepository<RegistroDeLaboreo, Integer> {

    RegistroDeLaboreo findById(int id);

}
