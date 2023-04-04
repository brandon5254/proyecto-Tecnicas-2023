package co.edu.usbcali.aerolinea.mapper;



import co.edu.usbcali.aerolinea.model.Usuario;
import co.edu.usbcali.aerolinea.dtos.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDTO modelToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .usuaId(usuario.getUsuaId())
                .idRolUsuario(usuario.getIdRolUsuario() != null ? usuario.getIdRolUsuario().getRousId() : null)
                .cedula(usuario.getCedula())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .correo(usuario.getCorreo())
                .estado(usuario.getEstado())
                .build();
    }

    public static List<UsuarioDTO> modelToDTOList(List<Usuario> usuarios) {
        return usuarios.stream().map(usuario -> modelToDTO(usuario)).collect(Collectors.toList());
    }

    public static Usuario dtoToModel(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .usuaId(usuarioDTO.getUsuaId())
                .cedula(usuarioDTO.getCedula())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .correo(usuarioDTO.getCorreo())
                .estado(usuarioDTO.getEstado())
                .build();
    }

    public static List<Usuario> dTOToModelList(List<UsuarioDTO> usuariosDTO) {
        return usuariosDTO.stream().map(usuarioDTO -> dtoToModel(usuarioDTO)).collect(Collectors.toList());
    }


}
