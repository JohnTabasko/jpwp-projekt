//Panel gdzie gra będzie się znajdować

package abcatcher;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import java.awt.*;  //do wczytania obrazka
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Board extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
    }

    private void drawDonut(Graphics g) { /* dobrą praktyką jest delegowanie 
                                         rzeczywistego malowania na określoną metodę*/ 
        Graphics2D g2d = (Graphics2D) g; // klasa Graphics2D stanowi rozszerzenie klasy
                                         // klasy Graphics. Zapewnia większą kontrolę nad 
                                         // geometrią, transformacje współrzędnych, 
                                         // zarządzanie kolorami i układ tekstu
        RenderingHints rh   // Wygładzanie rysunku
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize(); // pobieram szerokość i wysokość okna
        double w = size.getWidth(); // potrzebuję je do wycentrowania donuta
        double h = size.getHeight();// w oknie

        Ellipse2D e = new Ellipse2D.Double(0, 0, 150, 200); // tworzę elipsę
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        for (double deg = 0; deg < 360; deg += 5) { // tutaj obracam elipsę 72 razy
            AffineTransform at                      // aby utworzyć kształt donuta
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
}