package br.com.practica1.model;
import java.io.*;

public class Foto {
	int id;
	String titulo;
	String descripcion;
	ByteArrayOutputStream imagen;
	Double ancho;
	Double altura;
	int albumId;
	int PublicacionID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getPublicacionID() {
		return PublicacionID;
	}
	public void setPublicacionID(int publicacionID) {
		PublicacionID = publicacionID;
	}
}
