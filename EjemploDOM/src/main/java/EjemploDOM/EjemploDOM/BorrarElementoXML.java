package EjemploDOM.EjemploDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class BorrarElementoXML {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File dir = new File("ejemplo7");
			
			Document document = builder.parse(new File(dir, "jugadores.xml"));
			document.getDocumentElement().normalize();
			
			Element raiz = document.getDocumentElement();
			
			Node nodo = raiz.getFirstChild();
			
			
			do{
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					raiz.removeChild(nodo);
					break;
				}
			}while((nodo = nodo.getNextSibling()) != null);
				
			DOMSource source = new DOMSource(document);
			Result result = new StreamResult(new File(dir, "jugadores.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		}catch(Error e) {
			e.printStackTrace();
		
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
