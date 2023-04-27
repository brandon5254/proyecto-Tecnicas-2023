package co.edu.usbcali.aerolinea.services;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.dtos.FacturaDTO;
import co.edu.usbcali.aerolinea.model.Factura;
import co.edu.usbcali.aerolinea.repository.FacturaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FacturaServiceImplTests {

    @Mock
    private FacturaRepository facturaRepository;

    @Mock
    private Factura factura;

    @InjectMocks
    private FacturaServiceImpl facturaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerFacturas() {
        List<Factura> facturas = new ArrayList<Factura>();
        facturas.add(factura);
        Mockito.when(facturaRepository.findAll()).thenReturn(facturas);

        List<FacturaDTO> result = facturaService.obtenerFacturas();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test(expected = Exception.class)
    public void testObtenerFacturaException() throws Exception {
        Integer id = 1;
        Mockito.when(facturaRepository.findById(id)).thenReturn(Optional.empty());

        facturaService.obtenerFactura(id);
    }

    @Test
    public void testObtenerFactura() throws Exception {
        Integer id = 1;
        Mockito.when(facturaRepository.findById(id)).thenReturn(Optional.of(factura));

        FacturaDTO result = facturaService.obtenerFactura(id);
        assertNotNull(result);
}
}
