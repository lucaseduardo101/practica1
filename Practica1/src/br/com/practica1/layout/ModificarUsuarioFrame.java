package br.com.practica1.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.practica1.dao.UsuarioDAO;
import br.com.practica1.model.Sessao;
import br.com.practica1.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class ModificarUsuarioFrame extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField_FechaNacimiento;
	private JTextField textField_Nick;
	private JTextArea textField_Descripcion;
	/**
	 * Create the frame.
	 */
	public ModificarUsuarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNick.setBounds(21, 66, 161, 14);
		contentPane.add(lblNick);
		
		JLabel lblFecha = new JLabel("Fecha Nacimiento:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(21, 91, 161, 14);
		contentPane.add(lblFecha);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setBounds(21, 116, 161, 14);
		contentPane.add(lblDescripcin);
		
		textField_FechaNacimiento = new JTextField();
		textField_FechaNacimiento.setBounds(192, 88, 86, 20);
		contentPane.add(textField_FechaNacimiento);
		textField_FechaNacimiento.setColumns(10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaNacimientoUsuario = sdf.format(Sessao.getInstance().getUsuario().getFechaNacimento());
		textField_FechaNacimiento.setText(fechaNacimientoUsuario);
		
		textField_Nick = new JTextField();
		textField_Nick.setBounds(192, 63, 86, 20);
		contentPane.add(textField_Nick);
		textField_Nick.setColumns(10);
		textField_Nick.setText(Sessao.getInstance().getUsuario().getNick());
		textField_Nick.setEditable(true);
		
		textField_Descripcion = new JTextArea();
		textField_Descripcion.setBounds(192, 116, 161, 42);
		contentPane.add(textField_Descripcion);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario = Sessao.getInstance().getUsuario();
				usuario.setNick(textField_Nick.getText());
				usuario.setDescripcion(textField_Descripcion.getText());
				usuario.setFechaNacimento(stringToDate(textField_FechaNacimiento.getText()));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.actualizar(usuario);
				PaginaInicialFrame paginaInicialFrame = new PaginaInicialFrame();
				paginaInicialFrame.setVisible(true);
				dispose();
			}
		});
		btnSalvar.setBounds(192, 169, 89, 23);
		contentPane.add(btnSalvar);
		
		
	}
	
	public java.sql.Date stringToDate(String stringFecha){
		long t;
		Date fecha = null;
		java.sql.Date dt = null;
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha = formatoDelTexto.parse(stringFecha);
			t = fecha.getTime();
			dt = new java.sql.Date(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
}
