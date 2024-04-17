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


