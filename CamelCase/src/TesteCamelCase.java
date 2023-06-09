		import static org.junit.Assert.*;
		import java.util.Arrays;
		import java.util.List;
		
		import org.junit.Test;
		
		public class TesteCamelCase {
		       
		    @Test
		    public void ConverterCamelCaseParaLista() {
		        String palavra = "webert";
		        List<String> lista = Arrays.asList("webert");
		        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra); // invocando um metodo estatico Classe.metodo()
		        System.out.println("Teste nome:"+resultado);
		        assertEquals(lista, resultado);
		    }
		    @Test
		    public void ConverterCamelCaseParaListaPrimeiraLetraMaiuscula() {
		        String palavra = "Webert";
		        List<String> lista = Arrays.asList("Webert");
		        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
		        System.out.println("Teste Nome:"+resultado);
		        assertEquals(lista, resultado);
		    }
		    
		    @Test
		    public void ConverterCamelCaseParaListaNomeComposto() {
		        String palavra = "webertMaximiano";
		        List<String> lista = Arrays.asList("webert", "maximiano");
		        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
		        System.out.println("Teste nomeComposto:"+resultado);
		        assertEquals(lista, resultado);
		    }
		    
		    @Test
		    public void ConverterCamelCaseParaListaNomeCompostoIniciaisMaiusculas() {
		        String palavra = "WebertMaximiano";
		        List<String> lista = Arrays.asList("webert", "maximiano");
		        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
		        System.out.println("Teste NomeComposto:"+resultado);
		        assertEquals(lista, resultado);
		    }
		    
		    @Test
		    public void ConverterCamelCaseParaListaCPF() {
		        String palavra = "CPF";
		        List<String> lista = Arrays.asList("CPF");
		        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
		        System.out.println(resultado);
		        assertEquals(lista, resultado);
		    }
		    
	    @Test
	    public void ConverterCamelnumeroCPF() {
	        String palavra = "numeroCPF";
	        List<String> lista = Arrays.asList("numero", "CPF");
	        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
	        System.out.println("Teste numeroCPF:"+resultado);
	        assertEquals(lista, resultado);
	    }
	    
	    @Test
	    public void ConverterCamelnumeroCPFContribuinte() {
	        String palavra = "numeroCPFContribuinte";
	        List<String> lista = Arrays.asList("numero", "CPF", "Contribuinte");
	        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
	        System.out.println("Teste numeroCPFContribuinte:"+resultado);
	        assertEquals(lista, resultado);
	    }
	    
	    @Test
	    public void ConverterCamelrecupera10Primeiros() {
	        String palavra = "recupera10Primeiros";
	        List<String> lista = Arrays.asList("recupera", "10", "Primeiros");
	        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
	        System.out.println("Teste recupera10Primeiros:"+resultado);
	        assertEquals(lista, resultado);
	    }
	    
	    @Test
	    public void ConverterCamel10Primeiros() {
	        String palavra = "10Primeiros";
	        List<String> lista = Arrays.asList("Inválido → não deve começar com números");
	        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
	        System.out.println("Teste 10Primeiros:"+resultado);
	        assertEquals(lista, resultado);
	    }
	    
	    @Test
	    public void ConverterCamelnomeCompostoCaractereEspecial() {
	        String palavra = "nome#Composto";
	        List<String> lista = Arrays.asList("Inválido → caracteres especiais não são permitidos, somente letras e números");
	        List<String> resultado = ConversorDePalavras.converterCamelCase(palavra);
	        System.out.println("Teste recupera10Primeiros:"+resultado);
	        assertEquals(lista, resultado);
	    }
	    
	}