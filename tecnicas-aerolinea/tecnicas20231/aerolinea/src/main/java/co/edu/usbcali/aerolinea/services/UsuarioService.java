package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obtenerUsuarios();
    UsuarioDTO obtenerUsuario(Integer id) throws Exception;
    UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception;
}


