<!DOCTYPE html>

<html lang="it">
<head>
    <meta charset=""ISO-8859-1"" />
    <!-- titolo mostrato per la home -->
    <title> Agenzia Viaggi da Sogno </title>
    
    <!-- riferimento al foglio di stile css chiamato stile in stili relativo a tutto il progetto -->
    <link rel="stylesheet" href="stili/stile.css" />
</head>
<body>
    <!-- nome delle sezioni da cambiare? -->
    <!-- sezione riferita alla barra principale sopra, con il logo ed a destra i vari riferimenti -->
    <section id="titolo">
        <!-- caricamento immagine logo a sinistra con uno spazio prima del nome della agenzia -->
        <img src="logo 2.jpg" width="100px" height="100px" align="left" hspace="20px" /> <h2> Agenzia Viaggi da Sogno </h2>
    <div class="link"> <h3>
    <!-- collegamento ipertestuale alla pagina itinerari -->
    <a href="itinerari.html"> Itinerari </a>      |
    <!-- collegamento ipertestuale alla pagina guide -->
    <a href="guide.html"> Guide  </a>           |
    <!-- collegamento ipertestuale alla pagina informazioni -->
    <a href="informazioni.html"> Informazioni</a>   
                       </h3>
   </div>
        
    </section>
    <!-- sezione che fa riferimento al form -->
    <section id="modulo">
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
                <div classe="uno">
                    <!-- Nome con casella di testo per inserire il nome -->
                    <label for="nome"> Nome </label>
                    <input type="text" name="nome" value="${nome}"  required />
                </div>
                <div classe="uno">
                    <!-- Cognome con casella di testo per inserire il cognome -->
                    <label for="cognome"> Cognome </label>
                    <input type="text" name="cognome" value="${cognome}" required />
                </div>
                <div classe="uno">
                    <!-- Numero di telefono con casella di testo (numerica) per inserire il numero -->
                    <label for="numero di telefono"> Numero di telefono </label>
                    <input type="tel" name="numTel" value="${numTel}"  required />
                </div>
                <div classe="uno">
                    <!-- Email con casella di testo (email) per inserire l'email -->
                    <label for="email"> Email </label>
                    <input type="email" name="email" value="${email}"  required />
                </div>
                <div classe="uno">
                    <!-- Destinazione con casella di testo per inserire la destinazione -->
                    <label for="citta"> Destinazione</label>
                    <input type="text" name="citta" value="${citta}" required />
                </div>
                <div classe="uno">
                    <!-- Periodo con data di inizio e di fine con casella calendario per inserire le due date -->
                    <label for="periodo"> Periodo </label>
                    <input type="date" name="periodo" value="${dataInizio}" required />
                    <input type="date" name="periodo" value="${dataFine}"  required />
                </div>
                <div class="due">
                    <!-- Pulsante per inviare i dati che porta alla pagina chiamata "Dati correttamente inviati" -->
                    <div><input type="submit" name="submit" value="invia" class="pulsante" />
                </div>
                    
            </form>
        </div>
    </section>
    <!-- sezione che fa riferimento alla parte di testo-->
    <section id="testoViaggi">
        <h1> Viaggi da Sogno </h1>
        <h2>  Perch? scegliere l'Agenzia Viaggi da Sogno?   </h2>
        <p>

            testo descrizione sul perch? scegliere l'agenzia Viaggi da Sogno, vantaggi su viaggi, itinerari stupendi, citt?

        </p>
        <!-- sezione che fa riferimento alle immagini delle destinazioni -->
    </section>
    <section id="immagini">
        <h2> Scopri le nostre imperdibili mete! </h2>
        <!-- l'immagine una ? sopra -->
        <img src="logo 2.jpg" width="1471px" height="400px" align="top" />
        <!-- le altre tre immagini sono allineate, senza spazi l'una dall'altra -->
        <img src="logo 2.jpg" width="450px" height="200px" align="left" hspace="0" />
        <img src="logo 2.jpg" width="571px" height="200px" align="left" hspace="0" />
        <img src="logo 2.jpg" width="450px" height="200px" align="left" hspace="0" />

    </section>

</body>
</html>