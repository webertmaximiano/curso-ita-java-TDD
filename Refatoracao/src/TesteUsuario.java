import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import exceptions.UsuarioInexistenteException;
class TesteUsuario {

		
	@Test
	void testRegistraUsuarioComNomeVazio() {
	    Usuario usuario = new Usuario("");
	    assertThrows(UsuarioComNomeVazioException.class, () -> {
	        usuario.registraUsuario();
	    });
	}
	
	@Test
	    public void testRegistraUsuarioComNomeNulo() throws UsuarioInexistenteException, Exception, Throwable {
		Usuario usuario = new Usuario(null);
	        usuario.setNome(null);
	        usuario.registraUsuario();
	        assertThrows(UsuarioInexistenteException.class, () -> {
		        usuario.registraUsuario();
		    });
	    }
}
