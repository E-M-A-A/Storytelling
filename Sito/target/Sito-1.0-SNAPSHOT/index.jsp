<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%Object x =session.getAttribute("uscito");
    boolean uscito=false;
if(x !=null&&((boolean) x)==true) {
        session.invalidate();
       uscito=(boolean) x;
    };%>

<!DOCTYPE html>
<html>
<head>
    <title>BENVENUTO IN E.M.A.A.</title>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./customcss/general.css"/>
</head>
<span id = "eliminato" hidden=""><%if(uscito)%><%=true%></span>
<body class="text-center">

<div id = "pageContenent">
    <div>

        <h1 style="padding: 10px; background-color: rgba(0,0,0,0.3); text-align: center">
            BENVENUTO IN E.M.A.A.!!!
        </h1>

        <img class="mb-4" src="./images/logo3.png" alt="" width="130" height="90">

    </div>

    <div class = "buttonContainer">
        <div>
            <a class="btn btn-lg btn-primary btn-block" href="./login.jsp">Accedi</a>
        </div>

        <div>
            <a class="btn btn-lg btn-primary btn-block" href="./registrazione.jsp">Registrati</a>
        </div>
    </div>

</div>
<p class="mt-5 mb-3 text-muted">© E.M.A.A. corp</p>
</body>
<script>
    /**
     * Controlla se vi è scritto "true" nell'oggetto html eliminato per poter mostrare il messaggio di account eliminato
     */
    document.onload= function(){
        if(document.getElementById("eliminato").innerText==="true")
            alert("Account Eliminato");
    }
</script>
</html>