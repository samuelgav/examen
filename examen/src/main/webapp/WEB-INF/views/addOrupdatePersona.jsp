<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div id="page-wrapper">
	<c:if test="${not empty message}">	
		<div class="row">			
			<div class="col-xs-12 col-md-offset-2 col-md-8">			
				<div class="alert alert-info fade in">${message}</div>				
			</div>
		</div>
	</c:if>
			
	<div class="row">		
		 <div class="col-md-offset-2 col-md-8">		 	
		 	<h2 class="page-header">Administrar Personas</h2>		 			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Persona Management</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="persona" action="${contextRoot}/manage/persona" method="POST" enctype="multipart/form-data" >
						<sf:input type="hidden" path="idpersona" />						
						<div class="form-group">
							<label class="control-label col-md-4">Nombres</label>
							<div class="col-md-8">
								<sf:input type="text" path="nombres" class="form-control" placeholder="Nombres..." />
								<sf:errors path="nombres" cssClass="help-block" element="em"/>								
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Apellidos</label>
							<div class="col-md-8">
								<sf:input type="text" path="apellidos" class="form-control" placeholder="Apellidos..." />
								<sf:errors path="apellidos" cssClass="help-block" element="em"/>								
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Edad</label>
							<div class="col-md-8">
								<sf:input type="number" path="edad" class="form-control" placeholder="Edad..." />
								<sf:errors path="edad" cssClass="help-block" element="em"/>								
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Cargar Foto</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4">Sexo</label>
							<div class="col-md-8">
							<sf:select path="sexo"  class="form-control">
								<sf:option value="">---Seleccione---</sf:option>
								<sf:option value="M">Masculino</sf:option>
								<sf:option value="F">Femenino</sf:option>
							</sf:select>
							<sf:errors path="sexo" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Tipo Persona</label>
							<div class="col-md-8">
							<sf:select path="tipoPersona.id" items="${tipopersonas}" itemLabel="descripcion" itemValue="id" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>