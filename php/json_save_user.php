<?php
	include'config.php';
	$response = array();
	$name = $_POST['name'];
	$phone = $_POST['phone'];
	$mail = $_POST['mail'];

	$result = mysql_query("INSERT INTO json_user(name,phone,mail) VALUES('$name','$phone','$mail')");

	if($result){
		$response["success"] = 1;
		echo json_encode($response);
	}else{
		$response["success"] = 0;
		echo json_encode($response);
	}
	
?>