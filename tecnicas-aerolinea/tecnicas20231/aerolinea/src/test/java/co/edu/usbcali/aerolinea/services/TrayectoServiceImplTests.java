package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.TrayectoDTO;
import co.edu.usbcali.aerolinea.model.Trayecto;
import co.edu.usbcali.aerolinea.repository.TrayectoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.Optional;


import java.util.List;


import static org.mockito.Mockito.when;

public class TrayectoServiceImplTests {

    private TrayectoServiceImpl trayectoService;

    @Mock
    private TrayectoRepository trayectoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        trayectoService = new TrayectoServiceImpl(trayectoRepository);
    }

    @Test
    public void obtenerTrayecto_shouldReturnTrayectoDTO_whenTrayectoExists() throws Exception {
        // Given
        Integer id = 1;
        Trayecto trayecto = new Trayecto();
        trayecto.setIdTrayecto(id);
        when(trayectoRepository.findById(id)).thenReturn(Optional.of(trayecto));

        // When
        TrayectoDTO trayectoDTO = trayectoService.obtenerTrayecto(id);

        // Then
        Assertions.assertEquals(id, trayectoDTO.getIdTrayecto());
    }

    @Test
    public void obtenerTrayecto_shouldThrowException_whenTrayectoDoesNotExist() {
        // Given
        Integer id = 1;
        when(trayectoRepository.findById(id)).thenReturn(Optional.empty());

        // When / Then
        Assertions.assertThrows(Exception.class, () -> trayectoService.obtenerTrayecto(id));
    }

    @Test
    public void obtenerTrayectos_shouldReturnTrayectoDTOList() {
        // Given
        Trayecto trayecto = new Trayecto();
        trayecto.setIdTrayecto(1);
        when(trayectoRepository.findAll()).thenReturn(Collections.singletonList(trayecto));

        // When
        List<TrayectoDTO> trayectoDTOList = trayectoService.obtenerTrayectos();

        // Then
        Assertions.assertEquals(1, trayectoDTOList.size());
    }
}
