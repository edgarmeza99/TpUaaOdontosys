document.getElementById("regCliente").style.display = "none"
document.getElementById("listPacientes").style.display = "none"
function cargarCliente() {
    if (document.getElementById("regCliente").style.display == "none") {
      document.getElementById("regCliente").style.display = "block"
    document.getElementById("listPacientes").style.display = "block"
    } else {
      document.getElementById("regCliente").style.display = "none"
      document.getElementById("listPacientes").style.display = "none"
    }
  
  }