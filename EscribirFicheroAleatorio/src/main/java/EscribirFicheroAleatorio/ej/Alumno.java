package EscribirFicheroAleatorio.ej;

import java.io.Serializable;
import java.time.LocalDate;

public class Alumno implements Serializable{
	private int expediente;
	private String nombre;
	private Float notaMedia;
	private LocalDate fecha_nac;
	
	public Alumno(int expediente, String nombre, Float notaMedia, LocalDate fecha_nac) {
		super();
		this.expediente = expediente;
		this.nombre = nombre;
		this.notaMedia = notaMedia;
		this.fecha_nac = fecha_nac;
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(Float notaMedia) {
		this.notaMedia = notaMedia;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", notaMedia=" + notaMedia + ", fecha_nac="
				+ fecha_nac + "]";
	}
	
	
}
