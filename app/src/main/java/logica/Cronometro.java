
package logica;

import javax.swing.JTextField;


public class Cronometro implements Runnable{

    private volatile boolean corriendo = false;
    private JTextField horasField, minutosField, segundosField;
    private int segundosTotales = 0;

    public Cronometro(JTextField horasField, JTextField minutosField, JTextField segundosField) {
        this.horasField = horasField;
        this.minutosField = minutosField;
        this.segundosField = segundosField;
    }
    
    public void iniciar(){
        
    }
    
    public void detener(){
        
    }
    
    public void reiniciar(){
        
    }
    
    @Override
    public void run() {
        
    }

    
}
