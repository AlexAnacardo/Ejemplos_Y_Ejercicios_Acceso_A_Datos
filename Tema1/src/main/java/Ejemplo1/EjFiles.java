package Ejemplo1;
import java.io.*;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EjFiles {
	public static void main(String [] args) {
		/*File fichero = new File("ejemplo1");*/
		
		try {
			/*		
			fichero.mkdir();
			
			File fichero1 = new File("ejemplo1/fichero");
			
			fichero1.createNewFile();
			
			File fichero2 = new File("ejemplo1\\fichero2");
			
			fichero2.createNewFile();
			
			File fichero3 = new File(fichero, "fichero3");
			
			fichero3.createNewFile();
			*/
			
			File fichero=new File(".");
			
			String[] arrayDirectorios=fichero.list();
			
			for(String nombreArchivo : arrayDirectorios) {
				String dir="";
				
				File archivo = new File(nombreArchivo);
				
				if(archivo.isDirectory()) {
					dir="<DIR>";
				}
				
				Timestamp timestamp = new Timestamp(archivo.lastModified());			
				
				LocalDateTime fecha = timestamp.toLocalDateTime();
				
				DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				
				String fechaFormateada= fecha.format(formateador);
				
				
				
				System.out.println("Nombre: "+archivo.getName()+" | Path absoluto: "+archivo.getAbsolutePath()+" "+dir+" | Espacio total: "+archivo.getTotalSpace()+" bytes | Fecha ultima modificacion "+fechaFormateada);
				
			}
			
			
			
			
		} catch(Exception e) {			
			e.printStackTrace();
		}
	}
}
