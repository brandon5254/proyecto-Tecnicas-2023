package co.edu.usbcali.aerolinea.mapper;




import java.util.List;
import java.util.stream.Collectors;

import co.edu.usbcali.aerolinea.model.TipoAsiento;
import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;



public class TipoAsientoMapper {
    public static TipoAsientoDTO modelToDTO(TipoAsiento tipoAsiento) {
        return TipoAsientoDTO.builder()
                .idTipoAsiento(tipoAsiento.getIdTipoAsiento())
                .descripcion(tipoAsiento.getDescripcion())
                .estado(tipoAsiento.getEstado())
                .build();
    }

    public static List<TipoAsientoDTO> modelToDTOList(List<TipoAsiento> tipoAsientos) {
        return tipoAsientos.stream().map(tipoAsiento -> modelToDTO(tipoAsiento)).collect(Collectors.toList());
    }

    public static TipoAsiento dtoToModel(TipoAsientoDTO tipoAsientoDTO) {
        return TipoAsiento.builder()
                .idTipoAsiento(tipoAsientoDTO.getIdTipoAsiento())
                .descripcion(tipoAsientoDTO.getDescripcion())
                .estado(tipoAsientoDTO.getEstado())
                .build();
    }

    public static List<TipoAsiento> dtoToModelList(List<TipoAsientoDTO> tipoAsientosDTO) {
        return tipoAsientosDTO.stream().map(tipoAsientoDTO -> dtoToModel(tipoAsientoDTO)).collect(Collectors.toList());
    }
}
