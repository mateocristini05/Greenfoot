import greenfoot.*;

public class Jugador extends Actor {
    
    //defino los atributos
    private int marcador = 0; // marcador lo arranco en 0 
    private Marcador marcadorPantalla; // referencia al marcador en pantalla
    private MundoJuego mundo; // referencia al mundo del juego

   //esto es el constructor
    public Jugador(Marcador marcadorPantalla) {
        this.marcadorPantalla = marcadorPantalla; 
        setImage("Spaceship.png"); 
        getImage().scale(90, 90);
    }

    public void añadeAlMundo(World mundo) {
        this.mundo = (MundoJuego) mundo; // asigna la referencia al mundo del juego cuando se añade el jugador
    }

    //esto se ejecuta en todos los ciclos del juego
    public void act() {
        moverJugador(); //mueve la nave
        verificarColeccionable(); // verifica si recolecto un cofre
        verificarEnemigo(); // verifica si choco
    }

    private void moverJugador() {
        // muevo con las flechas
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
            setRotation(270); // mira hacia la izquierda
        } else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
            setRotation(90); // mira hacia la derecha
        } else if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
            setRotation(0); // mira hacia arriba
        } else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
            setRotation(180); // mira hacia abajo
        }
    }

   //esto verffica que si agarro un coleccionable que aumente el marcador
    private void verificarColeccionable() {
        if (isTouching(Coleccionable.class)) {
            Coleccionable coleccionable = (Coleccionable) getOneIntersectingObject(Coleccionable.class);
            if (coleccionable != null) {
                removeTouching(Coleccionable.class); // elimina el coleccionable tocado
                marcador++; // aumento el marcador
                marcadorPantalla.actualizarPuntos(marcador); // actualiza el marcador conlos nuevos puntos
                generarNuevoColeccionable(); // genera un nuevo coleccionable
            }
        }
    }
    
    private void generarNuevoColeccionable() {
        Coleccionable coleccionable = new Coleccionable();
        // genera un tesoro dentro de los limites del mundo que hice
        int x = Greenfoot.getRandomNumber(mundo.getWidth());
        int y = Greenfoot.getRandomNumber(mundo.getHeight());
        mundo.addObject(coleccionable, x, y); // aca lo añade en una posicion aleatoria 
    }


    private void verificarEnemigo() {
        Actor enemigo = getOneIntersectingObject(Enemigo.class); // obtiene el enemigo que toca al jugador, getOne.. se encuentra en la documentacion de greenfoot
        if (enemigo != null) {
            //esto lo hago para calcular la distancia entre el jugador y el el dron que va volando
            int distancia = (int) Math.sqrt(Math.pow(getX() - enemigo.getX(), 2) + Math.pow(getY() - enemigo.getY(), 2));
            int umbral = 40; // el rango invisible que tiene el enemigo que te hace perder si lo tocas

            if (distancia < umbral) {
                ((MundoJuego) getWorld()).finDelJuego(); // termina el juego si se acerca mas de lo debido
            }
        }
    }
}

