package AgendaXStream.AgendaXStream;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.Instant;
import java.time.ZoneId;

import com.thoughtworks.xstream.XStream;

public class EscribirAgendaXStream {
	public static void main(String[] args) {
		
		ListaContactos lista = new ListaContactos();
		File fichero = new File("agenda.dat");
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(fichero, "r");
			
			while(true) {
				
				int id = raf.readInt();
				
				char[] nombre = new char[20];
				char[] apellidos = new char[30];
				char[] telefono = new char[9];
				char[] correo = new char[50];
				String fechaNacimiento;
				
				
				for(int i=0; i<20; i++) {
					nombre[i] = raf.readChar();	
				}
				
				for(int i=0; i<30; i++) {
					apellidos[i] = raf.readChar();					
				}
				
				for(int i=0; i<9; i++) {
					telefono[i] = raf.readChar();					
				}
				
				for(int i=0; i<50; i++) {
					correo[i] = raf.readChar();					
				}
						
				fechaNacimiento = Instant.ofEpochMilli(raf.readLong()).atZone(ZoneId.systemDefault()).toLocalDate().toString();
				
				lista.añadirContacto(new Contacto(
					    id,
					    new String(nombre).trim(),
					    new String(apellidos).trim(),
					    new String(telefono).trim(),
					    new String(correo).trim(),
					    fechaNacimiento));
				
				XStream xstream = new XStream();
				
				xstream.alias("contactos", ListaContactos.class);
				xstream.alias("contacto", Contacto.class);
				
				xstream.addImplicitCollection(ListaContactos.class, "contactos");
				
				xstream.toXML(lista, new FileOutputStream("agenda.xml"));

			}
			
		}catch(EOFException ex) {
			System.out.println("Fin del fichero");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
