<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['password'])&& isset($_POST['FullName']) &&  isset($_POST['Email']) && isset($_POST['BornDate']) && isset($_POST['CardNumber'])) {
    if ($db->dbConnect()) {
        if ($db->register("user", $_POST['username'], $_POST['password'], $_POST['FullName'], $_POST['Email'], $_POST['BornDate'], $_POST['CardNumber'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
