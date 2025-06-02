
package logica;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.SwingUtilities;
import vista.VentanaCronometro;


public class Controlador {
    private static VentanaCronometro ventana;
    private static Cronometro cronometro;
    private static Thread hilo;
    
    public static void iniciarApp(){
        FlatDarculaLaf.setup();
        SwingUtilities.invokeLater( () -> {
        ventana = new VentanaCronometro();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        });
    }
    
    public static void iniciar(){
        if (cronometro == null || !hilo.isAlive()) {
            cronometro = new Cronometro(
                ventana.getTxtHoras(),
                ventana.getTxtMinutos(),
                ventana.getTxtSegundos()
            );
            hilo = new Thread(cronometro);
            cronometro.iniciar();
            hilo.start();
        }
    }
    public static void detener(){
        if (cronometro != null) {
            cronometro.detener();
        }
    }
    public static void pausa(){
        if (cronometro != null) {
            cronometro.pausar();
        }
    }
    public static void seguir(){
        if (cronometro != null) {
            cronometro.seguir();
        }
    }
}
