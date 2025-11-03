package Ejemplo2;

import java.io.File;
import java.io.FileWriter;

public class Ejemplo2 {
	public static void main(String[] args) {
		File d = new File("ejemplo2");
		
		
		
		try {
			
			if(!d.exists()) {
				d.mkdir();
			}
			
			File fichero = new File(d, "ficheroTexto.txt");
			
			//Poner true en el constructor le indica que queremos añadir contenido al archivo, no sobreescribir
			FileWriter fw = new FileWriter(fichero, true);
			
			String contenido = "Algo";
			String contenidoExtra = "Algo mas...";
			
			fw.write(contenido);
			
			fw.append(contenidoExtra);
			
			fw.close();
			
		} catch(Exception e) {
			
		}
	}
}
