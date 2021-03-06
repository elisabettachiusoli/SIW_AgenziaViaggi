<!DOCTYPE html>

<html lang="it">
<head>
    <meta charset="ISO-8859-1" />
    <!-- logo -->
    <link rel=icon href="logo 2.jpg" >
    <!-- titolo mostrato per la home -->
    <title> Agenzia Viaggi da Sogno </title>
    
    <!-- riferimento al foglio di stile css chiamato stile in stili relativo a tutto il progetto -->
    <link rel="stylesheet" href="stili/stile.css" />
</head>
<body>
    <!-- navigation bar -->
    <nav>
        <!-- caricamento immagine logo a sinistra con uno spazio prima del nome della agenzia -->
        <div class="titolo">
            <img src="logo 2.jpg" width="80px" height="70px" align="left" hspace="20px" /> <h2> Agenzia Viaggi da Sogno </h2>
        </div>
        
        <ul>
            
            <li>
                <!-- collegamento ipertestuale alla pagina itinerari -->
                <a href="itinerario.jsp"> Itinerari </a>
            </li>
            <li>
                <!-- collegamento ipertestuale alla pagina guide -->
                <a href="guideTeam.jsp"> Guide  </a>
            </li>
            <li>
                <!-- collegamento ipertestuale alla pagina informazioni -->
                <a href="informazioni.jsp"> Informazioni</a>
            </li>
        </ul>
      
        
    </nav>
 
    <!-- sezione che fa riferimento al form -->
    <section id="modulo">
    <video autoplay muted loop  id="video-back">
            <source src="stili/aereo 2.mp4" type="video/mp4" />
        </video>
        <!-- divisione in classi-->
        <div class="content">
            <h2>
                <!-- in grassetto per risaltare -->
                <strong>
                    PRENOTA UNA CONSULENZA
                    <br />
                    E RICHIEDI IL TUO ITINERARIO!
                </strong>
            </h2>
            <!-- inseriti i dati ti porta alla pagina chiamata "Dati correttamente inviati" -->
            <form action="controller" method="post">
                <!-- lista non ordinata 
                sono presenti in tutto sette voci (li)-->
                    <!-- Tutti i campi sono richiesti!-->
                <div class="uno">
                    <!-- Nome con casella di testo per inserire il nome -->
                    <label for="nome"> Nome </label>
                    <input type="text" name="nome" value="${nome}"  required />
                </div>
                <div class="uno">
                    <!-- Cognome con casella di testo per inserire il cognome -->
                    <label for="cognome"> Cognome </label>
                    <input type="text" name="cognome" value="${cognome}" required />
                </div>
                <div class="uno">
                    <!-- Numero di telefono con casella di testo (numerica) per inserire il numero -->
                    <label for="numero di telefono"> Numero di telefono </label>
                    <input type="tel" name="numTel" value="${numTel}"  required />
                </div>
                <div class="uno">
                    <!-- Email con casella di testo (email) per inserire l'email -->
                    <label for="email"> Email </label>
                    <input type="email" name="email" value="${email}"  required />
                </div>
                <div class="uno">
                    <!-- Destinazione con casella di testo per inserire la destinazione -->
                    <label for="citta"> Destinazione</label>
                    <input type="text" name="citta" value="${citta}" required />
                </div>
                <div class="uno">
                    <!-- Periodo con data di inizio e di fine con casella calendario per inserire le due date -->
                    <label for="periodo"> Periodo </label>
                    <input type="date" name="periodo" value="${dataInizio}" required />
                    <input type="date" name="periodo" value="${dataFine}"  required />
                </div>
                <div class="due">
                    <!-- Pulsante per inviare i dati che porta alla pagina chiamata "Dati correttamente inviati" -->
                    <div><input type="submit" name="submit" value="Prenota una consulenza" class="pulsante" />
                    </div>
                </div>
                    
            </form>
        </div>
    </section>
    <!-- sezione che fa riferimento alla parte di testo-->
    <section id="testoViaggi">
        <h1> Viaggi da Sogno </h1>
        <h2>  Perch? scegliere l'Agenzia Viaggi da Sogno?   </h2>
        <p>

            Agenzia Viaggi da Sogno offre una imperdibile gamma di itinerari tra cui scegliere la vostra prossima vacanza! Da pi? di trent'anni proprone mete sempre nuove a prezzi super vantaggiosi, unendo
            comodit? e divertimento. </br> 
            Il Team di Agenzia Viaggi da Sogno si propone come obiettivo il benessere del cliente, permettendo di creare o riadattare ogni itinerario alle esigenze dei singoli.

        </p>
        <!-- sezione che fa riferimento alle immagini delle destinazioni -->
    </section>
    <section id="immagini">
        <h2> Scopri le nostre imperdibili mete! </h2>
        <!-- l'immagine una ? sopra -->
        <img src="stili/berlino4.jpg" width="1471px" height="400px" align="top" />
        <!-- le altre tre immagini sono allineate, senza spazi l'una dall'altra -->
        <img src="stili/parigi.jpg" width="450px" height="200px" align="left" hspace="0" />
        <img src="stili/siviglia.jpg" width="571px" height="200px" align="left" hspace="0" />
        <img src="stili/edimburgo.jpg" width="450px" height="200px" align="left" hspace="0" />

    </section>

</body>
</html>