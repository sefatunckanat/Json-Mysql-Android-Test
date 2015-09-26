<?php 
	$DB_USER 		= "945704";
	$DB_PASSWORD	= "password";
	$DB_DATABASE 	= "945704";
	$DB_SERVER 		= "localhost";
	$con 	= 	mysql_connect($DB_SERVER,$DB_USER,$DB_PASSWORD) or die(mysql_error());
	$db 	=	mysql_select_db($DB_DATABASE);
	mysql_query("SET NAMES UTF8");
?>