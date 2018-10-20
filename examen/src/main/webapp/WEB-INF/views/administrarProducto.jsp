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
		 	<h2 class="page-header">Administrar Productos</h2>		 			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Administrar Productos</h4>
				</div>
					<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="producto"
						action="${contextRoot}/manage/producto" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4">Nombre</label>
							<div class="col-md-8">
								<sf:input type="text" path="nombre" class="form-control"
									placeholder="Nombre Producto..." />
								<sf:errors path="nombre" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Marca</label>
							<div class="col-md-8">
								<sf:input type="text" path="marca" class="form-control"
									placeholder="Marca..." />
								<sf:errors path="marca" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Descripcion</label>
							<div class="col-md-8">
								<sf:textarea path="descripcion" class="form-control"
									placeholder="Descripcion..." /> 
								<sf:errors path="descripcion" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Precio Unitario</label>
							<div class="col-md-8">
								<sf:input type="number" path="precioUnitario" class="form-control"
									placeholder="Precio Unitario..." />
								<sf:errors path="precioUnitario" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Cantidad</label>
							<div class="col-md-8">
								<sf:input type="number" path="cantidad" class="form-control"
									placeholder="Cantidad" />
								<sf:errors path="cantidad" cssClass="help-block" element="em"/> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Cargar Imagen</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Categoria</label>
							<div class="col-md-8">
								<sf:select path="categoriaId" items="${categorias}" itemLabel="nombre" itemValue="id" class="form-control"/>							
								<div class="text-right">
									<br/>			
									<sf:hidden path="id"/>
									<sf:hidden path="codigo"/>
									<sf:hidden path="usuarioId"/>
									<sf:hidden path="estado"/>														
									<button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myCategoriaModal">Agregar Categoria</button>
								</div>							
							</div>							
						</div>
						<div class="form-group">							
							<div class="col-md-offset-4 col-md-4">							
								<input type="submit" name="submit" value="Save" class="btn btn-primary"/>								
							</div>
						</div>
					</sf:form>
				</div>
				</div>
			</div>
		</div>
		
		<!-- Modal -->
	<div class="modal fade" id="myCategoriaModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Nueva Categoria</h4>
				</div>
				<div class="modal-body">
					<sf:form id="categoriaForm" class="form-horizontal"
						modelAttribute="categoria"
						action="${contextRoot}/manage/categoria" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4">Nombre</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="nombre" class="form-control"
									placeholder="Nombre..." />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Descripcion</label>
							<div class="col-md-8 validate">
								<sf:textarea path="descripcion" class="form-control"
									placeholder="Descripcion..." />
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
	<hr/>	
	<h1>Productos Disponibles</h1>
	<hr/>
	<div class="row">		
		<div class="col-xs-12">
			<div class="table-responsive">		
			<table id="productosTable" class="table table-condensed table-bordered">
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Nombre</th>
						<th>Marca</th>
						<th>Cantidad</th>
						<th>Precio Unitario</th>
						<th>Estado</th>				
						<th>Editar</th>
					</tr>					
				</thead>
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Nombre</th>
						<th>Marca</th>
						<th>Cantidad</th>
						<th>Precio Unitario</th>
						<th>Estado</th>				
						<th>Editar</th>
					</tr>
				</tfoot>
			</table>
			</div>
		</div>
	</div>
</div>