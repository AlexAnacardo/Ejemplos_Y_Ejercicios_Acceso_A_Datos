package EjemploJSON.Ejemplo.JSON;

import java.util.ArrayList;
import java.util.List;

public class ListaJugadores {
	private List<Jugador> jugadores = new ArrayList<>();

	public ListaJugadores() {
		
	}
	
	public void añadirJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public List<Jugador> getLista(){
		return jugadores;
	}
}
