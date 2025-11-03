package EscribirFicheroAleatorio.ej;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerRegistro {
public static void main(String[] args) {
		
		File directorio = new File("ejemplo5");	
		
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
		File fichero = new File(directorio, "alumnos.dat");
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(fichero, "r");
			int registro = 1;
			int posicion = (registro-1)*(4 + 20*2);
			raf.seek(posicion);
			
			char[] nombre = new char[20];

			System.out.println(raf.readInt());
			for(int i=0; i<20; i++) {
				nombre[i] = raf.readChar();
			}
			
			System.out.println(nombre);
			
		}catch(EOFException ex) {
			System.out.println("Fin del fichero");
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
