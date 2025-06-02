
package logica;

import javax.swing.JTextField;


public class Cronometro implements Runnable{

    private volatile boolean corriendo = false;
    private volatile boolean pausado = false;
    private JTextField horasField, minutosField, segundosField;
    private int segundosTotales = 0;

    public Cronometro(JTextField horasField, JTextField minutosField, JTextField segundosField) {
        this.horasField = horasField;
        this.minutosField = minutosField;
        this.segundosField = segundosField;
    }
    
    public void iniciar(){
        corriendo = true;
        pausado = false;
    }
    
    public void detener(){
        corriendo = false;
        segundosTotales = 0;
        actualizarTexto(0, 0, 0);
    }
    
    public void seguir(){
        pausado = false;
    }
    
    public void pausar(){
        pausado = true;
    }
    
    @Override
    public void run() {
        while (corriendo) {
            if (!pausado) {
                segundosTotales++;
                int horas = segundosTotales / 3600;
                int minutos = (segundosTotales % 3600) / 60;
                int segundos = segundosTotales % 60;

                actualizarTexto(horas, minutos, segundos);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }        
    }

    private void actualizarTexto(int h, int m, int s) {
        // Asegura que se actualice en el hilo de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            horasField.setText(String.format("%02d", h));
            minutosField.setText(String.format("%02d", m));
            segundosField.setText(String.format("%02d", s));
        });
    }
}
