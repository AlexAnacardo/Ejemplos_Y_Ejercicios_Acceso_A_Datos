package Ejemplo2;

import java.io.File;
import java.io.FileReader;

public class LeerFichero {
	public static void main(String[] args) {
		File f = new File("ejemplo2\\ficheroTexto.txt");
		
		try {
			FileReader fr = new FileReader(f);
			int leido;
			/*
			while((leido=fr.read())!=-1) {
				System.out.println(leido + "==" + (char)leido);
			}
			*/
			char[] arrayC = new char[20];
			while(fr.read(arrayC)!=-1) {
				System.out.println(arrayC);
			}
			
			fr.close();
			
		} catch (Exception e) {
			
		}
	}
}
