package EjemploDOM.EjemploDOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Hello world!
 *
 */
public class EscribirXML 
{
    public static void main(String[] args )
    {
        
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
    	try {
    		DocumentBuilder builder = factory.newDocumentBuilder();
    		DOMImplementation imp = builder.getDOMImplementation();
    		
    		
    		Document doc = imp.createDocument(null, "jugadores", null);
    		doc.setXmlVersion("1.0");
    		
    		Node raiz = doc.getFirstChild();
    		
    		Element jugador = creaElemento("jugador", raiz, doc);
    		creaElementoConTexto("nombre", "pepe", jugador, doc);
    		creaElementoConTexto("posicion", "delantero", jugador, doc);
    		creaElementoConTexto("edad", "25", jugador, doc);
    		
    		Element jugador2 = creaElemento("jugador", raiz, doc);
    		creaElementoConTexto("nombre", "david", jugador2, doc);
    		creaElementoConTexto("posicion", "portero", jugador2, doc);
    		creaElementoConTexto("edad", "35", jugador2, doc);
    		
    		
    		DOMSource source = new DOMSource(doc);
    		
    		File dir = new File("ejemplo7");
    		if(!dir.exists()) {
    			dir.mkdir();
    		}
    		
    		Result result = new StreamResult(new File(dir, "jugadores.xml"));
    		Transformer transformer = TransformerFactory.newInstance().newTransformer();
    		transformer.transform(source, result);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public static Element creaElementoConTexto(String etiqueta, String text, Element padre, Document doc) {
    	Element element = doc.createElement(etiqueta);
		
		padre.appendChild(element);
		
		Text textNombre = doc.createTextNode(text);
		
		element.appendChild(textNombre);
		
		return element;
    }
    
    public static Element creaElemento(String etiqueta, Node raiz, Document doc) {
    	Element element = doc.createElement(etiqueta);
    	raiz.appendChild(element);
    	return element;
    }
}
