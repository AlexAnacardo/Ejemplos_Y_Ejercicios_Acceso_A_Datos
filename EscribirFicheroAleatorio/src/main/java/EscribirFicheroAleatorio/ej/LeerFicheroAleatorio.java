package EscribirFicheroAleatorio.ej;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;



public class LeerFicheroAleatorio {
public static void main(String[] args) {
		
		File directorio = new File("ejemplo5");	
		
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
		File fichero = new File(directorio, "alumnos.dat");
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(fichero, "r");
			//Leer hasta que se acabe el fichero 1 int y un string de 20 caracteres
			
			while(true) {
				System.out.println(raf.readInt());
				for(int i=0; i<20; i++) {
					System.out.print(raf.readChar());
				}
				System.out.println("Posicion en el fichero "+raf.getFilePointer());
			}
			
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
