package Ejercicio3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class lectorEmpleados {
	public static void main(String[] args) {
		
		File archivoEmpleados = new File("ejercicio3/empleados.bin");
		
		try {
			
			DataInputStream dis = new DataInputStream(new FileInputStream(archivoEmpleados));
			
			try {
				int contador=1;
				while(true) {
					System.out.println("La persona "+contador+" se llama "+dis.readUTF()+", tiene "+dis.readInt()+" años y un salario de "+dis.readFloat()+"€");
					contador++;
				}
			} catch( EOFException e) {
				System.out.println("Se alcanzó el final del fichero");
			}
			
			dis.close();
			
		} catch(IOException e) {
			
		}
	}
}
