package classes;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Cria uma instância do Armazenamento
        Armazenamento armazenamento = new Armazenamento("dados.xml");

        // Armazena pontos para alguns usuários
        armazenamento.armazenarPontos("usuario1", "estrela", 5);
        armazenamento.armazenarPontos("usuario1", "moeda", 10);
        armazenamento.armazenarPontos("usuario2", "estrela", 8);
        armazenamento.armazenarPontos("usuario3", "moeda", 3);

        // Recupera a quantidade de pontos do tipo "estrela" para o usuário "usuario1"
        int pontosEstrela = armazenamento.recuperarPontos("usuario1", "estrela");
        System.out.println("Pontos estrela do usuário usuario1: " + pontosEstrela);

        // Recupera a lista de usuários que receberam pontos
        List<String> usuarios = armazenamento.recuperarUsuarios();
        System.out.println("Usuários que receberam pontos: " + usuarios);

        // Recupera a lista de tipos de pontos registrados para o usuário "usuario1"
        List<String> tiposPontos = armazenamento.recuperarTiposPontos("usuario1");
        System.out.println("Tipos de pontos do usuário usuario1: " + tiposPontos);

        // Recupera o ranking de usuários por pontos do tipo "moeda"
        List<String> ranking = armazenamento.recuperarRanking("moeda");
        System.out.println("Ranking por pontos do tipo moeda: " + ranking);
    }
}
