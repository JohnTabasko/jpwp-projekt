//Klasa, w której znajduje się panel, gdzie gra ma miejsce
package skeleton;
/*
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Board extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        drawDonut(g);
    }
    
    private void drawDonut(Graphics g){ // dobrą praktykąjest delegowanie rzeczywistego malowania na określoną metodę
        Graphics2D g2d = (Graphics2D) g; // dziedziczy po klasie Graphics, jest bardziej
                                         // rozbudowana, zapewnia większą kontrolę nad geometrią, 
                                         // kolorami, przekształcaniem położenia współrzędnych itd.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // służy do wygładzania rysunku
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        g2d.setRenderingHints(rh);
        
        Dimension size = getSize(); // pobieramy wysokość i szerokość okna, potrzebujemy je do wycentrowania kształtu
        double w = size.getWidth();
        double h = size.getHeight();
        
        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130); // rysowanie elipsy
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);
        
        for (double deg = 0; deg < 360; deg += 5){ // elipsa obracana jest 72 razy aby utworzyć kształt
            AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
    
    
    public Board(){
        
    }
}
*/
/*
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private Image obraz;

    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        loadImage();
        
        int w = obraz.getWidth(this); // określam szerokość i wysokość obrazu.
                                      // Rozmiar panelu tablicy jest ustawiony na wymiary obrazu.
                                      // We współpracy z metodą pack() JFrame okno jest 
                                      // wystarczająco duże by pokazać obraz.
        int h =  obraz.getHeight(this);
        setPreferredSize(new Dimension(w, h));   // (1920 x 1080)     
    }
    
    private void loadImage() {       
        ImageIcon ii = new ImageIcon("src/images/jpg2.jpg"); // Tworzę ImageIcon
        obraz = ii.getImage();  // Otrzymuję obraz z ImageIcon      
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(obraz, 0, 0, null); // Rysuję obraz w oknie
    }
}*/
/*
// NAJRPOSTRZA METODA WYKORZYSTUJĄCA javax.Swing.Timer

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel
        implements ActionListener {

    private final int B_WIDTH = 1920;
    private final int B_HEIGHT = 1080;
    private final int INITIAL_X = -40; // początkowe współrzędne gwiazdy
    private final int INITIAL_Y = -40;
    private final int DELAY = 4; // szybkość animacji

    private Image star;
    private Timer timer;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/images/star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();
        
        x = INITIAL_X;
        y = INITIAL_Y;
        
        timer = new Timer(DELAY, this); // Tworzę klasę Swing Timer i wywołuję jej metodę start().
        timer.start();                  // Z każdym opóźnieniem w ms licznik wywoła metodę actionPerformed().
                                        // Aby użyć actionPerformed() musimy zaimplementować 
                                        // interfejs ActionListener.
    }

    @Override
    public void paintComponent(Graphics g) { // Rzeczywiste malowanie jest delegowane do metody drawStar().
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync(); // synchronizuje malowanie w systemach buforujących
                                            // zdarzenia graficzne. Bez tego wiersza animacja
                                            // może nie być płynna w systemie Linux
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }

        repaint();
    }
}*/

// METODA WYKORZYSTUJĄCA java.utill.Timer

/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel  {

    private final int B_WIDTH = 1920;
    private final int B_HEIGHT = 1080;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;    
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 4;
    
    private Image star;
    private Timer timer;
    private int x, y;
    
    public Board() {
    
        initBoard();        
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/images/star.png");
        star = ii.getImage();        
    }
    
    private void initBoard() {
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 
                INITIAL_DELAY, PERIOD_INTERVAL);        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }
    
    private void drawStar(Graphics g) {
        
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            
            x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            
            repaint();
        }
    }
}*/

//  METODA WYKORZYSTUJĄCA WĄTKI (Thread)
/*
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel
        implements Runnable {

    private final int B_WIDTH = 1920;
    private final int B_HEIGHT = 1080;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Thread animator;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/images/star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.pink);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    @Override
    public void addNotify() { // Metoda używana do różnych zadań inicjalizacyjnych
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime; // Chcę aby gra działała płynnie i ze
            sleep = DELAY - timeDiff;                           // stałą prędkościa, dlatego obliczam czas
                                                                // systemowy.
            // Metody cycle() i repaint() mogą zająć inny czas w różnych cyklach while.
            // Obliczam czas działania obu metod i odejmuję go od stałej DELAY. 
            // W ten sposób mam pewność, że każdy cykl działa w takim samym czasie.
            // (Opóźnienie w ms dla każdego cyklu).
            
            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                
                String msg = String.format("Thread interrupted: %s", e.getMessage());
                
                JOptionPane.showMessageDialog(this, msg, "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}*/
