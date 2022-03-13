import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Metoda, która opisuje Opcje w GUI
 */
public class Options extends Akari {

    
    static public Color kolorZar= Color.YELLOW;
    static public Color tempColor =Color.YELLOW;


    static public void swapIcons(String iconName){
        Path source = Paths.get("src\\bulbs\\"+iconName+".png");
        Path destination = Paths.get("src\\Icon\\bulb.png");
 
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
           
        }

    }
    
}
