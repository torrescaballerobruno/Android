<?php
//Vamoa recibir  el usr y el passa
$usu=$_REQUEST['usu'];
$pas=$_REQUEST['pas'];
$cnx=new PDO("mysql:host=localhost;dbname=Panaderia","root",""); //Root es a usuario y vacío es a pass
//La query del select
$res=$cnx->query("select * from usuarios where usuario='$usu' and password='$pas'");
$datos=array();
//Lo que esta en res lo mandamos a una fila nueva
//Despues lo mandamos a datos
foreach ($res as $row) {
	$datos[]=$row;
}
echo json_encode($datos);
?>