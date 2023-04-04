package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;

import java.util.List;

public interface TipoAsientoService {
    List<TipoAsientoDTO> obtenerTipoAsientos();
    TipoAsientoDTO obtenerTipoAsiento(Integer id) throws Exception;
    TipoAsientoDTO agregarTipoAsiento(TipoAsientoDTO tipoAsientoDTO) throws Exception;
}

