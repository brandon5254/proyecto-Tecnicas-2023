package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.model.Vuelo;
import co.edu.usbcali.aerolinea.dtos.VueloDTO;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VueloMapper {
    public static VueloDTO modelToDTO(Vuelo vuelo) {
        return VueloDTO.builder()
                .idVuelo(vuelo.getIdVuelo())
                .origen(vuelo.getOrigen())
                .destino(vuelo.getDestino())
                .precio(vuelo.getPrecio())
                .fechaHoraSalida(vuelo.getFechaHoraSalida())
                .fechaHoraLlegada(vuelo.getFechaHoraLlegada())
                .precioAsientoVip(vuelo.getPrecioAsientoVip())
                .precioAsientoBasico(vuelo.getPrecioAsientoBasico())
                .precioAsientoNormal(vuelo.getPrecioAsientoNormal())
                .estado(vuelo.getEstado())
                .avion(vuelo.getAvion())
                .build();
    }

    public static List<VueloDTO> modelToDTOList(List<Vuelo> vuelos) {
        return vuelos.stream().map(vuelo -> modelToDTO(vuelo)).collect(Collectors.toList());
    }

    public static Vuelo dtoToModel(VueloDTO vueloDTO) {
        return Vuelo.builder()
                .idVuelo(vueloDTO.getIdVuelo())
                .precio(vueloDTO.getPrecio())
                .origen(vueloDTO.getOrigen())
                .destino(vueloDTO.getDestino())
                .fechaHoraSalida((Date) vueloDTO.getFechaHoraSalida())
                .fechaHoraLlegada((Date) vueloDTO.getFechaHoraLlegada())
                .precioAsientoVip(vueloDTO.getPrecioAsientoVip())
                .precioAsientoBasico(vueloDTO.getPrecioAsientoBasico())
                .precioAsientoNormal(vueloDTO.getPrecioAsientoNormal())
                .estado(vueloDTO.getEstado())
                .build();
    }

    public static List<Vuelo> dtoToModelList(List<VueloDTO> vuelosDTO) {
        return vuelosDTO.stream().map(vueloDTO -> dtoToModel(vueloDTO)).collect(Collectors.toList());
    }
}


