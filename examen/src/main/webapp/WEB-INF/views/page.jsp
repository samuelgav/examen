<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<script>
		window.contextRoot = '${contextRoot}'	
	</script>

	<!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${css}/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${css}/sb-admin-2.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="${css}/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${css}/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
    <link href="${css}/myapp.css" rel="stylesheet">
    <link href="${css}/sweetalert2.min.css" rel="stylesheet">
	<!-- <link href="${css}/material-dashboard.min.css" rel="stylesheet"> -->

</head>
<body>

		<%@include file="./shared/navbar.jsp" %>

		<!-- Page Wrapper -->
		<c:if test="${userClickHome == true}">
        	<%@include file="home.jsp" %>
        </c:if>
        
        <c:if test="${userClickAllTipoPersona== true}">
				<%@include file="listTipoPersona.jsp"%>
		</c:if>
		
		<c:if test="${userClickAllPersona== true}">
				<%@include file="listPersona.jsp"%>
		</c:if>
		
		<c:if test="${userClickAddOrUpdateTipoPersona== true}">
				<%@include file="addOrupdate.jsp"%>
		</c:if>

		<c:if test="${userClickAddOrUpdatePersona== true}">
				<%@include file="addOrupdatePersona.jsp"%>
		</c:if>
		
		<c:if test="${userClickAllProductos == true or userClickCategoriaProductos==true}" >
			<%@include file="listProductos.jsp" %>
		</c:if>
		
		
		<!-- Load only when user clicks show product -->
		<c:if test="${userClickShowPersona == true}">
			<%@include file="singlePersona.jsp"%>
		</c:if>
		
		
		<c:if test="${userClickAdministrarProducto == true}">
				<%@include file="administrarProducto.jsp"%>
			</c:if>	

	<!-- jQuery -->
    <script src="${js}/jquery.min.js"></script>
    
    <script src="${js}/jquery.validate.js"></script> 
    
    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${js}/metisMenu.min.js"></script>
    <!-- Morris Charts JavaScript -->
    <script src="${js}/raphael.min.js"></script>
    <!--<script src="${js}/morris.min.js"></script>-->
    <!--<script src="${js}/morris-data.js"></script>-->
    <!-- Custom Theme JavaScript -->
    <script src="${js}/sb-admin-2.js"></script>
    <!-- DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>
	<!-- DataTable Bootstrap Script -->
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/bootbox.min.js"></script>
    <script src="${js}/tipopersonalist.js"></script>    
    <script src="${js}/sweetalert2.min.js"></script>
    <script src="${js}/personalist.js"></script>
    <script src="${js}/productolist.js"></script>    
</body>
</html>