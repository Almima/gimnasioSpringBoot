
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
            for (let socio in respuesta) {
                //let botonEliminar = '<a href="#" onclick="eliminarSocio('+ socio.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i> </a>'
                console.log(socio);
                let telefonoTexto = socio.telefono == null ? '-' : socio.telefono;
                let socioHtml = '<tr><td>'+ socio.id +'</td><td>'+ socio.nombre +' '+ socio.apellidos +'</td><td>'
                    + socio.email+'</td> <td>'+ telefonoTexto
                    + '</td><td>';
                listadoHtml += socioHtml;
            }
            document.querySelector('#socios tbody').outerHTML = listadoHtml;
        })
        .catch(error => console.error(error));

}

async function eliminarSocio(){
        const id = document.getElementById('id').value;
        if(!confirm("Desea eliminar este socio?")){
            return;
        }
        const request = await fetch('http://localhost:8080/api/getUsuarios'+id, {
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