package EjemploXStream;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public class LeerXStream {
	public static void main(String[] args) {
		try {
			
			XStream xstream = new XStream();
			xstream.allowTypes(new Class[] {Jugador.class});
			xstream.allowTypes(new Class[] {ListaJugadores.class});
			
			xstream.alias("jugadores", ListaJugadores.class);
			xstream.alias("jugador", Jugador.class);
			xstream.addImplicitCollection(ListaJugadores.class, "jugadores");
			
			ListaJugadores jugadores = (ListaJugadores)xstream.fromXML(new File("ejemplo9\\jugadores.xml"));
			
			for(Jugador j: jugadores.getLista()) {
				System.out.println(j.toString());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
