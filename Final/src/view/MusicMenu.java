package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicMenu {
    private static final long serialVersionUID = 1L;

    private Clip backgroundMusic;
    private Clip deathMusic;
    File background = new File("C:\\Users\\Khanh\\Downloads\\BackGroundMusicfinal.wav");
    File death = new File("C:\\Users\\Khanh\\Downloads\\Deathmusic.wav");
	
	public void playBackgroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	AudioInputStream backgroundInputStream = AudioSystem.getAudioInputStream(background);
    	backgroundMusic = AudioSystem.getClip();
    	backgroundMusic.open(backgroundInputStream);
        if (backgroundMusic != null && !backgroundMusic.isRunning()) {
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
	 public void stopBGMusic() {
     	backgroundMusic.stop();
     }
}
