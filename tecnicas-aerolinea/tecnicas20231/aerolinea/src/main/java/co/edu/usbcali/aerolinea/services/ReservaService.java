package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.ReservaDTO;

import java.util.List;

public interface ReservaService {
    List<ReservaDTO> obtenerReservas();
    ReservaDTO obtenerReserva(Integer id) throws Exception;
    ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception;
}
