package EjemploJSON.Ejemplo.JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

public class LeerJson {
	public static void main(String[] args) {
		
		
		try {
			
			FileReader fichero;
			fichero = new FileReader("ejemplo12\\concesionario.json");
			JsonReader jsonr = Json.createReader(fichero);
			
			JsonObject concesionario = jsonr.readObject();
			/*
			System.out.println("Nombre: "+ concesionario.getString("nombre"));
			System.out.println("Localidad: "+ concesionario.getString("localidad"));
			JsonArray coches = concesionario.getJsonArray("coches");
			
			for(int i=0; i<coches.size(); i++) {
				JsonObject coche = coches.getJsonObject(i);
				System.out.println(coche.getString("marca"));
				System.out.println(coche.getString("modelo"));
				System.out.println(coche.getString("año"));
			}
			
			JsonArray motos = concesionario.getJsonArray("motos");
			
			for(int i=0; i<motos.size(); i++) {
				JsonObject moto = motos.getJsonObject(i);
				System.out.println(moto.getString("marca"));
				System.out.println(moto.getString("modelo"));
				System.out.println(moto.getString("año"));
			}
			*/
			
			recorrerJson(concesionario);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	private static void recorrerJson(JsonValue value) {
		switch(value.getValueType()) {
			case OBJECT:
				JsonObject objeto = value.asJsonObject();
				for(Entry<String, JsonValue> entry : objeto.entrySet()) {
					recorrerJson(entry.getValue());
				}
			break;
			
			case STRING:
				System.out.println(((JsonString)value).getString());
			break;
			
			case ARRAY:
				JsonArray jarray = value.asJsonArray();
				for(int i=0; i< jarray.size(); i++) {
					recorrerJson(jarray.get(i));
				}
			break;
			
			default:
				
			break;
		}
	}

}
