package EscribirFicheroAleatorio.ej;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;


public class EscribirFicheroAleatorio {
	public static void main(String[] args) {
	
		File directorio = new File("ejemplo5");
		
		if(!directorio.exists()) {
			directorio.mkdir();
		}	
		
		File fichero = new File(directorio, "alumnos.dat");
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(fichero, "rw");
			
			int id = 1;
			StringBuffer nombre = new StringBuffer("Maria");
			nombre.setLength(20);
			raf.writeInt(id);
			raf.writeChars(nombre.toString());
			System.out.println(raf.getFilePointer());
			
			id = 2;
			nombre = new StringBuffer("Pepe");
			nombre.setLength(20);
			raf.writeInt(id);
			raf.writeChars(nombre.toString());
			System.out.println(raf.getFilePointer());
			
			id = 3;
			nombre = new StringBuffer("Alex");
			nombre.setLength(20);
			raf.writeInt(id);
			raf.writeChars(nombre.toString());
			System.out.println(raf.getFilePointer());
			
		}catch(Exception e) {
			
		}finally {
			try {
				raf.close();
			} catch(IOException e) {
				
			}
		}
		
	}
}
