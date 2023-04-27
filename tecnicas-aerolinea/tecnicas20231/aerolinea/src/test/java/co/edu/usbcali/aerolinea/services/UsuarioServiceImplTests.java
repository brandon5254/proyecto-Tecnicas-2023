package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.dtos.UsuarioDTO;
import co.edu.usbcali.aerolinea.model.Usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.aerolinea.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class UsuarioServiceImplTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testObtenerUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setUsuaId(1);
        usuario1.setNombre("Juan");
        listaUsuarios.add(usuario1);
        Usuario usuario2 = new Usuario();
        usuario2.setUsuaId(2);
        usuario2.setNombre("Maria");
        listaUsuarios.add(usuario2);

        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        List<UsuarioDTO> listaUsuariosDTO = usuarioService.obtenerUsuarios();
        assertEquals(0, listaUsuariosDTO.size());
        assertEquals("brandon", listaUsuariosDTO.get(0).getNombre());
        assertEquals("Angel", listaUsuariosDTO.get(1).getNombre());
    }

    @Test
    public void testObtenerUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsuaId(1);
        usuario.setNombre("brandon");

        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuario(1);
        assertEquals("brandon", usuarioDTO.getNombre());
    }

    @Test(expected = Exception.class)
    public void testObtenerUsuarioNoExiste() throws Exception {
        when(usuarioRepository.findById(10)).thenReturn(Optional.empty());

        usuarioService.obtenerUsuario(1);
    }
}