/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private SpaceShip spaceShip;
    private final int DELAY = 10;

    public Board() {

        initBoard();
    }

    private void initBoard() {
        
        //setBackground(Color.PINK);
        addKeyListener(new TAdapter());
        setBackground(Color.pink);
	setFocusable(true);

        spaceShip = new SpaceShip();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) { // Rysuję obiekt za pomocą metody drawImage().
                                         // Pobieram obraz i współrzędne z klasy 'sprite'.
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), 
            spaceShip.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { // Metoda wywoływana z każdą milisekundą opóźnienia. 
                                                 // Wywołuję metodę step().
        step();
    }
    
    private void step() { // Przesuwam sprite i odmalowuję część planszy, która się zmieniła.
                          // Używam techniki optymalizacji, która odmalowuje tylko mały obszar okna, 
        spaceShip.move(); // który się zmienił.
        
        repaint(spaceShip.getX()-1, spaceShip.getY()-1, 
                spaceShip.getWidth()+2, spaceShip.getHeight()+2);     
    }    

    private class TAdapter extends KeyAdapter { // W klasie Board nasłuchujemy wydarzeń.
                                                // Nadpisane metody klasy KeyAdapter delegują 
        @Override                               // przetwarzanie do metod klasy statku
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }
}*/
/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    private SpaceShip spaceShip;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);

        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) { // Rysuję statek i wszystkie dostępne pociski.

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(spaceShip.getImage(), spaceShip.getX(),
                spaceShip.getY(), this);

        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updateSpaceShip();

        repaint();
    }

    private void updateMissiles() { // Analizuję wszystkie pociski z listy. W zależności
                                    // od tego, co zwraca metoda isVisible(), albo
                                    // przesuwam pocisk, albo usuwam go z pojemnika.
        List<Missile> missiles = spaceShip.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {

            Missile missile = missiles.get(i);

            if (missile.isVisible()) {

                missile.move();
            } else {

                missiles.remove(i);
            }
        }
    }

    private void updateSpaceShip() {

        spaceShip.move();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }
}*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private SpaceShip spaceship;
    private List<Alien> aliens;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 1920;
    private final int B_HEIGHT = 1080;
    private final int DELAY = 15;

    private final int[][] pos = { // Początkowe pozycje alien ships.
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 600}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        spaceship = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        initAliens();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initAliens() { // Metoda tworzy listę z objektami alien.
        
        aliens = new ArrayList<>();

        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) { // W metodzie albo rysuje sprite'y albo piszę grę nad komunikatem.
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) { // Metoda rysuje duszki w oknie.

        if (spaceship.isVisible()) {
            g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
                    this);
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile missile : ms) {
            if (missile.isVisible()) {
                g.drawImage(missile.getImage(), missile.getX(), 
                        missile.getY(), this);
            }
        }

        for (Alien alien : aliens) { // Rysuję wszystkich alienow (tylko wtedy, gdy nie są
                                     // wcześniej zniszczone (metoda isVisible().
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15); // W lewym rogu okna piszę jak dużo
                                                              // alienów jeszcze zostało.
    }

    private void drawGameOver(Graphics g) { // Metoda drukuje napis Game Over na środku okna.
                                            // W przypadku gdy zniszczymy alienów lub uderzymy w nich.

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame(); // Każde wydarzenie reprezentuje jeden cykl gry. Logika jest podzielona
                  // na konkretne metody. Np. updateMissiles() przenosi wszystkie dostępne
                  // pociski.

        updateShip();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updateShip() {

        if (spaceship.isVisible()) {
            
            spaceship.move();
        }
    }

    private void updateMissiles() {

        List<Missile> ms = spaceship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens() { // W metodzie najpierw sprawdzan czy są jeszcze jakieś obiekty w liście.
                                  // Gra jest skończona gdy lista jest pusta. Jeśli nie, idziemy przez listę
                                  // i poruszamy wszystkie jej obiekty. Zniszczone alieny są usuwane z listy.

        if (aliens.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    public void checkCollisions() { // Metoda sprawdza czy doszło do kolizji. Najpierw
                                    // sprawdzam, czy statek uderzył w aliena. Otrzymuję
                                    // prostokąt obiektów z metody getBounds(). Metoda 
                                    // intersects() sprawdza czy dwa prostokąty się skrzyżowały.

        Rectangle r3 = spaceship.getBounds();

        for (Alien alien : aliens) {
            
            Rectangle r2 = alien.getBounds();

            if (r3.intersects(r2)) {
                
                spaceship.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }

        List<Missile> ms = spaceship.getMissiles(); // Metoda sprawdza kolizje między pociskiem a alienem.

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Alien alien : aliens) {

                Rectangle r2 = alien.getBounds();

                if (r1.intersects(r2)) {
                    
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.keyPressed(e);
        }
    }
}
