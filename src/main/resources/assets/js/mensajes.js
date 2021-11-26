function eliminar(id) {
    swal({
        title: "Esta Seguro?",
        text: "Esta apunto de eliminar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            swal("El registro se elimino con exito!", {icon: "success", buttons:false});
            setTimeout(function (){location.href = "/main/paciente/eliminar/" + id;},1000)
        } else {
            swal("Your imaginary file is safe!");
        }
    });
}
function validar() {
    swal("Poof! Your imaginary file has been deleted!", {icon: "success", buttons:false});
}