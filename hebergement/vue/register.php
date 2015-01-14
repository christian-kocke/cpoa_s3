<?php
require_once '../core/init.php';
$user = new user();
// Validation des champ pour l'enregistrement de l'utilisateur

if (input::exists()) { // test si la variable $_POST est set
    if(token::check(input::get('token_register')) === true) { // verifie que le token du formulaire est equivalent au token dans la variable session de l'utilisateur
        $validate = new validation(); // nouvelle instance de validation
        $validation = $validate->check($_POST, array( // validation des champs
            'username' => array( // critères de validation du champ username
                'error' => "Le nom d'utilisateur",
                'required' => true,
                'min' => 2,
                'max' => 20,
                'unique' => 'users',
                'numeric' => false
            ),
            'password' => array( // critères de validation du champ password n°1
                'error' => 'Le mot de passe',
                'required' => true,
                'min' => 6,
            ),
            'password_again' => array( // critères de validation du champ password n°2
                'error' => 'Le second mot de passe',
                'required' => true,
                'matches' => 'password'
            ),
            'name' => array( // critères de validation du champ name
                'error' => 'Le nom du responsable',
                'required' => true,
                'min' => 2,
                'max' => 50,
            ),
        ));

        if ($validation->passed()) { // si les champs sont valider
            $user = new user(); // nouvelle instance utilisateur
            $salt = hash::salt(32); // création d'un salt pour le hashage du mot de passe dans la base de donnée
            try { // try - catch pour les erreurs sql éventuel
                $user->create(array( // création de l'utilisateur
                    'username' => input::get('username'),
                    'password' => hash::generate(input::get('password'), $salt), // hashage du mot de passe en 'sha256' avec un salt
                    'salt' => $salt,
                    'name' => input::get('name'),
                    'joined' => date('Y-m-d H:i:s'), // date de la création de l'utilisateur
                    'group' => 1 // sont groupe (admin, user, etc ...)
                ));
                session::flash('home', 'You registered successfully !'); // on affiche le message pour signaler a l'utilisateur qu'il a bien été enregistrer
                redirect::to('index.php'); // on le redirige a la page d'accueil

            } catch(Exception $e) { 
                die($e->getMessage()); // affichage des erreurs eventuelles
            }
        } else {
            session::flash('register', $validation->errors()); // si la validation des champs échoue on affiche les erreurs
        }
    }
}

$token = token::generate(); // on génère le token pour évité les 'cross site forgeries'

require_once 'head.php';
?>      
        <div class="row login">
            <div class = "large-6 large-centered column">
                <div class="row panel">
                    <h4 class="text-center">Ajouter un sous-responsable</h4>
                    <div id="mainAlert3" data-alert class="alert-box alert hide" tabindex="0" aria-live="assertive" role="dialogalert">
                        <p class="flash"><?php
                        if(session::exists('register')){
                            foreach(session::flash('register') as $error){
                                echo $error.'</br>';
                            }
                        }
                        ?></p>
                      <button href="#" tabindex="0" class="close" aria-label="Close Alert">&times;</button>
                    </div>
                    <form action="" method="post" name="registerForm" id="registerForm">
                        <div class="large-12 large-centered column">
                            <label for="username">Nom d'utilisateur </label>
                            <input type="text" name="username" id="username" value="<?php echo input::get('username'); ?>" autocomplete="off"/>
                        </div> 
                        <div class="large-12 large-centered column">
                            <label for="password">Mot de passe </label>
                            <input type="password" name="password" id="password"/>
                        </div>
                        <div class="large-12 large-centered column">
                            <label for="password_again">Confirmer le mot de passe </label>
                            <input type="password" name="password_again" id="password_again"/>
                        </div>
                        <div class="large-12 large-centered column">
                            <label for="name">Nom du responsable </label>
                            <input type="text" name="name" id="name" value="<?php echo input::get('name'); ?>"/>
                        </div>
                        <div class="large-6 large-centered column text-center">
                            <input type="hidden" name="token_register" value="<?php echo $token ?>"/>
                            <button class='button' type='submit' value='register'>Enregistrer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <footer>
        <script src="js/vendor/fastclick.js"></script>
        <script src="js/foundation.min.js"></script>
        <script>
            $(document).foundation();

            $(document).ready(function() {
                $(".flash").each(function() {
                    if($(this).is(":empty")){
                        $(this).parent().addClass("hide");
                    }else{
                        $(this).parent().removeClass("hide");
                    }
                });
            });
        </script>
    </footer>
</body>
</html>
