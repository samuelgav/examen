<%@include file="../shared/flows-header.jsp" %>

<div class="container">
<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Detalle de Personal</h4>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<h4>${registerModel.usuario.nombres} ${registerModel.usuario.apellidos}</h4>
					<h4>Email: ${registerModel.usuario.email}</h4>
					<h4>Numero de Contacto: ${registerModel.usuario.numeroContacto}</h4>
					<h4>Rol: ${registerModel.usuario.rol}</h4>
				</div>
			</div>
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Editar</a>
			</div>
		</div>
	</div>


	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Direccion de Envio</h4>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<h4>${registerModel.direccion.direccionLineaUno}</h4>
					<h4>${registerModel.direccion.direccionLineaDos}</h4>
					<h4>${registerModel.direccion.ciudad} - ${registerModel.direccion.codigoPostal}</h4>
					<h4>${registerModel.direccion.estado} - ${registerModel.direccion.pais}</h4>
				</div>			
			</div>
			<div class="panel-footer">
				<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Editar</a>
			</div>
		</div>
	</div>	
</div>

<div class="row">
	<div class="col-sm-4 col-sm-offset-4">
		<div class="text-center">
			<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirmar</a>
		</div>
	</div>
</div>

</div>
<%@include file="../shared/flows-footer.jsp" %>
