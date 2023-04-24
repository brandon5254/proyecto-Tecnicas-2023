package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.VueloDTO;

import java.util.List;

public interface VueloService {

    VueloDTO guardarVuelo(VueloDTO vuelDTO) throws Exception;
    VueloDTO obtenerVuelo(Integer id) throws Exception;
    List<VueloDTO> obtenerVuelos();


}
