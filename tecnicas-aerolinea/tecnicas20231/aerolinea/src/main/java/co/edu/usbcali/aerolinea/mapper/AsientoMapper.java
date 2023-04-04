package co.edu.usbcali.aerolinea.mapper;
import co.edu.usbcali.aerolinea.model.Asiento;
import co.edu.usbcali.aerolinea.dtos.AsientoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AsientoMapper {
    public static AsientoDTO modelToDTO(Asiento asiento) {
        return AsientoDTO.builder()
                .idAsiento(asiento.getIdAsiento())
                .idTipoAsiento(asiento.getIdTipoAsiento() != null ? asiento.getIdTipoAsiento().getIdTipoAsiento() : null)

                .ubicacion(asiento.getUbicacion())
                .precio(asiento.getPrecio())
                .estado(asiento.getEstado())
                .build();
    }
    public static List<AsientoDTO> modelToDTOList(List<Asiento> asientos) {
        return asientos.stream().map(asiento -> modelToDTO(asiento)).collect(Collectors.toList());
    }
    public static Asiento dtoToModel(AsientoDTO asientoDTO) {
        return Asiento.builder()
                .idAsiento(asientoDTO.getIdAsiento())
                .ubicacion(asientoDTO.getUbicacion())
                .precio(asientoDTO.getPrecio())
                .estado(asientoDTO.getEstado())
                .build();
    }
    public static List<Asiento> dtoToModelList(List<AsientoDTO> asientosDTO) {
        return asientosDTO.stream().map(asientoDTO -> dtoToModel(asientoDTO)).collect(Collectors.toList());
    }
}
