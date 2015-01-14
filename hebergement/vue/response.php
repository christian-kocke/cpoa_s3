<?php
include_once '../core/init.php';

if (is_ajax()) {
  if (isset($_POST["action"]) && !empty($_POST["action"])) { //Checks if action value exists
    $db = db::getInstance();
    $action = $_POST["action"];
    switch($action) { //Switch case for value of action
      case "update": update_function($db); break;
      case "add": add_function($db); break;
      case "service": display_service_function($db); break; 
      case "remove": remove_function($db); break;
      case "display": display_function($db); break;
      case "display2": display_final_function($db); break;
      case "display_h": display_h_function($db); break;
      case "display_h2": display_h_function2($db); break;
      case "displayModal": display_modal_function($db); break;
      case "getValue": getValue_function($db); break;
    }
  }
}


function display_h_function2($db){
  $query = $db->query("SELECT * FROM HEBERGEMENT WHERE responsable = ?", array(input::get('user')));
  $rslt = $query->results();
  if(count($rslt) > 0){
    $return = array ("draw" => $_POST['draw'], "recordsTotal" => count($rslt), "recordsFiltered" => count($rslt), "aaData" => array());
    for($i = 0; $i < count($rslt); $i++){
      $return['aaData'][$i] = array(utf8_encode($rslt[$i]->nom), "<button value=".$rslt[$i]->id." class='button add' data-reveal-id='myModalService'><i class='fa fa-plus'></i> Ajouter service</button>", "<button value=".$rslt[$i]->id." class='button reveal' data-reveal-id='myModalProfil'>Consulter</button>");
    }
    echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
  }else{
    echo json_encode(array ("draw" => $_POST['draw'], "recordsTotal" => 0, "recordsFiltered" => 0, "aaData" => []));
  }
}

function getValue_function($db){
  $return = array("list" => array());
  if(input::get('id')){
    $rslt = $db->get("HEBERGEMENT", array("id", "=", input::get("id")));
    $return = array(
        "nom" => utf8_encode($rslt->first()->nom),
        "adresse" => utf8_encode($rslt->first()->adresse),
        "capacite" => $rslt->first()->capacite,
        "tel" => $rslt->first()->tel,
        "etoile" => $rslt->first()->etoiles,
        "image" => $rslt->first()->image,
        "description" => utf8_encode($rslt->first()->description),
        "id_responsable" => $rslt->first()->responsable
      );
    $responsable = $db->get("USERS", array("id", "=", $rslt->first()->responsable));
    $return['responsable'] = utf8_encode($responsable->first()->name);
  }
    $query = $db->query("SELECT * FROM `USERS` WHERE `group` = 1");
    $rslt = $query->results();
    for($i = 0; $i < count($rslt); $i++){
      $return['list'][$i] = "<option value=".$rslt[$i]->id.">".utf8_encode($rslt[$i]->name)."</option>";
    }
  echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
}

function display_h_function($db){
  $query = $db->query("SELECT * FROM HEBERGEMENT");
  $rslt = $query->results();
  if(count($rslt) > 0){
    $return = array ("draw" => $_POST['draw'], "recordsTotal" => count($rslt), "recordsFiltered" => count($rslt), "aaData" => array());
    for($i = 0; $i < count($rslt); $i++){
      $responsable = $db->get("USERS", array("id", "=", $rslt[$i]->responsable));
      $return['aaData'][$i] = array(utf8_encode($rslt[$i]->nom), utf8_encode($responsable->first()->name), "<button value=".$rslt[$i]->id." class='button modif' data-reveal-id='myModal'><i class='fa fa-pencil'></i> Modifier</button>", "<form action='' method='post'><input type='hidden' name='id' value=".$rslt[$i]->id."><button type='submit' class='button alert'><i class='fa fa-trash'></i> Supprimer</button></form>");
    }
    echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
  }else{
    echo json_encode(array ("draw" => $_POST['draw'], "recordsTotal" => 0, "recordsFiltered" => 0, "aaData" => []));
  }
}




function display_modal_function($db){
  $query = $db->get("SERVICE", array("id_hebergement", "=", input::get('id')));
  $rslt = $query->results();
  $restauration = "";
  $loisirs = "";
  $bien_etre = "";
  $sports = "";
  for($i=0;$i<count((array) $rslt);$i++) {
    switch($rslt[$i]->categorie) {
      case "restauration":
        $restauration .= "<li>".utf8_encode($rslt[$i]->nom)."</li>";
        break;
      case 'loisirs':
        $loisirs .= "<li>".utf8_encode($rslt[$i]->nom)."</li>";
        break;
      case 'bien-etre':
        $bien_etre .= "<li>".utf8_encode($rslt[$i]->nom)."</li>";
        break;
      case 'sports':
        $sports .= "<li>".utf8_encode($rslt[$i]->nom)."</li>";
        break;
    }
  }
  $return = "<div class='row'><div class='large-3 column'><ul class='accordion' data-accordion='myAccordionGroup'><li class='accordion-navigation'><a href='#panel1c'>Restauration</a><div id='panel1c' class='content'><ul>".(($restauration) ? $restauration : "aucun service de restauration disponnible")."</ul></div></li><li class='accordion-navigation'><a href='#panel2c'>Loisirs</a><div id='panel2c' class='content'><ul>".(($loisirs) ? $loisirs : "aucun service de restauration disponnible")."</ul></div></li><li class='accordion-navigation'><a href='#panel4c'>Bien-être</a><div id='panel4c' class='content'><ul>".(($bien_etre) ? $bien_etre : "aucun service de bien-être disponnible")."</ul></div></li><li class='accordion-navigation'><a href='#panel5c'>Sports</a><div id='panel5c' class='content'><ul>".(($sports) ? $sports : "aucun service de sport disponnible")."</ul></div></li></ul></div>";
  $rslt = $db->get("HEBERGEMENT", array("id", "=", input::get('id')));
  $etoiles = "";
  for($i=0;$i<$rslt->first()->etoiles;$i++){
    $etoiles .= " <i class='fa fa-star'></i>";
  }
  $return .= "<div class='large-9 column text-center'><img src=img/".$rslt->first()->image."><h2>".utf8_encode($rslt->first()->nom)."</h2><p>".$etoiles."</p><p><strong>Adresse : </strong>".utf8_encode($rslt->first()->adresse)."</p><p><strong>Tel : </strong>".$rslt->first()->tel."</p><p><strong>Description : </strong>".utf8_encode($rslt->first()->description)."</p></div><a class='close-reveal-modal'>&#215;</a></div>";
  echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
}

