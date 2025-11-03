package EjemploSAX;

import java.io.File;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class LeerConSAX {
	public static void main(String[] args) {
		
		XMLReader xml;
		
		try {
			
			xml = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			
			Eventos event = new Eventos();
			
			xml.setContentHandler(event);
			
			InputSource fileXML = new InputSource("ejemplo7//jugadores.xml");
			
			xml.parse(fileXML);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
