package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.FacturaDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaDTO> obtenerFacturas();
    FacturaDTO obtenerFactura(Integer id) throws Exception;
    FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception;
}
