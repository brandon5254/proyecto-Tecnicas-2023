package co.edu.usbcali.aerolinea.services;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.AeropuertoDTO;
import co.edu.usbcali.aerolinea.model.Aeropuerto;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AeropuertoServiceImplTests {

    @Mock
    private AeropuertoRepository aeropuertoRepository;

    private AeropuertoServiceImpl aeropuertoService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        aeropuertoService = new AeropuertoServiceImpl(aeropuertoRepository);
    }

    @Test
    void testObtenerAeropuerto() throws Exception {
        // Given
        Long id = 1L;
        Optional<Aeropuerto> aeropuerto = Optional.of(new Aeropuerto());
        Mockito.when(aeropuertoRepository.findById(id)).thenReturn(aeropuerto);

        // When
        AeropuertoDTO aeropuertoDTO = aeropuertoService.obtenerAeropuerto(id.intValue());

        // Then
        assertNotNull(aeropuertoDTO);
    }

    @Test
    void testObtenerAeropuertoConIdInexistente() {
        // Given
        Long id = 1L;
        Mockito.when(aeropuertoRepository.findById(id)).thenReturn(Optional.empty());

        // When-Then
        assertThrows(Exception.class, () -> {
            aeropuertoService.obtenerAeropuerto(id.intValue());
        });
    }

    @Test
    void testObtenerAeropuertos() {
        // Given
        List<Aeropuerto> aeropuertos = new ArrayList<>();
        aeropuertos.add(new Aeropuerto());
        Mockito.when(aeropuertoRepository.findAll()).thenReturn(aeropuertos);

        // When
        List<AeropuertoDTO> aeropuertosDTO = aeropuertoService.obtenerAeropuertos();

        // Then
        assertNotNull(aeropuertosDTO);
        assertEquals(aeropuertos.size(), aeropuertosDTO.size());
}
}
