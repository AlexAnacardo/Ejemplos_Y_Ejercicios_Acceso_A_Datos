package EjemploXStream;

import java.io.File;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;

public class EscribirXStream {
	public static void main(String[] args) {
		ListaJugadores lista = new ListaJugadores();
		lista.añadirJugador(new Jugador("Maria", "delantera", 25));
		lista.añadirJugador(new Jugador("Maria", "delantera", 28));
		
		try {
			
			XStream xstream = new XStream();
			
			xstream.alias("jugadores", ListaJugadores.class);
			xstream.alias("jugador", Jugador.class);
			
			xstream.addImplicitCollection(ListaJugadores.class, "jugadores");
			
			File d = new File("ejemplo9");
			
			if(!d.exists()){
				d.mkdir();
			}
			
			xstream.toXML(lista, new FileOutputStream("ejemplo9\\jugadores.xml"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
