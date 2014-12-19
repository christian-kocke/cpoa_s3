<?php
function escape($string){
    return htmlentities($string, ENT_QUOTES, 'UTF-8');
}

function is_ajax() {
  return isset($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest';
}