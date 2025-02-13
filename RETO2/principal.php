<?php
session_start();
if (!isset($_SESSION["Nombre"])) {
    header("Location: index.php"); 
    exit();
}

?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/principal.css">
</head>

<style>
    .MensajeBienvenida {
        text-align: center;
        font-family: 'Poppins', sans-serif, 'arial';
        background-color:rgb(82, 195, 247);
        padding: 40px;
        color: white;
    }
    .titulo {
        color: white;
    }
</style>


    <img class="avionCabecera" src="../imagenes/avionCabecera.jpg">
    <h1 class="titulo"> Elorrieta <br>Viajes</h1>
    <h1 class="MensajeBienvenida">Bienvenido, <?php echo htmlspecialchars($_SESSION["Nombre"]); ?>!</h1>

    
    <div class="menu">
        <li><a href="#contacto">CONTACTO</a></li>
        <li><a href="RegistrarViaje.php">REGISTRAR VIAJE</a></li>
        <li><a href="RegistrarServicios.php">REGISTRAR SERVICIO</a></li>
        <li id="LogOut"><a>CERRAR SESIÓN</a></li>
    </div>

    <section id="carrusel">
        <div class="carousel">
            <div class="galeria">
                <div class="imagen imagen-1"></div>
                <div class="imagen imagen-2"></div>
                <div class="imagen imagen-3"></div>
                <div class="imagen imagen-4"></div>
                <div class="imagen imagen-5"></div>
                <div class="imagen imagen-6"></div>
                <div class="imagen imagen-7"></div>
                <div class="imagen imagen-8"></div>
                <div class="imagen imagen-9"></div>
                <div class="imagen imagen-10"></div>
            </div>
        </div>
    </section>

</body>

<footer id="contacto">
    <form id="contacto">
        <h1>Contacto</h1>
        <input type="text" required id="nombre" placeholder="Nombre">
        <input type="text" required id="apellidos" placeholder="Tipo de viaje">
        <input type="email" required id="email" placeholder="Email">
        <input type="text" required id="telefono" placeholder="Nº Teléfono">
        <textarea required placeholder="Escríbenos un mensaje"></textarea>
        <button type="button" id="contactoBoton">Enviar</button>
    </form>
    <img id="licencias" src="../imagenes/creative-commons.png">
    <span>© 2025 ElorrietaViajes, Inc.</span>
</footer>

<script>
    document.getElementById("LogOut").addEventListener("click", function(event) {
        event.preventDefault();
        window.location.replace("index.php");
    });
</script>

</html>
