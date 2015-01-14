<?php
include_once '../core/init.php';
include_once 'head.php';
$db = db::getInstance();
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
    echo $query_final;
    echo json_encode($return, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);
  }else{
     echo json_encode(array ("draw" => $_POST['draw'], "recordsTotal" => 0, "recordsFiltered" => 0, "aaData" => []));
  }
?>