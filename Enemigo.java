import greenfoot.*;

public class Enemigo extends Actor {
    private int velocidad;  //creo este private para que cada una tenga un velocidad diferente
    private int direccion;  //creo este private para que cada una tenga un direccion diferente

    public Enemigo() {
        velocidad = Greenfoot.getRandomNumber(3) + 2; //velocidad aleatoria entre 2 y 5 
        direccion = Greenfoot.getRandomNumber(360); // aca le pongo una direccion aleatoria entre 0 y 360 grados
        GreenfootImage imagen = new GreenfootImage("EnemyDrone.png"); // le pongo la imagen
        imagen.scale(70, 70); 
        setImage(imagen);
    }

    //esto verifica los bordes para que no se vayan
    public void act() {
        moverEnemigo(); // mueve al enemigo
        verificarLimites(); // verifica si el dron choca con los bordes
    }   

   // mueve el enemigo
    private void moverEnemigo() {
        // Calcula el desplazamiento en X y Y usando la velocidad y la dirección
        int x = (int)(velocidad * Math.cos(Math.toRadians(direccion)));
        int y = (int)(velocidad * Math.sin(Math.toRadians(direccion)));
        setLocation(getX() + x, getY() + y); // Actualiza la posición del enemigo
    }

    
     // esto verifica si el enemigoalcanzo los bordes del mundo y cambia la direccion
     
    private void verificarLimites() {
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || 
            getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            direccion = (direccion + 180) % 360; // Cambia la dirección al chocar con un borde
        }
    }
}

