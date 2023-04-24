package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.Asiento;
import co.edu.usbcali.aerolinea.dtos.AsientoDTO;
import co.edu.usbcali.aerolinea.mapper.AsientoMapper;
import co.edu.usbcali.aerolinea.repository.AsientoRepository;




import co.edu.usbcali.aerolinea.model.Asiento;
import co.edu.usbcali.aerolinea.model.Reserva;
import co.edu.usbcali.aerolinea.model.TipoAsiento;


import co.edu.usbcali.aerolinea.repository.ReservaRepository;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import co.edu.usbcali.aerolinea.services.AsientoService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AsientoServiceImpl implements AsientoService {
    private final AsientoRepository asientoRepository;
    private final ModelMapper modelMapper;
    private final TipoAsientoRepository tipoAsientoRepository;

    private final ReservaRepository  reservaRepository;

    public AsientoServiceImpl(AsientoRepository asientoRepository, TipoAsientoRepository tipoAsientoRepository, ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.asientoRepository = asientoRepository;
        this.tipoAsientoRepository = tipoAsientoRepository;
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AsientoDTO> obtenerAsientos() {
        return AsientoMapper.modelToDTOList(asientoRepository.findAll());
    }
    @Override
    public AsientoDTO obtenerAsiento(Integer id) throws Exception {
        if (asientoRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun asiento!");
        }
        return AsientoMapper.modelToDTO(asientoRepository.findById(id).get());
    }
    @Override
    public AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception {
        if (asientoDTO == null) {
            throw new Exception("El asiento es nulo!");
        }
        if (asientoDTO.getUbicacion() == null || asientoDTO.getUbicacion().isBlank() || asientoDTO.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del asiento no es valido!");
        }
        if (asientoDTO.getPrecio() < 0) {
            throw new Exception("El precio del asiento no debe ser negativo!");
        }
        if (asientoDTO.getEstado() == null || asientoDTO.getEstado().isBlank() || asientoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del asiento no es valido!");
        }
        if(asientoRepository.findById(asientoDTO.getIdAsiento()).isPresent()){
            throw new Exception("id de asiento ya existente!");
        }
        Asiento asiento = AsientoMapper.dtoToModel(asientoDTO);
        return AsientoMapper.modelToDTO(asientoRepository.save(asiento));
    }
}


