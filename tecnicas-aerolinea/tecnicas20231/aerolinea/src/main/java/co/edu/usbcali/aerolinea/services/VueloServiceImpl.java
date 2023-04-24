package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.VueloDTO;

import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.dtos.VueloDTO;
import co.edu.usbcali.aerolinea.mapper.VueloMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.repository.VueloRepository;
import co.edu.usbcali.aerolinea.services.VueloService;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;

    private final AvionRepository avionRepository;
    private final ModelMapper modelMapper;
    public VueloServiceImpl(VueloRepository vueloRepository, AvionRepository avionRepository, ModelMapper modelMapper) {
        this.vueloRepository = vueloRepository;
        this.avionRepository = avionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<VueloDTO> obtenerVuelos() {
        return VueloMapper.modelToDTOList(vueloRepository.findAll());
    }
    @Override
    public VueloDTO guardarVuelo(VueloDTO vueloDTO) throws Exception {
        if (vueloDTO == null) {
            throw new Exception("El vuelo no puede ser nulo!");
        }
        if (vueloDTO.getPrecio() < 0) {
            throw new Exception("El precio del vuelo no puede ser negativo!");
        }
        /*if (vueloDTO.getIdVuelo() == null) {
            throw new Exception("El id del vuelo es invalido!");
        }*/
        if (vueloDTO.getFechaHoraSalida() == null) {
            throw new Exception("La hora de salida es invalida!");
        }
        if (vueloDTO.getFechaHoraLlegada() == null) {
            throw new Exception("La hora de llegada es invalida!");
        }
        if (vueloDTO.getPrecioAsientoBasico() < 0) {
            throw new Exception("El precio del asiento preferencial no puede ser negativo!");
        }
        if (vueloDTO.getPrecioAsientoVip() < 0) {
            throw new Exception("El precio del asiento vip no puede ser negativo!");
        }
        if (vueloDTO.getPrecioAsientoNormal() < 0) {
            throw new Exception("El precio del asiento turista no puede ser negativo!");
        }
        if (vueloDTO.getEstado() == null || vueloDTO.getEstado().isBlank() || vueloDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del vuelo es invalido!");
        }
        if(vueloDTO.getIdVuelo() != null){
            if(vueloRepository.findById(vueloDTO.getIdVuelo()).isPresent()){
                throw new Exception("Ya existe el id del vuelo!");
            }
        }
        Avion avion = avionRepository.findById(vueloDTO.getAvion().getIdAvion()).get();
        Vuelo vuelo = VueloMapper.dtoToModel(vueloDTO);
        vuelo.setAvion(avion);
        return VueloMapper.modelToDTO(vueloRepository.save(vuelo));
    }

    @Override
    public VueloDTO obtenerVuelo(Integer id) throws Exception {
        if (vueloRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun vuelo!");
        }
        return VueloMapper.modelToDTO(vueloRepository.findById(id).get());
    }


}



