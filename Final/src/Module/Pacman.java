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
}
