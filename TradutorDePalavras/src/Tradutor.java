import java.util.HashMap;
import java.util.Map;


public class Tradutor {
	
	private Map<String,String> traducoes = new HashMap<>();

	public boolean estaVazio() {	
		return traducoes.isEmpty();
	}

	public void adicionaTraducao(String palavra, String traducao) {
		if (traducoes.containsKey(palavra)) {
			traducao = traduzir(palavra)+", "+traducao;
		}
		traducoes.put(palavra, traducao); //guarda a traducao
	}

	public String traduzir(String palavra) {
		return traducoes.get(palavra); //devolve a traducao
	}

	public String traduzirFrase(String frase) {
		String[] palavras = frase.split(" "); //coloca a frase em um array separando pelo espaço em branco
		String fraseTraduzida = "";
		for (String palavra : palavras) { //pega cada palavra do array palavras
			String traducao = primeiraTraducao(palavra);
			fraseTraduzida += " "+ traducao;
		}
		return fraseTraduzida.trim();//retirar os espaços vazios antes e depois
	}

	private String primeiraTraducao(String palavra) {
		String traducao = traduzir(palavra);
		if(traducao.contains(",")) // se o metodo traduzir retornar uma frase com virgula tem 2 traduçoes
			traducao = traducao.substring(0, traducao.indexOf(",")); // monta a frase com a primeira tradução, removendo depois da virgula
		return traducao;
	}

}















