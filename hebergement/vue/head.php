<?php
include_once '../core/init.php';

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
					<li><a href="gestion.php">Attribution des hebergements</a></li>
					<li><a href="gestion_hebergement.php">Gestion des hebergements</a></li>
					<li><a href="register.php">Création sous-responsable</a></li>
				</ul>

		    	<!-- Right Nav Section -->
			    <ul class="right">
					<li><a href=""><i class="fa fa-user"></i> <?php echo $user->data()->name; ?></a></li>
			     	<li><a href="logout.php"><i class="fa fa-power-off"></i> Déconnexion</a></li>
			    </ul>
		  	</section>
		</nav>
	</header>
