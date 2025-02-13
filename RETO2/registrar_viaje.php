<?php
// Conexión a la base de datos (ajusta según tus datos de acceso)
$servername = "127.0.0.1:33060"; 
$username = "root"; 
$password = "elorrieta";
$dbname = "elorrietaviajes"; 

$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}




// Si el formulario ha sido enviado
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Recoger los datos del formulario
    $nombre = $_POST['nombre'];
    $tipo = $_POST['tipo'];  // Asumimos que 'tipo' corresponde a Tipo_Viaje
    $fechaIni = $_POST['Fec_Ini'];
    $fechaFin = $_POST['Fec_Fin'];
    $dias = $_POST['Duracion_Via'];
    $pais = $_POST['paises']; // El valor de 'paises' debe coincidir con la columna Pais
    $descripcion = $_POST['descripcion'];
    $servicios = $_POST['servicios'];  // Si corresponde a 'Ser_no_inc'
    session_start();
    $ID = $_SESSION["ID"];  // Recoger el ID de la agencia seleccionada

    // Registrar el viaje en la base de datos
    $sql_viaje = "INSERT INTO Viajes (Nom_Via, Descripcion, Tipo_Viaje, Fec_Ini, Fec_Fin, Duracion_Via, Pais, Ser_no_inc, ID)
                  VALUES ('$nombre', '$descripcion', '$tipo', '$fechaIni', '$fechaFin', '$dias', '$pais', '$servicios', '$ID')";

    if (mysqli_query($conn, $sql_viaje)) {
        $last_id = mysqli_insert_id($conn); // Obtener el último ID insertado (el ID del nuevo viaje)

        // Ahora que tenemos el ID del viaje, podemos registrar los servicios
        if (!empty($_POST['viajeSeleccionado']) && !empty($_POST['tipoServicio']) && !empty($_POST['descripcionServicio'])) {
            $viajeSeleccionado = $_POST['viajeSeleccionado'];
            $tipoServicio = $_POST['tipoServicio'];
            $descripcionServicio = $_POST['descripcionServicio'];

            // Registrar el servicio en la base de datos
            $sql_servicio = "INSERT INTO Servicios (ID_Viaje, Tipo_Servicio, Descripcion)
                             VALUES ('$viajeSeleccionado', '$tipoServicio', '$descripcionServicio')";

            if (mysqli_query($conn, $sql_servicio)) {
                echo "Servicio registrado correctamente.";
            } else {
                echo "Error al registrar el servicio: " . mysqli_error($conn);
            }
        }
        
        echo "Viaje registrado correctamente para la persona con ID Agencia: $ID.";
    } else {
        echo "Error al registrar el viaje: " . mysqli_error($conn);
    }

    // Redirigir al menú principal (ajusta la URL del menú según sea necesario)
    header("Location: principal.php");
    exit();
}

mysqli_close($conn);
?>
