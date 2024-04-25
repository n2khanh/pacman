package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Module.Pacman;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class HomeMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static MusicMenu bg = new MusicMenu();


	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
					Image icon = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/icon.png").getImage();
					HomeMenu frame = new HomeMenu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setIconImage(icon);
					try {
						bg.playBackgroundMusic();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	/**
	 * Create the frame.
	 */
	public HomeMenu() {
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
        ImageIcon backgroundImage = new ImageIcon("C:/Users/Khanh/Downloads/pacman-main/Final/src/images/images.png");

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
		contentPane.setLayout(null);
				
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setBounds(242, 351, 162, 54);
		btnSetting.setBackground(Color.YELLOW);
		btnSetting.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		contentPane.add(btnSetting);
		contentPane.setComponentZOrder(btnSetting, 0);
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SettingMenu frame = new SettingMenu();
				frame.setTitle("Pacman");
				frame.setSize(650,700);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
     		}
		});
		
		JButton btnInstruction = new JButton("GUIDE");
		btnInstruction.setBounds(242, 427, 162, 54);
		btnInstruction.setBackground(Color.YELLOW);
		btnInstruction.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		contentPane.add(btnInstruction);
		btnInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GuideMenu frame = new GuideMenu();
				frame.setTitle("Pacman");
				frame.setSize(650,700);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
     		}
		});
		contentPane.setComponentZOrder(btnInstruction, 0);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(242, 498, 162, 54);
		btnExit.setBackground(Color.lightGray);
		btnExit.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		contentPane.add(btnExit);
		contentPane.setComponentZOrder(btnExit, 0);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBounds(242, 273, 162, 54);
		btnPlay.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnPlay.setBackground(Color.YELLOW);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bg.stopBGMusic();
				dispose();
				Pacman pac = null;
				try {
					pac = new Pacman();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pac.setTitle("Pacman");
				pac.setSize(650,700);
				pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
				pac.setLocationRelativeTo(null);
				pac.setVisible(true);
				
     		}
		});
		btnPlay.setToolTipText("");
		contentPane.add(btnPlay);
		contentPane.setComponentZOrder(btnPlay, 0);
	}
	
}
