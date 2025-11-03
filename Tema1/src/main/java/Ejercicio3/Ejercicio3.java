package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) {
		String[] nombres = {"Alex", "Rodrigo", "Eloy", "Pablito", "Jorgito"};
		int[] edades = {21, 23, 56, 20, 19};
		float[] salarios = {1300.32f, 1322.43f, 1000.3f, 980.21f, 600.34f};
		
		File carpeta = new File("ejercicio3");
		
		carpeta.mkdir();
		
		File archivoEmpleados = new File("ejercicio3\\empleados.bin");
		
		try {
			
			archivoEmpleados.createNewFile();
			
			DataInputStream dis = new DataInputStream(new FileInputStream(archivoEmpleados));
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivoEmpleados));
			
			for(int i=0; i<nombres.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
				dos.writeFloat(salarios[i]);
			}
			
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
