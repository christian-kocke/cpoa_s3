<?php
require_once '../core/init.php';

$user = new user();
// Validation des champ pour la connection
if(input::exists()) { // test si la variable $_POST est set
    if(token::check(input::get('token_login'))) { // verifie que le token du formulaire est equivalent au token dans la variable session de l'utilisateur
        $validation = new validation(); // nouvelle instance de validation
        $validation = $validation->check($_POST, array( // validation des champs
            'login_username' => array('required' => true, 'error' => 'the username', 'numeric' => false), // critères de validation du champ username
            'login_password' => array('required' => true, 'error' => 'the password') // critères de validation du champ password
        ));
        if($validation->passed()) { // si les champs sont valider
            $user = new user(); // nouvelle instance utilisateur
            $remember = (input::get('remember') === 'on') ? true : false; // on regarde si l'utilisateur veut être retenue dans un cookie
            $login = $user->login(input::get('login_username'), input::get('login_password'), $remember); // connection de l'utilisateur

            if($login) { // si la connection à été effectuer
            	redirect::to('index.php');
            } else {
                session::flash('login', array('connection failed')); // sinon on notifie l'utilisateur que la connection a échoué
            }
        } else {
            session::flash('login', $validation->errors()); // si la validation n'a pas réussit on affiche les erreurs
        }
    }
}
if($user->hasPermission("responsable1")){ // si l'utilisateur est admin
	redirect::to('gestion.php'); // redirection a la page d'accueil
}elseif($user->hasPermission("responsable2")){
	redirect::to("ajout_service.php");
}
?>
<!DOCTYPE html>
<html>
	<head>
	<title>Hebergement</title>
	<meta charset="utf-8" />
	<meta name = "viewport" content = "width = device-width, initial-scale = 0.4, user-scalable = yes">
	<link rel="stylesheet" href="css/foundation.css">
  	<link rel="stylesheet" href="css/app.css">
  	<script src="js/vendor/modernizr.js"></script>
  	<script src="js/vendor/jquery.js"></script>
	<script src="js/foundation/foundation.js"></script>
	<script src="js/foundation/foundation.alert.js"></script>

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
			   
		  	</section>
		</nav>
	</header>
	<body>
		<div class="row ">
			<form action="" method="post" class="large-6 large-centered columns">
				<fieldset>
					<legend>Connexion</legend>
						<div class="row">
							<div class="large-6 large-centered column"><input type="text" name="login_username" placeholder="nom d'utilisateur"></div>
							<div class="large-6 large-centered column"><input type="password" name="login_password" placeholder="mot de passe"></div>
							<div class="large-6 large-centered column text-center"><input type="hidden" name="token_login" value="<?php echo token::generate(); ?>"/><input type="submit" value="connexion" class="button tiny"></div>
						</div>
				</fieldset>
			</form>
		</div>
	</body>
	<footer>
	</footer>
</html>


