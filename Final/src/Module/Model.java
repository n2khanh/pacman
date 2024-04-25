package Module;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.HomeMenu;

public class Model extends JPanel implements ActionListener {

	private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false;
    private boolean dying = false;
    private Music backgroundmusic = new Music();;
    private Music deathmusic = new Music();
    private Music oveMusic = new Music();
    private final int BLOCK_SIZE = 30 ;
    private final int N_BLOCKS = 21 ;
    private final int SCREEN_SIZE = BLOCK_SIZE * N_BLOCKS;
    private final int MAX_GHOSTS = 6;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 6;
    private int lives, score;
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    private Image heart, ghost;
    private Image up, down, left, right;

    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy;

    private final short levelData[] = {
    		19,26,26,26,18,26,26,26,26,22, 0,19,26,26,26,26,18,26,26,26,22,
        	21, 0, 0, 0,21, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,21, 0, 0, 0,21,
        	21, 0, 0, 0,21, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,21, 0, 0, 0,21,
        	17,26,26,26,16,26,18,26,26,24,26,24,26,26,18,26,16,26,26,26,20,
        	21, 0, 0, 0,21, 0,21, 0, 0, 0, 0, 0, 0, 0,21, 0,21, 0, 0, 0,21,
        	25,26,26,26,20, 0,25,26,26,22, 0,19,26,26,28, 0,17,26,26,26,28,
        	 0, 0, 0, 0,21, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,21, 0, 0, 0, 0, 
        	 0, 0, 0, 0,21, 0,19,26,26,16,18,16,26,26,22, 0,21, 0, 0, 0, 0,
        	 0, 0, 0, 0,21, 0,21, 0, 0,17,32,20, 0, 0,21, 0,21, 0, 0, 0, 0,
        	27,26,26,26,16,26,20, 0,19,16,16,16,22, 0,17,26,16,26,26,26,30,
        	 0, 0, 0, 0,21, 0,21, 0,25,24,24,24,28, 0,21, 0,21, 0, 0, 0, 0,
        	 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,
        	 0, 0, 0, 0,21, 0,17,26,26,26,26,26,26,26,20, 0,21, 0, 0, 0, 0,
        	 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,
        	19,26,26,26,16,26,24,26,26,22, 0,19,26,26,24,26,16,26,26,26,22,
        	21, 0, 0, 0,21, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0,21, 0, 0, 0,21,
        	25,26,22, 0,17,26,18,26,26,24,26,24,26,26,18,26,20, 0,19,26,28,
        	 0, 0,21, 0,21, 0,21, 0, 0, 0, 0, 0, 0, 0,21, 0,21, 0,21, 0, 0,
        	19,26,24,26,28, 0,25,26,26,22, 0,19,26,26,28, 0,25,26,24,26,22,
        	21, 0, 0, 0, 0, 0, 0, 0, 0,21, 0,21, 0, 0, 0, 0, 0, 0, 0, 0,37,
        	25,26,26,26,26,26,26,26,26,24,26,24,26,26,26,26,26,26,26,26,28,
    		
    };

    private final int validSpeeds[] = { 1 , 2 , 3 , 5 , 6 , 10 };
    private final int maxSpeed = 10;

    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;
   
    public Model() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }
    
    
    private void loadImages() {
    	down = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/down.gif").getImage();
    	up = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/up.gif").getImage();
    	left = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/left.gif").getImage();
    	right = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/right.gif").getImage();
        ghost = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/ghost.gif").getImage();
        heart = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/heart.png").getImage();

    }
       private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(1000, 700);
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];
        
        timer = new Timer(60, this);
        timer.start();
    }

    private void playGame(Graphics2D g2d) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        if (dying) {
        	backgroundmusic.stopBGMusic();
        	deathmusic.playDeathMusic();
        	Thread.sleep(1000);
        	backgroundmusic.playBackgroundMusic();
            death();

        } else {
            movePacman();
            drawPacman(g2d);
            moveGhosts(g2d);
            checkMaze();
        }
    }

    private void showIntroScreen(Graphics2D g2d) {
 
    	String start = "Press SPACE to start";
    	g2d.setFont(new Font("NewellsHand", Font.PLAIN, 18));
        g2d.setColor(Color.yellow);
        g2d.drawString(start, (8*BLOCK_SIZE) , 350);
    }

    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + score;
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (int i = 0; i < lives; i++) {
            g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }

    private void checkMaze() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        int i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {

            if ((screenData[i] & 16) != 0 ) {
                finished = false;
            }

            i++;
        }

        if (finished) {
        	backgroundmusic.stopBGMusic();
            backgroundmusic.playWinMusic();
            inGame = false;
        }
    }

    private void death() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

    	lives--;

        if (lives == 0) {

			deathmusic.gameoverMusic();
			backgroundmusic.stopBGMusic();
            inGame = false;
        }

        continueLevel();
    }

    private void moveGhosts(Graphics2D g2d) {

        int pos;
        int count;

        for (int i = 0; i < N_GHOSTS; i++) {
            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {
                pos = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (int) (ghost_y[i] / BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);
            drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

            if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && inGame) {

                dying = true;
                
            }
        }
    }
    private void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	backgroundmusic.playBackgroundMusic();
    	
   }


    private void drawGhost(Graphics2D g2d, int x, int y) {
    	g2d.drawImage(ghost, x, y, this);
        }

    private void movePacman() {

        int pos;
        short ch;

        if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
            pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
            ch = screenData[pos];
            
            if((ch & 32) != 0) {
            	screenData[pos] = (short) (ch & 31);
            	score+=5;
            	if(lives < 4) lives++;
            }
            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                }
            }

            // Check for standstill
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        } 
        pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
        pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
    }

    private void drawPacman(Graphics2D g2d) {

        if (req_dx == -1) {
        	g2d.drawImage(left, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dx == 1) {
        	g2d.drawImage(right, pacman_x + 1, pacman_y + 1, this);
        } else if (req_dy == -1) {
        	g2d.drawImage(up, pacman_x + 1, pacman_y + 1, this);
        } else {
        	g2d.drawImage(down, pacman_x + 1, pacman_y + 1, this);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(new Color(0,72,251));
                g2d.setStroke(new BasicStroke(5));
                
                if ((levelData[i] == 0)) { 
                	g2d.setColor(Color.BLACK);
                	g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
         
                 }

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(Color.ORANGE);
                    g2d.fillOval(x + 10, y + 10, 6, 6);
               }
                if((screenData[i] & 32) != 0) {
                	g2d.setColor(Color.ORANGE);
                	g2d.fillOval(x+10, y+10, 15, 15);
                }

                i++;
            }
        }
    }

    private void initGame() {

    	lives = 3;
        score = 0;
        initLevel();
        N_GHOSTS = 6;
        currentSpeed = 3;
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    private void continueLevel() {

    	int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {

            ghost_y[i] = 10 * BLOCK_SIZE; //start position
            ghost_x[i] = 10 * BLOCK_SIZE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostSpeed[i] = validSpeeds[random];
        }

        pacman_x = 10 * BLOCK_SIZE;  //start position
        pacman_y = 16 * BLOCK_SIZE;
        pacmand_x = 0;	//reset direction move
        pacmand_y = 0;
        req_dx = 0;		// reset direction controls
        req_dy = 0;
        dying = false;
    }

 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame) {
			try {
				playGame(g2d);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        else {
        	showIntroScreen(g2d);
        }
        

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }


    //controls
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    try {
						playMusic();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    initGame();
                }
            }
        }
			
}
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
		
	}
