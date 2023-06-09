package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.AvionController;
import co.edu.usbcali.aerolinea.dtos.AvionDTO;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.services.AvionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AvionControllerTests {

    @Mock
    private AvionService avionService;

    @InjectMocks
    private AvionController avionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerAviones_DebeRetornarListaDeAviones() {
        // Arrange
        List<AvionDTO> aviones = new ArrayList<>();
        aviones.add(new AvionDTO(1, "Avion1", "Tipo1"));
        when(avionService.obtenerAviones()).thenReturn(aviones);

        // Act
        ResponseEntity<List<AvionDTO>> response = avionController.obtenerAviones();

        // Assert
        verify(avionService, times(1)).obtenerAviones();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(aviones, response.getBody());
    }

    @Test
    public void obtenerAvion_ConIdExistente_DebeRetornarAvion() throws Exception {
        // Arrange
        Integer idAvion = 1;
        AvionDTO avionDTO = new AvionDTO(idAvion, "Avion1", "Tipo1");
        when(avionService.obtenerAvion(idAvion)).thenReturn(avionDTO);

        // Act
        ResponseEntity<AvionDTO> response = avionController.obtenerAvion(idAvion);

        // Assert
        verify(avionService, times(1)).obtenerAvion(idAvion);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(avionDTO, response.getBody());
    }


    @Test
    public void guardarAvion_ConAvionValido_DebeRetornarAvionGuardado() throws Exception {
        // Arrange
        AvionDTO avionDTO = new AvionDTO(1, "Avion1", "Tipo1");
        when(avionService.guardarNuevoAvion(avionDTO)).thenReturn(avionDTO);

        // Act
        ResponseEntity response = avionController.guardarAvion(avionDTO);

        // Assert
        verify(avionService, times(1)).guardarNuevoAvion(avionDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(avionDTO, response.getBody());
    }

    @Test
    public void guardarAvion_ConAvionInvalido_DebeRetornarBadRequest() throws Exception {
        // Arrange
        AvionDTO avionDTO = new AvionDTO(1, "Avion1", "Tipo1");
        String mensajeError = "El avión proporcionado es inválido";
        when(avionService.guardarNuevoAvion(avionDTO)).thenThrow(new Exception(mensajeError));

        // Act
        ResponseEntity response = avionController.guardarAvion(avionDTO);

        // Assert
        verify(avionService, times(1)).guardarNuevoAvion(avionDTO);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mensajeError, ((MensajeVueloDTO) response.getBody()).getMensaje());

    }
}
