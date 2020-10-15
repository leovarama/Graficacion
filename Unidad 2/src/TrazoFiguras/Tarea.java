package TrazoFiguras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tarea extends JPanel {
     // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;

    public Tarea() {
        // inicializar la ventana
        ventana = new JFrame("Dibujando icono");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.blue);
        g.drawLine(100, 50, 200, 50);
        g.drawLine(100, 100, 200, 100);
        g.drawLine(100, 50, 100, 100);
        g.drawLine(200, 50, 200, 100);
        g.drawLine(100, 50, 150, 20);
        g.drawLine(200, 50, 150, 20);
        g.drawLine(120, 100, 120, 70);
        g.drawLine(120, 70, 140, 70);
        g.drawLine(140, 70, 140, 100);
        g.drawLine(80, 120, 120, 100);
        g.drawLine(100, 120, 140, 100);
        
        
        g.setColor(Color.red);
        g.drawRect(300, 90, 10,10 );
        g.drawRect(315, 80, 10, 20 );
        g.drawRect(330, 70, 10, 30 );
        g.drawRect(345, 60, 10, 40 );
        g.drawRect(360, 50, 10, 50 );
        
        
        g.setColor(Color.GRAY);
        g.drawRoundRect(500, 50, 20, 100, 100, 100);
        g.drawRoundRect(480, 60, 60, 30, 100, 100);
        g.drawRoundRect(450, 80, 120, 30, 100, 100);
        
        
        g.setColor(Color.black);
        g.drawOval(50, 300, 100, 100);
        g.drawOval(70, 320, 15, 15);
        g.drawOval(110, 320, 15, 15);
        g.drawOval(85, 360, 30, 30);
        g.fillOval(75, 325, 5, 5);
        g.fillOval(115, 325, 5, 5);
        
        
        g.setColor(Color.green);
        g.drawOval(300,300,20,100);
        g.drawOval(280,310,60,30);
        g.drawOval(250,330,120,30);
        
        
        g.setColor(Color.CYAN);
        g.drawLine(500, 300, 500, 350);
        g.drawLine(500, 350, 530, 350);
        g.drawLine(530, 350, 500, 300);
        g.drawLine(500, 400, 600, 400);
        g.drawLine(500, 400, 570, 350);
        g.drawLine(600, 400, 570, 350);
        g.drawLine(570, 350, 610, 350);
        g.drawLine(570, 330, 570, 350);
        g.drawLine(570, 330, 610, 350);
        
    }
    
    
    
    
    
}
