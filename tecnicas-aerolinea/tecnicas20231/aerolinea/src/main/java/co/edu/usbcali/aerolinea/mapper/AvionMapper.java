package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.model.Avion;
import co.edu.usbcali.aerolinea.dtos.AvionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AvionMapper {

    public static AvionDTO modelToDTO(Avion avion) {
        return AvionDTO.builder()
                .idAvion(avion.getIdAvion())
                .modelo(avion.getModelo())
                .estado(avion.getEstado())
                .build();
    }

    public static List<AvionDTO> modelToDTOList(List<Avion> aviones) {
        return aviones.stream().map(avion -> modelToDTO(avion)).collect(Collectors.toList());
    }

    public static Avion dTOToModel(AvionDTO avionDTO) {
        return Avion.builder()
                .idAvion(avionDTO.getIdAvion())
                .modelo(avionDTO.getModelo())
                .estado(avionDTO.getEstado())
                .build();
    }

    public static List<Avion> dTOToModelList(List<AvionDTO> avionesDTO) {
        return avionesDTO.stream().map(avionDTO -> dTOToModel(avionDTO)).collect(Collectors.toList());
    }


}