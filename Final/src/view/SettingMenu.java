package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;


public class SettingMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public SettingMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(446, 259, 64, 60);
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		contentPane.add(btnNewButton);
		contentPane.setComponentZOrder(btnNewButton, 0);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(124, 259, 64, 60);
		btnNewButton_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
		contentPane.add(btnNewButton_1);
		contentPane.setComponentZOrder(btnNewButton_1, 0);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setBounds(240, 600, 150, 45);
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		contentPane.add(btnNewButton_2);
		contentPane.setComponentZOrder(btnNewButton_2, 0);
		btnNewButton_2.addActionListener(new ActionListener() {
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
	
	}
}
