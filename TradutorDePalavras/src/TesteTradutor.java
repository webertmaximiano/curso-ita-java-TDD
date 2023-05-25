
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TesteTradutor {
	
	private Tradutor t;
	
	@BeforeEach// executa antes de cada teste
	public void criaTradutor() {
		t= new Tradutor();
	}

	@Test
	public	void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		t.adicionaTraducao("bom", "good"); // adiciona palavras em t
		assertFalse(t.estaVazio());// verifica se t tá vazio
		assertEquals("good", t.traduzir("bom"));//verifca o metodo traduzir 
		
	}
	
	@Test
	public void duasTraducoes() {
		t.adicionaTraducao("bom", "good"); // adiciona palavras em t
		t.adicionaTraducao("mau", "bad");
		assertEquals("good", t.traduzir("bom"));//verifca o metodo traduzir
		assertEquals("bad", t.traduzir("mau"));
		
	}
	
	@Test
	public void duasTraducoesMesmaPalavra() {
		t.adicionaTraducao("bom", "good"); // adiciona palavras em t
		t.adicionaTraducao("bom", "nice");
		assertEquals("good, nice", t.traduzir("bom"));//verifca o metodo traduzir
		
	}
	
	@Test
	public void traduzirFrase() {
		t.adicionaTraducao("guerra", "war"); 
		t.adicionaTraducao("é", "is");
		t.adicionaTraducao("ruim", "bad");
		assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
		
	}

}
