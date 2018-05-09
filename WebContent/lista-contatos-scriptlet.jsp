<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
	<td>Nome</td>
	<td>Email</td>
	<td>Endereco</td>
	<td>Data de Nascimento: </td>
	 </tr>
		<%ContatoDAO dao = new ContatoDAO(); 
List<Contato> contatos = dao.getLista();

for(Contato contato : contatos){
%>
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<% String data = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());   %>
			<td><%= data %></td>
		</tr>
		<% } %>
	</table>

</body>
</html>