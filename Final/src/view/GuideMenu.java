package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Module.Pacman;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;

public class GuideMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public GuideMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 700);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane); // Thêm dòng này để gán contentPane cho frame

        // Tạo JLabel để hiển thị hình ảnh
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 650, 700);

        // Tải ảnh từ tệp hoặc URL
        ImageIcon backgroundImage = new ImageIcon("C://Users//phamt//Downloads//pacman-main//Final//src//images//images.png");

        Dimension frameSize = getSize();

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
    
    
	        
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnNewButton_1.setBounds(250, 600, 150, 45);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeMenu frame = new HomeMenu();
				frame.setTitle("Pacman");
				frame.setSize(650,700);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
     		}
		});
		contentPane.setComponentZOrder(btnNewButton_1, 0);
		
		JTextPane txtpnStartTheGame = new JTextPane();
		txtpnStartTheGame.setForeground(new Color(0, 0, 205));
		txtpnStartTheGame.setBackground(new Color(192, 192, 192));
		txtpnStartTheGame.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnStartTheGame.setText("Start the Game:\r\nPress the spacebar to begin the game.\r\nMove Pacman:\r\nUse the arrow keys (up, down, left, right) to navigate Pacman around the game board.\r\nObjective:\r\nEat all the dots (also known as pellets) on the map to score points.\r\nAvoid ghosts. If you consume a power pellet, you can temporarily eat the ghosts.\r\nTips:\r\nStrive to complete the board without getting caught by the ghosts.\r\nUtilize skill and strategy to achieve the highest score!\r\nHave fun playing! 🎮👻");
		txtpnStartTheGame.setBounds(50, 400, 550, 200);
		getContentPane().add(txtpnStartTheGame);
		contentPane.setComponentZOrder(txtpnStartTheGame, 0);
		contentPane.setLayout(null);
		
	}
}
