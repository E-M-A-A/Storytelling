<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 05/01/2022
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>paginaPrincipale</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-grid.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" href="./customcss/general.css"/>


</head>

<body >

<jsp:include page = "../pageComponents/navbar3.jsp"></jsp:include>
<div id = "pageContenent">


<main role="main">

    <section class="jumbotron text-center" style= "background-color: rgba(0,0,0,0.5)">
        <div class="container">
            <h1 class="jumbotron-heading">Benvenuto in Storytelling!</h1>
            <p class="lead text-muted">Racconta la tua storia e vivi quella degli altri!<p>
          <!--      <a href="#" class="btn btn-primary my-2">Main call to action</a>
                <a href="#" class="btn btn-secondary my-2">Secondary action</a>  -->
            </p>
        </div>
    </section>

    <div class="album" style= "background-color: rgba(0,0,0,0.3)">
        <div class="d-flex flex-row align-items-center" id="bacheca">
            <div class="col-md-4 mr-auto p-2" >
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)" onclick="visulizzaPost(this)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4  mr-auto p-2">
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4  mr-auto p-2">
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex flex-row align-items-center" id="bacheca">
            <div class="col-md-4 mr-auto p-2">
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4  mr-auto p-2">
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" id = "idStoria" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4  mr-auto p-2">
                <div class="card box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è l'autore della storia.</h4>
                        <p class="card-text" >Questa è una storia. Attraverso questo elemento, gli utenti di questo social possono esprimersi in modo libero, raccontando delle proprie esperienze e delle proprie emozioni.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary"  >
                                    <span> 13 </span>
                                    <div style="display: inline-block">

                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon" viewBox="0 0 16 16">
                                            <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>
                                        </svg>
                                    </div>

                                </button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">
                                    <span> 9 </span>
                                    <div style="display: inline-block">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                            <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                        </svg>
                                    </div>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </main>



    <!-- QUESTA E' LA NAVBAR DI SOTTO -->

    <div class=" collapse" id="navbarBottom" style="">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">About</h4>
                    <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Contact</h4>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Follow on Twitter</a></li>
                        <li><a href="#" class="text-white">Like on Facebook</a></li>
                        <li><a href="#" class="text-white">Email me</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>


    <div class="navbar navbar-dark bg-dark fixed-bottom">
        <!--<div class="container d-flex justify-content-between bg-white"> -->

            <!--
            <a href="#" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
                <strong>Album</strong>
            </a>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            -->

        <form class = "PubblicaStoria" id = "idStoria" action="./PubblicaStoria" method="post" onsubmit="return validateData()" style="display: block" aria-multiline="true" text-indent = "initial">
            <table>
                <tr>
                    <td style="width: 95%">

                        <textarea id="w3review" name="w3review" style="width: 100%" rows="3" placeholder="Scrivi la tua storia..." required=""></textarea>
                        <span id="lenght-alert" class="alert-info " hidden>Questa storia non ha il numero adeguato di caratteri!</span>
                    </td>
                    <td style="width:5%; height: 100%">
                        <button class="btn btn-lg btn-primary btn-block" style="width: 100%; height: 100%" type="submit"> <%@include file="/images/icone/pubblica.svg"%>
                        </button>
                    </td>
                </tr>
            </table>

        </form>

    </div>
</div>
</body>
<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Album example is © Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>

<script src="../jslibraries/popper.js"></script>
<script src="../jslibraries/holder.min.js"></script>
<script src="../jslibraries/bootstrap.min.js"></script>



