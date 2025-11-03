package prueba.prueba;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputSinCabecera extends ObjectOutputStream{

	public ObjectOutputSinCabecera(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
		System.out.println("Usando mi objeto nuevo");
	}
	
	@Override
	public void writeStreamHeader() {
		//El metodo original mete la cabecera, asi le decimos que no haga nada a mayores
		//al hacer el write sobre esta clase, accede al write stream header de la misma, pero este no hace nada
		//asi no escribe el header :D
	}
}
