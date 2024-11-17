<?php

    $connection = mysqli_connect("localhost", "root", "", "db_lms");
    if (!$connection) {
        die("Connection Die");
    } else {
        echo("Connection Established");
    }

?>