package Icono;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dibujo extends JPanel{
    private JFrame ventana;
    private Container contenedor;
    

    private final int [] FIGURA = {
        0x80000000,
        0x80000000,
        0x8000fe00,
        0x83010100,
        0x02820080,
        0x02440240,
        0x02280020,
        0x02101020,
        0x02282020,
        0x0244c040,
        0x02820080,
        0x03010100,
        0x0000fe00,
        0x00000000,
        0x00000000
    };
    
    
    
    private final int MASCARA = 0x8000000;
    
    private final int ANCHO_BITS = 32;
    
    private int coordenadasx, coordenadasy;
    
    int cont = 0;
    
    //Definiendo hilo de ejecucion
    private Thread hilo;

    public Dibujo() {
        ventana = new JFrame ("Dibujando icono");
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800,600);
        contenedor.add(this, BorderLayout.CENTER);
        
        this.hilo = new Thread();
    }

    @Override
    protected void paintComponent(Graphics graficos) {
        super.paintComponent(graficos);
        
        //Iterador de la figura
        for (int i = 0; i < this.FIGURA.length; i++) {
          //Iterador para el ancho en bits
            for (int j = 0; j < this.ANCHO_BITS; j++) {
                int temp = this.FIGURA [i] & (this.MASCARA >> j);
                if (temp != 0){
                    graficos.drawLine(j + coordenadasx,
                                      i + coordenadasy,
                                      j + coordenadasx,
                                      i + coordenadasy);
                }
            }
        }
    }
    
    public void dibujar(){
        do{
            this.coordenadasx = (int) (Math.random()*(ventana.getWidth()-ANCHO_BITS));
            this.coordenadasy = (int) (Math.random()*(ventana.getHeight() - 60));
            int dir = (int) (Math.random()*4);
            elegir (dir);
            JOptionPane.showMessageDialog(ventana, "Ejecución " + cont + " de 10");
        }while (cont < 10); 
        JOptionPane.showMessageDialog(ventana, "Terminó la ejecución");
        System.exit(0);
    }
    
    public void elegir (int dir){
        switch (dir){
            case 0: 
                do{
                try{
                    this.coordenadasx = this.coordenadasx - 10;
                    this.hilo.sleep(50);
                    paint(getGraphics());
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                }while (this.coordenadasx > 0);
                paint(getGraphics());
                break;
            case 1: 
                do{
                try{
                    this.coordenadasy = this.coordenadasy - 10;
                    this.hilo.sleep(50);
                    paint(getGraphics());
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                }while (this.coordenadasy > 0);
                paint(getGraphics());
                break;
            case 2: 
                do{
                try{
                    this.coordenadasx = this.coordenadasx + 10;
                    this.hilo.sleep(50);
                    paint(getGraphics());
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                }while (this.coordenadasx < ventana.getWidth() - ANCHO_BITS);
                paint(getGraphics());
                break;
            case 3: 
                do{
                try{
                    this.coordenadasy = this.coordenadasy + 10;
                    this.hilo.sleep(50);
                    paint(getGraphics());
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                }while (this.coordenadasy < ventana.getHeight() - 45);
                paint(getGraphics());
                break;
        }
        cont++;
    }
    
    
}
