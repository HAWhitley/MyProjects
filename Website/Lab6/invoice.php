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
        echo "<h1>CSCI Store Invoice</h1>";
        if(isset($_GET["Checkout"]))
        {
            $desktop = 0;
            $laptop = 0;
            $cd = 0;
            $cp = 0;
            $a = $_GET["dell"];
            foreach ($a as $element)
            {
                switch($element)
                {
                    case "0":
                        $desktop=1234;
                        break;
                    case "1":
                        $laptop=2345;
                        break;
                    case "2":
                        $cd=246;
                        break;
                    case "3":
                        $cp=79;
                        break;
                }
            }
            echo "<table border='1' cellpadding='10px' style='border: 1px solid black; border-collapse: collapse'>
            <tr>
                <td>Item</td>
                <td>Price</td>
            </tr>";
            if($desktop != 0) {
                echo "<tr>
                <td>Desktop</td>
                <td>$1234</td>
                </tr>";
            }
            if($laptop != 0) {
                echo "<tr>
                <td>Laptop</td>
                <td>$2345</td>
                </tr>";
            }
            if($cd != 0) {
                echo "<tr>
                <td>10TB Disk Drive</td>
                <td>$246</td>
                </tr>";
            }
            if($cp != 0) {
                echo "<tr>
                <td>4GB Ram</td>
                <td>$79</td>
                </tr>";
            }
            $total = $desktop + $laptop + $cd + $cp;
            echo "<tr>
            <td colspan='2'>Total: $" . $total . "</td>
            </tr>
            </table>";
            echo "<br/>";
            echo "<a href='store.html'>Go Back</a>";
            echo "<br/>";
        }
    ?>
</body>
</html>