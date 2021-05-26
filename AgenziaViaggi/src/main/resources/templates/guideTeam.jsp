<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
     <!-- logo -->
    <link rel=icon href="static/image/logo.jpg" >
    <title>Team</title>
    <link rel="stylesheet" href="static/css/guideTeam.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,500;0,700;1,100&display=swap" rel="stylesheet">
</head>
<body>
<nav>
        <!-- caricamento immagine logo a sinistra con uno spazio prima del nome della agenzia -->
        <div class="titolo">
            <img src="static/image/logo.jpg" width="80px" height="70px" align="left" hspace="20px" /> <h2> Agenzia Viaggi da Sogno </h2>
        </div>
        
        <ul>
            <li>
                <!-- collegamento ipertestuale alla pagina guide -->
                <a href="index.jsp"> Home  </a>
            </li>
            <li>
                <!-- collegamento ipertestuale alla pagina itinerari -->
                <a href="itinerario.jsp"> Itinerari </a>
            </li>
            
            <li>
                <!-- collegamento ipertestuale alla pagina informazioni -->
                <a href="informazioni.jsp"> Informazioni</a>
            </li>
        </ul>
      
        
    </nav>
    <section>
    <div class="column">
        <div class="card">
            <img id="img" src="static/image/avatar2.png" alt="">
            <h2><a href="#">Camilla Moretti</a></h2>
            <p class="title">Guida Turistica</p>
            <p>Breve descrizione</p>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <img id="img" src="static/image/avatar3.png" alt="">
            <h2><a href="guida.jsp"> Matteo Rossi </a></h2>
            <p class="title">Guida Turistica</p>
            <p>Breve descrizione</p>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <img id="img" src="static/image/avatar1.png" alt="">
            <h2><a href="#">Alessandra Fiorentino</a></h2>
            <p class="title">Guida Turistica</p>
            <p>Breve descrizione</p>
        </div>
    </div>
    </section>
</body>
</html>