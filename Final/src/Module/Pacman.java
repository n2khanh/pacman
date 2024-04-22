package Module;



import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Pacman extends JFrame{

	public Pacman() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		add(new Model());
	}
	
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Image icon = new ImageIcon("images/icon.png").getImage();
		Pacman pac = new Pacman();
		pac.setVisible(true);
		pac.setTitle("Pacman");
		pac.setSize(650,700);
		pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pac.setLocationRelativeTo(null);
		pac.setIconImage(icon);
		
	}

}
