package co.edu.usbcali.aerolinea.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.edu.usbcali.aerolinea.controllers.UsuarioController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.UsuarioDTO;
import co.edu.usbcali.aerolinea.services.UsuarioService;

public class UsuarioControllerTests {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerUsuario_DebeRetornarUsuarioExistente() throws Exception {
        // Arrange
        Integer idUsuario = 1;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdRolUsuario(idUsuario);
        when(usuarioService.obtenerUsuario(idUsuario)).thenReturn(usuarioDTO);

        // Act
        ResponseEntity<UsuarioDTO> response = usuarioController.obtenerUsuario(idUsuario);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuarioDTO, response.getBody());
        verify(usuarioService, times(1)).obtenerUsuario(idUsuario);
    }



    @Test
    public void obtenerUsuarios_DebeRetornarListaDeUsuariosExistente() {
        // Arrange
        List<UsuarioDTO> usuarios = new ArrayList<>();
        usuarios.add(new UsuarioDTO());
        usuarios.add(new UsuarioDTO());
        when(usuarioService.obtenerUsuarios()).thenReturn(usuarios);

        // Act
        ResponseEntity<List<UsuarioDTO>> response = usuarioController.obtenerUsuarios();

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuarios, response.getBody());
        verify(usuarioService, times(1)).obtenerUsuarios();
    }

    @Test
    public void agregarUsuario_DebeRetornarUsuarioAgregado() throws Exception {
        // Arrange
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        when(usuarioService.agregarUsuario(usuarioDTO)).thenReturn(usuarioDTO);

        // Act
        ResponseEntity response = usuarioController.agregarUsuario(usuarioDTO);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuarioDTO, response.getBody());
        verify(usuarioService, times(1)).agregarUsuario(usuarioDTO);
    }


}

