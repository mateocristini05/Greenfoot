import greenfoot.*;
//esta es la clase del cofre 
public class Coleccionable extends Actor {
    
    public Coleccionable() {
        //le pongo la imagen y el tamaño nada mas 
        GreenfootImage imagen = new GreenfootImage("Tesoro.png"); 
        imagen.scale(80, 80);
        setImage(imagen);
    }
}
