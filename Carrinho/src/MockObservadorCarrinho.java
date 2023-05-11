import static org.junit.Assert.assertEquals;

public class MockObservadorCarrinho implements ObservadorCarrinho{
	
	private String nomeRecebido;
	private int valorRecebido;
	private boolean falhar = false;

	@Override
	public void produtoAdicionado(String nome, int valor) {
		if (falhar)
			throw new RuntimeException("Problema simulado pelo mock");
		nomeRecebido = nome;
		valorRecebido = valor;
	}

	public void verificaRecebimentoProduto(String nomeEsperado, int valorEsperado) {
		assertEquals(nomeEsperado, nomeRecebido);
		assertEquals(valorEsperado, valorRecebido);
		
	}

	public void queroQueFalha() {
		falhar = true;
		
	}

	


}
