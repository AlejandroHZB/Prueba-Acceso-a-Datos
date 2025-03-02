import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class EntradaLectura {
    public static void main(String[] args) {
        //gestor
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //lector
        try {
            DocumentBuilder lector = builderFactory.newDocumentBuilder();
            Document document = lector.parse(new File("src/main/java/peliculas.xml"));
            Node nodoRaiz = document.getDocumentElement();
            NodeList nodeList = nodoRaiz.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Node nodoTitulo = node.getAttributes().getNamedItem("titulo");
                    System.out.println(nodoTitulo.getTextContent());

                }

            }


        } catch (ParserConfigurationException e) {
            System.out.println("Error en el parseo");
        } catch (IOException | SAXException e) {
            System.out.println("Error en el parseo");
        }


    }
}
