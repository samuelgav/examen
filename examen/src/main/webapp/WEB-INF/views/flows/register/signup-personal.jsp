<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

	<!-- Page Content -->
	<div class="container"> 
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Sign Up - Personal</h4>
					</div>
					<div class="panel-body">
						<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="usuario">
							
							<div class="form-group">
								<label class="control-label col-md-4">Nombres</label>
								<div class="col-md-8">
									<sf:input type="text" path="nombres" class="form-control" placeholder="Nombres..."/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Apellidos</label>
								<div class="col-md-8">
									<sf:input type="text" path="apellidos" class="form-control" placeholder="Apellidos..."/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Email</label>
								<div class="col-md-8">
									<sf:input type="text" path="email" class="form-control" placeholder="Email..."/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Numero de Contacto</label>
								<div class="col-md-8">
									<sf:input type="text" path="numeroContacto" class="form-control" placeholder="Numero de Contacto..."/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Password</label>
								<div class="col-md-8">
									<sf:input type="password" path="password" class="form-control" placeholder="Password..."/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4">Seleccione rol</label>
								<div class="col-md-8">
									<label class="radio-inline">
										<sf:radiobutton path="rol" value="USER" checked="checked"/> Usuario
									</label>
									<label class="radio-inline">
										<sf:radiobutton path="rol" value="SUPPLIER" /> Supplier
									</label>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" class="btn btn-primary" name="_eventId_billing">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
									</button>
								</div>								
							</div>
							
						</sf:form>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!-- End -->

<%@include file="../shared/flows-footer.jsp" %>