<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 03/01/2022
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registrazione</title>
  <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
  <link rel="stylesheet" href="./customcss/general.css"/>

</head>
<body>
<script src="./jslibraries/jQuery.js"></script>

<form class="form-signin" action="./registrazione" method="post" onsubmit="return validateData()">
  <img class="mb-4" src="/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="username" class="sr-only" >Nome Utente:</label>
  <input type="text" id="username" class="form-control" onfocusout="existingusername()" placeholder="Nome Utente" required="" autofocus="">
  <span id="usernametest-alert" class="alert-info " hidden>Questo nome utente esiste già!</span>

  <label for="email" class="sr-only">Email</label>
  <input type="email" id="email" class="form-control" onfocusout="existingEmail()" placeholder="Email" required="">
  <span id="emailtest-alert" class="alert-info " hidden>Questa email risulta già iscritta!</span>

  <label for="password" class="sr-only">Password</label>
  <input type="password" id="password" class="form-control" placeholder="Password" required="">
  <input type="checkbox" value="eula" required=""> Accetto le condizioni sulla privacy

  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>

<script>

  function validateData(){
    existingUsername();
    existingEmail();
    let submitable = true;
    let emailvalid=true;
    let passwordvalid=true;
    let email=document.getElementById("email");
    let emailtest=document.getElementById("emailtest");
    let password=document.getElementById("password");
    let passwordtest=document.getElementById("passwordtest");

    if(!email.checkValidity){
      submitable =false;
      emailvalid=false;
      document.getElementById("email-alert").hidden=false;
    }
    else document.getElementById("email-alert").hidden=true;
    if(emailvalid&&email.value!=emailtest.value) {
      submitable = false;
      document.getElementById("emailtest-alert").innerText="Incorrect Email";
      document.getElementById("emailtest-alert").hidden=false;
    }
    else document.getElementById("emailtest-alert").hidden=true;
    let passAlert= document.getElementById("password-alert");
    if(!document.getElementById("password").checkValidity){
      submitable =false;
      passwordvalid=false;
      passAlert.innerText="Password Not Inserted";
      passAlert.hidden=false;
    }
    else passAlert.hidden=true;
    if(passwordvalid&&passwordtest.value!=password.value){
      submitable =false;
      document.getElementById("passwordtest-alert").hidden=false;
    }
    else document.getElementById("passwordtest-alert").hidden=true;
    return submitable;
  }


  function existingUsername(){
    let xhttp = new XMLHttpRequest();
    let usernametestalert = document.getElementById("usernametest-alert");
    let submit = document.getElementById("submit-registration");
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        if (this.responseText == "true") {
          submit.disabled = true;
          usernametestalert.hidden = false;
          console.log("username rejected");
        } else{
          submit.disabled = false;
          usernametestalert.hidden = true;
        }
      }
    };
    xhttp.open("POST", "/Sito_war_exploded/UsernamePresente", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("username="+document.getElementById("username").value);
  }

  function existingEmail(){
    let xhttp = new XMLHttpRequest();
    let emailalert = document.getElementById("email-alert");
    let submit = document.getElementById("submit-registration");
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        if (this.responseText == "true") {
          emailalert.innerText = "Email Already Present";
          submit.disabled = true;
          emailalert.hidden = false;
          console.log("email rejected");
        } else{
          submit.disabled = false;
          emailalert.hidden = true;
        }
      }
    };
    xhttp.open("POST", "/Sito_war_exploded/EmailPresente", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("email="+document.getElementById("email").value);
  }
</script>
</body>
</html>
