<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
     <!-- logo -->
    <link rel=icon href="logo 2.jpg" >
    <!-- titolo mostrato per la pagina dell'itinerario -->
    <title> Nome Itinerario </title>
    <!-- riferimento al foglio di stile css chiamato stile in stili relativo a tutto il progetto -->
    <link rel="stylesheet" href="stili/stileItinerario.css" />
</head>
<body>
<nav>
        <!-- caricamento immagine logo a sinistra con uno spazio prima del nome della agenzia -->
        <div class="titolo">
            <img src="logo 2.jpg" width="80px" height="70px" align="left" hspace="20px" /> <h2> Agenzia Viaggi da Sogno </h2>
        </div>
        
        <ul>
            <li>
                <!-- collegamento ipertestuale alla home-->
                <a href="index.jsp"> Home </a>
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
    <section class="parallax">
    <div class="parallax-inner">
     A spasso per Berlino 
            <h3> Berlino </h3>
    </div>        
    </section>

    <section id="icona">
        <img src="stili/calendar.png" width="50px" height="50px" hspace="15px" />  Dal 20 luglio al 23 giugno
        <img src="stili/finePrenotazione.png" width="50px" height="50px" hspace="15px" />  Prenotazioni fino al 23 giugno
        <img src="stili/guidaIcona.png" width="50px" height="50px" hspace="15px" /> Guida: <a href="guida.jsp"> Matteo Rossi</a>
        <img src="stili/money.png" width="50px" height="50px" hspace="15px" /> Prezzo: 500 euro


    </section>
    <section id="descrizione">
        <p>
            
                A spasso per Berlino è l'itinerario fatto apposta per le persone che programmano una vacanza alla ricerca della storia! <br />
                Il viaggio è composto da 4 giornate, nella quale sarà incluso il pass per accedere ai musei.  <br />
                Per tutto il soggiorno verrete accompagnati da una guida, in modo tale da poter essere sempre affiancati da esperti pronti a soddisfare ogni vostra curiosità.<br /> 
                Cliccate sulle varie giornate per scoprire di più su questa fantastica avventura!
                <br /> <br />
            DOVE DORMIRE [valido per le 3 notti]: Meininger Hotel Berlin Mitte "Humboldthaus"
        </p>


    </section>
    <section id="programma">
        <div class="top">
            <h2> Programma </h2>
        </div>
        <div class="elenco">
            <ul>
                <li>
                    <a href="giorno.jsp"> Giorno 1: </a> La bellezza di
                    <p>
                    	<a href="monumento.jsp"> Monumento </a>
                    </p>
					
                </li>
                <li>
                    <a href="giorno.html"> Giorno 2: </a> Luci di

                </li>
                <li>
                    <a href="giorno.html"> Giorno 3: </a> Visita al

                </li>
            </ul>
        </div>
    </section>

</body>
</html>ml>