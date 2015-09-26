<?php
	include'config.php';
	$response = array();
	$name = $_POST["name"];
	$result = mysql_query("DELETE FROM json_user WHERE name LIKE '$name'");

	if($result){
		$response["success"] = 1;
		echo json_encode($response);
	}else{
		$response["success"] = 0;
		echo json_encode($response);
	}
	
?>