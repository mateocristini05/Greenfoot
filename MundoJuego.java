import greenfoot.*;

public class MundoJuego extends World {
    
    public MundoJuego() {    
        super(800, 600, 1); // configura el tamaño del mundo
        Marcador marcador = new Marcador(); // hago el marcador
        addObject(marcador, 100, 30); // pongo las coordenadas de donde quiero que esté el marcador
        Jugador jugador = new Jugador(marcador); // creo el jugador y le paso el marcador para que sume puntos
        addObject(jugador, getWidth() / 2, getHeight() / 2); // centro el jugador en el mapa dividiendo por 2 
        jugador.añadeAlMundo(this); // asigno el mundo al jugador
        generarColeccionable(); // genero los coleccionables
        generarEnemigos(); // hago los enemigos 
    }

    public void generarColeccionable() {
        Coleccionable coleccionable = new Coleccionable(); // genero un cofre
        int x = Greenfoot.getRandomNumber(getWidth()); // genera una posición x aleatoria para los cofres
        int y = Greenfoot.getRandomNumber(getHeight()); // genera una posición y aleatoria para los cofres
        addObject(coleccionable, x, y); // y lo coloco en una posición aleatoria
    }

    public void generarEnemigos() {
        for (int i = 0; i < 13; i++) { // defino cuántos enemigos quiero
            Enemigo enemigo = new Enemigo(); // creo un enemigo
            int x = Greenfoot.getRandomNumber(getWidth()); // lo creo en una posición x aleatoria
            int y = Greenfoot.getRandomNumber(getHeight()); // lo creo en una posición y aleatoria
            addObject(enemigo, x, y); // lo añado a una coordenada aleatoria
        }
    }

    public void finDelJuego() {
        showText("¡Perdiste! Presiona Reset para volver a jugar.", getWidth() / 2, getHeight() / 2); // muestro el mensaje en el centro
        Greenfoot.stop(); // Detiene el juego
    }
}

