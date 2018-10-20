<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="msapplication-tap-highlight" content="no">
  <meta name="description" content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
  <meta name="keywords" content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
  <title>${title}</title>
  
  <!-- Favicons-->
  <link rel="icon" href="${images}/favicon-32x32.png" sizes="32x32">
  <!-- Favicons-->
  <link rel="apple-touch-icon-precomposed" href="${images}/apple-touch-icon-152x152.png">
  <!-- For iPhone -->
  <meta name="msapplication-TileColor" content="#00bcd4">
  <meta name="msapplication-TileImage" content="images/favicon/mstile-144x144.png">
  <!-- For Windows Phone -->


  <!-- CORE CSS-->
  
  <link href="${css}/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="${css}/style.min.css" type="text/css" rel="stylesheet" media="screen,projection">
  
  <!-- Custome CSS-->    
  <link href="${css}/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">

  <!-- INCLUDED PLUGIN CSS ON THIS PAGE -->
  <link href="${css}/prism.css" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="${css}/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection"> 
  
  
  <script type="text/javascript">
	window.menu='${title}';
	window.contextRoot='${contextRoot}';	
  </script>
   
</head>
<body class="cyan">
  <!-- Start Page Loading -->
  <div id="loader-wrapper">
      <div id="loader"></div>        
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
  </div>
  <!-- End Page Loading -->



  <div id="login-page" class="row">
    <div class="col s12 z-depth-4 card-panel">
      <form class="login-form" action="${contextRoot}/login" method="post" id="loginForm">
        <div class="row">
          <div class="input-field col s12 center">
            <img src="${images}/login-logo.png" alt="" class="circle responsive-img valign profile-image-login">
            <p class="center login-form-text">Logueo de Usuarios</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input id="username" type="text">
            <label for="username" class="center-align">Usuario</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" type="password">
            <label for="password">Password</label>
          </div>
        </div>
        
        <div class="row">
          <div class="input-field col s12">
            <a href="index.html" class="btn waves-effect waves-light col s12">Login</a>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12 m12 l12">
            <p class="margin medium-small"><a href="${contextRoot}/register">REGISTRAR NUEVO USUARIO!</a></p>
          </div>                    
        </div>

      </form>
    </div>
  </div>



  <!-- ================================================
    Scripts
    ================================================ -->

  <!-- jQuery Library -->
  <script type="text/javascript" src="${js}/jquery-1.11.2.min.js"></script>
  <!--materialize js-->
  <script type="text/javascript" src="${js}/materialize.min.js"></script>
  <!--prism-->
  <script type="text/javascript" src="${js}/prism.js"></script>
  <!--scrollbar-->
  <script type="text/javascript" src="${js}/perfect-scrollbar.min.js"></script>

      <!--plugins.js - Some Specific JS codes for Plugin Settings-->
    <script type="text/javascript" src="${js}/plugins.min.js"></script>
    <!--custom-script.js - Add your own theme custom JS-->
    <script type="text/javascript" src="${js}/custom-script.js"></script>

</body>

</html>