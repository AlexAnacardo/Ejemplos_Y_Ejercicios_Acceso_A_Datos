package EjemploConfiguraciones.EjemploConfiguraciones;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class LeerPropiedades {
	public static void main( String[] args )
    {
    	File dir = new File("ejemplo6");
    	
    	
        File fich = new File(dir, "conf.properties");
        FileInputStream fis = null;
        
        try {
        	Properties propiedades = new Properties();        	
        	
        	fis = new FileInputStream(fich);
        	
        	propiedades.load(fis);
        	        	
        	System.out.println(propiedades.getProperty("user"));
        	System.out.println(propiedades.getProperty("pass"));
        	
        	System.out.println(propiedades.getProperty("ip"));
        	
        	//Recorrer fichero y mostrar las propiedades y sus valores
        	Set<String> listadoPropiedades = propiedades.stringPropertyNames();
        	
        	for(String s: listadoPropiedades) {
        		System.out.println(s);
        		System.out.println(propiedades.getProperty(s));
        	}
        	
        	fis.close();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
        	
        }
    }
}
