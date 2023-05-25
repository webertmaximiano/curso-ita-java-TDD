package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.com.webert.componentedegamificacao.classes.Armazenamento;
import src.main.java.com.webert.componentedegamificacao.classes.Placar;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.*;

public class ArmazenamentoClassTest {

        private Placar placar;
        private Armazenamento mockArmazenamento;

        @BeforeEach
        void setUp() {
            mockArmazenamento = mock(Armazenamento.class);
            placar = new Placar(mockArmazenamento);
        }


        @Test
        void registrarPonto_deveChamarMetodoArmazenarPontosDoArmazenamento() {
            placar.registrarPonto("guerra", "estrela", 10);
            verify(mockArmazenamento).armazenarPontos("guerra", "estrela", 10);
        }

        @Test
        void consultarPontos_deveChamarMetodoRecuperarQuantidadePontosDoArmazenamento() {
            placar.consultarPontos("guerra", "estrela");
            verify(mockArmazenamento).recuperarQuantidadePontos("guerra", "estrela");
        }
}

