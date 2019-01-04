<%-- Archivo JSP que realiza la consultas correspondientes para guardar, actualizar y borrar pilotos --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%-- Importo el paquete de clases que voy a usar --%>
<%@ page import="com.f1.dao.*" %>

<%
	//Instancio la clase de las consultas
	DBQueries pilotos = new DBQueries();
	//Si el par�metro "type" que recibo tiene el valor de "update", llamo al m�todo updateData, pasando los valores de los otros par�metros para actualizar los datos del piloto. 
	if(request.getParameter("type").contentEquals("update")){
		pilotos.updateData(request.getParameter("id"),request.getParameter("piloto"),request.getParameter("equipo"),request.getParameter("motor"),request.getParameter("pais"),request.getParameter("edad"));
	//Si el par�metro "type" que recibo tiene el valor de "create", llamo al m�todo createData, pasando los otros valores de los par�metros para crear un nuevo piloto. 
	}else if(request.getParameter("type").contentEquals("create")){
		pilotos.createData(request.getParameter("id"),request.getParameter("piloto"),request.getParameter("equipo"),request.getParameter("motor"),request.getParameter("pais"),request.getParameter("edad"));
	//Si el par�metro "type" que recibo tiene el valor de "delete", llamo al m�todo deleteData, pasando el ID del piloto para borrarlo.
	}else if(request.getParameter("type").contentEquals("delete")){
		pilotos.deleteData(request.getParameter("id"));
	}
	
%>