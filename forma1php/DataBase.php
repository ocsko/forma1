<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && $dbpassword == $password) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function register($table, $username, $password, $FullName, $Email, $BornDate, $CardNumber)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $FullName = $this->prepareData($FullName);
        $Email = $this->prepareData($Email);
        $BornDate = $this->prepareData($BornDate);
        $CardNumber = $this->prepareData($CardNumber);
        $password = password_hash($password, PASSWORD_DEFAULT);

        $this->sql =
            "INSERT INTO " . $table . " (username, password, FullName, Email, BornDate, CardNumber)
            VALUES ('" . $username . "','" . $password . "','" . $Email . "','" . $BornDate . "','" . $CardNumber . "')";
        if (mysqli_query($this->connect, $this->sql))
        {
            return true;
        } else return false;

    }

	function doBet($table, $race, $team, $driver)
    {
        $race = $this->prepareData($race);
        $team = $this->prepareData($team);
        $driver = $this->prepareData($driver);
        $this->sql =
            "INSERT INTO " . $table . " (race, team, driver) 
			VALUES ('" . $race . "','" . $team . "','" . $driver . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
}

?>
