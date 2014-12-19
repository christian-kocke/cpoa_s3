<?php

session_start();

$GLOBALS['config'] = array(
    'mysql' => array(
        'host' => 'iutdoua-webetu.univ-lyon1.fr',
        'username' => 'p1301074',
        'password' => '188145',
        'db' => 'p1301074'
    ),
    'remember' => array(
        'cookie_name' => 'hash',
        'cookie_expiry' => 604800
    ),
    'session' => array(
        'session_name' => 'user',
        'token_name' => 'token'
    ),
    'files' => array(
        'product_image' => array(
            'path' => '../includes/assets/products/',
            'size' => 500000,
            'type' => array('image/png', 'image/gif', 'image/jpeg', 'image/jpg')
        ),
        'profile_image' => array(
            'path' => '../includes/assets/images/',
            'size' => 500000,
            'type' => array('image/png', 'image/gif', 'image/jpeg', 'image/jpg')
        ),
        'default' => array(
            'path' => '../includes/assets/default/',
            'size' => 5000,
            'type' => array('text/plain') 
        )
    )
);

spl_autoload_register(function($class) {   
    require_once '../classes/' . $class . '.php';
});

require_once '../functions/sanitize.php';

if(cookie::exists(config::get('remember/cookie_name')) && !session::exists(config::get('session/session_name'))){
    $hash = cookie::get(config::get('remember/cookie_name'));
    $hashCheck = db::getInstance()->get('users_session', array('hash', '=', $hash));

    if($hashCheck->count()){
        $user = new user($hashCheck->first()->user_id);
    }
}