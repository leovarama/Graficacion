package Proyecto;

public class Punto {
    private int x;
    private int y;
    
    
    /**
     * Generar un punto en las coordenadas (0,0)
    */
    public Punto (){
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Generar un punto en las coordenadas (x,y)
     * @param x coordenada en x del punto
     * @param y coordenada en y del punto
     */
    public Punto (int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Metodo que recupera la coordenada en x de un punto
     * @return coordenada en x
     */
    public int getX() {
        return x;
    }
    
    
    /**
     * Asignar valor de la coordenada en x
     * @param x coordenada en x
     */
    public void setX(int x) {
        this.x = x;
    }
    
    
    /**
     * Metodo que recupera la coordenada en y de un punto
     * @return coordenada en y
     */
    public int getY() {
        return y;
    }

    /**
     * Asignar valor de la coordenada en y
     * @param y coordenada en y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    
}
