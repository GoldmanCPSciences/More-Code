<html>
	<head>
		<title> Phone Book </title>
		<link rel='stylesheet' type='text/css' href='AssignmentStyle.css'>
			<script language ='JavaScript'>
				function checkForm()
				{
					var phone = document.getElementById('phone');
					var phonePattern=/\d\d\d-\d\d\d-\d\d\d\d/;
					if (phone.value.match(phonePattern) == null)
					{
						alert("please enter correct phone format);
						return false;
					}
					else
					{
						return true;
					}
				}
			</script>
	</head>
	<body>
		<h1> Phone Book </h1>
		<noscript>
			<font size='32'> please enable javascript so this program can work properly </font>
		</noscript>
		<form name='PB' action='PhoneBook.php' method='POST' onSubmit='return checkForm()'>
		<input type='radio' name='ACTION' value='ADD' checked> ADD &nbsp;&nbsp;
		<input type='radio' name='ACTION' value='LOOKUP'> Lookup &nbsp;&nbsp;
		<input type='radio' name='ACTION' value='UPDATE'> Update &nbsp;&nbsp;
		<input type='radio' name='ACTION' value='DELETE'> Delete &nbsp;&nbsp;
		<br/> <br/>
		<?php
				if(empty($_POST['phone']))
				{
					$phone='999-999-9999';
					$address='timbuktoo';
				}
				else
				{
					$action=$_POST['ACTION'];
					$phone=$_POST['phone'];
					$firstname=$_POST['firstName'];
					$middleinitial=$_POST['middleInitial'];
					$lastname=$_POST['lastName'];
					$address=$_POST['address'];
					$city=$_POST['city'];
					$state=$_POST['state'];
					$zipcode=$_POST['zipcode'];
				}
				
				$conn = mysql_connect('localhost', 'andrewg', 'andrewg');
				mysql_select_db("andrewgDB",$conn);
				
				if ($action == 'ADD')
				{
					echo "Insert<br/>\n";	
					$SQL="INSERT INTO Phonebook VALUES ('$phone', '$firstname', '$middleinitial',
					'$lastname', '$address', '$city', '$state', '$zipcode')";
					$result1 = mysql_query($SQL, $conn) or die(mysql_error());
				}
				
				if ($action == 'LOOKUP')
				{
					$SQL="SELECT phoneNumber, firstname, middleinitial, lastname, address, city, state, " .
						 "zipcode FROM Phonebook WHERE phonenumber='$phone'";
					$result = mysql_query($SQL, $conn) or die(mysql_error());
					
					while ($array1=mysql_fetch_array($result1))
					{
						$phone=$array1['phoneNumber'];
						$firstname=$array1['firstName'];
						$middleinitial=$array1['middleInitial'];
						$lastname=$array1['lastName'];
						$address=$array1['address'];
						$city=$array1['city'];
						$state=$array1['state'];
						$zipcode=$array1['zipCode'];
					}
				}
				
				if ($action == 'UPDATE')
				{
					$SQL="update Phonebook set firstName='$firstname' " .
						 "set middleInitial='$middleinitial' " .
						 "set lastName='$lastname' " .
						 "set address='$address' ".
						 "set city='$city' " .
						 "set state='$state' " .
						 "set zipCode='$zipcode' " .
						 "where phoneNumber='$phone'";
					$result1 = mysql_query($SQL, $conn) or die(mysql_error());
					
					echo "<br/> UPDATE <br/>\n";
				}
				
				if ($action == 'DELETE')
				{
					$SQL="delete from Phonebook where phoneNumber='$phone'";
					$result1 = mysql_query($SQL, $conn) or die(mysql_error());
					echo "<br/> DELETE <br/>\n";
				}
				
				echo ": $SQL \n";
				echo "<br/> \n";
				mysql_close($conn);
			
				echo "Phone Number: <input type='text' name='phone' id='phone' " .
					 "value='$phone' size='12' maxlength='12'>\n";
				echo "<br/><br/> \n";
				echo "First Name: <input type='text' name='firstname' id='firstname' " .
					 "value='$firstname' size='12' maxlength='12'>";
				echo "&nbsp; &nbsp;";
				echo "Middle Initial: <input type='text' name='middleinitial' id='middleinitial' " .
					 "value='$middleinitial' size='2' maxlength='2'>";
				echo "&nbsp; &nbsp;";
				echo "Last Name : <input type='text' name='lastname' id='lastname' " .
					 "value='$lastname' size='30' maxlength='30'> \n";
				echo "<br/> <br/> \n";
				echo "Address : <input type='text' name='address' id='address' " .
					 "value='$address' size='30' maxlength='30'> \n";
			    echo "<br/> <br/> \n";
				echo "City : <input type='text' name='city' id='city' " .
					 "value='$city' size='30' maxlength='30'>";
				echo "&nbsp; &nbsp;";
				echo "State : <input type='text' name='state' id='state' " .
					 "value='$state' size='2' maxlength='2'>";
				echo "&nbsp; &nbsp;";
				echo "Zip Code : <input type='text' name='zipcode' id='zipcode' " .
					 "value='$zipcode' size='6' maxlength='6'> \n";
				echo "<br/> <br/> \n";
		?>
		<input type='submit' value='Save'>
		<br/><br/>
		<input type='reset' value='Clear Fields'>
		</form>	 
	</body>
</html>