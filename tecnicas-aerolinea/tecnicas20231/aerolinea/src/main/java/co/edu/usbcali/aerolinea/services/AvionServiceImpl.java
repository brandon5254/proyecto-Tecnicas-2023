package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.dtos.AvionDTO;
import co.edu.usbcali.aerolinea.mapper.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AvionServiceImpl implements AvionService{

    private final AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }


    @Override
    public List<AvionDTO> obtenerAviones() {
        log.info("Servicio obtener aviones");
        return AvionMapper.modelToDTOList(avionRepository.findAll());
    }

    @Override
    public AvionDTO guardarNuevoAvion(AvionDTO avionDTO) throws Exception {

        Avion avion = AvionMapper.dTOToModel(avionDTO);
        if(avion.getModelo() == null || avion.getModelo().trim().isEmpty()) {
            throw new Exception("Debe ingresar el Modelo");
        }

        return AvionMapper.modelToDTO(avionRepository.save(avion));
    }
}