<?php
session_start();
$servername = "127.0.0.1:33060";
$username = "root"; 
$password = "elorrieta"; 
$dbname = "elorrietaviajes"; 

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de servicios</title>

    <link rel="stylesheet" href="css/registrarServicios.css">
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
        .form-container button {
            
        }

    </style>
    
    <form class="form-container" action="resgistrar_servicio.php" method="POST" id="formulario">
        <div class="logo">
        </div>
        <label for="viajes">Tipo de viaje:</label>
        <select id="viajes" name="viajes" >
            <option value="">--Elige--</option>
            <option value="Novios">Novios</option>
            <option value="Senior">Senior</option>
            <option value="Grandes viajes (destinos exoticos)">Grandes viajes (destinos exoticos)</option>
            <option value="Combinado (vuelo+hotel)">Combinado (vuelo+hotel)</option>
            <option value="Escapadas">Escapadas</option>
            <option value="Familias con niños menores">Familias con niños menores</option>
        </select>




        <label for="ID_Viaje">ID de viaje</label>
            <select id="ID_Viaje" name="ID_Viaje" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                // Conexión a la base de datos
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT ID_Viaje FROM viajes ORDER BY ID_Viaje ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['ID_Viaje'] . '">' . $row['ID_Viaje'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>
               
                
            </select>



        <p>¿Que servicio quieres registrar?</p>
        <div class="elegir-servicio">
            <input type="radio" name="ocultar" id ="vuelo" value="vuelo" onclick="mostrarFormulario('vuelo')">
            <label><b>Vuelo</b></label>
            <input type="radio" name="ocultar" id="hotel" value="hotel" onclick="mostrarFormulario('hotel')">
            <label><b>  Alojamiento</b></label>
            <input type="radio" name="ocultar" id="otros" value="otros" onclick="mostrarFormulario('otros')">
            <label><b>Otros</b></label>
        </div>

        <!-- Sección Vuelo -->
        <div id="vuelo-section" class="ocultar">
            <p>¿Que tipo de vuelo es?</p>
            <div class="IdaVuelta">
                <input type="radio" name="IdaVuelta" id="ida" value="ida" onclick="mostrarFormularioVuelo('ida')">
                <label><b>Ida</b></label>
                <input type="radio" name="IdaVuelta" id="ida-vuelta" value="ida-vuelta" onclick="mostrarFormularioVuelo('ida-vuelta')">
                <label><b>Ida / Vuelta</b></label>
            </div>

            <label for="aeropuerto_procedencia">Aeropuerto de Origen:</label>
            <select id="aeropuerto_procedencia" name="aeropuerto_procedencia" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                // Conexión a la base de datos
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT Codigo, Nombre FROM codigoiatas ORDER BY Codigo ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['Codigo'] . '">' . $row['Codigo'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>

            

                

            </select>


            <label for="aeropuerto_destino">Aeropuerto de Destino</label>
            <select id="aeropuerto_destino" name="aeropuerto_destino" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                // Conexión a la base de datos
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT Codigo, Nombre FROM codigoiatas ORDER BY Codigo ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['Codigo'] . '">' . $row['Codigo'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>
               
                
            </select>

            <label for="codigo_vuelo">Código del Vuelo:</label>
            <input type="text" id="codigo_vuelo" name="codigo_vuelo">

            <label for="aerolinea">Aerolínea:</label>
            <select id="aerolinea" name="aerolinea" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                // Conexión a la base de datos
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT Nombre FROM codigocompañiasaereas ORDER BY Nombre ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['Nombre'] . '">' . $row['Nombre'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>

                
            </select>

            <label for="precio_vuelo">Precio (€):</label>
            <input type="number" id="precio_vuelo" name="precio_vuelo" >

            <label for="fecha_salida_vuelo">Fecha de salida:</label>
            <input type="date" id="fecha_salida_vuelo" name="fecha_salida_vuelo">

            <label for="hora_salida_vuelo">Hora de salida</label>
            <input type="time" id="hora_salida_vuelo" name="hora_salida_vuelo">

            <label for="duracion_viaje" id="">Duración del viaje (en horas):</label>
            <input type="number" id="duracion_viaje" name="duracion_viaje">

            <!-- Sección Ida y Vuelta -->
            <div id="vuelta-section" class="ocultar">
                <p>Vuelo (vuelta)</p>
                <label for="fecha_de_vuelta">Fecha de Vuelta:</label>
                <input type="date" id="fecha_de_vuelta" name="fecha_de_vuelta">

                <label for="hora_de_vuelta">Hora de Vuelta:</label>
                <input type="time" id="hora_de_vuelta" name="hora_de_vuelta">

                <label for="viaje_duracion_vuelta">Duración del Vuelo de Vuelta (en horas):</label>
                <input type="number" id="viaje_duracion_vuelta" name="viaje_duracion_vuelta">

                <label for="vuelo_codigo_vuelta">Código del Vuelo de Vuelta:</label>
                <input type="text" id="vuelo_codigo_vuelta" name="vuelo_codigo_vuelta">

                <label for="aerolinea_vuelta">Aerolínea de Vuelta:</label>
                <select id="aerolinea_vuelta" name="aerolinea_vuelta" >
                    <option value="" disabled selected>--Elige--</option>
                    <?php
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT Nombre FROM codigocompañiasaereas ORDER BY Nombre ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['Nombre'] . '">' . $row['Nombre'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>

                </select>
            </div>
        </div>


        <!-- Sección hotel -->
        <div id="hotel-section" class="ocultar">


        <label for="ID_Viaje">ID de viaje</label>
            <select id="ID_Viaje" name="ID_Viaje" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT ID_Viaje FROM viajes ORDER BY ID_Viaje ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['ID_Viaje'] . '">' . $row['ID_Viaje'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>
               
                
            </select>




                
        <label for="ID_Viaje">ID de viaje</label>
            <select id="ID_Viaje" name="ID_Viaje" >
                <option value="" disabled selected>--Elige--</option>
                <?php
                error_reporting(E_ALL);
                ini_set('display_errors', 1);
               
                $servername = "127.0.0.1:33060";
                $username = "root";
                $password = "elorrieta";
                $dbname = "elorrietaviajes";


                $conn = new mysqli($servername, $username, $password, $dbname);
               
                if ($conn->connect_error) {
                    die("Conexión fallida: " . $conn->connect_error);
                }
               
                // Consultar la tabla de aerolinea
                $sql = "SELECT ID_Viaje FROM viajes ORDER BY ID_Viaje ASC";
                $result = $conn->query($sql);


                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        // Mostrar las aerolineas en el select
                        echo '<option value="' . $row['ID_Viaje'] . '">' . $row['ID_Viaje'] . '</option>';
                    }
                } else {
                    echo '<option value="">No se encontraron Viajes</option>';
                }


                $conn->close();
            ?>
               
                
            </select>


            <label for="nombre_hotel">Nombre hotel:</label>
            <input type="text" id="nombre_hotel" name="nombre_hotel" >

        
            <label for="ciudad_hotel">Ciudad:</label>
            <input type="text" id="ciudad_hotel" name="ciudad_hotel" >

            <label for="precio_hotel">Precio (€):</label>
            <input type="number" id="precio_hotel" name="precio_hotel" >

            <label for="dia_entrada">Día de entrada:</label>
            <input type="date" id="dia_entrada" name="dia_entrada" >

            <label for="dia_salida">Día de salida:</label>
            <input type="date" id="dia_salida" name="dia_salida">

            <label for="tipo_habitacion">Tipo de habitación:</label>
            <input list="tipos" id="tipo_habitacion" name="tipo_habitacion" placeholder="--Elige--" >
            <datalist id="tipos">
                <option value="Doble"></option>
                <option value="Doble uso individual"></option>
                <option value="Individual"></option>
                <option value="Triple"></option>
            </datalist>

        </div>

        <!-- Sección Otros servicios -->
        <div id="otros-section" class="ocultar">

            <label for="nombre_otros">Nombre:</label>
            <input type="text" id="nombre_otros" name="nombre_otros">

            <label for="fecha_salida_otros">Fecha:</label>
            <input type="date" id="fecha_salida_otros" name="fecha_salida_otros">

            <label for="otros_info">Descripción:</label>
            <textarea id="otros_info" name="otros_info"></textarea>

            <label for="precio_otros">Precio (€):</label>
            <input type="number" id="precio_otros" name="precio_otros" >
        </div>

        <button type="submit" id="guardar">Guardar Servicios</button>
    </form>

    <script>
        // Función para mostrar y ocultar secciones principales
        function mostrarFormulario(seccion) {
            // Ocultar todas las secciones
            const secciones = ['vuelo-section', 'hotel-section', 'otros-section'];
            secciones.forEach(id => {
                document.getElementById(id).classList.add('ocultar');
            });
    
            // Mostrar la sección seleccionada
            const seleccion = document.getElementById(`${seccion}-section`);
            if (seleccion) {
                seleccion.classList.remove('ocultar');
            }
        }
    
        // Función para mostrar campos adicionales dentro de la sección de vuelos
        function mostrarFormularioVuelo(tipo) {
            // Ocultar sección de vuelo de vuelta
            const vueltaSection = document.getElementById('vuelta-section');
            if (tipo === 'ida-vuelta') {
                vueltaSection.classList.remove('ocultar');
            } else {
                vueltaSection.classList.add('ocultar');
            }
        }



            // Función para mostrar y ocultar secciones principales
    function mostrarFormulario(seccion) {
        // Ocultar todas las secciones
        const secciones = ['vuelo-section', 'hotel-section', 'otros-section'];
        secciones.forEach(id => {
            document.getElementById(id).classList.add('ocultar');
        });

        // Mostrar la sección seleccionada
        const seleccion = document.getElementById(`${seccion}-section`);
        if (seleccion) {
            seleccion.classList.remove('ocultar');
        }
    }

    // Función para mostrar campos adicionales dentro de la sección de vuelos
    function mostrarFormularioVuelo(tipo) {
        // Ocultar sección de vuelo de vuelta
        const vueltaSection = document.getElementById('vuelta-section');
        if (tipo === 'ida-vuelta') {
            vueltaSection.classList.remove('ocultar');
        } else {
            vueltaSection.classList.add('ocultar');
        }
    }

    // Mostrar campos ocultos antes de enviar el formulario
    document.querySelector("#formulario").addEventListener("submit", function(e) {
        document.querySelectorAll(".ocultar").forEach(function(campo) {
            campo.style.display = "block"; // Mostrar campos antes del envío
        });
    });


    // Obtener los elementos del DOM
    const fechaInicio = document.getElementById("fecha_salida_vuelo");
    const fechaFin = document.getElementById("fecha_de_vuelta");
    
    // Escuchar cambios en la fecha de inicio
    fechaInicio.addEventListener("change", () => {
        // Bloquear fechas anteriores a la fecha de inicio en el campo de fecha de fin
        fechaFin.min = fechaInicio.value;
    
        // Limpiar el campo de fecha de fin si su valor es anterior al mínimo permitido
        if (fechaFin.value && fechaFin.value < fechaInicio.value) {
            fechaFin.value = "";
        }
    
        // Calcular días si ambas fechas están seleccionadas
        calcularDias();
    });



    </script>    









</body>

</html>









