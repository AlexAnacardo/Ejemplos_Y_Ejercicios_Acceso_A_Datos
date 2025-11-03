package Ejemplo10.Ejemplo10;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class EscribirJaxb {	

	public static void main(String[] args) {
		
		File d = new File("ejemplo10");
		
		if(!d.exists()) {
			d.mkdir();
		}
		
		Libro l1 = new Libro("La Celestina", "Pepe", "Novela", "123424513", new Date(1900, 5, 10));
		Libro l2 = new Libro("Los Pilares", "Follet", "Novela", "14372113", new Date(1980, 7, 20));
		
		ArrayList<Libro> lista = new ArrayList<>();
		
		lista.add(l1);
		lista.add(l2);
		
		Biblioteca biblioteca = new Biblioteca("Zamora", "980526712", lista);

		try {
			JAXBContext jaxb = JAXBContext.newInstance(Biblioteca.class);
			Marshaller m = jaxb.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(biblioteca, new File(d, "biblio.xml"));
		}catch(Exception e) {
			
		}
	}

}
