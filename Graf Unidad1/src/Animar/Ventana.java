package Animar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {
    private JFrame ventana;
    private Container contenedor;
    private Ovalo [] circ; 
            
    public Ventana (){
        ventana = new JFrame ("Animando objetos");
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800,600);
        contenedor.add(this, BorderLayout.CENTER);
        
        this.circ = new Ovalo [5];
        for (int i = 0; i < this.circ.length; i++) {
            this.circ [i] = new Ovalo(this.ventana.getHeight(),this.ventana.getWidth(), 25 ,50);
        }
        
    }
    
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
            for (int i = 0; i < this.circ.length; i++) {
                circ[i].dibujar(g);
            }
            try{
                Thread.sleep(50);
            }catch(Exception e){}
    }
    
    public void animar() {
        while (this.ventana.isVisible()) {
            for (Ovalo circulo : circ) {
                circulo.animar();
            }
            try {
                Thread.sleep(50);

            } catch (Exception e) {

            }
            repaint();
        }
    }
}
