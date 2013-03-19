package br.com.practica1.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.practica1.model.Sessao;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class PaginaInicialFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PaginaInicialFrame() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNick = new JLabel("");
		lblNick.setBounds(82, 0, 249, 34);
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNick);
		lblNick.setText(Sessao.getInstance().getUsuario().getNick());

		JLabel lblFechaNacimiento = new JLabel("");
		lblFechaNacimiento.setBounds(120, 36, 176, 14);
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblFechaNacimiento);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaNacimientoUsuario = sdf.format(Sessao.getInstance()
				.getUsuario().getFechaNacimento());
		lblFechaNacimiento.setText(fechaNacimientoUsuario);

		JButton btnModificarInformacion = new JButton(
				"Modificar Informaci\u00F3n");
		btnModificarInformacion.setBounds(178, 106, 204, 23);
		btnModificarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarUsuarioFrame modificarUsuarioFrame = new ModificarUsuarioFrame();
				modificarUsuarioFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnModificarInformacion);

		JTextPane textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setBounds(145, 61, 237, 34);
		contentPane.add(textPaneDescripcion);
		textPaneDescripcion.setText(Sessao.getInstance().getUsuario()
				.getDescripcion());
		textPaneDescripcion.setEditable(false);

		JLabel lbl_Foto = new JLabel("");
		lbl_Foto.setBounds(24, 11, 95, 118);
		lbl_Foto.setVisible(true);
		ImageIcon foto = new ImageIcon(
				PaginaInicialFrame.class
						.getResource("/images/Forever_Alone.png"));
		Icon icono = new ImageIcon(foto.getImage().getScaledInstance(
				lbl_Foto.getWidth(), lbl_Foto.getHeight(), Image.SCALE_DEFAULT));
		lbl_Foto.setIcon(icono);
		contentPane.add(lbl_Foto);

		JPanel panel = new JPanel();
		panel.setBounds(24, 140, 358, 111);
		contentPane.add(panel);

		JTabbedPane jtp = new JTabbedPane();
		panel.add(jtp);
		jtp.addTab("Amigos", new AmigoPaginaInicialPanel());
		jtp.addTab("Fotos", new AmigoPaginaInicialPanel());
		jtp.addTab("Publicaciones", new AmigoPaginaInicialPanel());

	}

}
