import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteCarrinhoCompra {

	@Test
	public void totalCarrinho() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		c.adicionaProduto(new Produto("tenis", 100));
		c.adicionaProduto(new Produto("camiseta", 50));
		c.adicionaProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}
	
	@Test
	public void escutaAdicaoDeProduto() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock = new MockObservadorCarrinho();
		c.adicionaObservador(mock);
		c.adicionaProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void adicinarDoisObservador() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		c.adicionaObservador(mock1);
		c.adicionaObservador(mock2);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock2.verificaRecebimentoProduto("tenis", 100);
	}
	
	@Test
	public void continuaAposError() {
		CarrinhoDeCompras c = new CarrinhoDeCompras();
		MockObservadorCarrinho mock1 = new MockObservadorCarrinho();
		MockObservadorCarrinho mock2 = new MockObservadorCarrinho();
		mock2.queroQueFalha();
		MockObservadorCarrinho mock3 = new MockObservadorCarrinho();
		c.adicionaObservador(mock1);
		c.adicionaObservador(mock2);
		c.adicionaObservador(mock3);
		c.adicionaProduto(new Produto("tenis", 100));
		mock1.verificaRecebimentoProduto("tenis", 100);
		mock3.verificaRecebimentoProduto("tenis", 100);
	}
}
