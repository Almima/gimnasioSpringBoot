    function getHeaders(){
        return {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };
    }
    async function eliminarUsuario(){
        const id = document.getElementById('id').value;
        if(!confirm("Desea eliminar este usuario?")){
            return;
        }
        const request = await fetch('http://localhost:8080/api/usuarios/'+id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        location.reload();
    }

    async function getActividadById(id){
       
        await fetch('api/registraInstructor', {
            method: 'POST',
            headers: getHeaders(),
            body: JSON.stringify(datos)
        }).then((response) => {return(response)}) ;
    }
    async function registrarInstructor(){
      let numero = 1;
        let datos={}
        datos.nombreInstructor = "David";
        datos.tipoActividad = getActividadById(numero);

        await fetch('api/registraInstructor', {
            method: 'POST',
            headers: getHeaders(),
            body: JSON.stringify(datos)
        });
    }
    async function registrarSocio(){
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
    async function eliminarSocio(){
        const id = document.getElementById('id').value;
        if(!confirm("Desea eliminar este socio?")){
            return;
        }
        const request = await fetch('http://localhost:8080/api/usuarios/'+id, {
            method: 'DELETE',
            headers: getHeaders(),
        });
        location.reload();
    }
    async function eliminarInstructor(){
        const id = document.getElementById('id').value;
        if(!confirm("Desea eliminar este instructor?")){
            return;
        }
        const request = await fetch('http://localhost:8080/api/instructor/'+id, {
            method: 'DELETE',
            headers: getHeaders(),

        });
        location.reload();
    }
    async function registrarTipoActividad(){
      
    }