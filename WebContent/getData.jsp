<%-- Archivo JSP que realiza la consulta correspondiente para listar todos los pilotos --%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Importo el paquete de clases que voy a usar --%>
<%@ page import="com.f1.dao.*" %>

<%
	//Instancio la clase de las consultas
	DBQueries pilotos = new DBQueries();
	//Llamo al método que hace la consulta de listar a todos los pilotos
	pilotos.listData();
	//Imprimo el resultado en el template, los datos estarán con formato Json
    out.println(pilotos.content);
%>