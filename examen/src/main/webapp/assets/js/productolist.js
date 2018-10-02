$(function() {
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
								if(data) {											
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
	
	
	
	
	
	
	
	
	
	
	
});