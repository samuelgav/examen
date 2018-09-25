$(function() {
	
	var $table = $('#PersonaListTable');
	
	if ($table.length) {
		
		$table
			    .DataTable({	
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
});

$(document).ready(function () {
	 $(document).on('click', '#deleteP', function(e){			
			var personaId = $(this).data('id');	
			SwalDeletePersona(personaId);
			e.preventDefault();		
	 });
	  
});


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