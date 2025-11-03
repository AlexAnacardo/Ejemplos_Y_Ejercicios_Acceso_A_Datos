package prueba.prueba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class EscribirFichObj {
	public static void main(String[] args) {
		Alumno alumno = new Alumno(0, "Alex", 6.3f, LocalDate.of(2004, 07, 19));
		Alumno alumno1 = new Alumno(0, "Alex1", 67.3f, LocalDate.of(2004, 07, 20));
		Alumno alumno2 = new Alumno(0, "Alex2", 68.3f, LocalDate.of(2004, 07, 21));
		File directorio = new File("ejemplo4");
		
		if(!directorio.exists()) {
			directorio.mkdir();
		}	
		
		File fichero = null;
		ObjectOutputStream ous = null;
		
		try {
			fichero = new File(directorio, "alumnos.dat");
			//Si no existe escribe el fichero con la cabecera
			if(!fichero.exists()) {
				ous = new ObjectOutputStream(new FileOutputStream(fichero));
			}
			else {
				//Si existe necesito un output que no escriba cabecera (no existe, se crea)
				ous = new ObjectOutputSinCabecera(new FileOutputStream(fichero, true));
			}
			//Stream para objetos
						
			ous.writeObject(alumno);
			ous.writeObject(alumno1);
			ous.writeObject(alumno2);
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ous.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
