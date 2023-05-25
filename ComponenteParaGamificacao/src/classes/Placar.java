package classes;
import java.util.List;

public class Placar {
    private Armazenamento armazenamento;

    public Placar(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void registrarPontos(String usuario, String tipoPonto, int quantidade) {
        armazenamento.armazenarPontos(usuario, tipoPonto, quantidade);
    }

    public int getPontos(String usuario, String tipoPonto) {
        return armazenamento.recuperarPontos(usuario, tipoPonto);
    }

    public List<String> getUsuarios() {
        return armazenamento.recuperarUsuarios();
    }

    public List<String> getTiposPontos(String usuario) {
        return armazenamento.recuperarTiposPontos(usuario);
    }

    public List<String> getRanking(String tipoPonto) {
        return armazenamento.recuperarRanking(tipoPonto);
    }
}



