$(function(){
	
	var $table = $('#TipoPersonaListTable');	
	if ($table.length) {		
		$table
			    .DataTable({	
				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				pageLength : 5,
				ajax : {
					url : window.contextRoot + '/json/data/all/tipopersona',
					dataSrc : ''
				},
				columns : [
						{
							data : 'id'
						},
						{
							data : 'descripcion'
						},
						{
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row) {
							var str = '';
							str += '<a href="'
										+ window.contextRoot
										+ '/manage/'
										+ data
										+ '/tipopersona" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
							str += '<a href="javascript:void(0)" id="deleteTP" data-id="'+data+'" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
							return str;
		
							}
						} ]
			});
		
	}
	
	var $table = $('#PersonaListTable');
	if ($table.length) {
		$table.DataTable({	
				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				pageLength : 5,
				ajax : {
					url : window.contextRoot + '/json/data/all/persona',
					dataSrc : ''
				},
				columns : [
						{
							data : 'idpersona'
						},
						{
							data : 'nombres'
						},
						{
							data : 'apellidos'
						},
						{
							data : 'edad'
						},
						{
							data : 'tipoPersona.descripcion'
						},
						{
							data: 'nombres',
							bSortable : false,
							mRender : function(data, type, row) {

								return '<img src="' + window.contextRoot
										+ '/resources/images/' + data
										+ '.jpg" class="dataTableImg"/>';

							}
						},						
						{
							data : 'idpersona',
							bSortable : false,
							mRender : function(data, type, row) {
							var str = '';
							str += '<a href="'
										+ window.contextRoot
										+ '/manage/'
										+ data
										+ '/persona" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
							str += '<a href="javascript:void(0)" id="deleteP" data-id="'+data+'" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a> &#160;';
							str +='<a href="'+window.contextRoot+'/show/'+data+'/persona" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></a>';
							return str;
		
							}
						} 
					]
			});
		
		}
	
	var $table=$("#ProductoListTable");	
	if($table.length){
		var jsonUrl = '';		
		if (window.categoriaId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/productos';
		} else {
			jsonUrl = window.contextRoot + '/json/data/categoria/'
					+ window.categoriaId + '/productos';
		}
		
		$table.DataTable({	
		lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
		pageLength : 5,
		ajax : {
			url : jsonUrl,
			dataSrc : ''
		},
		columns : [
				{
					data : 'codigo',
					bSortable : false,
					mRender : function(data, type, row) {

						return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';

					}
				},
				{
					data : 'nombre'
				},
				{
					data : 'marca'
				},
				{
					data : 'precioUnitario',
					mRender : function(data, type, row) {
						return '&#8377; ' + data
					}
				},
				{
					data : 'cantidad',
					mRender : function(data, type, row) {

						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}

						return data;

					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {
					var str = '';
					str += '<a href="'
								+ window.contextRoot
								+ '/manage/'
								+ data
								+ '/tipopersona" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
					str += '<a href="javascript:void(0)" id="deleteTP" data-id="'+data+'" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>';
					return str;

					}
				} ]
	});
	}
	
	var $productosTable = $('#productosTable');	
	if($productosTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/productos';
		console.log(jsonUrl);
		$productosTable.DataTable({
			lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
			pageLength : 30,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [		
			           	{data: 'id'},
			           	{data: 'codigo',
			           	 bSortable: false,
			           		mRender: function(data,type,row) {
			           			return '<img src="' + window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg" class="dataTableImg"/>';					           			
			           		}
			           	},
			           	{
							data : 'nombre'
						},
						{
							data : 'marca'
						},
						{
							data : 'cantidad',
							mRender : function(data, type, row) {

								if (data < 1) {
									return '<span style="color:red">Out of Stock!</span>';
								}

								return data;

							}
						},
						{
							data : 'precioUnitario',
							mRender : function(data, type, row) {
								return '&#8377; ' + data
							}
						},
						{
							data : 'estado',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								if(data == '1') {											
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
									
								}else {
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
								}
								
								return str;
							}
						},
						{
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row) {

								var str = '';
								str += '<a href="'
										+ window.contextRoot
										+ '/manage/'
										+ data
										+ '/producto" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

								return str;
							}
						}					           	
			],			
			initComplete: function () {
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change' , function() {							
					var dText = (this.checked)? 'Desea activar el Producto?': 'Desea desactivar el Producto?';
					var checked = this.checked;
					var checkbox = $(this);
					debugger;
				    bootbox.confirm({
				    	size: 'medium',
				    	title: 'Producto Activacion/Desactivacion',
				    	message: dText,
				    	callback: function (confirmed) {
				    		if (confirmed) {
					            $.ajax({							            	
					            	type: 'GET',
					            	url: window.contextRoot + '/manage/producto/'+checkbox.prop('value')+'/activation',
					        		timeout : 100000,
					        		success : function(data) {
					        			bootbox.alert(data);							        										        			
					        		},
					        		error : function(e) {
					        			bootbox.alert('ERROR: '+ e);
					        			//display(e);
					        		}						            	
					            });
					        }
					        else {							        	
					        	checkbox.prop('checked', !checked);
					        }
				    	}
				    });																											
				});					
			}
		});
	}
	
	
	function errorPlacement(error,element){
		error.addClass("help-block");
		error.insertAfter(element);
		element.parents(".validate").addClass("has-feedback");
	}
	
	
	var $categoriaForm=$("#categoriaForm");
	if($categoriaForm.length){
		$categoriaForm.validate({
			rules:{
				nombre:{
					required:true,
					minlength:3
				},
				descripcion:{
					required:true,
					minlength:3
				}
			},
			messages:{
				nombre:{
					required:"Por favor ingrese el nombre de la categoria!!",
					minlength:"Longitud debe ser minima de 3 caracteres!!"
				},
				descripcion:{
					required:"Por favor ingrese la descripcion de la categoria!!",
					minlength:"Longitud debe ser minima de 3 caracteres!!"
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				errorPlacement(error, element);
			}
		});
	}
	
	
	var $loginForm=$("#loginForm");
	if($loginForm.length){
		$loginForm.validate({
			rules:{
				username:{
					required:true,
					email:true
				},
				password:{
					required:true					
				}
			},
			messages:{
				username:{
					required:"Por favor ingrese su usuario!!",
					email:"Por favor ingrese un correo idoneo!!"
				},
				password:{
					required:"Por favor ingrese su password!!"					
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				errorPlacement(error, element);
			}
		});
	}
	
});



