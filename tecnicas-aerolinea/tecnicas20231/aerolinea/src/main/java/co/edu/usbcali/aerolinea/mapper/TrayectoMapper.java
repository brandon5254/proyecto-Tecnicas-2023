package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.model.Trayecto;
import co.edu.usbcali.aerolinea.dtos.TrayectoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TrayectoMapper {
    public static TrayectoDTO modelToDTO(Trayecto trayecto) {
        return TrayectoDTO.builder()
                .idTrayecto(trayecto.getIdTrayecto())
                .idAeropuertoOrigen(Math.toIntExact(trayecto.getIdAeropuertoOrigen() != null ? trayecto.getIdAeropuertoOrigen().getAero_id() : null))
                .idAeropuertoDestino(Math.toIntExact(trayecto.getIdAeropuertoDestino() != null ? trayecto.getIdAeropuertoDestino().getAero_id() : null))
                .idVuelo(trayecto.getIdVuelo().getIdVuelo())
                .estado(trayecto.getEstado())
                .build();
    }

    public static List<TrayectoDTO> modelToDTOList(List<Trayecto> trayectos) {
        return trayectos.stream().map(trayecto -> modelToDTO(trayecto)).collect(Collectors.toList());
    }

    public static Trayecto dtoToModel(TrayectoDTO trayectoDTO) {
        return Trayecto.builder()
                .idTrayecto(trayectoDTO.getIdTrayecto())
                .estado(trayectoDTO.getEstado())
                .build();
    }

    public static List<Trayecto> dtoToModelList(List<TrayectoDTO> trayectosDTO) {
        return trayectosDTO.stream().map(trayectoDTO -> dtoToModel(trayectoDTO)).collect(Collectors.toList());
    }
}
