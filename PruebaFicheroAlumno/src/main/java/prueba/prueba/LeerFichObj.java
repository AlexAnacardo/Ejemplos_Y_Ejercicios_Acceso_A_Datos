package prueba.prueba;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class LeerFichObj {
	public static void main(String[] args) {
		
		File directorio = new File("ejemplo4");	
		
		File fichero = null;
		ObjectInputStream ois = null;
		
		try {
			fichero = new File(directorio, "alumnos.dat");
			//Stream para objetos
			ois = new ObjectInputStream(new FileInputStream(fichero));
			
			try {
				while(true) {
					Alumno alumno = (Alumno)ois.readObject();
					
					System.out.println(alumno.toString());
				}
			}catch(EOFException ex) {
				System.out.println("Fin del archivo");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
