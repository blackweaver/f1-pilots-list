//Referencio el paquete de clases, en este caso, la de la conexión y la de las consultas, dado que una implementa la otra
package com.f1.dao;
//Importo las librerías SQL de Java
import java.sql.*;

//Defino la clase para las consultas a la base de datos
public class DBQueries {
	//Declaro la variable de texto que contendrá la cadena del Json con los datos que traigo de las tablas.
	public String content;
	
	//Constructor -mismo nombre que la clase-
	public DBQueries(){
		//Asigno una cadena vacía a la propiedad content
		content = "";
	}
	//Método público para listar los registros, en este caso, los pilotos que participan del campeonato F1 - 2017 -Grande Hamilton, les diste de comer a todos-
	public void listData(){
		//Creo una instancia de la clase DBConnection para conectarme antes de hacer una consulta
		DBConnection connection = new DBConnection();
		//Intento obtener la conexión y hacer las consultas dentro de una captura de errores try/catch
		try{
			//Creo una variable del tipo Statement de java.sql -declaración- para almacenear la conexión
			Statement list = connection.getConnection().createStatement();
			//Creo una variable del tipo ResultSet de java.sql -conjunto de resultados- para almacenar los datos otenidos de la tabla "pilotos"
			ResultSet data = list.executeQuery("SELECT * FROM pilotos");
			
			//Construyo una cadena de textos en formato Json con la iteración de resultados, para luego asignarla al contenido de la variable "content"
			content+= "{ \"pilotos\": [";
			//Variable booleana para marcarar el primer item antes de comenzar a iterar
			boolean first = true;
			//Iteración while con parámetro del resultado siguiente
			while(data.next()){
				//Si es el primero no coloco una coma al inicio
				if(first){
					content+= "{ \"id\" : \"" + data.getString(1) + "\", \"piloto\" : \"" + data.getString(2) + "\", \"equipo\" : \"" + data.getString(3) + "\", \"motor\" : \"" + data.getString(4) + "\", \"pais\" : \"" + data.getString(5) + "\", \"edad\" : \"" + data.getString(6) + "\"}\n";
					first = false;
				}else{
					content+= ",{ \"id\" : \"" + data.getString(1) + "\", \"piloto\" : \"" + data.getString(2) + "\", \"equipo\" : \"" + data.getString(3) + "\", \"motor\" : \"" + data.getString(4) + "\", \"pais\" : \"" + data.getString(5) + "\", \"edad\" : \"" + data.getString(6) + "\"}\n";
				}
			}
			
			content+="]}";
			//Cierro la conexión llamando al método de la clase DBConnection correspondiente
			connection.closeConnection();
			//Informo en la consola que se ha listado el contenido de la tabla de la base de datos
			System.out.println("Se listó");
		}catch(Exception ex){
			//De haber existido un error, imprimo en la consola el nombre de dicho error.
			System.out.println("Ha ocurrido este error" + ex.getMessage());
		}
	}
	//Método que se encarga de editar un registro, recibe como parámetro cada uno de los detalles de un piloto
	public void updateData(String id, String piloto,String equipo,String motor,String pais,String edad){
		//Creo una instancia de la conexión
		DBConnection connection = new DBConnection();
		
		/*
		Object[] objs = new Object[3];
		objs[0] = 3;
		objs[1] = 4;
		objs[2] = "Prueba de propiedad de objeto";
		
		System.out.println(objs[2]);
		*/
		
		//Dentro de una captura de errores, defino una variable con la cadena para la consulta, asignando a cada columna de la DB los valores que recibo por parámetro
		try{
			String data = "UPDATE pilotos SET piloto='" + piloto + "', equipo='" + equipo + "', motor='" + motor + "', pais='" + pais + "', edad='" + edad + "' WHERE id='" + id + "'";
			//Creo una variable del tipo Statement de java.sql -declaración- para almacenear la conexión
			Statement edit = connection.getConnection().createStatement();
			//Ejecuto la consulta
			edit.executeUpdate(data);
			//Una vez ejecutada la consulta, cierro la conexión con la base de datos
			connection.closeConnection();
			//Informo a la consola que el registro se actualizó con éxito
			System.out.println("Se ACTUALIZÓ");
		}catch(Exception ex){
			//No se pudo hacer la consulta e imprimo el error correspondiente
			System.out.println("Hubo un error al actualizar");
			System.out.println(ex.getMessage());
		}	
	}
	//Método públio que crea nuevos registros de pilotos en la tabla "pilotos" de la base de datos "F1"
	public void createData(String id, String piloto,String equipo,String motor,String pais,String edad){
		//Creo una instancia de la conexión
		DBConnection connection = new DBConnection();
		
		//Dentro de una captura de errores, defino una variable con la cadena para la consulta, asignando a cada columna de la DB los valores que recibo por parámetro
		try{
			String data = "INSERT INTO pilotos (piloto,equipo,motor,pais,edad) VALUES ('" + piloto + "','" + equipo + "','"  + motor + "','" + pais + "','" + edad + "')";
			//Creo una variable del tipo Statement de java.sql -declaración- para almacenear la conexión
			Statement edit = connection.getConnection().createStatement();
			//Ejecuto la consulta
			edit.executeUpdate(data);
			//Cierro la conexión con la base de datos
			connection.closeConnection();
			//Informo en la consola que el registro se guardo correctamente
			System.out.println("Se GUARDÓ");
		}catch(Exception ex){
			//Informo en la consola que hubo un error, y especifico cual
			System.out.println("Hubo un error al crear");
			System.out.println(ex.getMessage());
		}
	}
	//Método públio encargado de borrar registros en la DB, recibo el ID del piloto como parámetro
	public void deleteData(String id){
		//Creo una instancia de la conexión
		DBConnection connection = new DBConnection();
		//Dentro de una captura de errores, defino una variable con la cadena para la consulta, asignando el ID del piloto a sustraer
		try{
			String data = "DELETE FROM pilotos WHERE id=" + id;
			//Creo una variable del tipo Statement de java.sql -declaración- para almacenear la conexión
			Statement edit = connection.getConnection().createStatement();
			//Ejecuto la consulta
			edit.executeUpdate(data);
			//Cierro la conexión con la base de datos
			connection.closeConnection();
			//Informo en la consola que el registro se borró correctamente
			System.out.println("Se BORRÓ");
		}catch(Exception ex){
			//Informo en la consola que hubo un error, y especifico cual
			System.out.println("Hubo un error al crear");
			System.out.println(ex.getMessage());
		}
	}
}
