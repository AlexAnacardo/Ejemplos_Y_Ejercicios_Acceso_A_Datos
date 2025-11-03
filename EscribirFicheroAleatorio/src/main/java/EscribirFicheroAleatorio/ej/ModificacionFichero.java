package EscribirFicheroAleatorio.ej;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificacionFichero {
	public static void main(String[] args) {
		
		File directorio = new File("ejemplo5");
		
		if(!directorio.exists()) {
			directorio.mkdir();
		}	
		
		File fichero = new File(directorio, "alumnos.dat");
		RandomAccessFile raf = null;
		
		try {
			//Quiero modificar el nombre del registro 2 por Manolo
			
			raf = new RandomAccessFile(fichero, "rw");
			
			StringBuffer nombre = new StringBuffer("Manolo");
			nombre.setLength(20);
			int registro = 2;
			int posicion = (registro-1)*(4 + 20*2)+4;
			raf.seek(posicion);
			
			raf.writeChars(nombre.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (raf != null) {
		            raf.close();
		        }
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
