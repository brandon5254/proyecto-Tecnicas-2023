package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.TrayectoController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.TrayectoDTO;
import co.edu.usbcali.aerolinea.services.TrayectoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TrayectoControllerTests {

    @Mock
    private TrayectoService trayectoService;

    @InjectMocks
    private TrayectoController trayectoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerTrayecto_debeRetornarTrayectoExistente() throws Exception {
        // Arrange
        Integer idTrayecto = 1;
        TrayectoDTO trayectoDTO = new TrayectoDTO(); // Crea un objeto TrayectoDTO simulado
        when(trayectoService.obtenerTrayecto(idTrayecto)).thenReturn(trayectoDTO);

        // Act
        ResponseEntity<TrayectoDTO> response = trayectoController.obtenerTrayecto(idTrayecto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trayectoDTO, response.getBody());
        verify(trayectoService, times(1)).obtenerTrayecto(idTrayecto);
    }




    @Test
    void guardarTrayecto_debeRetornarTrayectoGuardado() throws Exception {
        // Arrange
        TrayectoDTO trayectoDTO = new TrayectoDTO(); // Crea un objeto TrayectoDTO simulado
        when(trayectoService.agregarTrayecto(trayectoDTO)).thenReturn(trayectoDTO);

        // Act
        ResponseEntity response = trayectoController.guardarTrayecto(trayectoDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trayectoDTO, response.getBody());
        verify(trayectoService, times(1)).agregarTrayecto(trayectoDTO);
    }



    @Test
    void obtenerTrayectos_debeRetornarListaDeTrayectos() {
        // Arrange
        List<TrayectoDTO> trayectosDTO = Arrays.asList(new TrayectoDTO(), new TrayectoDTO());
        when(trayectoService.obtenerTrayectos()).thenReturn(trayectosDTO);

        // Act
        ResponseEntity<List<TrayectoDTO>> response = trayectoController.obtenerTrayectos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trayectosDTO, response.getBody());
        verify(trayectoService, times(1)).obtenerTrayectos();
    }
}
