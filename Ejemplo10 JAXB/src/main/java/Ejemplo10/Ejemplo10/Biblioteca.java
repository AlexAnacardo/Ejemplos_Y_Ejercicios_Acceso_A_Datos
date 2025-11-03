package Ejemplo10.Ejemplo10;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Biblioteca {
	
	private String localidad;
	private String tlf;
	private ArrayList<Libro> lista;

	public Biblioteca() {
		
	}

	public Biblioteca(String localidad, String tlf, ArrayList<Libro> lista) {
		super();
		this.localidad = localidad;
		this.tlf = tlf;
		this.lista = lista;
	}

	@XmlAttribute
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@XmlAttribute
	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@XmlElementWrapper
	@XmlElement(name="libro")
	public ArrayList<Libro> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
	}
	
	
}
