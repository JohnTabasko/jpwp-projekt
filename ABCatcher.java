package abcatcher;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class ABCatcher extends JFrame{
    

    public ABCatcher() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(1920, 1080);
        setResizable(false); //użytkownik nie może zmienić rozmiaru ramki
        
        setTitle("ABCatcher");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            ABCatcher ex = new ABCatcher();
            ex.setVisible(true);
        });
    }
}