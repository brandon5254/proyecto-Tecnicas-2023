package co.edu.usbcali.aerolinea.services;


import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import java.util.List;

public interface AeropuertoService {
    AeropuertoDTO agregarAeropuerto(AeropuertoDTO aeropuertoDTO) throws Exception;
    AeropuertoDTO obtenerAeropuerto(Integer id) throws Exception;
    List<AeropuertoDTO> obtenerAeropuertos();
}
