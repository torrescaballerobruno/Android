<?php 
 //Importing Database Script 
 define('HOST','mysql.hostinger.mx');
 define('USER','u775336626_bruni');
 define('PASS','proteco1234');
 define('DB','u775336626_pan');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 //AQUÍ TERMINA LA CONEXIÓN
 
 //Creating sql query
 $sql = "SELECT * FROM usuarios";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 //creating a blank array 
 $result = array();
 
 //looping through all the records fetched
 while($row = mysqli_fetch_array($r)){
 
 //Pushing name and id in the blank array created 
 array_push($result,array(
 "id"=>$row['id'],
 "name"=>$row['nombre']
 ));
 }
 
 //Displaying the array in json format 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($con);
 ?>