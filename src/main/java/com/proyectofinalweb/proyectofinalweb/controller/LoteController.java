package com.proyectofinalweb.proyectofinalweb.controller;


import com.proyectofinalweb.proyectofinalweb.dto.LoteDTO;
import com.proyectofinalweb.proyectofinalweb.dto.request.LoteRequestDTO;
import com.proyectofinalweb.proyectofinalweb.service.crud.ICampoService;
import com.proyectofinalweb.proyectofinalweb.service.crud.ILoteService;
import com.proyectofinalweb.proyectofinalweb.service.crud.IRegistroDeLaboreoService;
import com.proyectofinalweb.proyectofinalweb.service.crud.ITipoDeSueloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LoteController.RESOURCE)
public class LoteController {
    private static final Logger logger = LoggerFactory.getLogger(LoteController.class);
    public static final String RESOURCE = "/api/v1/lotes";

    public static final String LOTE_ID = "/{lote_id}";
    public static final String SEARCH = "/search";

    private ICampoService campoService;

    private ILoteService loteService;

    private ITipoDeSueloService tipoDeSueloService;



    public LoteController(ICampoService campoService, ILoteService loteService, ITipoDeSueloService tipoDeSueloService) {
        this.campoService = campoService;
        this.loteService = loteService;
        this.tipoDeSueloService = tipoDeSueloService;
    }

/* @RequestMapping(value = DNI, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CampoDTO> getOneCampo(@PathVariable("campo_id") String campoID) {
        logger.info("Buscar un campo por id {}", campoID);
        EmpleadoDTO empleado = this.campoService.buscarEmpleadoPorDNI(campoID);
        if (empleado == null) {
            return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmpleadoDTO>(empleado, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<EmpleadoDTO>> getEmpleados(){
        logger.info("Get All Hotels");
        Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
        empleados.addAll(this.campoService.listarTodos());
        if (empleados.isEmpty()){
            return new ResponseEntity<Collection<EmpleadoDTO>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Collection<EmpleadoDTO>>(empleados, HttpStatus.OK);
        }
    }*/



    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity<LoteDTO> create(@RequestBody LoteRequestDTO loteRequestDTO) {
        LoteDTO loteRespuesta = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "LoteController");

        try {

            if (campoService.buscarCampoPorNumero(loteRequestDTO.getNumeroCampo())!=null){

                logger.info("verificación: El campo existe {}", loteRequestDTO.getNumeroCampo());

                if (tipoDeSueloService.buscarTipoDeSueloPorDescripcion(loteRequestDTO.getTipoDeSuelo()) !=null){
                    logger.info("verificación: El tipo de suelo existe {}", loteRequestDTO.getTipoDeSuelo());

                    LoteDTO nuevoLote = new  LoteDTO();
                    nuevoLote.setNumeroLote(loteRequestDTO.getNumeroLote());
                    logger.info("setea el numero de lote {}", loteRequestDTO.getNumeroLote());
                    nuevoLote.setSuperficie(loteRequestDTO.getSuperficie());
                    nuevoLote.setCampo(campoService.buscarCampoPorNumero(loteRequestDTO.getNumeroCampo()));
                    nuevoLote.setTipoDeSuelo(tipoDeSueloService.buscarTipoDeSueloPorDescripcion(loteRequestDTO.getTipoDeSuelo()));

                    if (!loteService.verificarNumeroLote(nuevoLote, campoService.buscarCampoPorNumero(loteRequestDTO.getNumeroCampo()))){
                        logger.info("verificación: El numero de lote no existe {}", loteRequestDTO.getNumeroLote());
                        loteRespuesta = loteService.registrar(nuevoLote);
                        logger.info("algo {}", loteRequestDTO.getNumeroLote());
                    }
                }
            }

        } catch(Exception ex) {
            logger.info("error: El campo ya existe {}", loteRequestDTO.getNumeroCampo());
            return ResponseEntity.ok().headers(headers).body(loteRespuesta);
        }

        return ResponseEntity.ok().headers(headers).body(loteRespuesta);
    }

}