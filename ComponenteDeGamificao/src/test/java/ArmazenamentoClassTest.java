import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmazenamentoClassTest {
    private Armazenamento armazenamento;
    private static final String TEST_FILE_PATH = "caminho/para/o/arquivo_test.xml";

    @BeforeEach
    void setUp() {
        armazenamento = new Armazenamento();
        armazenamento.setFilePath(TEST_FILE_PATH);
        // Remover o arquivo de teste, se existir
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void armazenarPontos_deveAdicionarNovoUsuarioComPontos() {
        armazenamento.armazenarPontos("guerra", "estrela", 10);
        int quantidadePontos = armazenamento.recuperarQuantidadePontos("guerra", "estrela");
        assertEquals(10, quantidadePontos);
    }

    @Test
    void armazenarPontos_deveAtualizarQuantidadeDePontosExistente() {
        armazenamento.armazenarPontos("guerra", "estrela", 10);
        armazenamento.armazenarPontos("guerra", "estrela", 5);
        int quantidadePontos = armazenamento.recuperarQuantidadePontos("guerra", "estrela");
        assertEquals(15, quantidadePontos);
    }

    @Test
    void recuperarQuantidadePontos_deveRetornarZeroQuandoUsuarioNaoExistir() {
        int quantidadePontos = armazenamento.recuperarQuantidadePontos("guerra", "estrela");
        assertEquals(0, quantidadePontos);
    }

    @Test
    void recuperarQuantidadePontos_deveRetornarZeroQuandoTipoPontoNaoExistir() {
        armazenamento.armazenarPontos("guerra", "estrela", 10);
        int quantidadePontos = armazenamento.recuperarQuantidadePontos("guerra", "moeda");
        assertEquals(0, quantidadePontos);
    }

    @Test
    void retornarUsuariosComPontos_deveRetornarListaUsuariosComPontos() {
        armazenamento.armazenarPontos("guerra", "estrela", 10);
        armazenamento.armazenarPontos("joao", "estrela", 5);
        List<String> usuariosComPontos = armazenamento.retornarUsuariosComPontos();
        assertEquals(2, usuariosComPontos.size());
        assertTrue(usuariosComPontos.contains("guerra"));
        assertTrue(usuariosComPontos.contains("joao"));
    }

    @Test
    void retornarUsuariosComPontos_deveRetornarListaVaziaQuandoNenhumUsuarioTiverPontos() {
        List<String> usuariosComPontos = armazenamento.retornarUsuariosComPontos();
        assertEquals(0, usuariosComPontos.size());
    }

    @Test
    void retornarTiposPontosRegistrados_deveRetornarListaTiposPontosRegistrados() {
        armazenamento.armazenarPontos("guerra", "estrela", 10);
        armazenamento.armazenarPontos("joao", "moeda", 5);
        List<String> tiposPontosRegistrados = armazenamento.retornarTiposPontosRegistrados();
        assertEquals(2, tiposPontosRegistrados.size());
        assertTrue(tiposPontosRegistrados.contains("estrela"));
        assertTrue(tiposPontosRegistrados.contains("moeda"));
    }

    @Test
    void retornarTiposPontosRegistrados_deveRetornarListaVaziaQuandoNenhumTipoPontoRegistrado() {
        List<String> tiposPontosRegistrados = armazenamento.retornarTiposPontosRegistrados();
        assertEquals(0, tiposPontosRegistrados.size());
    }
}
