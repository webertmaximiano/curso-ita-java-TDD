package classes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Armazenamento implements ArmazenamentoInterface {
    private Map<String, Map<String, Integer>> pontosUsuarios;
    private String arquivo;

    public Armazenamento(String arquivo) {
        this.pontosUsuarios = new HashMap<>();
        this.arquivo = arquivo;
        carregarArquivo();
    }

    @Override
    public void armazenarPontos(String usuario, String tipoPonto, int quantidade) {
        Map<String, Integer> pontosUsuario = pontosUsuarios.getOrDefault(usuario, new HashMap<>());
        pontosUsuario.put(tipoPonto, quantidade);
        pontosUsuarios.put(usuario, pontosUsuario);
        salvarArquivo();
    }

    @Override
    public int recuperarPontos(String usuario, String tipoPonto) {
        Map<String, Integer> pontosUsuario = pontosUsuarios.get(usuario);
        if (pontosUsuario != null) {
            Integer pontos = pontosUsuario.get(tipoPonto);
            if (pontos != null) {
                return pontos;
            }
        }
        return 0;
    }

    @Override
    public List<String> recuperarUsuarios() {
        return new ArrayList<>(pontosUsuarios.keySet());
    }

    @Override
    public List<String> recuperarTiposPontos(String usuario) {
        Map<String, Integer> pontosUsuario = pontosUsuarios.get(usuario);
        if (pontosUsuario != null) {
            return new ArrayList<>(pontosUsuario.keySet());
        }
        return new ArrayList<>();
    }

    private void salvarArquivo() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("pontos");
            doc.appendChild(rootElement);

            for (Map.Entry<String, Map<String, Integer>> entry : pontosUsuarios.entrySet()) {
                String usuario = entry.getKey();
                Map<String, Integer> pontosUsuario = entry.getValue();

                Element usuarioElement = doc.createElement("usuario");
                usuarioElement.setAttribute("nome", usuario);
                rootElement.appendChild(usuarioElement);

                for (Map.Entry<String, Integer> pontosEntry : pontosUsuario.entrySet()) {
                    String tipoPonto = pontosEntry.getKey();
                    int quantidade = pontosEntry.getValue();

                    Element pontoElement = doc.createElement("ponto");
                    pontoElement.setAttribute("tipo", tipoPonto);
                    pontoElement.setTextContent(String.valueOf(quantidade));
                    usuarioElement.appendChild(pontoElement);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            File file = new File(arquivo);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void carregarArquivo() {
        try {
            File file = new File(arquivo);
            if (!file.exists()) {
                return;
            }

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList usuarioList = doc.getElementsByTagName("usuario");

            for (int i = 0; i < usuarioList.getLength(); i++) {
                Node usuarioNode = usuarioList.item(i);
                if (usuarioNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element usuarioElement = (Element) usuarioNode;
                    String usuario = usuarioElement.getAttribute("nome");

                    Map<String, Integer> pontosUsuario = new HashMap<>();

                    NodeList pontoList = usuarioElement.getElementsByTagName("ponto");

                    for (int j = 0; j < pontoList.getLength(); j++) {
                        Node pontoNode = pontoList.item(j);
                        if (pontoNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element pontoElement = (Element) pontoNode;
                            String tipoPonto = pontoElement.getAttribute("tipo");
                            int quantidade = Integer.parseInt(pontoElement.getTextContent());
                            pontosUsuario.put(tipoPonto, quantidade);
                        }
                    }

                    pontosUsuarios.put(usuario, pontosUsuario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> recuperarRanking(String tipoPonto) {
        List<String> ranking = new ArrayList<>();

        // Filtra os usuários que possuem pontos do tipoPonto
        List<String> usuariosComPontos = pontosUsuarios.keySet().stream()
                .filter(u -> pontosUsuarios.get(u).containsKey(tipoPonto))
                .collect(Collectors.toList());

        // Ordena os usuários em ordem decrescente de pontos do tipoPonto
        usuariosComPontos.sort((u1, u2) -> {
            int pontosU1 = pontosUsuarios.get(u1).getOrDefault(tipoPonto, 0);
            int pontosU2 = pontosUsuarios.get(u2).getOrDefault(tipoPonto, 0);
            return Integer.compare(pontosU2, pontosU1);
        });

        ranking.addAll(usuariosComPontos);

        return ranking;
    }
}
