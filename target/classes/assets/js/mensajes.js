function eliminar(id, modulo) {
    console.log(id + '' + modulo)
    console.log("/main/" + modulo + "/eliminar/" + id)
    swal({
        title: "Esta Seguro?",
        text: "Esta apunto de eliminar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            swal("El registro se elimino con exito!", {icon: "success", buttons: false});
            setTimeout(function () {
                location.href = "/main/" + modulo + "/eliminar/" + id;
            }, 1000)
        } else {
            swal("No se elimino ningun registro!");
        }
    });
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("regCliente").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
    evento.preventDefault();
    var clave = document.getElementById('clave').value;
    if (clave.length < 1) {
        swal('La clave no es válida');

        return;
    }
    var usuario = document.getElementById('descripcion').value;
    if (usuario.length == 0) {
        swal('No has escrito nada en la descripcion');
        return;
    }
    this.submit();
}