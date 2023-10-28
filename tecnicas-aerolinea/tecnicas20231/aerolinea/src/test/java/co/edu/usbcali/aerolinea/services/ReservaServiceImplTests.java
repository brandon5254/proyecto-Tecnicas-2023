package co.edu.usbcali.aerolinea.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.ReservaDTO;
import co.edu.usbcali.aerolinea.model.Reserva;
import co.edu.usbcali.aerolinea.repository.ReservaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class ReservaServiceImplTests {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerReservas() {
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva(1, "Reserva 1"));
        reservas.add(new Reserva(2, "Reserva 2"));
        when(reservaRepository.findAll()).thenReturn(reservas);
        when(modelMapper.map(reservas.get(0), ReservaDTO.class)).thenReturn(new ReservaDTO(1, "Reserva 1"));
        when(modelMapper.map(reservas.get(1), ReservaDTO.class)).thenReturn(new ReservaDTO(2, "Reserva 2"));

        List<ReservaDTO> resultado = reservaService.obtenerReservas();
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(new ReservaDTO(1, "Reserva 1")));
        assertTrue(resultado.contains(new ReservaDTO(2, "Reserva 2")));
    }



    @Test(expected = Exception.class)
    public void testObtenerReservaNotFound() throws Exception {
        when(reservaRepository.findById(1)).thenReturn(Optional.empty());
        reservaService.obtenerReserva(1);
    }
}
