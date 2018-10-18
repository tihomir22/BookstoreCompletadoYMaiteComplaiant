/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Constantes;
import controlador.ControlBookstore;
import controlador.ControlDom;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import modelo.Bookstore;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class BookstoreProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        Scanner teclado = new Scanner(System.in);
        ControlDom ctrlDoc = new ControlDom();
        Constantes cons = new Constantes();
        ControlBookstore cb = new ControlBookstore();
        Document doc = null;
        Document docNuevo = null;
        Bookstore bs = null;
        Bookstore bs2 = null;
        int opcion = 999;
        String ruta = "", rutafinal = null;
        while (opcion != 0) {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce ruta del fichero o dejalo en blanco usar la por defecto");
                    ruta = teclado.nextLine();
                    if (ruta != "") {
                        doc = ctrlDoc.deXMLaDOM(doc, new File("bookstore.xml"));
                    } else {
                        doc = ctrlDoc.deXMLaDOM(doc, new File(ruta));
                    }
                    break;
                case 2:
                    bs = new Bookstore();
                    bs = cb.leerBookstore(doc);
                    break;
                case 3:
                    bs.imprimirBS();
                    break;
                case 4:
                    bs2 = new Bookstore();
                    bs2 = cons.altaBookStore(bs2);
                    bs2.imprimirBS();
                    break;
                case 5:
                    docNuevo = ctrlDoc.instanciarDocumento(docNuevo);
                    Element raiz = docNuevo.createElement("bookstore");
                    docNuevo.appendChild(raiz);
                    System.out.println("Mi raiz es  " + docNuevo.getDocumentElement().getTagName());
                    cb.escribirBookstore(docNuevo, bs2, raiz);
                    System.out.println("DOM GENERADO CON EXITO");
                    break;
                case 6:
                    rutafinal = teclado.nextLine();
                    break;
                case 7:
                    ctrlDoc.deDOMaXML(docNuevo, new File(rutafinal));
                    break;
            }
        }

    }

    public static void mostrarMenu() {
        System.out.println("1.-Seleccionar un fichero xml a recuperar y crea un document");
        System.out.println("2.-Lee del documento y crea un objeto BookStore");
        System.out.println("3.-Mostrar objeto BookStore");
        System.out.println("4.-Crear un objeto BookStore y añadir libros de ejemplo");
        System.out.println("5.-Escribir el objeto bookstore creado en un documento nuevo");
        System.out.println("6.-Introduce ruta final del fichero");
        System.out.println("7.-GUARDAR");
    }
}
