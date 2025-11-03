package Ejemplo3;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class LeerFicheroBinario {
	public static void main(String[] args) {
				
		File f = new File("ejemplo3\\fichero.bin");
		
		try {
			
			f.createNewFile();
			
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
			
			int edad;
			String nombre;
			Float peso;
			
			nombre=dis.readUTF();
			edad=dis.readInt();
			peso=dis.readFloat();
			
			System.out.println(nombre);
			System.out.println(edad);
			System.out.println(peso);

			dis.close();
			
		} catch (Exception e) {
			
		}
		
	}
}
