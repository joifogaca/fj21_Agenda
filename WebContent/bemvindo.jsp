<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- Coment�rio em JSP aqui: nossa primeira p�gina JSP --%>
<%
String mensagem = "Bem Vindo ao nosso sistema de agenda do FJ-21!";
%>
<%
out.println(mensagem);
%>
<% String desenvolvido = "Desenvolvido por Joice"; %>
<%= desenvolvido %>
<br />
<% System.out.println("Tudo foi executado"); %>
</body>
</html>