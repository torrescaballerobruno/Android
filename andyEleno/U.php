<?php 
 //if($_SERVER['REQUEST_METHOD']=='POST'){
 //Getting values 
 $id = $_REQUEST['id'];
 $name = $_REQUEST['name'];
 $pas = $_REQUEST['pas'];
 $usu = $_REQUEST['usu'];
 
//Importing Database Script 
 define('HOST','mysql.hostinger.mx');
 define('USER','u775336626_bruni');
 define('PASS','proteco1234');
 define('DB','u775336626_pan');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 //AQUÍ TERMINA LA CONEXIÓN
 
 //Creating sql query 
 $sql = "UPDATE usuarios SET nombre = '$name', password = '$pas', usuario = '$usu' WHERE id = $id;";
 
 //Updating database table 
 if(mysqli_query($con,$sql)){
 echo 'Employee Updated Successfully';
 }else{
 echo 'Could Not Update Employee Try Again';
 }
 
 //closing connection 
 mysqli_close($con);
 //}
 ?>