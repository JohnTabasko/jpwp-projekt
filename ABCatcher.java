package abcatcher;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class ABCatcher extends JFrame {
    
    public ABCatcher() {

        initUI();
    }

    private void initUI() {

        add(new Board()); // Tutaj umieszczam Board do centrum kontenera JFrame

        setSize(1920, 1080);

        setTitle("ABCatcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            ABCatcher ex = new ABCatcher();
            ex.setVisible(true);
        });
    }
}