<script>
    let pagina = 0;
    let hashmap;
    function caricaStorie(){
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                pagina++;
                hashMap = JSON.parse(this.responseText);
                hashMap.keys.forEach(listatore);
            }
            else if((this.readyState == 4)){
                let bacheca = document.getElementById("bacheca");
                bacheca.appendChild("" +
                     "<h1 id = 'erroreCaricamento'> Non è stato possibile visualizzare la bacheca</h1>" +
                    "");
            }

        }
        xhttp.open("POST", "/Sito_war_exploded/visualizzaBacheca", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("pagina="+pagina);
    }

    function listatore(storia){
        let variabileBacheca;
        let temp;
        variabileBacheca = document.getElementById("bacheca");
       temp =
            '<div class="col-md-4  mr-auto p-2">'+
        '<div class="card box-shadow" style = "background-color: var(--bg-default-color)">'+
            '<div class="card-body">'+
            '<h4>'+storia.username+'</h4>'+
        '<p class="card-text" onclick = "visualizzaPost('+storia.id+')>'+storia.contenuto+'</p>'+
        '<div class="d-flex justify-content-between align-items-center">'+
            '<div class="btn-group">'+
                '<button type="button" id = '+ storia.id +'class="btn btn-sm btn-outline-secondary" onclick="aggiungiReazione('+storia.id+')" >'+
                    '<span id = '+ storia.id +'r>'+storia.nReazioni+'</span>'+
                    '<div style="display: inline-block">';

                    if(hashmap.get(storia))
                    {
                        temp += '<svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon false" viewBox="0 0 16 16">'+
                            '<path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278zM4.858 1.311A7.269 7.269 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.316 7.316 0 0 0 5.205-2.162c-.337.042-.68.063-1.029.063-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286z"/>'+
                            '</svg>'
                    }
                    else{
                        temp += '<svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon-fill true" viewBox="0 0 16 16">'+
                            '<path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>'+
                            '</svg>'
                    }
                    temp += ('</div>'+

                '</button>'+
               ' <button type="button" class="btn btn-sm btn-outline-secondary">'+
                    '<span>'+storia.nCommenti+' </span>'+
                    '<div style="display: inline-block">'+
                        '<svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">'+
                            '<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/></svg>'+
                    '</div>'+
                '</button>'+
            '</div></div></div></div> </div>');
    variabileBacheca.appendChild(temp);
    }
    function visulizzaPost(id){
        console.log(object.classList.contains("card"))
        window.location.replace("./visualizzaPost?storia="+id);
    }

    window.onscroll = function(pippo) {
        if ((window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
            caricaStorie();

            console.log("Bottom of page");
        }
    };

    function pubblicaStoria(){

    let xhttp = new XMLHttpRequest();
    let formDATA = $("#idStoria").serialize();


    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            alert("La tua storia è stata pubblicata!");
            setTimeout(aggiornamento, 2000)


        }

        }

    xhttp.open("POST", "./pubblicaStoria", true);

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send(formDATA);
    console.log(formDATA);
    };

    function aggiornamento()
    {
        window.location.reload();
    };

    function aggiungiReazione(storia)
    {
        var span = document.getElementById(storia);
        var pulsante = span.getElementsByTagName("svg")[2].childNodes[2];

        if(pulsante.className.includes("false"))
        {
            impostaReazione(storia);
        }
    }

    function impostaReazione(storia)
    {

        let xhttp = new XMLHttpRequest();
        let formDATA = new formDATA();
        formData.append("storia", storia);
        let contatore;

        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                console.log(this.responseText);
                contatore = document.getElementById(storia + "r").innerHTML;
                contatore = parseInt(contatore);
                contatore++;
                document.getElementById(storia + "r").innerHTML = contatore;
                alert("La tua reazione è stata aggiunta!");
                setTimeout(aggiornamento, 2000)
                var span = document.getElementById(storia);
                var pulsante = span.getElementsByTagName("div")[1].childNodes[1];
                pulsante.innerHTML = '';
                pulsante.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-moon-fill true" viewBox="0 0 16 16">'+
                    '<path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>'+
                    '</svg>';

            }

        }

        xhttp.open("POST", "./inserisciReazione", true);

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


        xhttp.send(formDATA);
        console.log(formDATA);

    }




</script>


</html>









