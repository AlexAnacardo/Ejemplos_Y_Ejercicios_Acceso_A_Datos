package Ejemplo10.Ejemplo10;

import java.util.Date;

public class Libro {
	private String titulo;
	private String autor;
	private String genero;
	private String isbn;
	private Date fecha;
	
	public Libro() {
		
	}

	public Libro(String titulo, String autor, String genero, String isbn, Date fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.isbn = isbn;
		this.fecha = fecha;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
