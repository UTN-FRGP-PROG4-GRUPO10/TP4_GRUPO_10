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
	<a href="servletSeguro?action=nuevo">Agregar Seguros</a> |
	<a href="servletSeguro?action=listar">Listar Seguros</a>
	<h1>Listar Seguros</h1>
	
	<% 
	java.util.ArrayList<dominio.Seguro> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null)
	{
		listaSeguros = (java.util.ArrayList<dominio.Seguro>) request.getAttribute("listaSeguros");
	}

 %>


<table border=1 id="table_id" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Descripción Seguro</th>
            <th>Descripción Tipo Seguro</th>
            <th>Costo Contración</th>
            <th>Costo Asegurado</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
       <%  if(listaSeguros!=null)
		for(dominio.Seguro seguro : listaSeguros) 
		{
	%>
		<tr>  
			<td><%= seguro.getIdSeguro() %></td> 
			<td><%= seguro.getDescripcion() %></td>   
			<td><%= seguro.getTipoSeguro().getDescripcion() %></td>
			<td><%= seguro.getCostoContratacion() %></td>
			<td><%= seguro.getCostoAsegurado() %></td>
			<td></td> 
		</tr>
	<%  } %>
    </tbody>
</table>
</body>
</html>