<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 03/01/2022
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./customcss/general.css"/>

</head>
<body class="text-center">
<div id = "pageContenent">
    <form class="form-signin">
        <img class="mb-4" src="./images/logo3.png" alt="" width="130" height="90">
        <h1 class="h3 mb-3 font-weight-normal">Inserisci le tue credenziali</h1>
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
<p class="mt-5 mb-3 text-muted">© E.M.A.A. corp</p>

</body>

<%@ page import="Model.User.User" %>
<% User user= (User) session.getAttribute("user");%>
<script>
    window.onload= function (){
        if($("#LoginErrato").val()=="true") createToast("Login Error","Email or Password incorrect");
    }
    function loggedToEnterCart(){
        if($("#loggedHeader").val()=="")
            createToast("Not Logged In","Cannot Visualize Cart If Not Logged In")
        else
            window.location.href="/MYOPSite_war_exploded/showCart"
    }
</script>

<nav class="navbar navbar-expand-lg navbar-dark  header">
    <div class="container-fluid">
        <a class="navbar-brand" href="/MYOPSite_war_exploded/">Make Your Own Pc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/MYOPSite_war_exploded/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/MYOPSite_war_exploded/build.jsp">Build</a>
                </li>
                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle  <%if(user==null){%> disabled <%}%>" <%if(user==null){%> aria-disabled="true" <%}%> id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        User Managment
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <li><a class="dropdown-item" href="/MYOPSite_war_exploded/showBuilds">Saved Builds</a></li>
                        <li><a class="dropdown-item" href="/MYOPSite_war_exploded/oldOrders">Old Orders</a></li>
                        <li><a class="dropdown-item" href="/MYOPSite_war_exploded/showUser">User Data</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <%if(user!=null&& user.isAdmin()){%>
                        <li><a class="dropdown-item" href="/MYOPSite_war_exploded/admin">Admin Page</a></li>
                        <%}%>
                    </ul>
                </li>
            </ul>
            <button class="icon-container" onclick=" loggedToEnterCart()" style="height: 3rem">
                <%@include file="/icons/cart.svg"%>
                <input type="hidden" name="loggedHeader" id="loggedHeader" value="${user.email}">
            </button>
            <%if(user==null){%>
            <form class="d-flex" method="post" action="login">
                <input class="form-control" type="email" placeholder="Email" name="email">
                <input class="form-control" type="password" placeholder="Password" name="password">
                <button class="btn active" type="submit">Log In</button>
                <a class="btn optional" href="/MYOPSite_war_exploded/registrationPage.jsp">Register Now</a>
            </form>
            <%}else{%>
            <div>
                <span class="navbar-text"> Welcome <%=user.fullName()%></span>
                <form action="/MYOPSite_war_exploded/logout" style="display: inline-block;height: 3rem;">
                    <button class="icon-container"  ><%@include file="/icons/exit_door.svg"%> </button>
                </form>
            </div>

            <%}%>
        </div>
    </div>
    <input type="hidden" id="LoginErrato" value="${LoginErrato}">
    <%if(session.getAttribute("LoginErrato")!=null)
        session.removeAttribute("LoginErrato");%>
</nav>


</html>
