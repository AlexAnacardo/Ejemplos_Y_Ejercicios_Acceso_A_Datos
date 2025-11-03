package Ejemplo10.Ejemplo10;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class LeerJaxb {

	public static void main(String[] args) {
		File d = new File("ejemplo10");
		
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Biblioteca.class);
			
			Unmarshaller um = jaxb.createUnmarshaller();
			
			Biblioteca biblioteca = (Biblioteca)um.unmarshal(new File(d, "biblio.xml"));
			
			ArrayList<Libro> libros = biblioteca.getLista();
			
			for(Libro l: libros) {
				System.out.printf("Titulo: %s \nAutor: %s \nGenero: %s \nISBN: %s \nFecha publicacion: %s\n", l.getTitulo(), l.getAutor(), l.getGenero(), l.getIsbn(), l.getFecha().toString());
				
			}
			
			
			
		}catch(Exception e) {
			
		}
	}

}
