const URI_URL = 'http://localhost:8084/WServicios/api/login/usuario';

async function autenticarUsuario(event) {
    event.preventDefault(); // Evitar el comportamiento predeterminado del formulario

    // Obtener los valores de usuario y contraseña
    const usuario = document.getElementById('usuario').value.trim();
    const contrasenia = document.getElementById('contrasenia').value.trim();

    // Validar que ambos campos estén llenos
    if (!usuario || !contrasenia) {
        alert("Por favor, ingresa tanto el usuario como la contraseña.");
        return;
    }

    // Crear el cuerpo de la solicitud en formato application/x-www-form-urlencoded
    const datos = `usuario=${encodeURIComponent(usuario)}&contrasenia=${encodeURIComponent(contrasenia)}`;

    try {
        // Realizar la solicitud POST al servidor
        const respuesta = await fetch(URI_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: datos
        });

        if (respuesta.ok) {
            const resultado = await respuesta.json();

            // Si el servidor responde con éxito
            if (resultado.exito) {
                alert("Inicio de sesión exitoso: " + resultado.mensaje);
                window.location.href = './streaming.html'; // Redirigir al HTML de streaming
            } else {
                alert("Error: " + resultado.mensaje);
            }
        } else {
            throw new Error(`Error en la solicitud: ${respuesta.status}`);
        }
    } catch (error) {
        console.error('Error al autenticar el usuario:', error);
        alert('Hubo un error al conectar con el servidor.');
    }
}

// Asignar el evento submit al formulario
document.getElementById('loginForm').addEventListener('submit', autenticarUsuario);
