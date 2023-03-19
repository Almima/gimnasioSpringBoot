function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token //copiado del argentino

    };
}
async function registrarSocio(){

    let datos={}
    datos.nombre = document.getElementById('nombre').value;
    datos.email = document.getElementById('email').value;
    datos.apellidos = document.getElementById('apellidos').value;
    datos.telefono = document.getElementById('telefono').value;
    datos.clave = document.getElementById('clave').value;

    await fetch('api/registraSocio', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    }).catch(error => console.error(error));
    location.reload();
}
async function registrarunSocio(){
    let datos={}
    datos.nombre = "Alvarito";
    datos.email = "alvarito845@minabo.com";
    datos.apellidos = "845";
    datos.telefono = "6464646464";
    datos.clave = "loscuernosdetumadre";

    await fetch('api/registraSocio', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(datos)
    }).catch(error => console.error(error));
}