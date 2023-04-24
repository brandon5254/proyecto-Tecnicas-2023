package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.AvionDTO;

import java.util.List;

public interface AvionService {

    List<AvionDTO> obtenerAviones();

    AvionDTO obtenerAvion(Integer id) throws Exception;

    AvionDTO guardarNuevoAvion(AvionDTO avionDTO) throws Exception;
}