package br.com.practica1.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FotoFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FotoFrame frame = new FotoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FotoFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		JLabel lblNewLabel = new JLabel(criarImagem());
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	private static ImageIcon criarImagem() throws IOException {
		int width=200, height=200;
		BufferedImage buffer = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
		buffer = ImageIO.read(new File("C:/Users/Lucas/Pictures/botero-mona-lisa.jpg"));
		
		return new ImageIcon( buffer );
	}
}

