package br.com.practica1.model;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class Conexion {
	
   private static final String USERNAME = "root";
 
   private static final String PASSWORD = "";
 
   private static final String DATABASE_URL = "jdbc:mysql://localhost/Practica1";
   
   public static Connection crearConexion() throws Exception{
	  String className = "org.gjt.mm.mysql.Driver";
	  Class.forName(className);
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
      return connection;
   }
   
   
   
}