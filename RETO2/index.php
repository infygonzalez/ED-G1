
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Viajes Elorrieta-errekamari</title>
        <link rel="stylesheet" href="../css/style.css"> 
    </head>
    <body>
        
            <article class="login">
                <h1>Inicio de sesión</h1>
                <label for="usuario"> Agencia: </label>
                <input type="text" id="usuario" placeholder="Introduce el nombre de la agencia">
                <br>
                <label for="contraseña"> Contraseña: </label>
                <input type="password" id="contraseña" placeholder="Introduce la contraseña">
                
                <button type="button" id="botonLogin">Acceder</button>
                <p id="mensaje"></p>   
            </article>
            
        </body>
        <script> 
document.getElementById("botonLogin").addEventListener("click", function() {
    const usuario = document.getElementById("usuario").value;
    const contraseña = document.getElementById("contraseña").value;
    const mensaje = document.getElementById("mensaje");

    fetch("conexion.php", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `usuario=${encodeURIComponent(usuario)}&contraseña=${encodeURIComponent(contraseña)}`,
        credentials: "include"  // mantiene la sesion iniciada
    })
    .then(response => response.text())
    .then(data => {
        if (data.includes("✅ Login exitoso")) {
            window.location.href = "principal.php";
        } else {
            mensaje.textContent = "Usuario o contraseña incorrectos";
        }
    })
    .catch(error => {
        console.error("Error en la solicitud:", error);
        mensaje.textContent = "Error al conectar con el servidor";
    });
});


            </script> 

    </html>