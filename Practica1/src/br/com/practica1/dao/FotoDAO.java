package br.com.practica1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.practica1.model.Conexion;
import br.com.practica1.model.Foto;

public class FotoDAO {
	public Foto leer(int id) throws Exception{
		
		Foto foto = new Foto();
		Connection conn = Conexion.crearConexion();		
//		ResultSet rs = null;
//		PreparedStatement pstm = null;
		if(conn != null){
		
			
		}
		
		
		return foto;
	}
}
