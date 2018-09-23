$(function() {
	
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
});
		

$(document).ready(function () {
	 $(document).on('click', '#deleteTP', function(e){			
			var productId = $(this).data('id');	
			SwalDelete(productId);
			e.preventDefault();		
	 });
	  
});


function SwalDelete(productId){
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
		   		url: window.contextRoot +'/manage/'+productId+'/delete',
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


	
			
			
		

	
	
	
	
	
	
	
	
