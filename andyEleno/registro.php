<?php
  session_start();
  if(isset($_SESSION['nickname'])) {
    header('location: ./index.php');
    exit();
  }

  if ( !empty($_POST)) {

    $nickname = $_POST['nickname'];
    $nombre = $_POST['nombre'];
    $apellido_p = $_POST['apellido_p'];
    $apellido_m = $_POST['apellido_m'];
    $password = $_POST['password'];

    require 'db.php';
     
    $pdo = Database::connect();
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "INSERT INTO Becario (nickname,nombre,apellido_p,apellido_m,password) values(?,?,?,?,?)";
    $q = $pdo->prepare($sql);
    $q->execute(array($nickname,$nombre,$apellido_p,$apellido_m,$password));
    $sql = "INSERT INTO Asistencia (nickname,nombre,apellido,estado) values(?,?,?,?)";
    $q = $pdo->prepare($sql);
    $q->execute(array($nickname,$nombre,$apellido_p,'inactivo'));
    Database::disconnect();
    header('location: ./success.php');
    exit();
    }
?>