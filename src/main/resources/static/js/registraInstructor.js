function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    };
}
async function getActividadById(id){
    await fetch('api/getActividadById/'+id, {
        method: 'GET',
        headers: getHeaders(),
    }).then((actividad) => {return(actividad)})
        .catch(error => console.error(error));
}
async function registrarInstructor() {
    let id = document.getElementById('tipoActividad').value;
    let datos = {}
    let nombre = document.getElementById('nombreInstructor').value;

    console.log(datos.tipoActividad);
    await fetch('api/getActividadById/' + id, {
        method: 'GET',
        headers: getHeaders(),
    }).then((response) => response.json())
        .then((actividad) => {
        console.log(actividad)
        datos.nombreInstructor = nombre;
        datos.tipoActividad = actividad;
        fetchRegistro(datos);
    })
        .catch(error => console.error(error));
    location.reload();
}
async function fetchRegistro(datos){
    await fetch('api/registraInstructor', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    });
}
