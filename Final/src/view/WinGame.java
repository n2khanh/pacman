package view;
import Module.Model;
import Module.Pacman;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class WinGame {
	private JPanel contentPane=new JPanel();
	private JFrame frame;

//	public WinGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//		initialize();
//	}

	public void initialize() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Model a=new Model();
		Pacman b=new Pacman();
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		contentPane.setBounds(0, 0, 400, 300);
	    frame.getContentPane().add(contentPane);
	 // Tạo JLabel để hiển thị hình ảnh
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 400, 300); 
        
        // Tải ảnh từ tệp hoặc URL
        ImageIcon backgroundImage = new ImageIcon("C:/Users/phamt/Downloads/pacman-main/Final/src/images/images (1).jpg");

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
        int newHeight = (int) (originalHeight * scale+85);
        Image scaledImage = backgroundImage.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        lblBackground.setIcon(scaledIcon);
        contentPane.add(lblBackground);
	    
	    frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YOU WIN");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
		lblNewLabel.setBounds(95, 65, 209, 73);
		contentPane.add(lblNewLabel);
		contentPane.setComponentZOrder(lblNewLabel, 0);
		
		
		JLabel lblNewLabel_1 = new JLabel("Score : "+a.score);
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		lblNewLabel_1.setBounds(68, 136, 266, 35);
		frame.getContentPane().add(lblNewLabel_1);
		contentPane.add(lblNewLabel_1);
		contentPane.setComponentZOrder(lblNewLabel_1, 0);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 10));
		btnNewButton.setBounds(45, 194, 99, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				b.setTitle("Pacman");
				b.setSize(650,700);
				b.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				b.setLocationRelativeTo(null);
				b.setVisible(true);
     		}
		});
        contentPane.setComponentZOrder(btnNewButton, 0);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setBackground(new Color(128, 0, 64));
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 10));
		btnNewButton_1.setBounds(221, 194, 99, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
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
        contentPane.setComponentZOrder(btnNewButton_1, 0);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}
}
