package pSABbyCRC_UnitTestingSuite;

import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class RegistraUsuarioTest {

    private RegistrarUsuario registrarUsuario;

    @Before
    public void setUp() {
        registrarUsuario = new RegistrarUsuario();
    }

    @Test
    public void testRegistraUsuarioNomeVazio() {
        assertThrows(UsuarioComNomeVazioException.class, () -> registrarUsuario.registraUsuario(""));
    }

    @Test
    public void testRegistraUsuarioJaRegistrado() throws Exception {
        registrarUsuario.registraUsuario("Maria");
        assertThrows(UsuarioJaRegistradoException.class, () -> registrarUsuario.registraUsuario("Maria"));
    }

    @Test
    public void testRegistraUsuarioInexistente() {
       assertThrows(UsuarioInexistenteException.class, () -> registrarUsuario.registraUsuario(null));
    }
}
