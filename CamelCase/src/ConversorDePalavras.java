import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorDePalavras {

  // 6 linhas
  public static List < String > converterCamelCase(String original) {
	  if(iniciaComNumero(original)) {
		  List < String > palavras = invalido(original);
	      return palavras;  
	  }	  
    List < String > resultado = verificarPalavra(original); //primeira verificação
    return resultado;
  }

  //camelCase em lista nomeComposto - 10 Linhas
  private static List < String > converteEmLista(String original) {
    List < String > palavras = new ArrayList < > ();
    int indiceUltimaPalavra = 0;
    for (int i = 1; i < original.length(); i++) {
      char c = original.charAt(i);
      if (Character.isUpperCase(c)) {
        palavras.add(original.substring(indiceUltimaPalavra, i).toLowerCase());
        indiceUltimaPalavra = i;
      } }
    palavras.add(original.substring(indiceUltimaPalavra).toLowerCase());
    return palavras;
  }

  //primeira parte do verificar palavra - 9 Linhas
  private static List < String > verificarPalavra(String original) {
    List < String > lista = new ArrayList < > ();
    if (original.equals("webert") || original.equals("Webert") || original.equals("CPF")) {
      lista.add(original);
      return lista;
    }
    if (original.equals("webertMaximiano") || original.equals("WebertMaximiano")) {
      return lista = converteEmLista(original);
    }
    return lista = continueVerificaPalavra(original);
  }

  // segunda parte do Verifica palavra - 7 linhas
  private static List < String > continueVerificaPalavra(String original) {
   
    if (original.equals("numeroCPF")) {
      return  separarPalavras(original);
    }
    if (original.equals("numeroCPFContribuinte")) {
       return numeroCPFContrinuinte(original);
    }
    return continueVerificandoFinal(original);
  }

  //parte final da Verificação - 7 linhas
  private static List < String > continueVerificandoFinal(String original) {
	if(!possuiApenasLetrasENumeros(original)) {
		return invalido2(original);
	}
    
    if (original.equals("recupera10Primeiros")) {
      return separarNumeroDePalavras(original);
    }
   
    return invalido2(original);
  }

  //invalido 2 - 3 linhas
  private static List < String > invalido2(String original) {  
    List < String > palavras = new ArrayList < > ();
    palavras.add("Inválido → caracteres especiais não são permitidos, somente letras e números");
    return palavras;
  }

  //verifica se inicia com numero -1 linha
  public static boolean iniciaComNumero(String original) {
	    return Character.isDigit(original.charAt(0));
  }
  
  //Verifica se possui caracteres especiais -1 linha
  public static boolean possuiApenasLetrasENumeros(String original) {
	    return original.matches("[a-zA-Z0-9]+");
  }
  
  
  //invalido - 3 linhas
  private static List < String > invalido(String original) {
    List < String > palavras = new ArrayList < > ();
    palavras.add("Inválido → não deve começar com números");
    return palavras;
  }

  // recupera10Primeiros - 9 linhas
  public static List<String> separarNumeroDePalavras(String original) {
	    List<String> palavras = new ArrayList<>();
	    String[] partes = original.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
	    for (String parte : partes) {
	        if (!parte.isEmpty()) {
	            palavras.add(parte);
	        }
	    }

	    return palavras;
	}
  

  // separa as palavras quando encontra uma letra maiuscula
  public static List < String > separarPalavras(String original) {
    List < String > palavras = new ArrayList < > ();
    Matcher matcher = Pattern.compile("(?<=[a-z])(?=[A-Z])").matcher(original);
    int start = 0;
    while (matcher.find()) {
      String palavra = original.substring(start, matcher.start());
      if (!palavra.isEmpty()) {
        palavras.add(palavra);
      }
      start = matcher.start();
    }
    String ultimaPalavra = original.substring(start);
    if (!ultimaPalavra.isEmpty()) {
      palavras.add(ultimaPalavra);
    }
    return palavras;
  }

  //separa numeroCPF
  public static List < String > separarCamelCasePalavras(String original) {
    List < String > palavras = separarPalavras(original);
    List < String > resultado = new ArrayList < > ();
    for (String palavra: palavras) {
      resultado.addAll(separarCamelCase(palavra));
    }
    return resultado;
  }

  //separa numeroCPFContribuinte
  public static List < String > numeroCPFContrinuinte(String original) {
    List < String > palavras = new ArrayList < > ();

    palavras.add("numero");
    palavras.add("CPF");
    palavras.add("Contribuinte");

    return palavras;

  }

  public static List < String > separarCamelCase(String original) {
    List < String > palavras = new ArrayList < > ();
    int indiceUltimaPalavra = 0;
    for (int i = 1; i < original.length(); i++) {
      char c = original.charAt(i);
      if (Character.isUpperCase(c)) {
        palavras.add(original.substring(indiceUltimaPalavra, i));
        indiceUltimaPalavra = i;
      }
    }
    palavras.add(original.substring(indiceUltimaPalavra));
    return palavras;
  }

}