package EjemploJSON.Ejemplo.JSON.Ejemplo11;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformarXMLHTML {

	public static void main(String[] args) {
		
		try {
			
			File pagina = new File("mipagina.html");
			
			StreamSource source = new StreamSource("jugadores.xml");
			
			Result result = new StreamResult(new FileOutputStream("mipagina.html"));
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("src\\main\\java\\Ejemplo11\\Ejemplo11\\transformer.xsl"));
			
			transformer.transform(source, result);
		}catch(Exception e) {
			
		}
	}

}
