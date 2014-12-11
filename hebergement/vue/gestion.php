<!DOCTYPE html>
<html>
	<head>
	<title>Hebergement</title>
	<meta charset="utf-8" />
	<meta name = "viewport" content = "width = device-width, initial-scale = 0.4, user-scalable = yes">
	<link rel="stylesheet" href="css/foundation.css">
  	<link rel="stylesheet" href="css/app.css">
  	<link rel="stylesheet" href="datepicker/css/datepicker.css">

  	<script src="js/vendor/modernizr.js"></script>
  	<script src="js/vendor/jquery.js"></script>
  	<script src="datepicker/js/bootstrap-datepicker.js"></script>

	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="DataTables-1.10.4/media/css/jquery.dataTables.css">
	  
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/media/js/jquery.js"></script>
	  
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="DataTables-1.10.4/media/js/jquery.dataTables.js"></script>

	</head>
	<header>
		<nav class="top-bar" data-topbar role="navigation">
			<ul class="title-area">
				<li class="name">
					<h1><a href="">Hebergement</a></h1>
				</li>
			</ul>
		</nav>
	</header>
	<div class="row">
	<div class="large-12 columns">
    </div>
			<table id="table" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Nom</th>
				                <th>Role</th>
				            </tr>
				        </thead>
				 
				        <tfoot>
				            <tr>
				                <th>Nom</th>
				                <th>Role</th>
				            </tr>
				        </tfoot>
				 
				        <tbody>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				           	<tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				            </tr>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System</td>
				            </tr>
				        </tbody>
				    </table>
		</div>

		<script src="js/vendor/fastclick.js"></script>
		<script src="js/foundation.min.js"></script>
	
    	<script>
    		$(document).foundation();
			$(document).ready( function () {
			    $('#table').DataTable({
				    initComplete: function () {
			            var api = this.api();
			 
			            api.columns().indexes().flatten().each( function ( i ) {
			                var column = api.column( 1 );
			                var select = $('<label for="select">Filtrer par role</label><select id="select"><option value=""></option></select>')
			                    .appendTo( $(column.footer()).empty() )
			                    .on( 'change', function () {
			                        var val = $.fn.dataTable.util.escapeRegex(
			                            $(this).val()
			                        );
			 
			                        column
			                            .search( val ? '^'+val+'$' : '', true, false )
			                            .draw();
			                    } );
			 
			                column.data().unique().sort().each( function ( d, j ) {
			                    select.append( '<option value="'+d+'">'+d+'</option>' )
			                } );
			            } );
			        }	
			    });
			} );

		</script>

	<footer>

	</footer>
</body>
</html>






