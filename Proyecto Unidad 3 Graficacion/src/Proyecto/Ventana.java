package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JPanel implements ActionListener{
    private JFrame ventana;
    private Punto [] figura;
    private Container contenedor;
    public JMenuBar JMB_Barra;
    public JMenu JMenu_Transformaciones, JMenu_Opciones;
    public JMenuItem JMItraslacion, JMIescalar1, JMIescalar2, JMIrotacion, JMIescalarfijo1, JMIescalarfijo2, JMIrotacionfija,
            JMIreflejarX, JMIreflejarY, JMIreflejocompleto, JMIreiniciar;
    public JButton JB_traslacion, JB_escalar1, JB_escalar2, JB_rotacion, JB_escalarfijo1, JB_escalarfijo2, JB_rotacionfija,
            JB_reflejarX, JB_reflejarY, JB_reflejocompleto, JB_reiniciar;
    private JPanel JP_Norte, JP_Este;
    
    /**
     * Crea una ventana para representar la figura
     * @param titulo titulo de la ventana
     * @param figura figura que se va a dibujar con puntos
     */
    public Ventana (String titulo, Punto [] figura){
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(1000, 700);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        JP_Norte = new JPanel ();
        JP_Este = new JPanel ();
        JP_Norte.setLayout(null);
        JP_Este.setLayout(null);
        setLayout(null);
        setBounds(150, 50, 850, 650);
        JP_Norte.setBounds(0, 0, 1000, 50);
        JP_Este.setBounds(0, 50, 150, 700);
        ventana.addKeyListener(new Listener(this));
        ventana.addMouseListener(new MouseListener(this));
        
        JB_traslacion       = new JButton ("Trasladar");
        JB_escalar1         = new JButton ("Escalar con 1 parámetro");
        JB_escalar2         = new JButton ("Escalar con x y y");
        JB_rotacion         = new JButton ("Rotación");
        JB_escalarfijo1     = new JButton ("Escalamiento fijo con 1 parámetro");
        JB_escalarfijo2     = new JButton ("Escalamiento fijo con x y y");
        JB_rotacionfija     = new JButton ("Rotación fija");
        JB_reflejarX        = new JButton ("Reflexión en x");
        JB_reflejarY        = new JButton ("Reflexión en y");
        JB_reflejocompleto  = new JButton ("Reflexión completa");
        JB_reiniciar        = new JButton("Reiniciar imagen inicial");
        
        JMB_Barra = new JMenuBar();
        JMenu_Transformaciones = new JMenu ("Transformaciones");
        JMenu_Opciones = new JMenu ("Opciones");
        JMItraslacion       = new JMenuItem ("Trasladar");
        JMIescalar1         = new JMenuItem ("Escalar con 1 parámetro");
        JMIescalar2         = new JMenuItem ("Escalar con x y y");
        JMIrotacion         = new JMenuItem ("Rotación");
        JMIescalarfijo1     = new JMenuItem ("Escalamiento fijo con 1 parámetro");
        JMIescalarfijo2     = new JMenuItem ("Escalamiento fijo con x y y");
        JMIrotacionfija     = new JMenuItem ("Rotación fija");
        JMIreflejarX        = new JMenuItem ("Reflexión en x");
        JMIreflejarY        = new JMenuItem ("Reflexión en y");
        JMIreflejocompleto  = new JMenuItem ("Reflexión completa");
        JMIreiniciar        = new JMenuItem("Reiniciar imagen inicial");
        
        JMB_Barra.add(JMenu_Transformaciones);
        JMB_Barra.add(JMenu_Opciones);
        
        JMenu_Transformaciones.add(JMItraslacion);
        JMenu_Transformaciones.add(JMIescalar1    );
        JMenu_Transformaciones.add(JMIescalar2    );
        JMenu_Transformaciones.add(JMIrotacion    );
        JMenu_Transformaciones.add(JMIescalarfijo1);
        JMenu_Transformaciones.add(JMIescalarfijo2);
        JMenu_Transformaciones.add(JMIrotacionfija);
        JMenu_Transformaciones.add(JMIreflejarX   );
        JMenu_Transformaciones.add(JMIreflejarY   );
        JMenu_Transformaciones.add(JMIreflejocompleto);
        JMenu_Opciones.add(JMIreiniciar);
        
        
                
        

        ventana.add(JP_Norte);
        JP_Norte.add(JMB_Barra);
        JMB_Barra.setBounds(5, 5, 300, 40);
        
        ventana.add(JP_Este);
        JP_Este.add(JB_traslacion     );
        JP_Este.add(JB_escalar1       );
        JP_Este.add(JB_escalar2       );
        JP_Este.add(JB_rotacion       );
        JP_Este.add(JB_escalarfijo1   );
        JP_Este.add(JB_escalarfijo2   );
        JP_Este.add(JB_rotacionfija   );
        JP_Este.add(JB_reflejarX      );
        JP_Este.add(JB_reflejarY      );
        JP_Este.add(JB_reflejocompleto);
        JP_Este.add(JB_reiniciar      );
        Font fuente = new Font("Arial", Font.BOLD, 8);
        JB_traslacion.setBounds(0, 60, 150, 30);
        JB_escalar1.setBounds(0, 100, 150, 30);       
        JB_escalar2.setBounds(0, 140, 150, 30);        
        JB_rotacion.setBounds(0, 180, 150, 30);       
        JB_escalarfijo1.setBounds(0, 220, 150, 30);   
        JB_escalarfijo2.setBounds(0, 260, 150, 30);   
        JB_rotacionfija.setBounds(0, 300, 150, 30);   
        JB_reflejarX.setBounds(0, 340, 150, 30);      
        JB_reflejarY.setBounds(0, 380, 150, 30);      
        JB_reflejocompleto.setBounds(0, 420, 150, 30);
        JB_reiniciar.setBounds(0, 460, 150, 30); 
        JB_traslacion.setFont(fuente);
        JB_escalar1.setFont(fuente);       
        JB_escalar2.setFont(fuente);       
        JB_rotacion.setFont(fuente);       
        JB_escalarfijo1.setFont(fuente);   
        JB_escalarfijo2.setFont(fuente);   
        JB_rotacionfija.setFont(fuente);   
        JB_reflejarX.setFont(fuente);      
        JB_reflejarY.setFont(fuente);      
        JB_reflejocompleto.setFont(fuente);
        JB_reiniciar.setFont(fuente);      
        
        JB_traslacion.addActionListener(this);
        JB_escalar1.addActionListener(this);
        JB_escalar2.addActionListener(this);       
        JB_rotacion.addActionListener(this);       
        JB_escalarfijo1.addActionListener(this);   
        JB_escalarfijo2.addActionListener(this);   
        JB_rotacionfija.addActionListener(this);   
        JB_reflejarX.addActionListener(this);      
        JB_reflejarY.addActionListener(this);      
        JB_reflejocompleto.addActionListener(this);
        JB_reiniciar.addActionListener(this);
        
        JMItraslacion.addActionListener(this);     
        JMIescalar1.addActionListener(this);       
        JMIescalar2.addActionListener(this);       
        JMIrotacion.addActionListener(this);       
        JMIescalarfijo1.addActionListener(this);   
        JMIescalarfijo2.addActionListener(this);   
        JMIrotacionfija.addActionListener(this);   
        JMIreflejarX.addActionListener(this);      
        JMIreflejarY.addActionListener(this);      
        JMIreflejocompleto.addActionListener(this);
        JMIreiniciar.addActionListener(this);      
        
        
        
        
        
        
        JP_Este.setBackground(Color.red);
        JP_Norte.setBackground(Color.BLUE);
        contenedor = ventana.getContentPane();
        contenedor.setSize(850, 650);
        // agregar la ventana en el contenedor
        contenedor.add(this);
        
        this.figura = figura;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        this.dibujar(g);
    }
    
    public void trasladar (int factor_x, int factor_y){
        for (Punto punto : figura) {
            punto.setX(punto.getX()+factor_x);
            punto.setY(punto.getY()+factor_y);
        }
    }
    
    public void escalar (float factor_x, float factor_y){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX()*factor_x));
            punto.setY((int)(punto.getY()*factor_y));
        }
    }
    
    public void escalar (float escalar){
        for (Punto punto : figura){
            punto.setX((int) (punto.getX()*escalar));
            punto.setY((int) (punto.getY()*escalar));
        }
    }
    
    public void rotacion(double ang){
        for (Punto punto : figura){
            punto.setX((int) ((punto.getX()*Math.cos(Math.toRadians(ang)) - (punto.getY()*Math.sin(Math.toRadians(ang))))));
            punto.setY((int) ((punto.getX()*Math.sin(Math.toRadians(ang)) + (punto.getY()*Math.cos(Math.toRadians(ang))))));
        }
    }
    
    public void escalarFijo (float escalar, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * escalar)));
            punto.setY((int) (fy + ((punto.getY() - fy) * escalar)));
        }
    }
    
    public void escalarFijo (float factorX, float factorY, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * factorX)));
            punto.setY((int) (fy + ((punto.getY() - fy) * factorY)));
        }
    }
    
    public void rotacionFija(double ang, int fx, int fy){
        this.trasladar(-fx, -fy);
        this.rotacion(ang);
        this.trasladar(fx, fy);
    }
    
    public void reflexionX (){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX(-(punto.getX()-tx) + tx);
            punto.setY((punto.getY()-ty) + ty);
        }
    }
    
    public void reflexionY (){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX((punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    
    public void reflexionXY(){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX(-(punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    
    private void dibujar (Graphics g){
        for (int i = 0; i < figura.length - 1; i++) {
            g.drawLine(this.figura[i].getX(), this.figura[i].getY(), this.figura[i+1].getX(), this.figura[i+1].getY());
        }
    }
    
    public void setFigura (Punto [] figura){
        this.figura = figura;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==JMIescalar1){
            float esc;
            esc = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento"));
            this.escalar(esc);
            ventana.repaint();
        }
        else if(ae.getSource()==JMIescalar2){
            float x,y;
            x=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento en en X"));
            y=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento en Y"));
            this.escalar(x,y);
            ventana.repaint();
        }
        else if(ae.getSource()== JMIreflejarX){
            this.reflexionX();
            ventana.repaint();
        }
        else if(ae.getSource()== JMIreflejarY){
            this.reflexionY();
            ventana.repaint();
        }
        else if(ae.getSource()== JMIreflejocompleto){
            this.reflexionXY();
            ventana.repaint();
        }
        else if(ae.getSource()== JMIreiniciar){
            Punto[] figura = {
            new Punto(100, 400),
            new Punto(700, 400),
            new Punto(200, 400),
            new Punto(200, 390),
            new Punto(350, 390),
            new Punto(350, 400),
            new Punto(600, 400),
            new Punto(600, 390),
            new Punto(450, 390),
            new Punto(450, 400),
            new Punto(450, 385),
            new Punto(435, 385),
            new Punto(437, 385),
            new Punto(437, 320),
            new Punto(448, 320),
            new Punto(448, 385),
            new Punto(435, 385),
            new Punto(435, 400),
            new Punto(365, 400),
            new Punto(365, 385),
            new Punto(350, 385),
            new Punto(352, 385),
            new Punto(352, 320),
            new Punto(363, 320),
            new Punto(363, 385),
            new Punto(350, 385),
            new Punto(350, 400),
            new Punto(385, 400),
            new Punto(385, 340),
            new Punto(415, 340),
            new Punto(415, 400),
            new Punto(200, 400),
            new Punto(200, 250),
            new Punto(350, 250),
            new Punto(350, 315),
            new Punto(347, 315),
            new Punto(347, 320),
            new Punto(452, 320),
            new Punto(452, 315),
            new Punto(350, 315),
            new Punto(350, 225),
            new Punto(400, 200),
            new Punto(400, 140),
            new Punto(450, 140),
            new Punto(435, 155),
            new Punto(450, 170),
            new Punto(400, 170),
            new Punto(400, 200),
            new Punto(450, 225),
            new Punto(450, 315),
            new Punto(450, 250),
            new Punto(600, 250),
            new Punto(600, 400),};
            this.setFigura(figura);
            ventana.repaint();
        }
        else if(ae.getSource()== JMIrotacion){
            int ang;
            ang =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del ángulo"));
            this.rotacion(ang);
            ventana.repaint();
        }
        else if(ae.getSource()== JMItraslacion){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.trasladar(x,y);
            ventana.repaint();
        }
        if(ae.getSource()==JB_escalar1){
            float esc;
            esc = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento"));
            this.escalarFijo(esc,150,150);
            ventana.repaint();
        }
        else if(ae.getSource()==JB_escalar2){
            float x,y;
            x=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento en en X"));
            y=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de escalamiento en Y"));
            this.escalarFijo(x,y,150,150);
            ventana.repaint();
        }
        else if(ae.getSource()== JB_reflejarX){
            this.reflexionX();
            ventana.repaint();
        }
        else if(ae.getSource()== JB_reflejarY){
            this.reflexionY();
            ventana.repaint();
        }
        else if(ae.getSource()== JB_reflejocompleto){
            this.reflexionXY();
            ventana.repaint();
        }
        else if(ae.getSource()== JB_reiniciar){
            Punto[] figura = {
            new Punto(100, 400),
            new Punto(700, 400),
            new Punto(200, 400),
            new Punto(200, 390),
            new Punto(350, 390),
            new Punto(350, 400),
            new Punto(600, 400),
            new Punto(600, 390),
            new Punto(450, 390),
            new Punto(450, 400),
            new Punto(450, 385),
            new Punto(435, 385),
            new Punto(437, 385),
            new Punto(437, 320),
            new Punto(448, 320),
            new Punto(448, 385),
            new Punto(435, 385),
            new Punto(435, 400),
            new Punto(365, 400),
            new Punto(365, 385),
            new Punto(350, 385),
            new Punto(352, 385),
            new Punto(352, 320),
            new Punto(363, 320),
            new Punto(363, 385),
            new Punto(350, 385),
            new Punto(350, 400),
            new Punto(385, 400),
            new Punto(385, 340),
            new Punto(415, 340),
            new Punto(415, 400),
            new Punto(200, 400),
            new Punto(200, 250),
            new Punto(350, 250),
            new Punto(350, 315),
            new Punto(347, 315),
            new Punto(347, 320),
            new Punto(452, 320),
            new Punto(452, 315),
            new Punto(350, 315),
            new Punto(350, 225),
            new Punto(400, 200),
            new Punto(400, 140),
            new Punto(450, 140),
            new Punto(435, 155),
            new Punto(450, 170),
            new Punto(400, 170),
            new Punto(400, 200),
            new Punto(450, 225),
            new Punto(450, 315),
            new Punto(450, 250),
            new Punto(600, 250),
            new Punto(600, 400),};
            this.setFigura(figura);
            ventana.repaint();
        }
        else if(ae.getSource()== JB_rotacion){
            int ang;
            ang =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del ángulo"));
            this.rotacionFija(ang,150,150);
            ventana.repaint();
        }
        else if(ae.getSource()== JB_traslacion){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.trasladar(x,y);
            ventana.repaint();
        }
    }
}



class Listener implements KeyListener{
    Ventana ventana;

    public Listener(Ventana ventana){
        this.ventana = ventana;
    }        

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == KeyEvent.VK_UP){
            ventana.trasladar(0, -10);
            ventana.repaint();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_DOWN){
            ventana.trasladar(0, 10);
            ventana.repaint();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            ventana.trasladar(-10, 0);
            ventana.repaint();
        }
        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            ventana.trasladar(10, 0);
            ventana.repaint();
        }
        else if (ke.isControlDown() && ke.getKeyChar()!= 'z' && ke.getKeyCode() == KeyEvent.VK_Z){
            Punto[] figura = {
            new Punto(100, 400),
            new Punto(700, 400),
            new Punto(200, 400),
            new Punto(200, 390),
            new Punto(350, 390),
            new Punto(350, 400),
            new Punto(600, 400),
            new Punto(600, 390),
            new Punto(450, 390),
            new Punto(450, 400),
            new Punto(450, 385),
            new Punto(435, 385),
            new Punto(437, 385),
            new Punto(437, 320),
            new Punto(448, 320),
            new Punto(448, 385),
            new Punto(435, 385),
            new Punto(435, 400),
            new Punto(365, 400),
            new Punto(365, 385),
            new Punto(350, 385),
            new Punto(352, 385),
            new Punto(352, 320),
            new Punto(363, 320),
            new Punto(363, 385),
            new Punto(350, 385),
            new Punto(350, 400),
            new Punto(385, 400),
            new Punto(385, 340),
            new Punto(415, 340),
            new Punto(415, 400),
            new Punto(200, 400),
            new Punto(200, 250),
            new Punto(350, 250),
            new Punto(350, 315),
            new Punto(347, 315),
            new Punto(347, 320),
            new Punto(452, 320),
            new Punto(452, 315),
            new Punto(350, 315),
            new Punto(350, 225),
            new Punto(400, 200),
            new Punto(400, 140),
            new Punto(450, 140),
            new Punto(435, 155),
            new Punto(450, 170),
            new Punto(400, 170),
            new Punto(400, 200),
            new Punto(450, 225),
            new Punto(450, 315),
            new Punto(450, 250),
            new Punto(600, 250),
            new Punto(600, 400),};
            ventana.setFigura(figura);
            ventana.repaint();
        }
        else if (ke.isControlDown() && ke.getKeyChar() != 'a' &&  ke.getKeyCode() == KeyEvent.VK_A){
            ventana.escalarFijo(1.1f,250,250);
            ventana.repaint();
        }
        else if (ke.isControlDown() && ke.getKeyChar() != 'e' &&  ke.getKeyCode() == KeyEvent.VK_E){
            ventana.escalarFijo(0.9f,250,250);
            ventana.repaint();
        }
        else if (ke.isControlDown() && ke.getKeyChar() != 'r' &&  ke.getKeyCode() == KeyEvent.VK_R){
            ventana.rotacionFija(50, 150,150);
            ventana.repaint();
        }
        //Refelejar en x
        else if (ke.isControlDown() && ke.getKeyChar() != 'x' &&  ke.getKeyCode() == KeyEvent.VK_X){
            ventana.reflexionX();
            ventana.repaint();
        }
        //Reflejar en Y
        else if (ke.isControlDown() && ke.getKeyChar() != 'y' &&  ke.getKeyCode() == KeyEvent.VK_Y){
            ventana.reflexionY();
            ventana.repaint();
        }
        //Reflejar XY
        else if (ke.isControlDown() && ke.getKeyChar() != 'f' &&  ke.getKeyCode() == KeyEvent.VK_F){
            ventana.reflexionXY();
            ventana.repaint();
        }
        
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}


class MouseListener implements java.awt.event.MouseListener{
    Ventana ventana;
    public MouseListener (Ventana ventana){
        this.ventana = ventana;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.isControlDown() && me.getButton() == 1){
            ventana.rotacionFija(50, 150,150);
            ventana.repaint();
        }
        else if (me.isControlDown() && me.getButton() == 2){
            ventana.escalarFijo(1.1f,250,250);
            ventana.repaint();
        }
        else if (me.isControlDown() && me.getButton() == 3){
            ventana.escalarFijo(0.9f,250,250);
            ventana.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
