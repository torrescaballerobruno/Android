<?php 
 //Getting Id
 $id = $_GET['id'];
 
//Importing Database Script 
 define('HOST','mysql.hostinger.mx');
 define('USER','u775336626_bruni');
 define('PASS','proteco1234');
 define('DB','u775336626_pan');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 //AQUÍ TERMINA LA CONEXIÓN
 
 //Creating sql query
 $sql = "DELETE FROM producto WHERE id=$id;";
 
 //Deleting record in database 
 if(mysqli_query($con,$sql)){
 echo 'pan destruido muajajaja >:v';
 }else{
 echo 'Tu pan es invensible';
 }
 
 //closing connection 
 mysqli_close($con);