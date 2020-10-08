package TrazoFiguras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Figuras extends JPanel {
        // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    
    
    public Figuras(){
    
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
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        
        //Trazpo de lineas
        grphcs.setColor(Color.blue);
        grphcs.drawLine(100, 50, 200, 50);
        grphcs.drawLine(100, 100, 200, 100);
        grphcs.drawLine(100, 50, 100, 100);
        grphcs.drawLine(200, 50, 200, 100);
        
        grphcs.drawLine(100, 50, 150, 20);
        grphcs.drawLine(200, 50, 150, 20);
        
        //trazo de rectangulos
        grphcs.setColor(Color.yellow);
        grphcs.drawRect(280, 50, 100, 50);
        grphcs.fillRect(280, 110, 100, 50);
        
        //trazo de rectangulos redondeados (ovalos)
        
        grphcs.setColor(Color.green);
        grphcs.drawRoundRect(450, 50, 100, 50, 50, 50);
        grphcs.fillRoundRect(450, 110, 100, 50, 20, 20);
        
        //trazo de circulos
        grphcs.setColor(Color.MAGENTA);
        grphcs.drawOval(100, 200, 80, 80);
        grphcs.fillOval(200, 200, 50, 50);
        
        //trazo de ovalos
        grphcs.setColor(Color.RED);
        grphcs.drawOval(280, 200, 80, 40);
        grphcs.fillOval(280, 250, 40, 80);
        
        //Trazo de triangulos
        grphcs.setColor(Color.black);
        grphcs.drawLine(450, 300, 550, 300);
        grphcs.drawLine(450, 300, 500, 250);
        grphcs.drawLine(550, 300, 500, 250);
        
        //dibujar cadenas de texto
        grphcs.setColor(Color.black);
        grphcs.drawString("Ejemplo de trazo de figuras basicas", 200, 400);
        
        //Trazo de arco
        grphcs.setColor(Color.black);
        grphcs.drawArc(450, 400, 150, 200, 20, 140);
        grphcs.fillArc(50, 450 , 150, 200, 20, 140);
        
        
    }
    
    
    
}
