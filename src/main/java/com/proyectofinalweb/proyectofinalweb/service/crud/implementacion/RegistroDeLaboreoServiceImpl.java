package com.proyectofinalweb.proyectofinalweb.service.crud.implementacion;



import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;
import com.proyectofinalweb.proyectofinalweb.dto.LoteDTO;
import com.proyectofinalweb.proyectofinalweb.dto.RegistroDeLaboreoDTO;
import com.proyectofinalweb.proyectofinalweb.model.Empleado;
import com.proyectofinalweb.proyectofinalweb.model.Lote;
import com.proyectofinalweb.proyectofinalweb.model.RegistroDeLaboreo;
import com.proyectofinalweb.proyectofinalweb.repository.LaboreoRepository;
import com.proyectofinalweb.proyectofinalweb.repository.RegistroDeLaboreoRepository;
import com.proyectofinalweb.proyectofinalweb.service.crud.IRegistroDeLaboreoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class RegistroDeLaboreoServiceImpl implements IRegistroDeLaboreoService {

    public RegistroDeLaboreoRepository registroDeLaboreoRepository;
    public List<LaboreoRepository> laboreoRepository;

    private ModelMapper modelMapper;

    public RegistroDeLaboreoServiceImpl(RegistroDeLaboreoRepository registroDeLaboreoRepository, List<LaboreoRepository> laboreoRepository, ModelMapper modelMapper) {
        this.registroDeLaboreoRepository = registroDeLaboreoRepository;
        this.laboreoRepository = laboreoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RegistroDeLaboreoDTO registrar(RegistroDeLaboreoDTO registroDeLaboreoDTO) {
        System.out.println("llega al principio");
        RegistroDeLaboreo nuevoRegistro = modelMapper.map(registroDeLaboreoDTO, RegistroDeLaboreo.class);
        System.out.println("convierte a modelo");
        registroDeLaboreoRepository.save(nuevoRegistro);
        System.out.println("guarda");
        registroDeLaboreoDTO.setId(nuevoRegistro.getId());
        System.out.println("setea id");
        return modelMapper.map(nuevoRegistro, RegistroDeLaboreoDTO.class);
    }

    @Override
    public RegistroDeLaboreoDTO modificar(RegistroDeLaboreoDTO registroDeLaboreoDTO) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public RegistroDeLaboreoDTO listarId(Integer id) {
        return null;
    }

    @Override
    public List<RegistroDeLaboreoDTO> listarTodos() {
        return null;
    }

    @Override
    public RegistroDeLaboreoDTO findById(int registro_id) {
            RegistroDeLaboreo registro = registroDeLaboreoRepository.findById(registro_id);
            if(registro == null) {
                throw new NoSuchElementException("no existe el registro : " + registro_id);
            }
            return modelMapper.map(registro, com.proyectofinalweb.proyectofinalweb.dto.RegistroDeLaboreoDTO.class);
    }
}