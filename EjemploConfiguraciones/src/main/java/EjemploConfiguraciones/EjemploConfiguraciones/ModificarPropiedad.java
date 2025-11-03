package EjemploConfiguraciones.EjemploConfiguraciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

public class ModificarPropiedad {
	public static void main( String[] args )
    {
    	File dir = new File("ejemplo6");
    	
    	
        File fich = new File(dir, "conf.properties");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
        	Properties propiedades = new Properties();        	
        	        	
        	fis = new FileInputStream(fich);
        	
        	propiedades.load(fis);
        	
        	fis.close();
        	
        	fos = new FileOutputStream(fich);
        	
        	propiedades.setProperty("user", "pepito");
        	
        	propiedades.store(fos, "Fichero escrito");        	
        	
        	fos.close();
        	
        	
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
        	
        }
    }
}
