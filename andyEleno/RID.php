<?php 
 //*********************MUESTRA INFO POR ID***********************

 //Getting the requested id
 $id = $_GET['id'];
 
//Importing Database Script 
 define('HOST','mysql.hostinger.mx');
 define('USER','u775336626_bruni');
 define('PASS','proteco1234');
 define('DB','u775336626_pan');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 //AQUÍ TERMINA LA CONEXIÓN
 
 //Creating sql query with where clause to get an specific employee
 $sql = "SELECT * FROM usuarios WHERE id=$id";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //pushing result to an array 
 $result = array();
 $row = mysqli_fetch_array($r);
 array_push($result,array(
 "id"=>$row['id'],
 "name"=>$row['nombre'],
 "pas"=>$row['password'],
 "usu"=>$row['usuario']
 ));
 
 //displaying in json format 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($con);
 ?>