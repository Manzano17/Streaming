const API_URL = 'http://localhost:5000/api/streaming'; // Cambiar según la URL de la API

// Función para consumir la API
async function fetchStreamingData() {
    try {
        const response = await fetch(API_URL, {
            method: 'GET', // Puedes cambiar a POST si es necesario
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }

        const data = await response.json();
        console.log('Datos recibidos:', data);

        // Aquí podrías actualizar la imagen y la descripción si la API lo provee
        document.getElementById('streamingImage').src = data.imageUrl || 'placeholder.jpg';
        document.getElementById('streamingDescription').value = data.description || '';
    } catch (error) {
        console.error('Error al consumir la API:', error);
    }
}

// Llama a la función para cargar datos al cargar la página
document.addEventListener('DOMContentLoaded', fetchStreamingData);
