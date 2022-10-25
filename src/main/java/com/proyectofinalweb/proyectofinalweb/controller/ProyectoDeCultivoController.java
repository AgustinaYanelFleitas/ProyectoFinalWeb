package com.proyectofinalweb.proyectofinalweb.controller;

import com.proyectofinalweb.proyectofinalweb.service.crud.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProyectoDeCultivoController {

    private static final Logger logger = LoggerFactory.getLogger(LoteController.class);
    public static final String RESOURCE = "/api/v1/proyectosDeCultivos";

    public static final String PROYECTOS_CULTIVOS_ID = "/{proyectoCultivos_id}";
    public static final String SEARCH = "/search";


    private IProyectoDeCultivoService proyectoDeCultivoService;

    private IEstadoProyectosService estadoProyectosService;

    private ILoteService loteService;

    private IRegistroDeLaboreoService registroDeLaboreoService;

    private ICultivoService cultivoService;



    }


