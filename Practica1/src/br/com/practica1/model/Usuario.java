package br.com.practica1.model;
import java.sql.Date;
import com.mysql.jdbc.Blob;


public class Usuario {
	String nick;
	String correo;
	String id;
	String contrasena;
	Date fechaNacimento;
	String descripcion;
	Blob foto;
	
	
	//GET AND SET
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Date getFechaNacimento() {
		return fechaNacimento;
	}
	public void setFechaNacimento(Date fechaNacimento) {
		this.fechaNacimento = fechaNacimento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	
}
