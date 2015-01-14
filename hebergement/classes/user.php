<?php
class user {

    private $_db,
            $_data,
            $_sessionName,
            $_cookieName,
            $_isLoggedIn = false;


    public function __construct($user = null) {
        $this->_db = db::getInstance();
        $this->_sessionName = config::get('session/session_name');
        $this->_cookieName = config::get('remember/cookie_name');

        if(!$user) {
            if(session::exists($this->_sessionName)) {
                $user = session::get($this->_sessionName);

                if($this->find($user)) {
                    $this->_isLoggedIn = true;
                } else {
                    //process logout
                }
            }
        } else {
            $this->find($user);
        }
    }

    public function create($fields = array()) {
        if(!$this->_db->insert('USERS', $fields)) {
            throw new Exception('There was a problem creating an account.');
        }
    }

    public function update($fields = array(), $id = null){

        if(!$id && $this->isLoggedIn()){
            $id = $this->data()->id;
        }

        if(!$this->_db->update('USERS', $id, $fields)){
            throw new Exception('There was a problem updating');
        }
    }

    public function find($user = null) {
        if($user) {
            $field = (is_numeric($user)) ? 'id' : 'username';
            $data = $this->_db->get('USERS', array($field, '=', $user));

            if($data->count() == 1) {
                $this->_data = $data->first();
                return true;
            }
        }
        return false;
    }

    public function login($username = null, $password = null, $remember = false) {
        $user = $this->find($username);
        if(!$username && !$password && $this->exists()){
            session::set($this->_sessionName, $this->data()->id);
        }else{
            if($user) {
                if($this->data()->password === hash::generate($password, $this->data()->salt)) {
                    session::set($this->_sessionName, $this->data()->id);

                    if($remember){
                        $hash = hash::unique();
                        $hashCheck = $this->_db->get('USERS_SESSION', array('user_id', '=', $this->data()->id));

                        if(!$hashCheck->count()){
                            $this->_db->insert('USERS_SESSION', array(
                                'user_id' => $this->data()->id,
                                'hash' => $hash
                                ));
                        }else{
                            $hash = $hashCheck->first()->hash;
                        }

                        cookie::set($this->_cookieName, $hash, config::get('remember/cookie_expiry'));

                    }
                    return true;
                }
            }
        }
        return false;
    }

    public function hasPermission($key){
        if($this->isLoggedIn()){
            $group = $this->_db->get('GROUPS', array('id', '=', $this->data()->group));
            if($group->count()){
                $permissions = json_decode($group->first()->permissions, true);
                if($permissions[$key] === 1){
                    return true;
                }
            }
        }
        return false;
    }

    public function exists(){
        return (!empty($this->_data) ? true : false);
    }

    public function logout(){

        $this->_db->delete('USERS_SESSION', array('user_id', '=', $this->data()->id));
        cookie::delete(config::get('remember/cookie_name'));
        session::delete($this->_sessionName);
        session::delete('basket');
    }

    public function data() {
        return $this->_data;
    }

    public function isLoggedIn() {
        return $this->_isLoggedIn;
    }
}