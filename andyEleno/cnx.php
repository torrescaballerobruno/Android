<?php
 /*
 Aquí hacemos la conexión a la base de datos de hostinger
 author: kubos777 
 */
 
 //Defining Constants
 define('HOST','mysql.hostinger.mx');
 define('USER','u775336626_bruni');
 define('PASS','proteco1234');
 define('DB','u775336626_pan');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 ?>