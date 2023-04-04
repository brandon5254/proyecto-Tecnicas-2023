package co.edu.usbcali.aerolinea.mapper;


import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import co.edu.usbcali.aerolinea.model.Aeropuerto;



import java.util.List;
import java.util.stream.Collectors;

public class AeropuertoMapper {
    public static AeropuertoDTO modelToDto(Aeropuerto aeropuerto){
        return  AeropuertoDTO.builder()
                .aero_id(aeropuerto.getAero_id())
                .nombre(aeropuerto.getNombre())
                .iata(aeropuerto.getIata())
                .estado(aeropuerto.getEstado())
                .ubicacion(aeropuerto.getUbicacion())
                .build();
    }

    public  static Aeropuerto dtoToModel(AeropuertoDTO aeropuertoDTO){
        return Aeropuerto.builder()
                .aero_id(aeropuertoDTO.getAero_id())
                .nombre(aeropuertoDTO.getNombre())
                .iata(aeropuertoDTO.getIata())
                .estado(aeropuertoDTO.getEstado())
                .ubicacion(aeropuertoDTO.getUbicacion())
                .build();
    }
    public static List<AeropuertoDTO> modelToDtoList(List<Aeropuerto> aeropuertos){
        return aeropuertos.stream().map(ae -> modelToDto(ae)).collect(Collectors.toList());
    }
    public static List<Aeropuerto> dtoToModelList(List<AeropuertoDTO> aeropuertoDTOS){
        return aeropuertoDTOS.stream().map(ae -> dtoToModel(ae)).collect(Collectors.toList());
    }

}

