<?php
include_once '../core/init.php';
$user = new user();
if(input::exists()){
	$db = db::getInstance();
	$debut = DateTime::createFromFormat('j/m/Y', $_POST['start'], new DateTimeZone('Europe/Paris'));
	$fin = DateTime::createFromFormat('j/m/Y', $_POST['end'], new DateTimeZone('Europe/Paris'));
	$d = $debut->format('Y-m-d');
	$f = $fin->format('Y-m-d');
	$query = "SELECT id
			  FROM CHAMBRE 
			  WHERE id_hebergement = ? AND id NOT IN (SELECT id_chambre 
				               FROM RESERVATION 
				               WHERE (date_debut >= '".$d."' AND date_debut < '".$f."') OR (date_fin > '".$d."' AND date_fin <= '".$f."') AND ('".$d."' >= date_debut AND '".$d."' < date_fin) OR ('".$f."' > date_debut AND '".$f."' <= date_fin))";
	$rslt = $db->query($query, array($_POST['id']));
	$id_chambre = $rslt->first()->id;
	$rslt = $db->get('VIP', array("nom", "=", $_POST["nom"]));
	$id_vip = $rslt->first()->id;
	$db->insert('RESERVATION', array("id_vip" => $id_vip,
									 "id_hebergement" => $_POST['id'],
									 "id_chambre" => $id_chambre,
									 "date_debut" => $d,
									 "date_fin" => $f
									));
	$rslt = $db->get('RESERVATION', array("id_vip", "=", $id_vip));
	$db->update('VIP', $id_vip, array("id_reservation" => $rslt->first()->id));
}




include_once 'head.php';
?>
	<div class="row">
		<div class="row step1">
			<div class="large-12 large-centered columns">
		    
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

			        </tbody>
			    </table>
			</div>
			<div class="large-2 large-centered column">
				<button class="button next n1" value="2">Suivant <i class="fa fa-angle-right fa-1x"></i></button>
			</div>
		</div>
		<div class="row step2">
			<div class="row">
				<div id="mainAlert1" data-alert class="alert-box large-10 large-centered column" tabindex="0" aria-live="assertive" role="dialogalert">
				  <span id="guest"></span>
				  <button href="#" tabindex="0" class="close" aria-label="Close Alert">&times;</button>
				</div>
		        <div class="large-12 large-centered column text-center">
		            <form action="" data-abide method="post" class="form1" id="form1"> 
		               <table class="table">
		               	    <thead>
		               	        <tr>
		               	            <th>Arrivé:
		               	                <div>
		               	                	<input type="date" name="debut" class="fdatepicker" value="" id="dpd1" required pattern="([1][4-9]|[2][0-3])[- \/.](05)[- \/.](2015)">
		               	                	<small class="error" id="dp1Error">La date n'est pas valide</small>
		               	                </div>
		               	            </th>
		               	            <th>Départ:
		               	            	<div>
		               	            		<input type="date" name="fin" class="fdatepicker" value="" id="dpd2" required pattern="([1][3-9]|[2][0-4])[- \/.](05)[- \/.](2015)" data-abide-validator="isAllowed">
		               	            		<small class="error" id="dp2Error">La date n'est pas valide</small>
		               	            	</div>
		               	            </th>
		               	            <th>Type de logement :                     	
		               	        		<select name="logement" id="tlogement" required>
		               	        			<option value="hotel">Hôtel</option>
		               	        			<option value="villa">Villa</option>
		               	        		</select>
		               	            </th>
		               	        </tr>
		               	    </thead>
		               	</table> 
		           	</form>
		        </div>
		    </div>
		    <div class="row">
		    	<div class="large-12 large-centered column">
		    		<dl class="sub-nav service">
					  <dt>Services :</dt>
					  <dd class="active"><a href="#" id="s">Tous</a></dd>
					  <dd><a href="#" id="s1">Restauration</a></dd>
					  <dd><a href="#" id="s2">Loisirs</a></dd>
					  <dd><a href="#" id="s3">Sports</a></dd>
					  <dd><a href="#" id="s4">Bien être</a></dd>
					</dl>
		    	</div> 
			    <div class="large-12 large-centered column">
			    	<div class="panel panel_service">
			    		<div class="row" data-equalizer>
			    			<div class="large-3 column s s1">
			    				<div class="panel">
			    					<h6>Restauration</h6>
			    					<ul class="list" id="restauration">	
			    					</ul>
			    				</div>
			    			</div>
			    			<div class="large-3 column s s2">
				    			<div class="panel">
				    				<h6>Loisirs</h6>
			    					<ul class="list" id="loisirs">
			    					</ul>
				    				</div>
				    			</div>
			    			<div class="large-3 column s s3">
			    				<div class="panel">
			    					<h6>Sports</h6>
			    					<ul class="list" id="sports">
			    					</ul>
			    				</div>
			    			</div>
			    			<div class="large-3 column s s4">
			    				<div class="panel">
			    					<h6>Bien être</h6>
			    					<ul class="list" id="bien-etre">	
			    					</ul>
			    				</div>
			    			</div>
			    		</div>
			    	</div>
			    </div>
		    	<div class="large-4 large-centered column">
		    		<ul class="button-group even-2">
					  <li><button class="button previous p2" value="1"><i class="fa fa-angle-left fa-1x"></i> Précédent</button></li>
					  <li><button type="submit" form="form1" class="button next n2" value="3">Suivant <i class="fa fa-angle-right fa-1x"></i></button></li>
					</ul>
		    	</div>
		    </div>
		</div>
		<div class="row step3">
			<div class="large-12 large-centered columns">
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
				</table>
			</div>
			<div class="large-4 large-centered column">
    			<ul class="button-group even-2">
				  	<li><button class="button previous" value="2"><i class="fa fa-angle-left fa-1x"></i> Précédent</button></li>
				  	<li>
					  	<form action="" method="post">
					  		<input type="hidden" name="start" id="start" value="">
					  		<input type="hidden" name="end" id="end" value="">
					  		<input type="hidden" id="id" name="id" value="">
					  		<input type="hidden" id="nom" name="nom" value="">
					  		<button type="submit" class="button p" value="3">Placer</button>
					  	</form>
				  	</li>
				</ul>
	    	</div>
		</div>
	</div>

	<div id="myModal" class="reveal-modal" data-reveal>
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






