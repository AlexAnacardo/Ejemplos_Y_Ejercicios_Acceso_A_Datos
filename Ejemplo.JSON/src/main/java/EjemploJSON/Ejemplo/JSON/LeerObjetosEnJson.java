package EjemploJSON.Ejemplo.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class LeerObjetosEnJson {

	public static void main(String[] args) {		
		try {
			ObjectMapper mapeador = new ObjectMapper();
			
			ListaJugadores lista;
			lista = mapeador.readValue(new File("ejemplo12\\jugadores.json"), ListaJugadores.class);			
			
			for(int i = 0; i<lista.getLista().size(); i++) {
				System.out.println(lista.getLista().get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
