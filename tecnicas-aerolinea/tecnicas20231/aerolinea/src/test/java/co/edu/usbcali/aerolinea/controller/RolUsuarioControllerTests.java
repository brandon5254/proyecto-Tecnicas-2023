package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.RolUsuarioController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.services.RolUsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class RolUsuarioControllerTests {
    @Mock
    private RolUsuarioService rolUsuarioService;

    @InjectMocks
    private RolUsuarioController rolUsuarioController;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }



    @Test
    public void shouldReturnAllRolUsuarios() {
        // Arrange
        List<RolUsuario> rolUsuarioList = new ArrayList<>();
        rolUsuarioList.add(new RolUsuario());
        rolUsuarioList.add(new RolUsuario());

        // Convertir lista de RolUsuario a lista de RolUsuarioDTO
        List<RolUsuarioDTO> rolUsuarioDTOList = new ArrayList<>();
        for (RolUsuario rolUsuario : rolUsuarioList) {
            RolUsuarioDTO rolUsuarioDTO = new RolUsuarioDTO();
            // Copiar propiedades de RolUsuario a RolUsuarioDTO
            rolUsuarioDTOList.add(rolUsuarioDTO);
        }

        when(rolUsuarioService.buscartodos()).thenReturn(rolUsuarioDTOList);

        // Act
        ResponseEntity<List<RolUsuario>> response = rolUsuarioController.todos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void shouldReturnRolUsuarioById() throws Exception {
        // Arrange
        int idRolUsuario = 1;
        RolUsuarioDTO rolUsuarioDTO = new RolUsuarioDTO();
        when(rolUsuarioService.obtenerRolUsuario(idRolUsuario)).thenReturn(rolUsuarioDTO);

        // Act
        ResponseEntity<RolUsuarioDTO> response = rolUsuarioController.obtenerRolUsuario(idRolUsuario);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rolUsuarioDTO, response.getBody());
    }


    @Test
    public void shouldSaveNewRolUsuario() throws Exception {
        // Arrange
        RolUsuarioDTO rolUsuarioDTO = new RolUsuarioDTO();
        when(rolUsuarioService.guardarNuevoRollUsuario(rolUsuarioDTO)).thenReturn(rolUsuarioDTO);

        // Act
        ResponseEntity response = rolUsuarioController.guardarNuevoRolUsuario(rolUsuarioDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rolUsuarioDTO, response.getBody());
    }



    @Test
    public void shouldHandleExceptionOnGuardarNuevoRolUsuario() throws Exception {
        // Arrange
        RolUsuarioDTO rolUsuarioDTO = new RolUsuarioDTO();
        String errorMessage = "Error saving new RolUsuario";
        when(rolUsuarioService.guardarNuevoRollUsuario(rolUsuarioDTO)).thenThrow(new RuntimeException(errorMessage));

        // Act
        ResponseEntity response = rolUsuarioController.guardarNuevoRolUsuario(rolUsuarioDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, ((MensajeVueloDTO) response.getBody()).getMensaje());
    }

}
