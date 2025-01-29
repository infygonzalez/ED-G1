
const credenciales = {
    usuario: "admin",
contraseña: "1234"
};
const usuarioInput = document.getElementById("usuario");
const contraseñaInput = document.getElementById("contraseña");
const loginButton = document.getElementById("botonLogin");
const mensaje = document.getElementById("mensaje");

loginButton.addEventListener("click", function() {
const usuario = usuarioInput.value;
const contraseña = contraseñaInput.value;

if (usuario === credenciales.usuario && contraseña === credenciales.contraseña) {
    localStorage.setItem("nombreUsuario", usuario);
    window.location.href = "principal.html";
} else {
mensaje.textContent= "Usuario o contraseña incorrectos ";
}
});

