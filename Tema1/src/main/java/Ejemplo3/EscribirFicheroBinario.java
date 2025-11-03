package Ejemplo3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EscribirFicheroBinario {
	public static void main(String[] args) {
		
		File carpeta = new File("ejemplo3");
		carpeta.mkdir();
		
		
		File f = new File("ejemplo3\\fichero.bin");
		
		
		try {
			
			f.createNewFile();
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			
			int edad = 55;
			String nombre = "Eloy";
			Float peso = 65.25f; 		
			
			dos.writeUTF(nombre);
			dos.writeInt(edad);
			dos.writeFloat(peso);
			
			dos.close();
			
		} catch (Exception e) {
			
		}
		
	}
}
