package co.edu.usbcali.aerolinea.services;



import co.edu.usbcali.aerolinea.model.TipoAsiento;
import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.mapper.TipoAsientoMapper;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import co.edu.usbcali.aerolinea.services.TipoAsientoService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TipoAsientoServiceImpl implements TipoAsientoService {
    private final TipoAsientoRepository tipoAsientoService;
    private final ModelMapper modelMapper;
    public TipoAsientoServiceImpl(TipoAsientoRepository tipoAsientoService, ModelMapper modelMapper) {
        this.tipoAsientoService = tipoAsientoService;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<TipoAsientoDTO> obtenerTipoAsientos() {
        return TipoAsientoMapper.modelToDTOList(tipoAsientoService.findAll());
    }



    @Override
    public TipoAsientoDTO obtenerTipoAsiento(Integer id) throws Exception {
        if (tipoAsientoService.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun tipo de asiento!");
        }
        return TipoAsientoMapper.modelToDTO(tipoAsientoService.findById(id).get());
    }
    @Override
    public TipoAsientoDTO agregarTipoAsiento(TipoAsientoDTO tipoAsientoDTO) throws Exception {
        if (tipoAsientoDTO == null) {
            throw new Exception("El tipo de asiento es invalido!");
        }
        if (tipoAsientoDTO.getDescripcion() == null || tipoAsientoDTO.getDescripcion().isBlank() || tipoAsientoDTO.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del tipo de asiento es invalida!");
        }
        if (tipoAsientoDTO.getEstado() == null || tipoAsientoDTO.getEstado().isBlank() || tipoAsientoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del tipo de asiento es invalido!");
        }
        if(tipoAsientoService.findById(tipoAsientoDTO.getIdTipoAsiento()).isPresent()){
            throw new Exception("Ya existe el id del asiento!");
        }
        TipoAsiento tipoAsiento = TipoAsientoMapper.dtoToModel(tipoAsientoDTO);
        return TipoAsientoMapper.modelToDTO(tipoAsientoService.save(tipoAsiento));
    }

}
