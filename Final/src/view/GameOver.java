package view;
import Module.Pacman;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class GameOver {
	
    private JFrame frame;
    private JPanel contentPane;

//    public GameOver() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//         initialize();
//    }

    public void initialize() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    	Pacman a=new Pacman();
        frame = new JFrame();
        frame.setTitle("Pacman");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); 
        
        contentPane = new JPanel(); 
        contentPane.setBounds(0, 0, 400, 300);
        frame.getContentPane().add(contentPane);

        // Tạo JLabel để hiển thị hình ảnh
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 400, 300); 
        
        // Tải ảnh từ tệp hoặc URL
        ImageIcon backgroundImage = new ImageIcon("C:/Users/phamt/Downloads/pacman-main/Final/src/images/1.jpg");

        Dimension frameSize = frame.getSize();

        // Lấy kích thước ảnh gốc
        int originalWidth = backgroundImage.getIconWidth();
        int originalHeight = backgroundImage.getIconHeight();

        // Tính tỷ lệ co giãn
        double widthScale = (double) frameSize.width / originalWidth;
        double heightScale = (double) frameSize.height / originalHeight;
        double scale = Math.min(widthScale, heightScale);

        // Tạo ảnh mới với kích thước đã co giãn
        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);
        Image scaledImage = backgroundImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        lblBackground.setIcon(scaledIcon);
        contentPane.add(lblBackground);
        
        frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		//Nút Play Agian
        JButton btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setBackground(new Color(0, 0, 255));
        btnPlayAgain.setForeground(new Color(255, 255, 0));
        btnPlayAgain.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 9));
        btnPlayAgain.setBounds(90, 143+50, 95, 37);
        contentPane.add(btnPlayAgain);
        btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				a.setTitle("Pacman");
				a.setSize(650,700);
				a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				a.setLocationRelativeTo(null);
				a.setVisible(true);
     		}
		});
        contentPane.setComponentZOrder(btnPlayAgain, 0);
        //Nút Menu
        JButton btnMenu = new JButton("Menu"); // Renamed btnNewButton_1_1 to btnMenu for clarity
        btnMenu.setBackground(new Color(128, 0, 64));
        btnMenu.setForeground(new Color(255, 128, 64));
        btnMenu.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 9));
        btnMenu.setBounds(215, 143+50, 95, 37);
        contentPane.add(btnMenu);
        btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMenu frame = new HomeMenu();
				frame.setTitle("Pacman");
				frame.setSize(650,700);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
     		}
		});
        contentPane.setComponentZOrder(btnMenu, 0);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

