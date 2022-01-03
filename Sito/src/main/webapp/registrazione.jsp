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
  <form class="form-signin">
    <img class="mb-4" src="/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="nomeUtente" class="sr-only">Nome Utente:</label>
    <input type="text" id="nomeUtente" class="form-control" placeholder="Nome Utente" required="" autofocus="">
    <label for="email" class="sr-only">Password</label>
    <input type="email" id="email" class="form-control" placeholder="Email" required="">
    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" class="form-control" placeholder="Password" required="">
    <input type="checkbox" value="eula" required=""> Accetto le condizioni sulla privacy

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2020</p>
  </form>
</body>
</html>
