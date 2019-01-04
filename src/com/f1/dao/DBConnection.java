//Referencio el paquete de clases, en este caso, la de la conexión y la de las consultas, dado que una implementa la otra
package com.f1.dao;
//Importo las librerías SQL de Java
import java.sql.*;

//Defino la clase para la conexión a la base de datos F1 dentro de mi phpMyAdmin de mi localhost
public class DBConnection {
	//Creo una propiedad del tipo Connection
	private Connection connection = null;
	
	//Constructor -mismo nombre que la clase-
	public DBConnection(){
		try{
			/* Esta es la referencio del driver MySql que copie en la carpeta "lib" */
			Class.forName("com.mysql.jdbc.Driver");
			/* Guardo en la variable "connection" la conexión que obtengo con el driver, pasando como parámetro la IP, base de datos, usuario y contraseña */
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/f1","root","root");
			
			/* Si la conexión es exitosa, imprimo un mensaje en la consola */
			if(connection != null){
				System.out.println("Conectado correctamente.");
			}
		}catch(Exception ex){
			/* De no hacerlo, capturo el error y lo imprimo */
			System.out.println(ex.getMessage());
		}
	}
	
	/* Método que devuelve el estado de la conexión a la base de datos */
	public Connection getConnection(){
		return connection;
	}
	
	/* Método que cierra la conexión a la base de datos */
	public void closeConnection(){
		connection = null;
	}

}
