package com.proyectofinalweb.proyectofinalweb.service.crud;


import com.proyectofinalweb.proyectofinalweb.dto.RegistroDeLaboreoDTO;

public interface IRegistroDeLaboreoService extends ICRUD<RegistroDeLaboreoDTO>{

    RegistroDeLaboreoDTO findById(int registro_id);

}