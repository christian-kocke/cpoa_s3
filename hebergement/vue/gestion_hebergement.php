<?php
include_once '../core/init.php';
$user = new user();
include_once 'head.php';
$db = db::getInstance();
if(input::exists()){
	if(input::get('id')){
		$query = $db->query("SELECT id FROM `RESERVATION` WHERE `id_hebergement` = ?", array(input::get('id')));
		$rslt = $query->results();
		$db->delete("RESERVATION", array("id_hebergement", "=", input::get('id')));
		$db->delete("CHAMBRE", array("id_hebergement", "=", input::get('id')));
		$db->delete("SERVICE", array("id_hebergement", "=", input::get('id')));
		for($i = 0; $i < count($rslt); $i++){
			$db->query("UPDATE VIP set id_reservation = NULL WHERE id_hebergement = ?", array($rslt[$i]->id));
		}
		$db->delete("HEBERGEMENT", array("id", "=", input::get('id')));
	}else{
		if(input::get('image')){
			$a = array("etoiles" => input::get('etoile'),
				"nom" => input::get('nom'),
				"adresse" => input::get('adresse'),
				"tel" => input::get('tel'),
				"image" => input::get('image'),
				"capacite" => input::get('capacite'),
				"description" => utf8_decode(input::get('description')),
				"responsable" => input::get('nom_resp')
				);
		}else{
			$a=array("etoiles" => input::get('etoile'),
				"nom" => input::get('nom'),
				"adresse" => input::get('adresse'),
				"tel" => input::get('tel'),
				"capacite" => input::get('capacite'),
				"description" => utf8_decode(input::get('description')),
				"responsable" => input::get('nom_resp')
				);
		}
		if(input::get('id_h')){
			$db->update("HEBERGEMENT", input::get('id_h'), $a);
		}else{
			$a['type'] = input::get('type');
			$db->insert("HEBERGEMENT", $a);
			$rslt = $db->get("HEBERGEMENT", array("nom", "=", input::get('nom')));
			$id = $rslt->first()->id;
			for($i = 0; $i < input::get('capacite');$i++){
				$db->insert("CHAMBRE", array("id_hebergement" => $id, "type" => "suite1", "capacite" => 2));
			}
		}
	}
}


?>
<div class="row">
	<div class="large-12 large-centered column">
		<table id="table" class="display" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>Hebergement</th>
	                <th>Responsable</th>
	                <th>Modifier</th>
	                <th>Supprimer</th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	        <tfoot>
	            <tr>
	                <th>Hebergement</th>
	                <th>Responsable</th>
	                <th>Modifier</th>
	                <th>Supprimer</th>
	            </tr>
	        </tfoot>
		</table>
	</div>
	<div class="large-12 column text-center">
		<button  href='#' class='button add' data-reveal-id='myModal'><i class="fa fa-plus"></i> Créer hébergement</button>
	</div>
</div>

<div id="myModal" class="reveal-modal" data-reveal>
	<div class="row">
		<div class="large-8 large-centered column">
			<form action="" method="post" id="form">
				<div class="large-5 column large-centered">
					<label for="image"><img id="imagesrc" src=""></label>
					<input type="file" name="image" id="image" value="">
					</div>
					<label for="nom_resp">Nom du responsable</label>
					<select name="nom_resp" id="nom_resp">
						<option id="nom_resp1" value=""></option>
					</select>
					<label for="nom">Nom de l'hebergement</label>
					<input type="text" name="nom" id="nom" value="">
					<div class="type">
						<label for="type">Type d'hebergement</label>
						<select name="type" id="type">
							<option value="hotel">hotel</option>
							<option value="villa">villa</option>
						</select>
					</div>
					<label for="etoile">Nombre d'étoiles</label>
					<input type="number" name="etoile" id="etoile" value="">
					<label for="capacite">Capaciter</label>
					<input type="number" name="capacite" id="capacite" value="">
					<label for="adresse">Adresse</label>
					<input type="text" name="adresse" id="adresse" value="">
					<label for="tel">Numéro de telephone</label>
					<input type="tel" name="tel" id="tel" value="">
					<label for="description">Description</label>
					<textarea name="description" id="description"></textarea>
					<div class="large-12 column text-center">
					<input type="hidden" id="id_h" name="id_h" value="">
					<button class="button">Valider</button>
					</div>
				</div>
			</form>
		</div>
		<a class="close-reveal-modal">&#215;</a>
	</div>
	</div>

	<script src="js/vendor/fastclick.js"></script>
	<script src="js/foundation.min.js"></script>
	<script src="js/foundation-datepicker.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<script type="text/javascript">
		$(document).foundation();
		$(document).ready(function() {
				var table = $('#table').DataTable({
		        "dom" : 'lfrtip',
		        "oLanguage": {
	                "sEmptyTable": "Aucun hebergement existe dans la base de donnée",
	                "sSearch": "Recherche",
	                "sLengthMenu": 'Afficher <select>'+
	                '<option value="10">10</option>'+
	                '<option value="20">20</option>'+
	                '<option value="30">30</option>'+
	                '<option value="40">40</option>'+
	                '<option value="50">50</option>'+
	                '<option value="-1">Tous</option>'+
	                '</select> ',
		            "sInfoFiltered": " - ( filtrer à partir de _MAX_ enregistrements )",
		            "sInfo": "Un total de _TOTAL_ enregistrement(s) afficher (de _START_ à _END_)",
	                "oPaginate": {
		                "sNext": "Suivant",
		                "sPrevious": "Précédent"
		            }
		        },
		        "serverSide": true,
		        "processing": true,
		        "ajax" : {
		            "type": "POST",
		            "dataType": "json",
		            "url": "response.php",
		            "data": { action : "display_h" }
				}
			});
			$(".add").click(function() {
				$("#imagesrc").attr("src", "");
				$(".type").show();
				document.getElementById("form").reset();
				$.ajax({
				  type: "POST",
				  dataType: "json",
				  url: "response.php", 
				  data: { action : "getValue" },
				  success: function(data) {
				  	for(i=0; i < data['list'].length; i++){
				  		$(data['list'][i]).appendTo("#nom_resp");
				  	}
				 }
				});
			});

			$("#table").on("click", "tr td button.modif", function() {
				$("#id_h").val($(this).val());
				$(".type").hide();
				$.ajax({
				  type: "POST",
				  dataType: "json",
				  url: "response.php", 
				  data: { action : "getValue", id : $(this).val() },
				  success: function(data) {
				  	$("#imagesrc").attr("src", "img/"+data['image']);
				  	$("#nom_resp1").html(data['responsable']);
				  	$("#nom_resp1").val(data['id_responsable']);
				  	$("#nom").val(data['nom']);
				  	$("#etoile").val(data['etoile']);
				  	$("#capacite").val(data['capacite']);
				  	$("#adresse").val(data['adresse']);
				  	$("#tel").val(data['tel']);
				  	$("#description").val(data['description']);
				  	$("#nom_resp").empty();
				  	for(i=0; i < data['list'].length; i++){
				  		$(data['list'][i]).appendTo("#nom_resp");
				  	}
				  }
				});
			});
		});
	</script>
	<footer>

	</footer>
</body>
</html>