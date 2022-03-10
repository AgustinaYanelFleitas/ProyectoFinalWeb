package com.proyectofinalweb.proyectofinalweb.controller;

import com.proyectofinalweb.proyectofinalweb.dto.CampoDTO;
import com.proyectofinalweb.proyectofinalweb.service.crud.ICampoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CampoController.RESOURCE)
public class CampoController {


    private static final Logger logger = LoggerFactory.getLogger(CampoController.class);
    public static final String RESOURCE = "/api/v1/campos";

    public static final String DNI = "/{empleado_dni}";

    public static final String DNI = "/{campo_id}";

    public static final String SEARCH = "/search";

    private ICampoService campoService;

    public CampoController(ICampoService campoService) {
        this.campoService = campoService;
    }

  @RequestMapping(value = DNI, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CampoDTO> getOneCampo(@PathVariable("numero_campo") String numeroCampo) {
        logger.info("Buscar un empleado por dni {}", numeroCampo);
        CampoDTO campo = this.campoService.bucarCampoPorNumero(numeroCampo);
        if (campo == null) {
            return new ResponseEntity<CampoDTO>(HttpStatus.NOT_FOUND);
          
   /* @RequestMapping(value = DNI, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CampoDTO> getOneCampo(@PathVariable("campo_id") String campoID) {
        logger.info("Buscar un campo por id {}", campoID);
        EmpleadoDTO empleado = this.campoService.buscarEmpleadoPorDNI(campoID);
        if (empleado == null) {
            return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmpleadoDTO>(empleado, HttpStatus.OK);
    }

    public ResponseEntity<Collection<EmpleadoDTO>> getEmpleados(){
        logger.info("Get All Hotels");
        Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
        empleados.addAll(this.campoService.listarTodos());
        if (empleados.isEmpty()){
            return new ResponseEntity<Collection<EmpleadoDTO>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Collection<EmpleadoDTO>>(empleados, HttpStatus.OK);
        }
    }
*/

    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity<CampoDTO> create(@RequestBody CampoDTO nuevoCampo) {
        CampoDTO campoRespuesta = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "EmpleadoController");
        headers.add("Responded", "CampoController");

        try {
            if (campoService.buscarCampoPorNumero(nuevoCampo.getNumeroCampo())==null){

                campoRespuesta = campoService.registrar(nuevoCampo);

            }

        } catch(Exception ex) {

            System.out.println("Employee not found" + ex.getMessage());

        headers.add("Responded", "CampoController");

        try {
            if (campoService.buscarCampoPorNumero(nuevoCampo.getNumeroCampo())==null){

                campoRespuesta = campoService.registrar(nuevoCampo);
            }

        } catch(Exception ex) {
            logger.info("El campo ya existe {}", nuevoCampo.getNumeroCampo());
            return ResponseEntity.ok().headers(headers).body(campoRespuesta);
        }

        return ResponseEntity.ok().headers(headers).body(campoRespuesta);
    }

}