package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.Factura;
import co.edu.usbcali.aerolinea.repository.FacturaRepository;
import co.edu.usbcali.aerolinea.services.FacturaService;
import lombok.extern.slf4j.Slf4j;
import co.edu.usbcali.aerolinea.dtos.FacturaDTO;
import co.edu.usbcali.aerolinea.mapper.FacturaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;
    private final ModelMapper modelMapper;

    public FacturaServiceImpl(FacturaRepository facturaRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<FacturaDTO> obtenerFacturas() {
        return FacturaMapper.modelToDTOList(facturaRepository.findAll());
    }
    @Override
    public FacturaDTO obtenerFactura(Integer id) throws Exception {
        if (facturaRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ninguna factura");
        }
        return FacturaMapper.modelToDTO(facturaRepository.findById(id).get());
    }
    @Override
    public FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception {
        if (facturaDTO == null) {
            throw new Exception("La factura es invalida!");
        }
        if (facturaDTO.getIdFactura() == null ) {
            throw new Exception("El id de la factura es invalido!");
        }
        if (facturaDTO.getEstado() == null || facturaDTO.getEstado().isBlank() || facturaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado es invalido!");
        }
        if(facturaRepository.findById(facturaDTO.getIdFactura()).isPresent()){
            throw new Exception("Ya existe el id de la factura!");
        }
        Factura factura = FacturaMapper.dtoToModel(facturaDTO);
        return FacturaMapper.modelToDTO(facturaRepository.save(factura));
    }
}