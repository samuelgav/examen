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
		 	
		 	<h2 class="page-header">Administrar Tipo Persona</h2>
		 			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Tipo Persona Management</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="tipopersona" action="${contextRoot}/manage/tipopersona" method="POST">
						<sf:input type="hidden" path="id" />						
						<div class="form-group">
							<label class="control-label col-md-4">Descripcion</label>
							<div class="col-md-8">
								<sf:input type="text" path="descripcion" class="form-control" placeholder="Descripcion..." />
								<sf:errors path="descripcion" cssClass="help-block" element="em"/>								
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