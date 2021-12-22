var boton = document.getElementById('agregar');
var guardar = document.getElementById('guardar');
var lista = document.getElementById('lista');
var sigTicket = $('#ticket').val();
var tot = 0;
var totFac = 0;
var ventaDetalle = [];
var cant = 1;
var venta = "";

$(document).ready(function () {

});

boton.addEventListener("click", agregar);
guardar.addEventListener("click", save);

function agregar() {
    var venid =parseInt($('#ventaid').val());
    var proid = $('#proid').val();
    var descripcion = $('#descripcion').val();
    var precio = parseFloat($('#precio').val());
    var cantidad = parseInt($('#cantidad').val());
    var total = precio * cantidad;
    totFac = $('#total').html;
    if (validarCamposAgregar()) {
        ventaDetalle.push(
            {
                "ventaid": venid,
                "id": cant,
                "proId": proid,
                "descripcion": descripcion,
                "cantidad": cantidad,
                "precio": precio,
                "total": total
            }
        );
        var id_row = 'row' + cant;
        var fila = `<tr id="${id_row}">
                    <td>${proid}</td>    
                    <td>${descripcion}</td>
                    <td>${cantidad}</td>
                    <td>${precio}</td>
                    <td>${total}</td>
                    <td>
                    <button type="button" class="btn btn-danger" onclick=eliminardet(${cant})>Eliminar</button></td>
                </tr>`

        //agregar a la lsita
        $('#lista').append(fila);
        $('#proid').val('');
        $('#descripcion').val('');
        $('#descripcion').focus();
        $('#precio').val('');
        $('#cantidad').val('');
        cant++;
        sumar();
    }
};

function fecha(){
    let mil = Date.parse($('#fecha').val());
    console.log("mill " + mil)
    let aux = Math.round(mil - 100000000)
    console.log("aux " + aux)
    //
    // let resultado = (aux * 100000000) + 90000000
    // console.log("resultado " +resultado)
    return aux
}


function save() {
    venta = {
        ventaId: parseInt($('#ventaid').val()),
        cedula: $('#cedula').val(),
        nombre: $('#cliente').val(),
        fecha: $('#fecha').val(),
        nroTicket: parseInt($('#ticket').val()),
        idDoctor:$('#idDoctor').val(),
        totalComp: tot,
        ventaDetalle
    }
    if (validarCamposSAVE()) {
        $.ajax({
            type: "POST",
            url: "/main/venta",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(venta),
            success: function (response) {
                succesEnviado()


            },
            error: function (response) {
                errorEnviado()
            }
        });
    }
};
function sumar() {
    tot = 0
    for (x of ventaDetalle) {
        tot = tot + x.total;
    }

    $('#total').html(`Total ${tot}`);
};

function eliminardet(id) {
    swal({
        title: "Esta Seguro?",
        text: "Esta apunto de eliminar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            swal("El registro se elimino con exito!", {icon: "success", buttons: true});
            setTimeout(function () {

                $('#row' + id).remove();
                var i = 0;
                var pos = 0;
                for (x of ventaDetalle) {
                    if (x.id == id) {
                        pos = i
                    }
                    i++
                }
                ventaDetalle.splice(pos, 1)
                sumar();
            }, 1000)

        } else {
            swal("No se elimino ningun registro!");
        }
    });

};

function vaciarCampos(){
    $('#cedula').val(''),
    $('#cliente').val(''),
    $('#fecha').val(''),
    $('#ticket').val(parseInt(sigTicket)+1),
    $('#descripcion').val('');
    $('#precio').val('');
    $('#cantidad').val('');
    
    $('#total').html('Total 0');
    
    for (x of ventaDetalle) {
        $('#row' + x.id).remove();
    }
    ventaDetalle.pop();
    fila = ''
}
function succesEnviado(){
    swal({
        title: "Resgistrado Exitosamente!",
        icon: "success",
      });
      vaciarCampos();
}
function errorEnviado(response){
    swal({
        title: "Oh Oh !!!",
        text: `ocurrio un error`,
        icon: "error",
      });
}
function aggPaciente(cedula, nombre){
    $('#cedula').val(cedula)
    $('#cliente').val(nombre);
    $('#cedula').attr("disabled",true);
    $("#cliente").attr("disabled",true);
    $('#fecha').focus()
}
function aggProducto(codigo, des,precio){
    $('#proid').val(codigo)
    $('#descripcion').val(des);
    $('#proid').attr("disabled",true);
    $("#descripcion").attr("disabled",true);
    $('#precio').val(precio);


}

$('#cerrar').click(function () {
    vaciarCampos();
    location.href='/main'
    
});


function validarCamposAgregar(){

    if  ($('#proid').val()===''){
        swal({text:'El codigo de producto no puede estar vacio',icon:'warning'});
        $('#proid').focus()
        return false;
    }
    if ($('#descripcion').val()===''){
        swal({text:'La descripcion no puede estar vacia',icon:'warning'});
        $('#descripcion').focus()
        return false;
    }
    if ($('#precio').val()==='0' || $('#precio').val()<0){
        swal({text:'El precio debe ser mayor a cero',icon:'warning'});
        $('#precio').focus()
        return false;
    }

    if ( $('#precio').val()===''){
        swal({text:'El precio no debe estar vacio',icon:'warning'});
        $('#precio').focus()
        return false;
    }
    if ($('#cantidad').val()==='0' || $('#cantidad').val()<0){
        swal({text:'La cantidad debe ser mayor a cero',icon:'warning'});
        $('#cantidad').focus()
        return false;
    }
    if ($('#cantidad').val()===''){
        swal({text:'La cantidad no debe esdtar vacia',icon:'warning'});
        $('#cantidad').focus()
        return false;
    }
    return true;
}


function validarCamposSAVE(){
    if ($('#cedula').val()===''){
        swal({text:'La cedula no puede estar vacia',icon:'warning'});
        $('#cedula').focus()
        return false;
    }
    if ($('#cliente').val()===''){
        swal({text:'El cliente debe tener un nombre',icon:'warning'});
        $('#cliente').focus()
        return false;
    }
    if ($('#fecha').val()===''){
        swal({text:'La fecha no puede estar vacia',icon:'warning'});
        $('#fecha').focus()
        return false;
    }
    if ($('#ticket').val()===''){
        swal({text:'El ticket no puede estar vacia',icon:'warning'});
        $('#ticket').focus()
        return false;
    }
    if ($('#total').html()==='Total 0') {
        swal({text: 'El total no puede ser cero', icon: 'warning'});
        return false;
    }
    return true;
}
