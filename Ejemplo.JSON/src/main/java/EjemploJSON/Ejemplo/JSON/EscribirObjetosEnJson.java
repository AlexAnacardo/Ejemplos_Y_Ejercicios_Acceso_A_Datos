package EjemploJSON.Ejemplo.JSON;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EscribirObjetosEnJson {

	public static void main(String [] args) {
		ListaJugadores lista = new ListaJugadores();
		lista.añadirJugador(new Jugador("Maria", "delantera", 25));
		lista.añadirJugador(new Jugador("Maria", "delantera", 28));
		
		ObjectMapper mapeador = new ObjectMapper();
		
		try {
			mapeador.writerWithDefaultPrettyPrinter()
			.writeValue(new File("ejemplo12\\jugadores.json"), lista);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		
	

}
