<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$servername = "127.0.0.1:33060"; 
$username = "root"; 
$password = "elorrieta";
$dbname = "elorrietaviajes"; 

$conn = new mysqli($servername, $username, $password, $dbname);


session_start();
if (!isset($_SESSION["ID"])) {
    header("Location: login.php");
    exit();
}


if ($conn->connect_error) {
    die("Error en la conexión: " . $conn->connect_error);
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de viaje</title>
    <link rel="stylesheet" href="css/RegistrarViaje.css">
</head>

<body>
    <style>
        body {
            background: url(../imagenes/fondoRegistroViajejpg.jpg);
        }
        .form-container {
            background-color: white;
            padding: 80px;
            width: 400px;
            border-radius: 8px;
            display: grid;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-weight: bold;
            box-shadow: 5px 5px 40px 1px black;
        }
        .form-container h1 {
            text-align: center; 
            font-size: 19px;
        }
    </style>

    <form class="form-container" action="registrar_viaje.php" method="POST">
        <h1>REGISTRO DE VIAJE</h1>
        <div>
            <label for="nombre">Nombre</label>
            <input type="text" id="nombre" name="nombre" placeholder="Escriba aquí su nombre"> 
        </div>

        <div>
            <label for="tipo">Tipo de viaje:</label>
            <input list="TipoViaje" id="tipo" name="tipo" placeholder="-Elige-" required>
            <datalist id="TipoViaje">
                <option value="Novios"></option>
                <option value="Senior"></option>
                <option value="Grandes Viajes"></option>
                <option value="Combinado (hotel + vuelo)"></option>
                <option value="Escapadas"></option>
                <option value="Familias con menores"></option>
            </datalist>

            <label for="fechaIni" required>Fecha de inicio</label>
            <input type="date" id="fechaIni" name="Fec_Ini">

            <label for="fechaFinal" required>Fecha de fin</label>
            <input type="date" id="fechaFinal" name="Fec_Fin">

            <label for="dias">Días: </label>
            <input type="text" id="dias" name="Duracion_Via">    
        </div>

        <div>
            <label for="descripcion">Descripcion</label>
            <textarea required id="descripcion" name="descripcion" placeholder="Descripcion" maxlength="300"></textarea>
        </div>

        <div>
            <label for="servicios">Servicios que se quedan fuera: </label>
            <textarea required id="servicios" name="servicios" placeholder="Escribe un mensaje"></textarea>
        </div>

        <label for="paises">Pais:</label>
        <input list="listapaises" id="paises" name="paises" placeholder="-Elige-" required>
        <datalist id="listapaises">
            <option value="-Elige-"></option>
            <?php
                $query = "SELECT * FROM codigopaises"; 
                $result = $conn->query($query);
                if ($result->num_rows > 0) {
                    $options = [];
                    while ($row = $result->fetch_assoc()) {
                        $nombreAero = $row['pais']; 
                        $idAero = $row['codigo']; 
                        echo "<option value='$idAero'>$nombreAero</option>";
                    }
                } 
            ?>
        </datalist>

        <button type="submit" id="enviar">Enviar datos</button>
    </form>

    <script>
        // Obtener los elementos del DOM
        const fechaInicio = document.getElementById("fechaIni");
        const fechaFin = document.getElementById("fechaFinal");
        const inputDias = document.getElementById("dias");

        // Escuchar cambios en la fecha de inicio
        fechaInicio.addEventListener("change", () => {
            // Bloquear fechas anteriores a la fecha de inicio en el campo de fecha de fin
            fechaFin.min = fechaInicio.value;

            // borrar el campo de fecha de fin si su valor es anterior al mínimo permitido
            if (fechaFin.value && fechaFin.value < fechaInicio.value) {
                fechaFin.value = "";
            }

            // Calcular días si ambas fechas están seleccionadas
            calcularDias();
        });

        // Escuchar cambios en la fecha de fin
        fechaFin.addEventListener("change", calcularDias);

        // Función para calcular los días entre las fechas
        function calcularDias() {
            if (fechaInicio.value && fechaFin.value) {
                const inicio = new Date(fechaInicio.value);
                const fin = new Date(fechaFin.value);

                // Calcular la diferencia en milisegundos y convertirla a días
                const diferenciaTiempo = fin - inicio;
                const diferenciaDias = diferenciaTiempo / (1000 * 60 * 60 * 24);

                // Mostrar la diferencia en el campo de días
                inputDias.value = diferenciaDias;
            } else {
                inputDias.value = ""; // Vaciar el campo si falta una fecha
            }
        }
    </script>
</body>

</html>
