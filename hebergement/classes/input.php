<?php
class Input {
    public static function exists($type = 'post'){
        switch($type) {
            case 'post' :
                return (!empty($_POST)) ? true : false;
            break;
            case 'get' :
                return (!empty($_GET)) ? true : false;
            break;
            case 'files' :
                return (!empty($_FILES)) ? true : false;
            break;
            default :
                return false;
            break;
        }
    }

    public static function get($item) {
        if(isset($_POST[$item])){
            return escape(trim($_POST[$item]));
        } else if(isset($_GET[$item])) {
            return escape(trim($_GET[$item]));
        }
        return '';
    }
}