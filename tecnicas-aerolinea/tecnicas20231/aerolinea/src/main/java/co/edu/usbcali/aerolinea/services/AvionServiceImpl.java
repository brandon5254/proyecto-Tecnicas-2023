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
    public AvionDTO obtenerAvion(Integer id) throws Exception {
        if (avionRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun avion!");
        }
        return AvionMapper.modelToDTO(avionRepository.findById(id).get());
    }




    @Override
    public AvionDTO guardarNuevoAvion(AvionDTO avionDTO) throws Exception {

        Avion avion = AvionMapper.dTOToModel(avionDTO);
        if(avion.getModelo() == null || avion.getModelo().trim().isEmpty()) {
            throw new Exception(" ingrese  el Modelo del avion");
        }


        if (avionDTO.getEstado() == null || avionDTO.getEstado().isBlank() || avionDTO.getEstado().trim().isEmpty()) {
        throw new Exception("El estado no es valido!");
    }
        if(avionRepository.findById(avionDTO.getIdAvion()).isPresent()){
        throw new Exception("Ya se encuentra existente   el identificador  del avion!");
    }
    Avion avion1 = AvionMapper.dTOToModel(avionDTO);
        return AvionMapper.modelToDTO(avionRepository.save(avion));
    }
}