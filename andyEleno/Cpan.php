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
 //AQUÍ TERMINA LA CONEXIÓN

// if($_SERVER['REQUEST_METHOD']=='POST'){
 
 //Getting values
 $name = $_REQUEST['name'];
 $precio = $_REQUEST['precio'];
 $cantidad = $_REQUEST['cantidad'];
 
 //Creating an sql query
 $sql = "INSERT INTO producto (nombre,precio,cantidad) VALUES ('$name','$precio','$cantidad')";
 
 //Importing our db connection script
 require_once('cnx.php');

 //Executing query to database
 if(mysqli_query($con,$sql)){
 echo json_encode('Registro exitoso');
 }else{
 echo 'Lo siento no has podido ser registrado';
 }
 
 //Closing the database 
 mysqli_close($con);
 //}
 ?>