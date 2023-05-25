package classes;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class TestClassePlacar {
    private Placar placar;
    private Armazenamento armazenamentoMock;

    @Before
    public void setUp() {
        // Inicialização do Placar e do mock de Armazenamento antes de cada teste
        armazenamentoMock = mock(Armazenamento.class);
        placar = new Placar(armazenamentoMock);
    }

    @Test
    public void testRegistrarPontos() {
        String usuario = "guerra";
        String tipoPonto = "estrela";
        int quantidade = 10;

        // Registra que o usuário "guerra" recebeu 10 pontos do tipo "estrela"
        placar.registrarPontos(usuario, tipoPonto, quantidade);

        // Verifica se o método correspondente em Armazenamento foi chamado corretamente
        verify(armazenamentoMock).armazenarPontos(usuario, tipoPonto, quantidade);
    }

    @Test
    public void testRecuperarPontos() {
        String usuario = "guerra";
        String tipoPonto1 = "estrela";
        String tipoPonto2 = "moeda";

        // Configura o mock de Armazenamento para retornar a quantidade de pontos esperada
        when(armazenamentoMock.recuperarPontos(usuario, tipoPonto1)).thenReturn(10);
        when(armazenamentoMock.recuperarPontos(usuario, tipoPonto2)).thenReturn(5);

        // Recupera os pontos do usuário "guerra"
        int pontosEstrela = placar.getPontos(usuario, tipoPonto1);
        int pontosMoeda = placar.getPontos(usuario, tipoPonto2);

        // Verifica se as quantidades de pontos retornadas são as esperadas
        assertEquals(10, pontosEstrela);
        assertEquals(5, pontosMoeda);
    }

    @Test
    public void testRecuperarRanking() {
        String tipoPonto = "estrela";
        List<String> usuarios = Arrays.asList("guerra", "fernandes", "rodrigo");
        List<Integer> pontos = Arrays.asList(25, 19, 17);

        // Configura o mock de Armazenamento para retornar a lista de usuários e pontos esperados
        when(armazenamentoMock.recuperarUsuarios()).thenReturn(usuarios);
        for (int i = 0; i < usuarios.size(); i++) {
            when(armazenamentoMock.recuperarPontos(usuarios.get(i), tipoPonto)).thenReturn(pontos.get(i));
        }

        // Recupera o ranking do tipo de ponto "estrela"
        List<String> ranking = placar.getRanking(tipoPonto);

        // Verifica se o ranking retornado é o esperado
        assertEquals(usuarios, ranking);
    }
}
