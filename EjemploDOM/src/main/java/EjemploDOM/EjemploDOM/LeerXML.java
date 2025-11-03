package EjemploDOM.EjemploDOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {
	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
		
			
			File dir = new File("ejemplo7");
			
			Document document = builder.parse(new File(dir, "jugadores.xml"));
			document.getDocumentElement().normalize();
			
			Element raiz = document.getDocumentElement();
			
			NodeList hijosRaiz = raiz.getChildNodes();
			
			for(int i=0; i<hijosRaiz.getLength(); i++) {
				Node nodo = hijosRaiz.item(i);			
				/*if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element jugador = (Element)nodo;
					
					System.out.println(jugador.getNodeName()+"-> "+jugador.getAttribute("id"));
					
					Node hijo = jugador.getFirstChild();
					
					do {
						if(hijo.getNodeType() == Node.ELEMENT_NODE) {
							Element nombre = (Element)hijo;
							System.out.println(nombre.getNodeName()+": "+nombre.getTextContent());
						
						}
					} while((hijo = hijo.getNextSibling()) != null);
				}*/
				
				leer(nodo, "\t");
				
			}
				
			
			
			System.out.println("Total elementos: "+hijosRaiz.getLength());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void leer(Node nodo, String tab) {
		if(nodo.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element)nodo;
			
			if(nodo.hasChildNodes() && nodo.getFirstChild().getNodeType() == Node.TEXT_NODE && nodo.getChildNodes().getLength() == 1) {
				System.out.println(tab+"Etiqueta: "+nodo.getNodeName()+" Contenido: "+nodo.getFirstChild().getTextContent());
				
				atributos(nodo, tab);
			}
			else if(nodo.hasChildNodes()) {
				System.out.println(tab+"Etiqueta: " + nodo.getNodeName());
				Node hijo = nodo.getFirstChild();
				do {
					leer(hijo, tab +"\t");
				}while((hijo = hijo.getNextSibling())!=null);
			}
		}
	}
	
	public static void atributos(Node nodo, String tab) {
		NamedNodeMap att = nodo.getAttributes();
		
		for(int i=0; i<att.getLength(); i++) {
			System.out.println(tab + att.item(i));
		}
	}
}
