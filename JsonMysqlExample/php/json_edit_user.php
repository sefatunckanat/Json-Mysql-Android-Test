<?php
	include'config.php';
	$response = array();
	$old = $_GET['old'];
	$name = $_GET['name'];
	$phone = $_GET['phone'];
	$mail = $_GET['mail'];

	$result = mysql_query("UPDATE json_user SET name = '$name' , phone = '$phone' , mail = '$mail' WHERE id LIKE '$old'");

	if($result){
		$response["success"] = 1;
		echo json_encode($response);
	}else{
		$response["success"] = 0;
		echo json_encode($response);
	}
	
?>