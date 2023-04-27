package co.edu.usbcali.aerolinea.services;

import static org.mockito.Mockito.*;

import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.model.TipoAsiento;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

public class TipoAsientoServiceImplTests {

    private TipoAsientoServiceImpl tipoAsientoServiceImpl;

    @Mock
    private TipoAsientoRepository tipoAsientoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.tipoAsientoServiceImpl = new TipoAsientoServiceImpl(tipoAsientoRepository, new ModelMapper());
    }

    @Test
    public void testObtenerTipoAsiento() throws Exception {
        TipoAsiento tipoAsiento = new TipoAsiento();
        tipoAsiento.setIdTipoAsiento(1);
        tipoAsiento.setDescripcion("Asiento1");
        Optional<TipoAsiento> optionalTipoAsiento = Optional.of(tipoAsiento);

        when(tipoAsientoRepository.findById(1)).thenReturn(optionalTipoAsiento);

        TipoAsientoDTO tipoAsientoDTO = tipoAsientoServiceImpl.obtenerTipoAsiento(1);

        Assertions.assertEquals(tipoAsientoDTO.getIdTipoAsiento(), tipoAsiento.getIdTipoAsiento());
        Assertions.assertEquals(tipoAsientoDTO.getDescripcion(), tipoAsiento.getDescripcion());
    }

    @Test
    public void testObtenerTipoAsientoConIdNoExistente() {
        Optional<TipoAsiento> optionalTipoAsiento = Optional.empty();

        when(tipoAsientoRepository.findById(1)).thenReturn(optionalTipoAsiento);

        Assertions.assertThrows(Exception.class, () -> {
            tipoAsientoServiceImpl.obtenerTipoAsiento(1);
        });
    }
}
