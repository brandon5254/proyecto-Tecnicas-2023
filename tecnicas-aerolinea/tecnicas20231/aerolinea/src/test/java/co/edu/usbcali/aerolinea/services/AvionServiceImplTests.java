package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.AvionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AvionServiceImplTests {

    @Autowired
    private AvionService avionService;

    @Test
    public void testObtenerAviones() {
        List<AvionDTO> aviones = avionService.obtenerAviones();
        Assertions.assertNotNull(aviones);
        Assertions.assertFalse(aviones.isEmpty());
    }

    @Test
    public void testObtenerAvion() throws Exception {
        // Se asume que hay al menos un avión en la base de datos con id = 1
        Integer id = 1;
        AvionDTO avion = avionService.obtenerAvion(id);
        Assertions.assertNotNull(avion);
        Assertions.assertEquals(id, avion.getIdAvion());

        // Verificar que la excepción se lanza correctamente cuando se busca un id inexistente
        Assertions.assertThrows(Exception.class, () -> {
            avionService.obtenerAvion(-1);
   });
}
}
