<?php
class session {


    public static function exists($name, $key = null) {
        if(is_null($key)){
            return (isset($_SESSION[$name])) ? true : false;
        }else if(!is_null($key) && isset($_SESSION[$name])) {
            if(is_array($_SESSION[$name])){
                return (array_key_exists($key, $_SESSION[$name]));
            }
            return false;
        }
    }

    public static function set($name, $value) {
        return $_SESSION[$name] = $value;
    }

    public static function setArray($name, $key, $value){
        if(!self::exists($name)){
            $_SESSION[$name] = array();
        }
        return $_SESSION[$name][$key] = $value;
    }

    public static function get($name, $key = null){
        if(is_null($key)){
            return (isset($_SESSION[$name])) ? $_SESSION[$name] : null;  
        }else if(!is_null($key) && is_array($_SESSION[$name])){
            if(self::exists($name, $key)){
                return $_SESSION[$name][$key];
            }
        }else{
            return null;
        }

    }

    public static function delete($name, $key = null) {
        if(is_null($key) && self::exists($name)) {
            unset($_SESSION[$name]);
        }else if(self::exists($name, $key)){
            unset($_SESSION[$name][$key]);
        }
    }

    public static function flash($name, $string = '') {
        if(self::exists($name)) {
            $session = self::get($name);
            self::delete($name);
            return $session;
        } else {
            self::set($name, $string);
        }
    }

    public static function flashArray($name, $array = array()) {
        if(self::exists($name)) {
            $session = self::get($name);
            self::delete($name);
            return $session;
        } else {
            self::set($name, $array);
        }
    }

}