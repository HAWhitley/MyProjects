<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <?php
        $servername="localhost";
        $username="root";
        $password="Evamore52!";
        $database="Registrations";
        $conn = new mysqli($servername, $username, $password, $database);

        if(!$conn) {
            die("Connection failed: ". $conn->connect_error);
        }
    ?>
    <center>
        <form action="<?=$_SERVER['PHP_SELF'] ?>" method="post">
            <h1>CSCI University Registration Page</h1>
            <hr />
            Student Name:<input type='text' name='name'> <br/>
            Please pick at most three classes: <br/> 
            <?php
                $rowNum=0;
                $sql2="select * from Classes";
                $myResult=$conn->query($sql2);
                if($myResult->num_rows>0) {
                    while($newrow=$myResult->fetch_assoc()) {
            ?>
                <input type="checkbox" name="class[]" value=<?php echo "'" . $newRow["Name"] . "'";?>/>
                <?php echo $newrow["Name"];?>
                <br/>
            <?php
                        $rowNum++;
                    }
                }
            ?>
            <input type='submit' name='submit' value='Register!'>
            <hr/>
        </form>
    </center>
    <?php

        if (isset($_POST['submit'])) {
            $myArray= array();
            $classNum = $_POST['class'];
            foreach ($classNum as $newClass) {
                array_push($myArray, $newClass);
            }
            
            $check = "Select * from Schedule where SNAME='" . $_POST["name"] . "'";
            /*if (mysql_num_rows($check) > 0) {
                    $update = "UPDATE Schedule SET Class1='" 
                    . $classNum[0] .
                    "', Class2='" . $classNum[1] . 
                    "', Class3='" . $classNum[2] . "' where SNAME='" . $_POST["name"] . "'";
            }
            else {*/
                $sql="insert into Schedule (SNAME, Class1, Class2, Class3)
                Values ('". $_POST["name"] . "','" . $myArray[0] . "','" . $myArray[1] . "','"
                 . $myArray[2] . "')";

            //}
            
            if ($conn->query($sql)) {
                echo "<center>Record created successfully</center><br/>";
            }
            else {
                echo "<center>Error creating record: " . $conn->error . "</center><br/>";
            }

            echo "<center><table border='1'>
            <tr>
                <td>Enrollment ID</td>
                <td>Student Name</td>
                <td>Class Name</td>
                <td>Class Name</td>
                <td>Class Name</td>
            </tr>";
            $sql1="select * from Schedule";
            $result=$conn->query($sql1);
            if ($result->num_rows > 0) {
                while ($row=$result->fetch_assoc()) {
                    echo "<tr>
                    <td>" . $row["EID"] . "</td>
                    <td>" . $row["SNAME"] . "</td>
                    <td>" . $row["Class1"] . "</td>
                    <td>" . $row["Class2"] . "</td>
                    <td>" . $row["Class3"] . "</td>
                    </tr>";
                }
            }

            echo "
            </table></center><br/>
            ";

        }
        else {
            echo "<center><table border='1'>
            <tr>
                <td>Enrollment ID</td>
                <td>Student Name</td>
                <td>Class Name</td>
                <td>Class Name</td>
                <td>Class Name</td>
            </tr>";
            $sql1="select * from Schedule";
            $result=$conn->query($sql1);
            if ($result->num_rows > 0) {
                while ($row=$result->fetch_assoc()) {
                    echo "<tr>
                    <td>" . $row["EID"] . "</td>
                    <td>" . $row["SNAME"] . "</td>
                    <td>" . $row["Class1"] . "</td>
                    <td>" . $row["Class2"] . "</td>
                    <td>" . $row["Class3"] . "</td>
                    </tr>";
                }
            }
            echo "
            </table></center><br/>
            ";
        }
        echo "<a href='/Lab7/Front.html'>Back</a>";
        $conn->close();
    ?>
</body>
</html>