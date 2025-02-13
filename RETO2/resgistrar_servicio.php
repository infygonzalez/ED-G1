<?php
session_start();
$servername = "127.0.0.1:33060"; 
$username = "root"; 
$password = "elorrieta";
$dbname = "elorrietaviajes"; 

$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Si el formulario ha sido enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    if (!isset($_SESSION["ID"]) || empty($_SESSION["ID"])) {
        die("Error: No hay un ID de viaje en la sesión.");
    }

    $ID = $_SESSION["ID"];


    if (!empty($_POST['codigo_vuelo'])) { // Verificar si el formulario de vuelos fue enviado

    // Verificar si el ID de viaje existe en la base de datos
    $check_viaje = "SELECT COUNT(*) as count FROM Viajes WHERE ID_Viaje = '$ID'";
    $result = mysqli_query($conn, $check_viaje);
    $row = mysqli_fetch_assoc($result);



    // Recoger y sanitizar los datos del formulario
    $codigo_vuelo = mysqli_real_escape_string($conn, $_POST['codigo_vuelo']);
    $viajes = mysqli_real_escape_string($conn, $_POST['viajes']);
    $aeropuerto_procedencia = mysqli_real_escape_string($conn, $_POST['aeropuerto_procedencia']);
    $aeropuerto_destino = mysqli_real_escape_string($conn, $_POST['aeropuerto_destino']);
        $precio_vuelo = mysqli_real_escape_string($conn, $_POST['precio_vuelo']);
        $aerolinea = mysqli_real_escape_string($conn, $_POST['aerolinea']);
        $fecha_salida_vuelo = mysqli_real_escape_string($conn, $_POST['fecha_salida_vuelo']);
        $hora_salida_vuelo = mysqli_real_escape_string($conn, $_POST['hora_salida_vuelo']);
        $duracion_viaje = mysqli_real_escape_string($conn, $_POST['duracion_viaje']);
        $ID_Viaje = mysqli_real_escape_string($conn, $_POST['ID_Viaje']);

    $ida_vuelta = isset($_POST['IdaVuelta']) ? mysqli_real_escape_string($conn, $_POST['IdaVuelta']) : NULL;

    // Comprobar si el viaje es SOLO IDA o IDA/VUELTA
    if ($ida_vuelta == "ida") {
        // Solo inserta los datos de IDA
        $sql_viaje = "INSERT INTO Vuelos (CodigoVuelo, Nombre, Origen, Destino, Precio, Aerolinea, Fec_Sal, Hora_Sal, Duracion, IdaVuelta, ID_Viaje) 
                      VALUES ('$codigo_vuelo', '$viajes', '$aeropuerto_procedencia', '$aeropuerto_destino', '$precio_vuelo', '$aerolinea', '$fecha_salida_vuelo', '$hora_salida_vuelo', '$duracion_viaje', '$ida_vuelta', '$ID_Viaje')";
    } else {
        // Si es ida/vuelta, recoge también los datos de la vuelta
        $fecha_de_vuelta = !empty($_POST['fecha_de_vuelta']) ? "'" . mysqli_real_escape_string($conn, $_POST['fecha_de_vuelta']) . "'" : "NULL";
        $viaje_duracion_vuelta = !empty($_POST['viaje_duracion_vuelta']) ? "'" . mysqli_real_escape_string($conn, $_POST['viaje_duracion_vuelta']) . "'" : "NULL";

        // Inserta los datos de ida/vuelta
        $sql_viaje = "INSERT INTO Vuelos (CodigoVuelo, Nombre, Origen, Destino, Precio, Aerolinea, Fec_Sal, Hora_Sal, Duracion, IdaVuelta, Fec_Vuelta, Dur_Vuelta, ID_Viaje) 
                      VALUES ('$codigo_vuelo', '$viajes', '$aeropuerto_procedencia', '$aeropuerto_destino', '$precio_vuelo', '$aerolinea', '$fecha_salida_vuelo', '$hora_salida_vuelo', '$duracion_viaje', '$ida_vuelta', $fecha_de_vuelta, $viaje_duracion_vuelta, '$ID_Viaje')";
    }

        
    if (mysqli_query($conn, $sql_alojamiento)) {
        echo "Servicio registrado correctamente. Redirigiendo en 3 segundos...";
        header("refresh:3; url=principal.php"); // Espera 3 segundos antes de redirigir
        exit();
    }
}

if (!empty($_POST['nombre_hotel'])) { // Verificar si el formulario de vuelos fue enviado


        $nombre_hotel = mysqli_real_escape_string($conn, $_POST['nombre_hotel']);
        $ciudad_hotel = mysqli_real_escape_string($conn, $_POST['ciudad_hotel']);
        $precio_hotel = mysqli_real_escape_string($conn, $_POST['precio_hotel']);
        $dia_entrada = mysqli_real_escape_string($conn, $_POST['dia_entrada']);
        $dia_salida = mysqli_real_escape_string($conn, $_POST['dia_salida']);
        $tipo_habitacion = mysqli_real_escape_string($conn, $_POST['tipo_habitacion']);
        $ID_Viaje = mysqli_real_escape_string($conn, $_POST['ID_Viaje']);

        $sql_alojamiento = "INSERT INTO alojamiento (Nom_Hotel, Ciudad, Precio, Fec_Ent, Fec_Sal, Tip_Hab, ID_Viaje) 
                          VALUES ('$nombre_hotel', '$ciudad_hotel', '$precio_hotel', '$dia_entrada', '$dia_salida', '$tipo_habitacion', '$ID_Viaje')";


        if (mysqli_query($conn, $sql_alojamiento)) {
            echo "Servicio registrado correctamente. Redirigiendo en 3 segundos...";
            header("refresh:3; url=principal.php"); // Espera 3 segundos antes de redirigir
            exit();
}
    }
}


if (!empty($_POST['nombre_otros'])) { // Verificar si el formulario de vuelos fue enviado

        $nombre_otros = mysqli_real_escape_string($conn, $_POST['nombre_otros']);
        $fecha_salida_otros = mysqli_real_escape_string($conn, $_POST['fecha_salida_otros']);
        $otros_info = mysqli_real_escape_string($conn, $_POST['otros_info']);
        $precio_otros = mysqli_real_escape_string($conn, $_POST['precio_otros']);
        $ID_Viaje = mysqli_real_escape_string($conn, $_POST['ID_Viaje']);

        $sql_alojamiento = "INSERT INTO Otros (Nombre, Fecha, Descripcion, Precio, ID_Viaje) 
                          VALUES ('$nombre_otros', '$fecha_salida_otros', '$otros_info', '$precio_otros', '$ID_Viaje')";

        if (mysqli_query($conn, $sql_alojamiento)) {
            echo "Servicio registrado correctamente. Redirigiendo en 3 segundos...";
            header("refresh:3; url=principal.php"); // Espera 3 segundos antes de redirigir
            exit();
        }
    
}
?>
