let btnMsg = document.getElementsByClassName("message")
document.onload = function () {
  document.getElementById("register-form").style.display = "none"
  document.getElementById("regCliente").style.display = "none"
  document.getElementById("msgError").style.display="none"
}



for (var i = 0; i < btnMsg.length; i++) {
  btnMsg[i].onclick = function () {

    if (document.getElementById("register-form").style.display == "none") {
      document.getElementById("register-form").style.display = "block"
      document.getElementById("login-form").style.display = "none"
      return
    }
    document.getElementById("register-form").style.display = "none"
    document.getElementById("login-form").style.display = "block"
    return
  }
}


document.getElementById("cliente").onclick = function () {
  if (document.getElementById("regCliente").style.display == "none") {
    document.getElementById("regCliente").style.display = "block"
    return
  }
  document.getElementById("regCliente").style.display = "none"
  return

}

document.getElementById("Lg_Ingresar").onclick = function () {
  document.getElementById("msgError").style.display="block"
}


