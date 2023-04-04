package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.AsientoDTO;

import java.util.List;

public interface AsientoService {
    List<AsientoDTO> obtenerAsientos();
    AsientoDTO obtenerAsiento(Integer id) throws Exception;
    AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception;
}