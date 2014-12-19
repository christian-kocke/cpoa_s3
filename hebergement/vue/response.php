<?php
include_once '../core/init.php';

if (is_ajax()) {
  if (isset($_POST["action"]) && !empty($_POST["action"])) { //Checks if action value exists
    $action = $_POST["action"];
    switch($action) { //Switch case for value of action
      case "update": update_function(); break;
      case "add": add_function(); break;
      case "remove": remove_function(); break;
      case "display": display_function(); break;
      case "login": login_function(); break;
    }
  }
}

function display_function(){
  if(input::exists()) {
    if(input::get('table') == "1"){
      $db = db::getInstance();
      $query = $db->query("SELECT nom, id FROM VIP");
      $rslt = $query->results();
      $arr = array ('aaData' => array(
array('3','35','4', '$14,500', '$15,200','$16,900','5','1'),
array('1','16','4', '$14,200', '$15,100','$14,900','Running','1'),
array('5','25','4', '$14,500', '$15,600','$16,900','Not Running','1')
)
);
      echo json_encode($arr);
    }
  }
}