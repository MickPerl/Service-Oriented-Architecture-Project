# Service Oriented Architecture Project
Repository per il progetto di _"Ingegneria del Software orientata ai servizi"_ (A.A. 2020/2021), realizzato da S. Fabbri, M. Perlino e G. Spiller.

# Descrizione del dominio e del problema
L'obiettivo è stato la realizzazione di un'architettura software orientata ai servizi che implementi ACMESky: trattasi di una piattaforma che offre ai suoi clienti un servizio di intermediazione per l'acquisto di biglietti aerei.<br>
ACMESky, essendo una SOA, integra sotto forma di servizi le seguenti capability esterne:
- **calcolo delle distanze geografiche** offerta da *Google Maps*, per ottenere la distanza tra il domicilio dell'utente e l'aeroporto da cui parte l'aereo di cui ha acquistato il biglietto, nonché la distanza tra il domicilio dell'utente e le sedi delle diverse compagnie di noleggio con cui ACMESky ha accordi;
- **gestione dei pagamenti** offerta da un *Fornitore di servizi bancari*, per garantire all'utente che la sua transazione per l'acquisto del biglietto vada a buon fine e sia sicura;
- **trasporto del cliente dal suo domicilio all'aeroporto** offerta da una serie di *compagnie di noleggio con autista* (rinominate in *compagnie di trasporto*, per brevità), con cui ACMESky ha accordi commerciali;
- **trasferimenti aerei di andata e ritorno** offerta da una serie di *compagnie aeree* convenzionate con ACMESky, le quali comunicano ad ACMESky le offerte ordinarie on demand e le offerte last minute (offerte LM) non appena sono attivate e inviano al cliente il biglietto acquistato, per poi realizzare il trasferimento aereo;
- **inoltro di messaggi** offerta da un'app di messaggistica chiamata *Prontogram*, per inoltrare le offerte di biglietti aerei ai clienti interessati.

# Descrizione struttura del repository
- La directory `assets` contiene gli artefatti realizzati per il progetto: in dettaglio, la coreografia definita formalmente con *process calculi*, il diagramma in BPMN, il modello UML con profilo *TinySOA* e la coreografia in BPMN.
- Il sottomodulo `soseng-project-documentation` contiene i file che compongono la documentazione, consistente in un documento web-based ospitato nella piattaforma *Stoplight* e raggiungibile al seguente link: https://soseng-unibo.stoplight.io/
- La directory `source-code` contenente il codice sorgente steso per le implementazioni dei diversi servizi.


