/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinaria.dataaccess;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author gabosaurio
 */
public class DBConfig {
    private static final String PROPERTIES_FILE = "properties/db_config.properties";
    private static final Logger logger = LogManager.getLogger(DBConfig.class);
    
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                logger.error("No se encontró el archivo db_config.properties: " + PROPERTIES_FILE);
            }
        } catch (IOException e) {
            logger.error("Error al cargar db_config.properties: ", e);
        }
        
        return properties;
    }
}
