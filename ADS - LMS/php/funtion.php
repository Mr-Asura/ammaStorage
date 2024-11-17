<?php

    include 'connection.php';
    $last_name = ucfirst($_POST['last_name']);
    $first_name = ucfirst($_POST['first_name']);
    $middle_name = ucfirst($_POST['middle_name']);
    $full_name = $last_name . ", " . $first_name . " " . $middle_name;

?>