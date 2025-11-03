package AgendaXStream.AgendaXStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

public class AñadirContacto {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            XStream xstream = new XStream();

            xstream.allowTypes(new Class[]{ListaContactos.class, Contacto.class});

            
            xstream.alias("contactos", ListaContactos.class);
            xstream.alias("contacto", Contacto.class);

            
            xstream.addImplicitCollection(ListaContactos.class, "contactos");

            File xmlContactos = new File("agenda.xml");
            ListaContactos listaContactos;

            listaContactos = (ListaContactos) xstream.fromXML(xmlContactos);
 

            System.out.println("Introduce los datos del nuevo contacto:");
            System.out.print("ID: ");
            int id = Integer.parseInt(teclado.nextLine());
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = teclado.nextLine();
            System.out.print("Teléfono: ");
            String telefono = teclado.nextLine();
            System.out.print("Correo: ");
            String correo = teclado.nextLine();
            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            String fecha = teclado.nextLine();

            Contacto nuevoContacto = new Contacto(id, nombre, apellidos, telefono, correo, fecha);
            listaContactos.añadirContacto(nuevoContacto);

            xstream.toXML(listaContactos, new FileOutputStream(xmlContactos));
            System.out.println("Contacto añadido");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            teclado.close();
        }
    }
}
