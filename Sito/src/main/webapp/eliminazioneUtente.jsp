<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 07/01/2022
  Time: 02:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eliminazioneUtente</title>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-grid.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" href="./customcss/general.css"/>

</head>
<body >
    <div id = "pageContenent">
        <form class="form-signin">
            <div class="text-center mb-4">
                <img class="mb-4" src="./images/logo3.png" alt="" width="100" height="84">
                <h1 class="h3 mb-3 font-weight-normal" style=" background-color: rgba(0,0,0,0.3)">Eliminazione account</h1>
                <p>Per eliminare il proprio account, compilare questi campi e poi cliccare su "conferma"</p>
            </div>

            <div class="form-label-group">
                <input type="string" id="inputNomeUtente" class="form-control" placeholder="Nome Utente" required="" autofocus="">
                <label for="inputEmail">Nome Utente</label>
            </div>

            <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <label for="inputEmail">Email</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                <label for="inputPassword">Password</label>
            </div>


            <div class="form-label-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Conferma</button>

            </div>

        </form>
    </div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<script src="../../assets/js/vendor/holder.min.js"></script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';

        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');

            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>


</body>
<footer>
    <p class="mt-5 mb-3 text-muted text-center">© E.M.A.A. Corp </p>

</footer>

</html>
