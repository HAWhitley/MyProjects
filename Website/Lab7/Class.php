<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <center>
        <form action="<?=$_SERVER['PHP_SELF'] ?>" method="post">
            <h1>CSCI University Class Page</h1>
            <hr />
            Class Name:<input type='text' name='class'>
            <input type='submit' name='submit' value='Enroll'>
            <br/>
        </form>
    </center>
    <?php
        $servername="localhost";
        $username="root";
        $password="Evamore52!";
        $database="Registrations";
        $conn = new mysqli($servername, $username, $password, $database);

        if(!$conn) {
            die("Connection failed: ". $conn->connect_error);
        }

        if (isset($_POST['submit'])) {
            
            $sql="insert into Classes (Name)
                Values ('". $_POST["class"] . "')";

            if ($conn->query($sql)) {
                echo "<center>Record created successfully</center><br/>";
            }
            else {
                echo "<center>Error creating record: " . $conn->error . "</center><br/>";
            }

            echo "<center><table border='1'>
            <tr>
                <td>Class ID</td>
                <td>Class Name</td>
            </tr>";
            $sql1="select * from Classes";
            $result=$conn->query($sql1);
            if ($result->num_rows > 0) {
                while ($row=$result->fetch_assoc()) {
                    echo "<tr>
                    <td>" . $row["CID"] . "</td>
                    <td>" . $row["Name"] . "</td>
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
                <td>Class ID</td>
                <td>Name</td>
            </tr>";
            $sql1="select * from Classes";
            $result=$conn->query($sql1);
            if ($result->num_rows > 0) {
                while ($row=$result->fetch_assoc()) {
                    echo "<tr>
                    <td>" . $row["CID"] . "</td>
                    <td>" . $row["Name"] . "</td>
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