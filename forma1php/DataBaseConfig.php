<?php
class DataBaseConfig
{
	public $servername;
	public $username;
	public $password;
	public $databasename;
	
	public function __construct(){
		$this->servername = 'localhost';
		$this->username = 'ocsko';
		$this->password = '';
		$this->databasename = 'forma1_2019n';
	}
}
?>