package EjemploJSON.Ejemplo.JSON;

import java.io.File;
import java.io.FileWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class EscribirJSON {

	public EscribirJSON() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		JsonObject concesionario = Json.createObjectBuilder()
				.add("nombre", "Coches Pepito")
				.add("localidad", "Sevilla")
				.add("coches", Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("marca", "ferrari")
								.add("modelo", "f40")
								.add("año", "2025")
						)
						.add(Json.createObjectBuilder()
								.add("marca", "lamborghini")
								.add("modelo", "aventador")
								.add("año", "2024")
						)
				)
				.add("motos", Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("marca", "amaha")
								.add("modelo", "mu rapida")
								.add("año", "2010")
						)
						.add(Json.createObjectBuilder()
								.add("marca", "ktm")
								.add("modelo", "1200")
								.add("año", "2004")
						)
				).build();
		
		try {
			File file = new File("ejemplo12");
			
			file.mkdir();
			
			FileWriter fichero = new FileWriter("ejemplo12\\concesionario.json");
			JsonWriter jsonw = Json.createWriter(fichero);
			jsonw.writeObject(concesionario);
			jsonw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
