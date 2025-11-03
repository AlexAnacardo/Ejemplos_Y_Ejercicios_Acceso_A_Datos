package AgendaXStream.AgendaXStream;

import java.util.ArrayList;
import java.util.List;


public class ListaContactos {
	private List<Contacto> contactos = new ArrayList<>();

	public ListaContactos() {
		
	}
	
	public void añadirContacto(Contacto contacto) {
		contactos.add(contacto);
	}
	
	public List<Contacto> getLista(){
		return contactos;
	}
}
