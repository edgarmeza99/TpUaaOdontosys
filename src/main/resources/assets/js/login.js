document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("login-form").addEventListener('submit', validarFormulario);
});

function validarFormulario(evento) {
  evento.preventDefault();
  var clave = document.getElementById('clave').value;
  if (clave.length < 1) {
    swal('La clave no es válida');

    return;
  }
  var usuario = document.getElementById('usuario').value;
  if (usuario.length == 0) {
    swal('No has escrito nada en el usuario');
    return;
  }
  var usuario = document.getElementById('mail').value;
  if (usuario.length == 0) {
    swal('No has escrito nada en el correo');
    return;
  }
  this.submit();
}