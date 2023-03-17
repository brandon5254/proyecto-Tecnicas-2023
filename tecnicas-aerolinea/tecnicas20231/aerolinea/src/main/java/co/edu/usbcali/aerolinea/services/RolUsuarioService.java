package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;

import java.util.List;

public interface RolUsuarioService {

    List<RolUsuarioDTO> buscartodos();

    RolUsuarioDTO guardarNuevoRollUsuario(RolUsuarioDTO rolUsuarioDTO) throws Exception;
}
