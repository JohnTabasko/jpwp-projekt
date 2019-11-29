package projekt_29_11;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Projekt_29_11 extends JFrame {

    public Projekt_29_11(){
        initUI();
    }
    
    private void initUI(){
        add(new Board());
        pack();
        //setSize(1980, 1080);
        
        setTitle("ABCatcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Projekt_29_11 ex = new Projekt_29_11();
            ex.setVisible(true);
        });
    }
    
}




