<?php
	include'config.php';
	$response = array();

	$result = mysql_query("SELECT * FROM json_user");

	if(mysql_num_rows($result)>0){
		$response["users"] = array();
		while($row = mysql_fetch_array($result)){
			$user = array();
			$user["id"] = $row["id"];
			$user["name"] = $row["name"];
			$user["phone"] = $row["phone"];
			$user["mail"] = $row["mail"];

			array_push($response["users"],$user);
		}
		$response["success"] = 1;
		echo json_encode($response);
	}else{
		$response["success"] = 0;
		$response["message"] = "Veri tabanına kayıtlı kişi bulunamadı.";

		echo json_encode($response);
	}
	
?>