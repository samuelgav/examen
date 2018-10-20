
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${contextRoot}/home">Mantenimiento</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">

		<li><a href="${contextRoot}/register"> Registrar</a></li>
		<li><a href="${contextRoot}/login"> Login</a></li>


		<!-- /.dropdown -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> User
						Profile</a></li>

				<li class="divider"></li>
				<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
						Logout</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li><a href="${contextRoot}/home"><i
						class="fa fa-dashboard fa-fw"></i> Inicio</a></li>

				<li><a href="${contextRoot}/about"><i
						class="fa fa-dashboard fa-fw"></i> Acerca de Nosotros</a></li>

				<!--<li>
                            <a href="${contextRoot}/login"><i class="fa fa-dashboard fa-fw"></i> Login</a>
                        </li> -->

				<li><a href="${contextRoot}/show/all/tipopersona"><i
						class="fa fa-dashboard fa-fw"></i> Tipo Personas</a></li>

				<li><a href="${contextRoot}/show/all/personas"><i
						class="fa fa-dashboard fa-fw"></i> Personas</a></li>
				<li><a href="${contextRoot}/show/all/producto"><i
						class="fa fa-dashboard fa-fw"></i> Producto</a></li>

				<li><a href="${contextRoot}/manage/producto"><i
						class="fa fa-dashboard fa-fw"></i> Administrar Producto</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
