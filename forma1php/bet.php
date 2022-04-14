<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['race']) && isset($_POST['team']) && isset($_POST['driver'])) {
    if ($db->dbConnect()) {
        if ($db->doBet("bets", $_POST['race'], $_POST['team'], $_POST['driver'])) {
            echo "Bet Success";
        } else echo "Bet Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>