package pSABbyCRC_UnitTestingSuite;
import java.util.ArrayList;
import java.util.List;

public class RegistrarUsuario {
    private static List<Usuario> _usuarios = new ArrayList<>();

    public void registraUsuario(String nome)
            throws UsuarioJaRegistradoException, UsuarioComNomeVazioException,
            UsuarioInexistenteException {
        if (nome == null) {
            throw new UsuarioInexistenteException("---> Não é possível registrar um usuário inexistente");
        } else if (nome.isEmpty()) {
            throw new UsuarioComNomeVazioException("---> Nome do usuário não pode ser vazio");
        } else {
            Usuario usuario = new Usuario(nome);
            if (_usuarios.contains(usuario)) {
                throw new UsuarioJaRegistradoException("---> Já existe usuário com o nome \"" + nome + "\"! Use outro nome!");
            } else {
                _usuarios.add(usuario);
            }
        }
    }
}
