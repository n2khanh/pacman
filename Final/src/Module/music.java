package Module;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

class music extends JPanel implements ActionListener {
        private static final long serialVersionUID = 1L;

        private Clip backgroundMusic;
        private Clip deathMusic;
        File background = new File("D:\\Study\\Final\\bin\\musicIG\\BackGroundMusicfinal.wav");
        File death = new File("D:\\Study\\Final\\bin\\musicIG\\Deathmusic.wav");


       public void playBackgroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        	AudioInputStream backgroundInputStream = AudioSystem.getAudioInputStream(background);
        	backgroundMusic = AudioSystem.getClip();
        	backgroundMusic.open(backgroundInputStream);
            if (backgroundMusic != null && !backgroundMusic.isRunning()) {
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }

        public void playDeathMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        	AudioInputStream deathInputStream = AudioSystem.getAudioInputStream(death);
        	deathMusic = AudioSystem.getClip();
        	deathMusic.open(deathInputStream);
            if (deathMusic != null && !deathMusic.isRunning()) {
                deathMusic.start();
            }
        }

        public void stopBGMusic() {
        	backgroundMusic.stop();
        }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}