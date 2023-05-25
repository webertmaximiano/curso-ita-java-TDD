package classes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TestClasseArmazenamento {
    private Armazenamento armazenamento;

    @Before
    public void setUp() {
        // Inicialização do Armazenamento antes de cada teste
        armazenamento = new Armazenamento("dados.xml");
    }

    @Test
    public void testArmazenarPontos() {
        String usuario = "guerra";
        String tipoPonto = "estrela";
        int quantidade = 10;

        // Armazena que o usuário "guerra" recebeu 10 pontos do tipo "estrela"
        armazenamento.armazenarPontos(usuario, tipoPonto, quantidade);

        // Verifica se a quantidade de pontos foi armazenada corretamente
        int pontosArmazenados = armazenamento.recuperarPontos(usuario, tipoPonto);
        assertEquals(quantidade, pontosArmazenados);
    }

    @Test
    public void testRecuperarPontos() {
        String usuario = "guerra";
        String tipoPonto = "estrela";
        int quantidade = 15;

        // Armazena que o usuário "guerra" recebeu 15 pontos do tipo "estrela"
        armazenamento.armazenarPontos(usuario, tipoPonto, quantidade);

        // Recupera a quantidade de pontos do tipo "estrela" para o usuário "guerra"
        int pontosRecuperados = armazenamento.recuperarPontos(usuario, tipoPonto);

        // Verifica se a quantidade de pontos foi recuperada corretamente
        assertEquals(quantidade, pontosRecuperados);
    }

    @Test
    public void testRecuperarUsuarios() {
        String usuario1 = "guerra";
        String usuario2 = "fernandes";

        // Armazena pontos para os usuários "guerra" e "fernandes"
        armazenamento.armazenarPontos(usuario1, "estrela", 10);
        armazenamento.armazenarPontos(usuario2, "moeda", 5);

        // Recupera a lista de usuários que receberam pontos
        List<String> usuarios = armazenamento.recuperarUsuarios();

        // Verifica se ambos os usuários estão presentes na lista
        assertTrue(usuarios.contains(usuario1));
        assertTrue(usuarios.contains(usuario2));
    }

    @Test
    public void testRecuperarTiposPontos() {
        String usuario = "guerra";
        String tipoPonto1 = "estrela";
        String tipoPonto2 = "moeda";

        // Armazena pontos do tipo "estrela" e "moeda" para o usuário "guerra"
        armazenamento.armazenarPontos(usuario, tipoPonto1, 10);
        armazenamento.armazenarPontos(usuario, tipoPonto2, 5);

        // Recupera a lista de tipos de pontos registrados para o usuário
        List<String> tiposPontos = armazenamento.recuperarTiposPontos(usuario);

        // Verifica se ambos os tipos de pontos estão presentes na lista
        assertTrue(tiposPontos.contains(tipoPonto1));
        assertTrue(tiposPontos.contains(tipoPonto2));
    }
}
