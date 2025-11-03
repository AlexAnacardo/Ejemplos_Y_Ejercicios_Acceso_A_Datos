package EjemploConfiguraciones.EjemploConfiguraciones;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class EscribirPropiedades 
{
    public static void main( String[] args )
    {
    	File dir = new File("ejemplo6");
    	
    	if(!dir.exists()) {
    		dir.mkdir();
    	}
    	
        File fich = new File(dir, "conf.properties");
        FileOutputStream fos = null;
        
        try {
        	Properties propiedades = new Properties();
        	
        	propiedades.setProperty("user", "root");
        	propiedades.setProperty("pass", "1234");
        	propiedades.setProperty("ip", "192.168.2.3");
        	
        	fos = new FileOutputStream(fich);
        	
        	propiedades.store(fos, "Fichero escrito");
        	
        	fos.close();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
        	
        }
    }
}
