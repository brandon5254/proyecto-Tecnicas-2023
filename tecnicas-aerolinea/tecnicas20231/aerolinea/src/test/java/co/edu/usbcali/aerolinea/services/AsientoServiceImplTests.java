package co.edu.usbcali.aerolinea.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.AsientoDTO;
import co.edu.usbcali.aerolinea.model.Asiento;
import co.edu.usbcali.aerolinea.repository.AsientoRepository;
import co.edu.usbcali.aerolinea.repository.ReservaRepository;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class AsientoServiceImplTests {

    @Mock
    private AsientoRepository asientoRepository;
    @Mock
    private TipoAsientoRepository tipoAsientoRepository;
    @Mock
    private ReservaRepository reservaRepository;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AsientoServiceImpl asientoServiceImpl;

    @Before
    public void setup() {
        when(asientoRepository.findById(1)).thenReturn(Optional.of(new Asiento()));
        when(asientoRepository.findById(2)).thenReturn(Optional.empty());
        when(asientoRepository.findAll()).thenReturn(new ArrayList<>());
        when(modelMapper.map(new Asiento(), AsientoDTO.class)).thenReturn(new AsientoDTO());
        when(modelMapper.map(new ArrayList<>(), List.class)).thenReturn(new ArrayList<>());
    }

    @Test
    public void testObtenerAsientos() {
        List<AsientoDTO> asientos = asientoServiceImpl.obtenerAsientos();
        assertNotNull(asientos);
        assertTrue(asientos.isEmpty());
    }

    @Test
    public void testObtenerAsientoExistente() throws Exception {
        AsientoDTO asiento = asientoServiceImpl.obtenerAsiento(1);
        assertNotNull(asiento);
    }

    @Test(expected = Exception.class)
    public void testObtenerAsientoNoExistente() throws Exception {
        asientoServiceImpl.obtenerAsiento(2);
}
}
