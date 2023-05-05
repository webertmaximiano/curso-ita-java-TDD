import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	private static List<Usuario> listaDeUsuarios = new ArrayList<>();
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

	public static List<Usuario> getUsuarios() {
        return listaDeUsuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Usuario.listaDeUsuarios = usuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registraUsuario() throws UsuarioJaRegistradoException, UsuarioComNomeVazioException, UsuarioInexistenteException {
        if (Objects.isNull(nome)) {
            throw new UsuarioInexistenteException("---> Não é possível registrar um usuário inexistente");
        } else if (nome.isEmpty()) {
            throw new UsuarioComNomeVazioException("---> Nome do usuário não pode ser vazio");
        } else {
            Usuario usuario = new Usuario(nome);
            if (listaDeUsuarios.contains(usuario)) {
                throw new UsuarioJaRegistradoException("---> Já existe usuário com o nome \"" + nome + "\"! Use outro nome!");
            } else {
                listaDeUsuarios.add(usuario);
            }
        }
    }
}

