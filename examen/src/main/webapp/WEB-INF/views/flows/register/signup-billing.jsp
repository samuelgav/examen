<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

	<!-- Page Content -->
	<div class="container"> 
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Sign Up - Direccion</h4>
					</div>
					<div class="panel-body">
						<sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
							
							<div class="form-group">
								<label class="control-label col-md-4" for="direccionLineaUno">Primera Direccion</label>
								<div class="col-md-8">
									<sf:input type="text" path="direccionLineaUno" class="form-control" placeholder="DIRECCION LINEA UNO..."/>
									<sf:errors path="direccionLineaUno" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="direccionLineaDos">Segunda Direccion</label>
								<div class="col-md-8">
									<sf:input type="text" path="direccionLineaDos" class="form-control" placeholder="DIRECCION LINEA DOS..."/>
									<sf:errors path="direccionLineaDos" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="ciudad">Ciudad</label>
								<div class="col-md-8">
									<sf:input type="text" path="ciudad" class="form-control" placeholder="Ciudad..."/>
									<sf:errors path="ciudad" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="codigoPostal">Codigo Postal</label>
								<div class="col-md-8">
									<sf:input type="text" path="codigoPostal" class="form-control" placeholder="Codigo Postal..."/>
									<sf:errors path="codigoPostal" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="estado">Estado</label>
								<div class="col-md-8">
									<sf:input type="text" path="estado" class="form-control" placeholder="Estado..."/>
									<sf:errors path="estado" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="pais">Pais</label>
								<div class="col-md-8">
									<sf:input type="text" path="pais" class="form-control" placeholder="Pais..."/>
									<sf:errors path="pais" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									
									<button type="submit" class="btn btn-primary" name="_eventId_personal">
									<span class="glyphicon glyphicon-chevron-left"></span> Previous - Personal 
									</button>
									
									<button type="submit" class="btn btn-primary" name="_eventId_confirm">
									Next - Confirm <span class="glyphicon glyphicon-chevron-right"></span> 
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