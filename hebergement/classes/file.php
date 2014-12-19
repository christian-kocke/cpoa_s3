<?php
class file {

	private $_errors = array(),
			$_file = null,
			$_name,
			$_path,
			$_size = null,
			$_type = array(),
			$_passed = false;

	public function __construct($name, $path = null, $type = null, $size = null){
		$this->_name = trim($name);
		if(in_array($name, array_keys(config::get('files')))){
			if(is_null($path)){
				$this->_path = config::get('files/'.$this->_name.'/path');
			}else{
				$this->_path = $path;
			}
			if(is_null($size)){
				$this->_size = config::get('files/'.$this->_name.'/size');
			}else{
				$this->_size = $size;
			}
			if(is_null($type)){
				$this->_type = config::get('files/'.$this->_name.'/type');
			}else{
				$this->_type = $type;
			}
		}else{
			if(is_null($path)){
				$this->_path = config::get('files/default/path');
			}else{
				$this->_path = $path;
			}
			if(is_null($size)){
				$this->_size = config::get('files/default/size');
			}else{
				$this->_size = $size;
			}
			if(is_null($type)){
				$this->_type = config::get('files/default/type');
			}else{
				$this->_type = $type;
			}
		}
	}

	public static function exists($name){
		if(!empty($_FILES[$name]['name'])){
			return true;
		}
		return false;
	}

	public function check($unique = false){
		if(self::exists($this->_name)){

			$this->_file = $_FILES[$this->_name];

			if(!in_array($this->_file['type'], $this->_type)){
				$this->addError('the file format is incorrect');
			}

			if(!is_null($this->_size) && $this->_file['size'] > $this->_size){
				$this->addError('the file is too large');
			}

			if($unique && file_exists($this->_path . $this->_file["name"])){
				$this->addError('the file already exists');
			}
			if(empty($this->_errors)){
				return $this->_passed = true;
			}
		}
		$this->addError("the file does not exist");
		return false;
	}

	public function upload(){
		if($this->_passed){
			if(!move_uploaded_file($this->_file["tmp_name"], $this->_path . $this->_file['name'])) {
		    	throw new Exception('There was an error uploading you file, error code : '. $this->_file['error']);
		    } 
		}
	}

	private function addError($error){
		$this->_errors[] = $error;
	}

	public function errors() {
        return $this->_errors;
    }

    public function passed(){
    	return $this->_passed;
    }
}