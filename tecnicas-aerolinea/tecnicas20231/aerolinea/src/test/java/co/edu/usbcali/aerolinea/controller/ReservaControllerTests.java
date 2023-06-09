package co.edu.usbcali.aerolinea.controller;

import co.edu.usbcali.aerolinea.controllers.ReservaController;
import co.edu.usbcali.aerolinea.dtos.MensajeVueloDTO;
import co.edu.usbcali.aerolinea.dtos.ReservaDTO;
import co.edu.usbcali.aerolinea.services.ReservaService;
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

public class ReservaControllerTests {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerReservas_DebeRetornarListaDeReservas() {
        // Arrange
        ReservaDTO reserva1 = new ReservaDTO();
        ReservaDTO reserva2 = new ReservaDTO();
        List<ReservaDTO> reservas = Arrays.asList(reserva1, reserva2);
        when(reservaService.obtenerReservas()).thenReturn(reservas);

        // Act
        ResponseEntity<List<ReservaDTO>> response = reservaController.obtenerReservas();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
        verify(reservaService, times(1)).obtenerReservas();
    }

    @Test
    public void agregarReserva_DebeRetornarReservaAgregada() throws Exception {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        when(reservaService.agregarReserva(reservaDTO)).thenReturn(reservaDTO);

        // Act
        ResponseEntity response = reservaController.agregarReserva(reservaDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservaDTO, response.getBody());
        verify(reservaService, times(1)).agregarReserva(reservaDTO);
    }

    @Test
    public void agregarReserva_DebeRetornarBadRequestEnCasoDeExcepcion() throws Exception {
        // Arrange
        ReservaDTO reservaDTO = new ReservaDTO();
        String mensajeError = "Error al agregar reserva";
        when(reservaService.agregarReserva(reservaDTO)).thenThrow(new Exception(mensajeError));

        // Act
        ResponseEntity response = reservaController.agregarReserva(reservaDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(mensajeError, ((MensajeVueloDTO) response.getBody()).getMensaje());
        verify(reservaService, times(1)).agregarReserva(reservaDTO);
    }

    @Test
    public void obtenerReserva_DebeRetornarReservaPorId() throws Exception {
        // Arrange
        int idReserva = 1;
        ReservaDTO reservaDTO = new ReservaDTO();
        when(reservaService.obtenerReserva(idReserva)).thenReturn(reservaDTO);

        // Act
        ResponseEntity<ReservaDTO> response = reservaController.obtenerReserva(idReserva);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservaDTO, response.getBody());
        verify(reservaService, times(1)).obtenerReserva(idReserva);
    }

    @Test
    public void obtenerReserva_DebeRetornarBadRequestEnCasoDeExcepcion() throws Exception {
        // Arrange
        int idReserva = 1;
        String mensajeError = "Error al obtener reserva";
        when(reservaService.obtenerReserva(idReserva)).thenThrow(new Exception(mensajeError));

        // Act
        ResponseEntity response = reservaController.obtenerReserva(idReserva);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(mensajeError, ((MensajeVueloDTO) response.getBody()).getMensaje());
        verify(reservaService, times(1)).obtenerReserva(idReserva);
    }
}
