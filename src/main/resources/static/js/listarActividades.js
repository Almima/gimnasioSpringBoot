
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
                console.log(actividad.id)
                botonEliminar = '<button onclick="eliminarActividad('+ actividad.id +')" class="btn FondoVerde btn-circle btn-sm">Eliminar</button>'
                console.log(actividad.nombreActividad);
                let actividadHtml = '<tr><td id="id">'+ actividad.id +'</td><td>'+ actividad.nombreActividad +'</td><td>'
                    + actividad.descripcion+
                    '</td> <td>'+botonEliminar+'</td></tr>';
                listadoHtml += actividadHtml;
            })
            document.querySelector('#actividades tbody').outerHTML = listadoHtml;
        })
        .catch(error => console.error(error));

}
async function eliminarActividad(id){
    console.log(id)
    if(!confirm("Desea eliminar este socio?")){
        return;
    }
    const request = await fetch(`http://localhost:8080/api/eliminaActividadById/${id}`, {
        method: 'DELETE',
        headers: getHeaders(),

    });
    location.reload();
}
