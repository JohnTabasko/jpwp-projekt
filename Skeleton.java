package skeleton;

/*
import java.awt.EventQueue; //biblioteka z funkcjami odpowiedzialnymi za ruch
import javax.swing.JFrame; // 

public class Skeleton extends JFrame{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { // tworzę instancję kodu i sprawiam, że jest widoczny na ekranie
            Skeleton skeleton = new Skeleton();
            skeleton.setVisible(true);                    
        });
    }
    
    
    public Skeleton(){
        initUI();
    }
    
    
    private void initUI(){
        
        add(new Board()); // tutaj dodaję tablice do centrum kontenera JFrame
        setSize(800,800); //tutaj ustawiam rozmiar okna
        setTitle("Apka");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // zamknie aplikację gdy klikną na krzyżyk
                                                 // nie jest to standardowe zachowanie
        setLocationRelativeTo(null); // podanie null jako argument centruje okno na ekranie
    }
}
*/

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Skeleton extends JFrame {

    public Skeleton() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        
        setResizable(false); // ustawia, czy można zmienić rozmiar ramki
        pack(); // metoda powoduje, że okno będzie w rozmiarze jaki podałem jako 
                // PreferredSize i w podanym layoucie

        setTitle("Basiulka<3");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Skeleton ex = new Skeleton();
            ex.setVisible(true);
        });
    }
}