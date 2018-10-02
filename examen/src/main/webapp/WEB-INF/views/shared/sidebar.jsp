<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="lead">Shopping</p>
<div class="list-group">
	<c:forEach items="${categorias}" var="categoria">
		<a href="${contextRoot}/show/categoria/${categoria.id}/productos" class="list-group-item" id="a_${categoria.nombre}">${categoria.nombre}</a>
	</c:forEach>
</div>