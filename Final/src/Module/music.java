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

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;

class Music extends JPanel implements ActionListener {
        private static final long serialVersionUID = 1L;

        private Clip backgroundMusic;
        private Clip deathMusic;
        private Clip winMusic;
        private Clip gameoverMusic;
        File background = new File("C:/Users/phamt/Downloads/pacman-main/Final/bin/musicIG/BackGroundMusicfinal.wav");
        File death = new File("C:/Users/phamt/Downloads/pacman-main/Final/bin/musicIG/Deathmusic.wav");
        File win = new File("C:/Users/phamt/Downloads/pacman-main/Final/bin/musicIG/winGame.wav");
        File gameover = new File("C:/Users/Khanh/Downloads/pacman-main/Final/bin/musicIG/gameoverMusic.wav");


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
        
        public void playWinMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
                AudioInputStream winInputStream = AudioSystem.getAudioInputStream(win);
                winMusic = AudioSystem.getClip();
                winMusic.open(winInputStream);
                if (winMusic != null && !winMusic.isRunning()) {
                    winMusic.start();
                }
            } 

        public void gameoverMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
            AudioInputStream gameoverInputStream = AudioSystem.getAudioInputStream(gameover);
            gameoverMusic = AudioSystem.getClip();
            gameoverMusic.open(gameoverInputStream);
            if (gameoverMusic != null && !gameoverMusic.isRunning()) {
                gameoverMusic.start();
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