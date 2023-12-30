<?php
// Connect to the database (replace with your database credentials)
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Lifecare";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Handle login request
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST["username"];
    $password = $_POST["password"];

    // Validate username and password against the database
    $sql = "SELECT * FROM users WHERE username = '$username'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $hashedPassword = $row["password"];

        // Use password_verify for secure password checking
        if (password_verify($password, $hashedPassword)) {
            // Authentication successful
            $response = array("success" => true, "redirect" => "homepage.html");
            echo json_encode($response);
        } else {
            // Authentication failed
            $response = array("success" => false, "error" => "Invalid password");
            echo json_encode($response);
        }
    } else {
        // User not found
        $response = array("success" => false, "error" => "User not found");
        echo json_encode($response);
    }
}

// Close the database connection
$conn->close();
?>

