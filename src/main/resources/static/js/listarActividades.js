
window.onload = (event) => {
    console.log("Hola");
    cargarActividad()
};

async function getHeaders(){
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };
  const socios = await request.json();
}

async function cargarActividad(){
    const cargarActividad = fetch('api/getActividades',
        {
            mode: 'no-cors', // Establecer el modo como "cors"
            method: 'GET',
            headers: getHeaders()
        }).then(response => response.json())
        .then(respuesta => {
            console.log(respuesta);
            let listadoHtml = '';
            respuesta.map((actividad) => {
                botonEliminar = '<button onclick="eliminarSocio('+ actividad.id +')" class="btn FondoVerde btn-circle btn-sm">Eliminar</button>'
                console.log(actividad.id);
                let actividadHtml = '<tr><td id="id">'+ actividad.id +'</td><td>'+ actividad.nombre +'</td><td>'
                    + actividad.descripcion+
                    '</td> <td>'+botonEliminar+'</td></tr>';
                listadoHtml += actividadHtml;
            })
            document.querySelector('#actividades tbody').outerHTML = listadoHtml;
        })
        .catch(error => console.error(error));

}
