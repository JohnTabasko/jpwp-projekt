package skeleton;

public class Missile extends Sprite {

    private final int BOARD_WIDTH = 1080;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("src/images/11.png");  
        getImageDimensions();
    }

    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH) { // Gdy pocisk uderzy w prawą krawędź tablicy, staje się niewidzialny 
            visible = false;
        }
    }
}
