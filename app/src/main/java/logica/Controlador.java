
package logica;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.SwingUtilities;
import vista.VentanaCronometro;


public class Controlador {
    
    public static void iniciarApp(){
        FlatDarculaLaf.setup();
        SwingUtilities.invokeLater( () -> {
        VentanaCronometro v1 = new VentanaCronometro();
        v1.setVisible(true);
        v1.setLocationRelativeTo(null);
        });
    }
    
    public static void iniciar(){
        
    }
    public static void detener(){
        
    }
    public static void parar(){
        
    }
    public static void seguir(){
        
    }
    
}
