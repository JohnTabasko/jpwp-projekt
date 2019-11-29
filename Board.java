package projekt_29_11;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Board extends JPanel{
    private Image background;
    private Image character;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard(){      
        loadImage();
        
        int w = background.getWidth(this);
        int h = background.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }
    
    private void loadImage(){
        ImageIcon ii = new ImageIcon("src/images/tlo2.png");
        ImageIcon boy = new ImageIcon("src/images/postac1.png");
        background  = ii.getImage();
        character = boy.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(background, 0, 0, null);
        g.drawImage(character, 1200, 810, null);
    }
}
