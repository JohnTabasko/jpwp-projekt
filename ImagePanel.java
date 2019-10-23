package abcatcher;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.HashMap;

public class ImagePanel extends JPanel {

	public BufferedImage background; //https://docs.oracle.com/javase/6/docs/api/java/awt/image/BufferedImage.html
        public HashMap sprites;
        public BufferedImage character = null;
        
	public ImagePanel() {
		super();
                sprites = new HashMap();
/*-----------------------------------------TŁO--------------------------------------------------*/
		File imageFile = new File("C:/programowanie/JavaPodstawyCwiczenia/JavaPodstawy/zadania_strona/projekt/ABCatcher/tła/haloween/1_game_background.png");
		try {
			background = ImageIO.read(imageFile); //https://javastart.pl/baza-wiedzy/java-podstawy-jezyka/zapis-i-odczyt-z-plikow
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension_background = new Dimension(background.getWidth(), background.getHeight());
		setPreferredSize(dimension_background);
                
/*---------------------------------------POSTAC-------------------------------------------------*/                
                File postac = new File("C:/programowanie/JavaPodstawyCwiczenia/JavaPodstawy/zadania_strona/projekt/ABCatcher/postaci/postac1.png");
                if (character == null)
                try {
			character = ImageIO.read(postac); //https://javastart.pl/baza-wiedzy/java-podstawy-jezyka/zapis-i-odczyt-z-plikow
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		/*Dimension dimension_character = new Dimension(character.getWidth(), character.getHeight());
		setPreferredSize(dimension_character);*/
        }
        
        /*public BufferedImage getSprite (String path){
            BufferedImage img = (BufferedImage)sprites.get(path);
            if (img == null){
             img = loadImage("img/"+path);
             
            }
        }*/

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0, 0, this);
                g2d.drawImage(character, 800, 512, this);
	}
        /*@Override
        public void paint(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(character, 800, 512, this);
        }*/
}