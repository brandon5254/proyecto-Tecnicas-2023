package co.edu.usbcali.aerolinea.services;

import org.springframework.stereotype.Service;
import co.edu.usbcali.aerolinea.model.Aeropuerto;
import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import co.edu.usbcali.aerolinea.mapper.AeropuertoMapper;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import org.modelmapper.ModelMapper;


import java.util.List;


@Service
public class AeropuertoServiceImpl implements AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;
    private final ModelMapper modelMapper;
    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository, ModelMapper modelMapper) {
        this.aeropuertoRepository = aeropuertoRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public AeropuertoDTO agregarAeropuerto(AeropuertoDTO aeropuertoDTO) throws Exception {
        if (aeropuertoDTO == null) {
            throw new Exception("El aeropuerto no puede ser nulo");
        }
        if (aeropuertoDTO.getNombre() == null || aeropuertoDTO.getNombre().isBlank() || aeropuertoDTO.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del aeropuerto es invalido!");
        }
        if (aeropuertoDTO.getIata() == null || aeropuertoDTO.getIata().isBlank() || aeropuertoDTO.getIata().trim().isEmpty()) {
            throw new Exception("El IATA es invalido!");
        }
        if (aeropuertoDTO.getUbicacion() == null || aeropuertoDTO.getUbicacion().isBlank() || aeropuertoDTO.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación es invalida!");
        }
        if (aeropuertoDTO.getEstado() == null || aeropuertoDTO.getEstado().isBlank() || aeropuertoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado es invalido!");
        }
        if(aeropuertoRepository.findById(Long.valueOf(aeropuertoDTO.getAero_id())).isPresent()){
            throw new Exception("Ya existe el id del aeropuerto!");
        }
        Aeropuerto aeropuerto = AeropuertoMapper.dtoToModel(aeropuertoDTO);
        return AeropuertoMapper.modelToDto(aeropuertoRepository.save(aeropuerto));
    }
    @Override
    public AeropuertoDTO obtenerAeropuerto(Integer id) throws Exception {
        if (aeropuertoRepository.findById(Long.valueOf(id)).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun aeropuerto!");
        }
        return AeropuertoMapper.modelToDto(aeropuertoRepository.findById(Long.valueOf(id)).get());
    }
    @Override
    public List<AeropuertoDTO> obtenerAeropuertos() {
        return AeropuertoMapper.modelToDtoList(aeropuertoRepository.findAll());
    }
}
