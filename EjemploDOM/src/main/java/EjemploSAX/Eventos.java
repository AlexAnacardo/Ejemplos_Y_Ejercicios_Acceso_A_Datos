package EjemploSAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Eventos extends DefaultHandler{
	public Eventos() {
		super();
	}
	
	public void startDocument() {
		System.out.println("Empiezo a leer");
	}
	
	public void endDocument() {
		System.out.println("Termino de leer");
	}
	
	public void startElement(String uri, String nombre, String nombreE, Attributes att) {
		System.out.println("Empiezo la etiqueta: " + nombreE);

		for(int i=0; i<att.getLength(); i++) {
			System.out.println(att.getLocalName(i)+" "+att.getValue(i).toString());
		}
	}
	
	public void endElement(String uri, String nombre, String nombreE) {
		System.out.println("Acabo la etiqueta: " + nombreE);
	}
	
	public void characters(char[] ch, int inicio, int longitud) {
		
		String interesa = new String(ch, inicio, longitud);
		
		if(ch[inicio]!='\n') {
			System.out.println(interesa);
			
		}		
	}
}
