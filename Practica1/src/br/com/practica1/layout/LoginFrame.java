package br.com.practica1.layout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import br.com.practica1.dao.UsuarioDAO;
import br.com.practica1.model.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Correo;
	private JPasswordField passwordFieldContrasena;
	private JLabel label_correovacio;
	private JLabel label_contraseñavacio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_Correo = new JTextField();
		textField_Correo.setBounds(123, 67, 136, 20);
		contentPane.add(textField_Correo);
		textField_Correo.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(48, 70, 46, 14);
		contentPane.add(lblCorreo);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(48, 94, 67, 14);
		contentPane.add(lblContrasena);

		JButton btnLogin = new JButton("Aceptar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(textField_Correo.getText());
				usuario.setContrasena(passwordFieldContrasena.getText());
				UsuarioDAO usuarioDAO = new UsuarioDAO();

				if (sinCamposVacios()) {

					if (usuarioDAO.conectarUsuario(usuario)) {
						PaginaInicialFrame paginaInicialFrame = new PaginaInicialFrame();
						paginaInicialFrame.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Usuario o contraseña incorrecto", "",
								JOptionPane.INFORMATION_MESSAGE, null);
					}
				}
			}
		});
		btnLogin.setBounds(123, 122, 136, 23);
		contentPane.add(btnLogin);

		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(textField_Correo.getText());
				usuario.setContrasena(passwordFieldContrasena.getText());
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				if (sinCamposVacios() && usuarioDAO.correoLibre(usuario)) {
					usuarioDAO.salvar(usuario);
					usuarioDAO.conectarUsuario(usuario);
					JOptionPane.showMessageDialog(null,"Usuario añadido com suceso", "", 
							 JOptionPane.INFORMATION_MESSAGE, null);
					limpiarCampos();
				}
				else{
					JOptionPane.showMessageDialog(null,"Correo ya utilizado", "", 
							 JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});
		btnNuevoUsuario.setBounds(123, 156, 136, 23);
		contentPane.add(btnNuevoUsuario);

		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(123, 91, 136, 20);
		contentPane.add(passwordFieldContrasena);

		label_correovacio = new JLabel("Correo Vacío");
		label_correovacio.setVisible(false);
		label_correovacio.setForeground(Color.RED);
		label_correovacio.setBounds(269, 70, 112, 14);
		contentPane.add(label_correovacio);

		label_contraseñavacio = new JLabel("Contraseña Vacío");
		label_contraseñavacio.setVisible(false);
		label_contraseñavacio.setForeground(Color.RED);
		label_contraseñavacio.setBounds(269, 94, 112, 14);
		contentPane.add(label_contraseñavacio);
	}

	public Boolean sinCamposVacios() {
		if (textField_Correo.getText().equals("")
				|| passwordFieldContrasena.getText().equals("")) {
			if (textField_Correo.getText().equals("")) {
				label_correovacio.setVisible(true);
			}

			if (passwordFieldContrasena.getText().equals("")) {
				label_contraseñavacio.setVisible(true);
			}
			return false;
		} else {
			label_correovacio.setVisible(false);
			label_correovacio.setVisible(false);
			return true;
		}
	}

	public void limpiarCampos() {
		passwordFieldContrasena.setText(null);
		textField_Correo.setText(null);
	}
}
