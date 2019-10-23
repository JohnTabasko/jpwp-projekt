package abcatcher;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageFrame extends JFrame {

	public ImageFrame() {
		super("ABCatcher");

		JPanel imagePanel = new ImagePanel();
		add(imagePanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}