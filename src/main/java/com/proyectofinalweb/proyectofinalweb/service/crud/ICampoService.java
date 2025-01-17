package com.proyectofinalweb.proyectofinalweb.service.crud;


import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;

public interface ICampoService extends ICRUD<EmpleadoDTO>{

    EmpleadoDTO buscarEmpleadoPorDNI(String dni);

    EmpleadoDTO findById(int empleado_id);

    EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO);
}
