
window.onload = (event) => {
    console.log("Hola");
    cargarInstructor();
};

async function getHeaders(){
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };
  const socios = await request.json();
}


async function cargarInstructor(){
    const cargarInstructor = fetch('api/getInstructores',
        {
            mode: 'no-cors', // Establecer el modo como "cors"
            method: 'GET',
            headers: getHeaders()
        }).then(response => response.json())
        .then(respuesta => {
            console.log(respuesta);
            let listadoHtml = '';
            respuesta.map((instructor) => {
                botonEliminar = '<button onclick="eliminarSocio('+ instructor.id +')" class="btn FondoRojo btn-circle btn-sm">Eliminar</button>'
                console.log(instructor.id);
                let instructorHtml = '<tr><td id="id">'+ instructor.id +'</td><td>'+ instructor.nombreInstructor +'</td><td>'
                    + instructor.tipoActividad.nombreActividad+
                    '</td> <td>'+botonEliminar+'</td></tr>';
                listadoHtml += instructorHtml;
            })
            document.querySelector('#instructores tbody').outerHTML = listadoHtml;
        })
        .catch(error => console.error(error));

}

