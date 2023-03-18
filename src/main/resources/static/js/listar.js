
window.onload = (event) => {
    console.log("Hola");
    cargarSocio();
};

async function getHeaders(){
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };
  const socios = await request.json();
}

async function cargarSocio(){
    const cargarSocio = fetch('api/getUsuarios',
        {
            mode: 'no-cors', // Establecer el modo como "cors"
            method: 'GET',
            headers: getHeaders()
        }).then(response => response.json())
        .then(respuesta => {
            console.log(respuesta);
            let listadoHtml = '';
            respuesta.map((socio) => {
                botonEliminar = '<button onclick="eliminarSocio('+ socio.id +')" class="btn btn-danger btn-circle btn-sm">Eliminar</button>'
                console.log(socio.id);
                let telefonoTexto = socio.telefono == null ? '-' : socio.telefono;
                let socioHtml = '<tr><td id="id">'+ socio.id +'</td><td>'+ socio.nombre +' '+ socio.apellidos +'</td><td>'
                    + socio.email+'</td><td>'+ telefonoTexto
                    + '</td> <td>'+botonEliminar+'</td></tr>';
                listadoHtml += socioHtml;
            })
            document.querySelector('#socios tbody').outerHTML = listadoHtml;
        })
        .catch(error => console.error(error));

}

async function eliminarSocio(id){
        if(!confirm("Desea eliminar este socio?")){
            return;
        }
        const request = await fetch('http://localhost:8080/api/usuarios/'+id, {
            method: 'DELETE',
            headers: getHeaders(),

        });
        location.reload();
    }
async function eliminarUsuario(id){
    if (!confirm('¿Desea eliminar este usuario?')){
       return;
    }
const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()
}