function display_function($db){
  if(input::exists()) {
    $query = $db->query("SELECT v.nom, v.role, c.libelle FROM VIP v INNER JOIN JURY j ON v.id_jury = j.id INNER JOIN CONCOURS c ON j.id_concours = c.id WHERE v.id_reservation IS NULL");
    $rslt = $query->results();
    $query = $db->query("SELECT v.nom, v.role, f.nom as film FROM VIP v INNER JOIN EQUIPE e ON v.id_equipe = e.id INNER JOIN FILM f ON e.id_film = f.id WHERE v.id_reservation IS NULL");
    $rslt = array_merge($rslt, $query->results());
    $return = array ("draw" => 1, "recordsTotal" => count($rslt), "recordsFiltered" => count($rslt), "aaData" => array());
    for($i = 0; $i < count($rslt); $i++){
      $return['aaData'][$i] = array(utf8_encode($rslt[$i]->nom), utf8_encode($rslt[$i]->role." ".(($rslt[$i]->libelle) ? $rslt[$i]->libelle : $rslt[$i]->film)));
    }
    echo json_encode($return);
  }
}

function display_service_function($db){
  if(input::exists()) {
    $query = $db->query("SELECT type FROM SERVICE WHERE categorie = ? GROUP BY type", array($_POST['categorie']));
    $rslt = $query->results();
    for($i = 0; $i < count($rslt); $i++){
      echo json_encode(utf8_encode('<li><input type=checkbox form=form1 name='.$rslt[$i]->type.'><label for='.$rslt[$i]->type.'>'.$rslt[$i]->type.'</label></li>'), JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
    }
  }
}

function display_final_function($db){
  if(isset($_POST['debut'])) {
    $debut = DateTime::createFromFormat('j/m/Y', $_POST['debut'], new DateTimeZone('Europe/Paris'));
    $fin = DateTime::createFromFormat('j/m/Y', $_POST['fin'], new DateTimeZone('Europe/Paris'));
    $d = $debut->format('Y-m-d');
    $f = $fin->format('Y-m-d');
    $c = 0;
    $s ="";
    foreach($_POST as $key => $value){
        if($value == "on"){
          $c++;
          $s = $s." '".$key."'";
        }
    }
    $subquery_service = ($c > 0) ? "h.id IN (SELECT temp.id_hebergement FROM (SELECT DISTINCT id_hebergement, type FROM SERVICE WHERE type in (".str_replace(" ", ", ", trim($s)).")) as temp GROUP BY id_hebergement HAVING COUNT(id_hebergement) = ".$c.") AND" : "";
    $query_final = "SELECT DISTINCT h.id, h.nom, h.type 
                    FROM HEBERGEMENT h INNER JOIN SERVICE s ON h.id = s.id_hebergement 
                    WHERE ".$subquery_service." h.type = ? AND h.id IN (SELECT id_hebergement 
                                                                        FROM CHAMBRE 
                                                                        WHERE id NOT IN (SELECT id_chambre
                                                                                        FROM RESERVATION 
                                                                                        WHERE (date_debut >= '".$d."' AND date_debut < '".$f."') OR (date_fin > '".$d."' AND date_fin <= '".$f."') AND ('".$d."' >= date_debut AND '".$d."' < date_fin) OR ('".$f."' > date_debut AND '".$f."' <= date_fin))
                                                                        GROUP BY id_hebergement)";
    $query = $db->query($query_final, array($_POST['logement']));
    $rslt = $query->results();
    $return = array ("draw" => $_POST['draw'], "recordsTotal" => count($rslt), "recordsFiltered" => count($rslt), "aaData" => array());
    for($i = 0; $i < count($rslt); $i++){
      $return['aaData'][$i] = array(utf8_encode($rslt[$i]->nom), utf8_encode($rslt[$i]->type), utf8_encode("<button value=".$rslt[$i]->id." class='button reveal'>Consulter</button>"));
    }
    echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
  }else{
     echo json_encode(array ("draw" => $_POST['draw'], "recordsTotal" => 0, "recordsFiltered" => 0, "aaData" => []));
  }
}

