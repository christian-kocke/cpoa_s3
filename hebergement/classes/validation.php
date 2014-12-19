<?php
class validation {
    private $_passed = false,
            $_errors = array(),
            $_db = null;

    public function __construct() {
        $this->_db = db::getInstance();
    }

    public function check($source, $items = array()) {
        foreach($items as $item => $rules) {
            foreach($rules as $rule => $rule_value) {
                $value = trim($source[$item]);
                if($rule === 'required' && empty($value)) {
                    $this->addError("{$items[$item]['error']} has to be specified");
                } else if(!empty($value)){
                    switch($rule) {
                        case 'min' :
                            if(strlen($value) < $rule_value) {
                                $this->addError("{$items[$item]['error']} must be a minimum of {$rule_value} characters");
                            }
                        break;
                        case 'max' :
                            if(strlen($value) > $rule_value) {
                                $this->addError("{$items[$item]['error']} can't be more then {$rule_value} characters");
                            }
                        break;
                        case 'matches' :
                            if($value != $source[$rule_value]) {
                                $this->addError("{$items[$rule_value]['error']} must match {$items[$item]['error']}");
                            }
                        break;
                        case 'unique' :
                            $check = $this->_db->get($rule_value, array($item, '=', $value));
                            if($check->count()) {
                                $this->addError("{$items[$item]['error']} already exists");
                            }
                        break;
                        case 'numeric' :
                            if(is_numeric($value) != $rule_value) {
                                $error = ($rule_value === true) ? "has to" : "can't";
                                $this->addError("{$items[$item]['error']} {$error} be composed only of numbers");
                            }
                        break;
                    }
                }
            }
        }
        if(empty($this->_errors)) {
            $this->_passed = true;
        }

        return $this;
    }

    private function addError($error) {
        $this->_errors[] = $error;
    }

    public function errors() {
        return $this->_errors;
    }

    public function passed() {
        return $this->_passed;
    }

}