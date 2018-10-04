<div id="page-wrapper">
	<div class="row">
		
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProductos == true}">
						<script type="text/javascript">
								window.categoriaId='';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Todos los Productos</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoriaProductos ==true }">
						<script type="text/javascript">
							window.categoriaId='${categoria.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">home</a></li>
							<li class="active">Categoria</li>
							<li class="active">${categoria.nombre}</li>
						</ol>
					</c:if>
				</div>
			</div>
		<div class="row">
				<div class="col-xs-12">
				  <div class="table-responsive">			
					<table id="ProductoListTable"
						class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>Nombre</th>
								<th>Marca</th>
								<th>Precio</th>
								<th>Cantidad</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Nombre</th>
								<th>Marca</th>
								<th>Precio</th>
								<th>Cantidad</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
					</div>
				</div>	
			</div>	
		</div>		
	</div>
</div>
