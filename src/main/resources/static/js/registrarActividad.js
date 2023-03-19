function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    };
}
async function registrarActividad(){
    let datos={}
    datos.nombreActividad = document.getElementById('nombreActividad').value;
    datos.descripcion = document.getElementById('descripcion').value;

    await fetch('api/registraActividad', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    }).catch(error => console.error(error));
    location.reload();
}