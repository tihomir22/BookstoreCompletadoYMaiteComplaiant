/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class ControlDom {

    public ControlDom() {
    }

    public Document deXMLaDOM(Document doc, File archivo) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(archivo);
        System.out.println("Instanciado exitosamente");
        return doc;
    }

    public void deDOMaXML(Document doc, File file) throws TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(file);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
    }

    public Document instanciarDocumento(Document doc) throws ParserConfigurationException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.newDocument();
        return doc;
    }

    public static String getValorEtiqueta(String etiquetaARecuperar, Element item) {
        Node nValue = item.getElementsByTagName(etiquetaARecuperar).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();
    }

    public static Element getElementEtiqueta(String atributo, Element item) {
        return (Element) item.getElementsByTagName(atributo).item(0);
    }

}
