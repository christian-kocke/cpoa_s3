<?php
include_once '../core/init.php';

?>
<!DOCTYPE html>
<html>
	<head>
	<title>Hebergement</title>
	<meta charset="utf-8" />
	<meta name = "viewport" content = "width = device-width, initial-scale = 0.4, user-scalable = yes">
	<link rel="stylesheet" href="css/foundation.css">
  	<link rel="stylesheet" href="css/app.css">
  	<link rel="stylesheet" href="css/foundation-datepicker.css">
  	<link rel="stylesheet" href="font-awesome-4.2.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

  	<script src="js/vendor/modernizr.js"></script>
  	<script src="js/vendor/jquery.js"></script>
  	

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
			<section class="top-bar-section">
		    <!-- Right Nav Section -->
			    <ul class="right">
			      <li><a href="#">Logout</a></li>
			    </ul>
		  	</section>
		</nav>
	</header>
	<div class="row">
		<div class="row step1">
			<div class="large-10 large-centered columns">
		    
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
			                <td>Executive</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Jean Claude</td>
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
			<div class="large-2 large-centered column">
				<button class="button next" value="2">Suivant <i class="fa fa-angle-right fa-1x"></i></button>
			</div>
		</div>
		<div class="row step2">
			<div class="row">
		        <div class="large-10 large-centered column">
		   			
		            <form action="" data-abide> 
		               <table class="table">
		               	    <thead>
		               	        <tr>
		               	            <th>Arrivé:
		               	                <div>
		               	                	<input type="text" name="debut" class="fdatepicker" value="" id="dpd1" required pattern="([1][4-9]|[2][0-3])[- \/.](05)[- \/.](2015)">
		               	                	<small class="error" id="dp1Error">La date n'est pas valide</small>
		               	                </div>
		               	            </th>
		               	            <th>Départ:
		               	            	<div>
		               	            		<input type="text" name="fin" class="fdatepicker" value="" id="dpd2" required pattern="([1][3-9]|[2][0-4])[- \/.](05)[- \/.](2015)" data-abide-validator="isAllowed">
		               	            		<small class="error" id="dp2Error">La date n'est pas valide</small>
		               	            	</div>
		               	            </th>
		               	            <th>Type de logement :                     	
		               	        		<select name="logement" id="tlogement" required>
		               	        			<option value="hotel">Hôtel</option>
		               	        			<option value="villa">Villa</option>
		               	        		</select>
		               	            </th>
		               	            <th class="chambre">Type de chambre :                     	
		               	        		<select name="chambre">
		               	        			<option value="suite1">suite simple 1 personne</option>
		               	        			<option value="suite2">suite simple 2 personnes</option>
		               	        			<option value="suite1luxe">suite luxe 1 personne</option>
		               	        			<option value="suite2luxe">suite luxe 2 personnes</option>
		               	        		</select>
		               	            </th>
		               	        </tr>
		               	    </thead>
		               	</table> 
		           	</form>
		        </div>
		    </div>
		    <div class="row">
		    	<div class="large-10 large-centered column">
		    		<dl class="sub-nav service">
					  <dt>Services :</dt>
					  <dd class="active"><a href="#">Tous</a></dd>
					  <dd><a href="#">Restauration</a></dd>
					  <dd><a href="#">Loisirs</a></dd>
					  <dd><a href="#">Sports</a></dd>
					  <dd><a href="#">Bien être</a></dd>
					</dl>
		    	</div> 
			    <div class="large-10 large-centered column">
			    	<div class="panel panel_service">
			    		<h5>This is a regular panel.</h5>
			    	  		<p>It has an easy to override visual style, and is appropriately subdued.</p>
			    	</div>
			    </div>
		    	<div class="large-4 large-centered column">
		    		<ul class="button-group">
					  <li><button class="button previous" value="1"><i class="fa fa-angle-left fa-1x"></i> Précédent</button></li>
					  <li><button type="submit" class="button next" value="3">Suivant <i class="fa fa-angle-right fa-1x"></i></button></li>
					</ul>
		    	</div>
		    </div>
		</div>
		<div class="row step3">
			<div class="large-10 large-centered columns">
				<table id="table2" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Hebergement</th>
			                <th>Type</th>
			                <th>Profil</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Hebergement</th>
			                <th>Type</th>
			                <th>Profil</th>
			            </tr>
			        </tfoot>
			 
			        <tbody>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			           	<tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			            <tr>
			                <td>Tiger Nixon</td>
			                <td>System Architect</td>
			                <td>System Architect</td>
			            </tr>
			        </tbody>
				</table>
			</div>
			<div class="large-4 large-centered column">
	    		<ul class="button-group">
				  <li><button class="button previous" value="2"><i class="fa fa-angle-left fa-1x"></i> Précédent</button></li>
				  <li><button type="submit" class="button" value="3">Placer</button></li>
				</ul>
	    	</div>
		</div>
	</div>
    	

	<script src="js/vendor/fastclick.js"></script>
	<script src="js/foundation.min.js"></script>
	<script src="js/foundation-datepicker.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<script src="js/gestion.js"></script>
	<footer>

	</footer>
</body>
</html>






