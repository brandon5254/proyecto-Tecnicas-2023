package co.edu.usbcali.aerolinea.services;




import co.edu.usbcali.aerolinea.dtos.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.repository.RolUsuarioRepository;
import org.junit.jupiter.api.Test;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.springframework.boot.test.context.SpringBootTest;
        import java.util.List;
        import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RolUsuarioServiceImplTests {

    @Mock
    private RolUsuarioRepository rolUsuarioRepository;

    @Test
    public void testBuscartodos() {
        // Arrange
        List<RolUsuario> mockRolUsuarios = List.of(
                new RolUsuario("ADMIN", "Admin"),
                new RolUsuario("USER", "User")
        );
        Mockito.when(rolUsuarioRepository.findAll()).thenReturn(mockRolUsuarios);
        RolUsuarioServiceImpl rolUsuarioService = new RolUsuarioServiceImpl(rolUsuarioRepository);

        // Act
        List<RolUsuarioDTO> result = rolUsuarioService.buscartodos();

        // Assert
        assertEquals(result.size(), mockRolUsuarios.size());
    }
}
