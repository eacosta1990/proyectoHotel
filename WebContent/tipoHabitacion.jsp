<%@ include file="/_acceso.jsp" %>
<%@ include file="/_menu.jsp"%>

<%@page import="datos.TipoHabitacion" %>
<%@page import="java.util.List" %>



<div class="page-header">
  <h1>Tipo de Habitacion <a href="./AltaTipoHabitacion" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a></h1>
</div>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
<% 
if(request.getAttribute("ListatipoHabitacion") != null){
	List<TipoHabitacion> c = (List<TipoHabitacion>) request.getAttribute("ListatipoHabitacion");
	
	if(!c.isEmpty()){
	for (TipoHabitacion tipo : c) {
%>
<tr>
	<td><%=tipo.getTipoHabitacion() %></td>
	<td><%=tipo.getDescripcion() %></td>
	<td>$<%=tipo.getPrecio() %></td>
	<td class="text-right">
		<a href="./ModificarTipoHabitacion?id=<%=tipo.getIdTipoHabitacion() %>" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span></a>
		<a href="./EliminarTipoHabitacion?id=<%=tipo.getIdTipoHabitacion() %>" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></a> 
	</td>
</tr>
<%
	}
	}
 else {
%>
<tr>
	<td colspan="2">No hay datos</td>
</tr>
<%
}
}
%>
		
	</tbody>
</table>

<!-- Modal Eliminar-->
<div class="modal fade" id="ver" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title text-danger" id="myModalLabel">Eliminar</h4>
      </div>
      <div class="modal-body">
        �Est� seguro que desea eliminar este registro?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-danger">Eliminar</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/_footer.jsp"%>