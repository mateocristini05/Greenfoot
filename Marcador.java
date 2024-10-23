import greenfoot.*;

public class Marcador extends Actor {
    private int puntos = 0; // inicio el puntaje en 0 

    public void actualizarPuntos(int nuevosPuntos) {
        this.puntos = nuevosPuntos; // le actualizo los puntos
        actualizarImagen(); // actualizo el marcador en pantalla
    }
// le pongo el color al marcador y pongo el texto en pantalla
    private void actualizarImagen() {
        setImage(new GreenfootImage("Puntuación: " + puntos, 24, Color.WHITE, new Color(0, 0, 0, 0)));
    }

}
    
