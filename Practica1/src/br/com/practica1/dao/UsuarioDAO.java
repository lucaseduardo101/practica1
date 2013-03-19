package br.com.practica1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.practica1.model.*;

public class UsuarioDAO {
 
	public void crearSession(Usuario usuario) {//
		Sessao sessao = Sessao.getInstance();
		sessao.setUsuario(usuario);
	}

	public void actualizarUsuarioSessao(Usuario usuario) {
		Sessao.getInstance().getUsuario();
	}

	// Recebe um resultado de uma query e retorna um usuario
	public Usuario popularUsuarioConectado(ResultSet rs) throws SQLException {
		Usuario usuario = null;
		while (rs.next()) {
			usuario = new Usuario();
			usuario.setContrasena(rs.getString("Contraseña"));
			usuario.setCorreo(rs.getString("Correo"));
			usuario.setDescripcion(rs.getString("Descripcion"));
			usuario.setFechaNacimento(rs.getDate("FechaNacimiento"));
			usuario.setId(rs.getString("Id"));
			usuario.setNick(rs.getString("Nick"));
		}
		return usuario;
	}

	// Recebe um resultado de uma query e retorna uma lista de usuarios
	public List<Usuario> popularUsuarios(ResultSet rs) throws SQLException {
		List<Usuario> listaUsuario = new ArrayList<>();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setContrasena(rs.getString("Contraseña"));
			usuario.setCorreo(rs.getString("Correo"));
			usuario.setDescripcion(rs.getString("Descripcion"));
			usuario.setFechaNacimento(rs.getDate("FechaNacimiento"));
			usuario.setId(rs.getString("Id"));
			usuario.setNick(rs.getString("Nick"));
			listaUsuario.add(usuario);
		}
		return listaUsuario;
	}

	// Recebe usuario com correo e senha e tenta conectar-lo. Retorna true se
	// conseguiu
	// e false se não
	public Boolean conectarUsuario(Usuario usuario) {
		String sql = "SELECT * FROM usuario WHERE Correo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		Usuario usuarioConectado = null;

		try {
			conn = Conexion.crearConexion();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getCorreo());

			rs = pstm.executeQuery();

			usuarioConectado = popularUsuarioConectado(rs);

			if (usuarioConectado != null) {
				crearSession(usuarioConectado);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void salvar(Usuario usuario) {
		String sql = "INSERT INTO usuario(Correo,Contraseña)" + " VALUES(?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexion.crearConexion();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getCorreo());
			pstm.setString(2, usuario.getContrasena());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// TODO
	// Atualizar todos os campos e não somente Nick, Descrição e data de
	// Nacimento
	public void actualizar(Usuario usuario) {

		String sql = "UPDATE usuario SET Nick = ?, Descripcion = ?, FechaNacimiento = ?"
				+ " WHERE Id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexion.crearConexion();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNick());
			pstm.setString(2, usuario.getDescripcion());
			pstm.setDate(3, usuario.getFechaNacimento());
			pstm.setString(4, usuario.getId());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	public Boolean correoLibre(Usuario usuario){
		String sql = "SELECT Id FROM usuario WHERE Correo = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = Conexion.crearConexion();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getCorreo());

			rs = pstm.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
