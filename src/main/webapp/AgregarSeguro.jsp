<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a> |
	<a href="servletSeguro?action=nuevo"><strong>Agregar Seguros</strong></a> |
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	<h1>Agregar Seguros</h1>
	<form>
	Id Seguro: <strong>${siguienteId}</strong><br><br>
	
	Descripción: <input type="text" name="txtDescripcion"><br><br>
	Tipo de Seguro:
	<select name="cboTipoSeguro">
	<%
	    java.util.ArrayList<dominio.TipoSeguro> tiposSeguro = (java.util.ArrayList<dominio.TipoSeguro>) request.getAttribute("tiposSeguro");
	    if (tiposSeguro != null) {
	        for (dominio.TipoSeguro tipo : tiposSeguro) {
	%>
	            <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
	<%
	        }
	    }
	%>
	</select>
	<br><br>
	Costo contratación: <input type="text" name="txtCostoContratacion"><br><br>
	Costo Máximo Asegurado: <input type="text" name="txtCostoMax"><br><br>
	<input type="submit" name="btnAceptar" value="Aceptar"/>
	</form>
</body>
</html>