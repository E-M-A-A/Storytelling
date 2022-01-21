<%--
  Created by IntelliJ IDEA.
  User: Lethal Muriel
  Date: 12/01/2022
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>visualizzazione post</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-grid.css"/>
    <link rel="stylesheet" href="./bootstrap-4.5.3-dist/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" href="./customcss/general.css"/>

</head>

<body >

<jsp:include page = "../pageComponents/navbar4.jsp"></jsp:include>
<div id = "pageContenent">
    <main role="main">
        <div class="album py-5" style= "background-color: rgba(0,0,0,0.3)">
            <div class="container" id =  "bacheca">
                <div class="card mb-4 box-shadow" style = "background-color: var(--bg-default-color)">
                    <div class="card-body">
                        <h4>Questo è il nome dell'utente</h4>
                        <p class="card-text" >This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
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

            <div class="container" >
                <div class="card mb-4 box-" style = "background-color: var(--bg-secondary-color)">
                    <div class="card-body">
                        <p class="card-text ">Scrolla verso il basso per visualizzare i commenti meno recenti.</p>
                        <div class="align-items-center" id = "commenti">
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                    <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                    <small class="text-muted">9 mins</small>
                            </div>
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                <small class="text-muted">9 mins</small>
                            </div>
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                <small class="text-muted">9 mins</small>
                            </div>
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                <small class="text-muted">9 mins</small>
                            </div>
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                <small class="text-muted">9 mins</small>
                            </div>
                            <div class="card" style = "background-color: var(--bg-default-color)"   >
                                <h5>Questo è l'autore del commento.</h5>
                                <p class="card-text">Questo è il testo del commento. Ogni utente può commentare una storia esprimendo la propria impressione.</p>

                                <small class="text-muted">9 mins</small>
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


        <form class = "PubblicaCommento" id = " " action="./PubblicaCommento" method="post" onsubmit="return validateData()" style="display: block" aria-multiline="true" text-indent = "initial">
            <table>
                <tr>
                    <td style="width: 95%">

                        <textarea id="commento" name="commento" style="width: 100%" rows="3" placeholder="Scrivi un commento..." required=""></textarea>
                        <span id="lenght-alert" class="alert-info " hidden>Questo commento non ha il numero adeguato di caratteri!</span>
                    </td>
                    <td style="width:5%; height: 100%">
                        <button class="btn btn-lg btn-primary btn-block" style="width: 100%; height: 100%" type="submit">
                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                            </svg>
                        </button>
                    </td>
                </tr>
            </table>

        </form>

    </div>
</div>
<span id = "post" hidden="">${post}</span>
</body>
<script src="./jslibraries/popper.js"></script>
<script src="./jslibraries/holder.min.js"></script>
<script src="./jslibraries/bootstrap.min.js"></script>
<script>
let listaCommenti;
let storia;
let reazione;

document.onload = function () {
    let temp = document.getElementById("post").innerHTML;
    temp = JSON.parse(temp);
    storia = temp.storia;
    listaCommenti = temp.commenti;
    reazione = temp.reazione;
    caricaStoria()
}

function caricaStoria(){
    let variabileBacheca;
    let temp;
    variabileBacheca = document.getElementById("bacheca");
    temp =
        '<div class="card box-shadow" style = "background-color: var(--bg-default-color)">'+
        '<div class="card-body">'+
        '<h4>'+storia.username+'</h4>'+
        '<p class="card-text" onclick = "visualizzaPost('+storia.id+')">'+storia.contenuto+'</p>'+
        '<div class="d-flex justify-content-between align-items-center">'+
        '<div class="btn-group">'+
        '<button id = ' + storia.id + ' class="btn btn-sm btn-outline-secondary" onclick="aggiungiReazione('+storia.id+')" >'+
        '<span id = '+ storia.id +'r>'+storia.nReazioni+'</span>'+
        '<div style="display: inline-block">';

    if(reazione)
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
    temp += (
        '</div>'+
        '</button>'+
        ' <button type="button" class="btn btn-sm btn-outline-secondary" onclick="visualizzaPost('+storia.id+')">'+
        '<span>'+storia.nCommenti+' </span>'+
        '<div style="display: inline-block">'+
        '<svg xmlns="http://www.w3.org/2000/svg" width="27" height="27" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">'+
        '<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/></svg>'+
        '</div>'+
        '</button>'+
        '</div></div></div></div> ');
    variabileBacheca.appendChild(temp);
}

    function listatoreCommenti()
    {

    }


//Il controller restiutuisce un boolean che si può ignorare
    function aggiungiCommento(commento)
    {


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
