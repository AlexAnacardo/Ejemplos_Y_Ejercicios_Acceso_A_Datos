package Ejercicio2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ejercicio2 {
	public static void main(String[] args) {
		try {
			
			File ficheroCopia = new File("ejercicio1/ficheroCopia");
			
			ficheroCopia.createNewFile();
			
			
			FileReader fr = new FileReader("ejercicio1/fichero");
			FileWriter fw = new FileWriter("ejercicio1/ficheroCopia");
			
			int caracter;			
			
			ArrayList<Integer> listaPosicionesCambiadas = new ArrayList<>();
			int posicionArray=0;
			int posicionCadena=0;
			
			while((caracter=fr.read())!=-1) {
				if((char)caracter=='a') {
					fw.append('@');
					listaPosicionesCambiadas.add(posicionCadena);
					posicionArray++;
				}
				else {
					fw.append((char)caracter);
				}
				
				posicionCadena++;
			}			
			
			fr.close();
			fw.close();
			
			System.out.println("Los ficheros tienen "+posicionArray+" diferencias en las posiciones:");
			for(int posicion : listaPosicionesCambiadas) {
				System.out.println(posicion);
			}
						
		} catch(Exception e) {			
			e.printStackTrace();
		}
	}
}
