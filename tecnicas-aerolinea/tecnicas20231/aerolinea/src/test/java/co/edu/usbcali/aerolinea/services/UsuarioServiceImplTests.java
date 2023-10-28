package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.model.RolUsuario;
import co.edu.usbcali.aerolinea.dtos.UsuarioDTO;
import co.edu.usbcali.aerolinea.repository.RolUsuarioRepository;
import co.edu.usbcali.aerolinea.repository.UsuarioRepository;
import co.edu.usbcali.aerolinea.services.UsuarioServiceImplTests;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import co.edu.usbcali.aerolinea.model.Usuario;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;

@SpringBootTest
public class UsuarioServiceImplTests {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private RolUsuarioRepository rolUsuarioRepository;
    @Mock
    private ModelMapper modelMapper;

    @Test
    public void agregarUsuarioTest() throws Exception {
        //Definimos las variables a utilizar
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .estado("Activo")
                .nombre("Jorge")
                .correo("jorge@gmail.com")
                .cedula("1122334455")
                .apellido("garcia")
                .idRolUsuario(1)
                .usuaId(1)
                .build();

        RolUsuario rolUsuario = RolUsuario.builder()
                .estado("Activo")
                .descripcion("ADMIN")
                .rousId(1).build();

        Usuario guardaUsuario = Usuario.builder()
                .idRolUsuario(rolUsuario)
                .apellido("garcia")
                .cedula("1122334455")
                .correo("jorge@gmail.com")
                .estado("Activo")
                .nombre("Jorge")
                .usuaId(1)
                .build();

        //Mockeamos las llamadas necesarias dentro del bean a probar
        given(usuarioRepository.findById(1)).willReturn(Optional.empty());
        given(rolUsuarioRepository.findById(1)).willReturn(Optional.of(rolUsuario));
        given(usuarioRepository.save(any(Usuario.class))).willReturn(guardaUsuario);

        //Llamamos al metodo del bean principal
        UsuarioDTO usuarioGuardado = usuarioService.agregarUsuario(usuarioDTO);

        //Validamos las respuestas
        assertEquals(usuarioDTO.getNombre(), usuarioGuardado.getNombre());

    }

    @Test
    public void obtenerUsuarioTest() throws Exception {
        RolUsuario rolUsuario = RolUsuario.builder()
                .estado("Activo")
                .descripcion("ADMIN")
                .rousId(1).build();

        Usuario usuario = Usuario.builder()
                .idRolUsuario(rolUsuario)
                .apellido("garcia")
                .cedula("1122334455")
                .correo("jorge@gmail.com")
                .estado("Activo")
                .nombre("Jorge")
                .usuaId(1)
                .build();
        given(usuarioRepository.findById(1)).willReturn(Optional.of(usuario));

        UsuarioDTO usuarioConsultado = usuarioService.obtenerUsuario(1);

        assertEquals(usuarioConsultado.getNombre(), usuario.getNombre());
    }
    @Test
    public void ObtenerUsuariosTest()throws Exception{
        RolUsuario rolUsuario = RolUsuario.builder()
                .estado("Activo")
                .descripcion("ADMIN")
                .rousId(1).build();

        List<Usuario> usuariosRetorno = Arrays.asList(Usuario.builder()
                        .idRolUsuario(rolUsuario)
                        .apellido("garcia")
                        .cedula("1122334455")
                        .correo("jorge@gmail.com")
                        .estado("Activo")
                        .nombre("Jorge")
                        .usuaId(1)
                        .build(),
                Usuario.builder()
                        .idRolUsuario(rolUsuario)
                        .apellido("bello")
                        .cedula("66865345")
                        .correo("cristina@gmail.com")
                        .estado("Activo")
                        .nombre("cristina")
                        .usuaId(2)
                        .build());

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuariosRetorno);

        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();

        assertEquals(2, usuarios.size());
    }

}
