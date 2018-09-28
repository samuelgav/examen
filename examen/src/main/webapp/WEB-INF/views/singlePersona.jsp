<div id="page-wrapper">
	<div class="row">
	<h3></h3>
		 <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Detalle Persona</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img src="${images}/${persona.nombres}.jpg" class="img img-responsive"> </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Nombres:</td>
                        <td>${persona.nombres}</td>
                      </tr>
                      <tr>
                        <td>Apellidos:</td>
                        <td>${persona.apellidos}</td>
                      </tr>
                      <tr>
                        <td>Sexo:</td>
                        <td>${sexo}</td>
                      </tr>
                      <tr>
                        <td>Edad:</td>
                        <td>${persona.edad}</td>
                      </tr>                     
                    </tbody>
                  </table>                  
                </div>
              </div>
            </div>         
          </div>
        </div>		
	</div>
</div>
