package skeleton;

public class Alien extends Sprite {

    private final int INITIAL_X = 1080;

    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("src/images/15.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) { // Alien powraca na ekran z prawej strony jeśli zniknął z lewej.
            x = INITIAL_X;
        }

        x -= 1;
    }
}
