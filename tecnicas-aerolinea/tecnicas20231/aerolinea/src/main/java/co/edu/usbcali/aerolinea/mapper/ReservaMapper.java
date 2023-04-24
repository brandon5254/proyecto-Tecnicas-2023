package co.edu.usbcali.aerolinea.mapper;

import co.edu.usbcali.aerolinea.model.Reserva;
import co.edu.usbcali.aerolinea.dtos.ReservaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {
    public static ReservaDTO modelToDTO(Reserva reserva) {
        return ReservaDTO.builder()
                .idReserva(reserva.getIdReserva())
                .idVuelo(reserva.getIdVuelo() != null ? reserva.getIdVuelo().getIdVuelo() : null)
                .precioTotal(reserva.getPrecioTotal())
                .estadoPago(reserva.getEstadoPago())
                .estado(reserva.getEstado())
                .build();
    }

    public static List<ReservaDTO> modelToDTOList(List<Reserva> reservas) {
        return reservas.stream().map(reserva -> modelToDTO(reserva)).collect(Collectors.toList());
    }

    public static Reserva dtoToModel(ReservaDTO reservaDTO) {
        return Reserva.builder()
                .idReserva(reservaDTO.getIdReserva())
                .precioTotal(reservaDTO.getPrecioTotal())
                .estadoPago(reservaDTO.getEstadoPago())
                .estado(reservaDTO.getEstado())
                .build();
    }

    public static List<Reserva> dtoToModelList(List<ReservaDTO> reservasDTO) {
        return reservasDTO.stream().map(reservaDTO -> dtoToModel(reservaDTO)).collect(Collectors.toList());
    }
}
