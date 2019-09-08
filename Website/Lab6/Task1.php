<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <style type="text/css">
      p {
        color: red;
        background-color: gray;
      }
    </style>
  </head>
  <body>
    <form action="<?=$_SERVER["PHP_SELF"]?>" method="post">
      <?php
        if (isset($_POST["submit"])) {
          echo "<h1>Sales Tax Calculator</h1>";
          if (!is_numeric($_POST["amount"]) && !is_numeric($_POST["tax"]))
          {
            echo "<p>Amount must be a numeric value!<br/>Rate must be a numeric value!<br/>Cannot calculate!</p>";
            echo "<input type='submit' value='Return to Calculator' name='return'/>";
          }
          else if (!is_numeric($_POST["amount"])) 
          {
            echo "<p>Amount must be a numeric value!<br/>Cannot calculate!</p>";
            echo "<input type='submit' value='Return to Calculator' name='return'/>";
          }
          else if (!is_numeric($_POST["tax"])) 
          {
            echo "<p>Rate must be a numeric value!<br/>Cannot calculate!</p>";
            echo "<input type='submit' value='Return to Calculator' name='return'/>";
          }
          else
          {
            echo "Entered Amount: ";
            echo $_POST["amount"];
            echo "<br/>";
            echo "Entered Tax Rate: ";
            echo $_POST["tax"] . "%<br/>";
            $amount = $_POST["amount"];
            $tax = 1 + ($_POST["tax"] * .01);
            $final = $amount * $tax;
            echo "Calculated Tax Amount: $";
            echo $final;
            echo "<br/>";
            echo "<br/>";
            echo "<input type='submit' value='Return to Calculator' name='return'/>";
          } 
        }
        else if (isset($_POST["return"])){
          echo "<h1>Sales Tax Calculator</h1><br/>";
          echo "Amount: <input type='text' name='amount'/><br/>";
          echo "Tax rate: <input type='text' name='tax'/>%<br/>";
          echo "<input type='submit' value='Calculate' name='submit'/><br/>";
        }
        else {
          echo "<h1>Sales Tax Calculator</h1><br/>";
          echo "Amount: <input type='text' name='amount'/><br/>";
          echo "Tax rate: <input type='text' name='tax'/>%<br/>";
          echo "<input type='submit' value='Calculate' name='submit'/><br/>";
        }
      ?>
    </form>
  </body>
</html>
