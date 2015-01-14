<?php
include_once '../core/init.php';
$user = new user();
$db = db::getInstance();
if(input::exists()){
	if(input::get('id')){
		$db->insert("SERVICE", array(
			"id_hebergement" => input::get('id'),
			"categorie" => input::get('categorie'),
			"type" => input::get('type'),
			"nom" => input::get('nom')
			));
	}
}
?>
<!DOCTYPE html>
<html>
	<head>
	<title>Hebergement</title>
	<meta charset="utf-8" />
	<meta name = "viewport" content = "width = device-width, initial-scale = 0.4, user-scalable = yes">

	<!-- foundation CSS -->
	<link rel="stylesheet" href="css/foundation.css">

	<!-- costum page CSS -->
  	<link rel="stylesheet" href="css/app.css">

	<!-- foundation datepicker CSS -->
  	<link rel="stylesheet" href="css/foundation-datepicker.css">

  	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="DataTables-1.10.4/media/css/jquery.dataTables.css">

  	<!-- font awesome CSS -->
  	<link rel="stylesheet" href="font-awesome-4.2.0/css/font-awesome.min.css">

	<!-- modernizr.js foundation -->
  	<script src="js/vendor/modernizr.js"></script>

  	<!-- jQuery -->
  	<script src="js/vendor/jquery.js"></script>
	    
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
				<ul class="left">
					
				</ul>

		    	<!-- Right Nav Section -->
			    <ul class="right">
			      <li><a href="logout.php">Déconnexion</a></li>
			    </ul>
		  	</section>
		</nav>
	</header>
	<div class="row">
		<div class="large-12 large-centered column">
			<table id="table" class="display" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Hebergement</th>
		                <th>Action</th>
		                <th>Profil</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		                <th>Hebergement</th>
		                <th>Action</th>
		                <th>Profil</th>
		            </tr>
		        </tfoot>
			</table>
		</div>
	</div>

	<div id="myModalService" class="reveal-modal" data-reveal>
	  <h4>Ajouter un service</h4>
		<form action="" method="post">
			<label for="categorie">Choisir une catégorie</label>
			<select name="categorie" id="categorie">
				<option value="restauration">restauration</option>
				<option value="loisirs">loisirs</option>
				<option value="bien-etre">bien-être</option>
				<option value="sports">sports</option>
			</select>
			<input type="text" name="type" id="type" placeholder="ex : restaurant, tennis">
			<input type="text" name="nom" id="nom" placeholder="ex : Restaurant Chez Joseph">
			<input type="hidden" name="id" id="id" value="">
			<button type="submit" class="button"><i class="fa fa-plus"></i> Ajouter</button>
		</form>
		<a class="close-reveal-modal">&#215;</a>
	</div>

	<div id="myModalProfil" class="reveal-modal" data-reveal>
		<div class="row">
			<div class="large-3 column">
			    <ul class="accordion" data-accordion="myAccordionGroup">
			      <li class="accordion-navigation">
			        <a href="#panel1c">Restauration</a>
			        <div id="panel1c" class="content">
			          <ul>
			          	<li>Le Grand restaurant</li>
			          	<li>Chez Jean</li>
			          </ul>
			        </div>
			      </li>
			      <li class="accordion-navigation">
			        <a href="#panel2c">Loisirs</a>
			        <div id="panel2c" class="content">
			          Panel 2. Lorem ipsum dolor
			        </div>
			      </li>
			      <li class="accordion-navigation">
			        <a href="#panel4c">Bien-être</a>
			        <div id="panel4c" class="content">
			          Aucun service de bien-être disponible.
			        </div>
			      </li>
			      <li class="accordion-navigation">
			        <a href="#panel5c">Sports</a>
			        <div id="panel5c" class="content">
			        	Aucun service de sports disponible.
			        </div>
			      </li>
			    </ul>
			</div>
			<div class="large-9 column text-center">
				<img src="img/hilton.jpg">
				<h2>Hitlon</h2>
				<p><i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i></p>	  	
			  	<p><strong>Adresse : </strong>15 boulevard de cannes</p>
			  	<p><strong>Tel : </strong>04 76 56 78 65</p>
			  	<p><strong>Description : </strong>L'hôtel Hilton de cannes est situer au bord de la plage et dispose d'un magnifique vu et d'un acces a une plage privée</p>
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
	                "sEmptyTable": "Vous êtes en charge d'aucun hebergement",
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
		            "data": {"action" : "display_h2", "user" : <?php echo $user->data()->id; ?>}
				}
		    });
			$(document).foundation({
			  accordion: {
			    // specify the class used for accordion panels
			    content_class: 'content',
			    // specify the class used for active (or open) accordion panels
			    active_class: 'active',
			    // allow multiple accordion panels to be active at the same time
			    multi_expand: false,
			    // allow accordion panels to be closed by clicking on their headers
			    // setting to false only closes accordion panels when another is opened
			    toggleable: true
			  }
			});
			$('#myAccordionGroup').on('click', 'a', function () {
				if($(this).sibling("div").hasClass("active")){
					$(this).siblings().removeClass("active");
				}else{
					$(this).siblings().addClass("active");
				}
			});

			$("#table").on("click", "tr td button.add", function() {
				$("#id").val($(this).val());
			});

			$("#table tbody").on("click", "button.reveal", function() {
		        var id = $(this).val();
		        $('#myModalProfil').foundation('reveal', 'open', {
		            url: 'response.php',
		            type: 'POST',
		            data: {action: 'displayModal', id: id},
		            dataFilter: function(data) {
		                return data.replace(/\"/g, "");
		            },
		        });
		    });

		    $('#myModalProfil').on("click", "a", function () {
		        field = $(this).attr("href");
		        if($(field).hasClass("active")){
		            $(field).removeClass("active");
		        }else{
		            $(field).addClass("active");
		            $("content.active").removeClass('active');
		        }
		    });
		});
	</script>
	<footer>

	</footer>
</body>
</html>