$(document).ready(function () {
	 $(document).on('click', '#deleteP', function(e){			
			var personaId = $(this).data('id');	
			SwalDeletePersona(personaId);
			e.preventDefault();		
	 });
	 
	 $(document).on('click', '#deleteTP', function(e){			
			var TipoPersonaId = $(this).data('id');	
			SwalDelete(TipoPersonaId);
			e.preventDefault();		
	 });
	  
});

function SwalDelete(TipoPersonaId){
	swal({
		title: 'Esta seguro?',
		text: "Estos datos se eliminaran permanentemente.!",
		type: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Si, Deseo!',
		showLoaderOnConfirm: true,				
		preConfirm: function() {
		  return new Promise(function(resolve) {
		       
		     $.ajax({
		   		url: window.contextRoot +'/manage/'+TipoPersonaId+'/delete',
		    	type: 'POST',
		    	timeout : 100000		    	
		     })
		     .done(function(response){
		     	 swal('Deleted!', response.message, response.status);
		     	 var table = $('#TipoPersonaListTable').DataTable(); 
	             table.ajax.reload(null,false);
		     })
		     .fail(function(){
		     	swal('Oops...', 'Something went wrong with ajax !', 'error');
		     });
		  });
	    },
		allowOutsideClick: false			  
	});	
}


function SwalDeletePersona(personaId){
	swal({
		title: 'Esta seguro?',
		text: "Estos datos se eliminaran permanentemente.!",
		type: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Si, Deseo!',
		showLoaderOnConfirm: true,				
		preConfirm: function() {
		  return new Promise(function(resolve) {
		       
		     $.ajax({
		   		url: window.contextRoot +'/manage/persona/'+personaId+'/delete',
		    	type: 'POST',
		    	timeout : 100000		    	
		     })
		     .done(function(response){
		     	 swal('Deleted!', response.message, response.status);
		     	 var tablePersona = $('#PersonaListTable').DataTable(); 
		     	 tablePersona.ajax.reload(null,false);
		     })
		     .fail(function(){
		     	swal('Oops...', 'Something went wrong with ajax !', 'error');
		     });
		  });
	    },
		allowOutsideClick: false			  
	});	
}

