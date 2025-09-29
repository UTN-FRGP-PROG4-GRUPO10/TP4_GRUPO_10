<%@page import="dominio.TipoSeguro"%>
<%@page import="java.util.ArrayList"%>
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
	<a href="servletSeguro?action=listar"><strong>Listar Seguros</strong></a>
	<h1>Listar Seguros</h1>

	<% 
	java.util.ArrayList<dominio.Seguro> listaSeguros = null;
		listaSeguros = (java.util.ArrayList<dominio.Seguro>) request.getAttribute("listaSeguros");

	java.util.ArrayList<dominio.TipoSeguro> listaTipoSeguros = null;
        listaTipoSeguros = (java.util.ArrayList<dominio.TipoSeguro>) request.getAttribute("tiposSeguro");

	Integer tipoSeleccionado = (Integer) request.getAttribute("tipoSeleccionado");
	if (tipoSeleccionado == null) {
        tipoSeleccionado = 0;
    }
	
	

 %>
 
 
 <form method="get" action="servletSeguro" style="margin:10px 0;">
  <input type="hidden" name="action" value="listar"/>
  <label>Busqueda por tipo de seguros:</label>
  <select name="tipoId">
    <option value="0">Todos</option>
    <% if (listaTipoSeguros != null) {
         for (dominio.TipoSeguro t : listaTipoSeguros) { %>
      <option value="<%= t.getIdTipo() %>"
        <%= (tipoSeleccionado == t.getIdTipo() ? "selected" : "") %>>
        <%= t.getDescripcion() %>
      </option>
    <% }} %>
  </select>
  <button type="submit">Filtrar</button>
  <a href="servletSeguro?action=listar">Limpiar</a>
</form>


<table border=1 id="table_id" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Descripción Seguro</th>
            <th>Descripción Tipo Seguro</th>
            <th>Costo Contración</th>
            <th>Costo Asegurado</th>
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
		</tr>
	<%  } %>
    </tbody>
</table>
</body>
</html>