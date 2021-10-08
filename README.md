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
- La directory `acmesky_source_code` contenente il codice sorgente steso per le implementazioni dei diversi servizi; al suo interno, son presenti le seguenti directory:
    - `Interfaccia a caratteri per Cliente` contiene uno script python che permette di generare e mandare offerte last minute al processo su Camunda;
    - `acmesky_java_camunda` contiene il codice java del processo che va eseguito su Camunda;
    - `server_python_jolie_e_client_java` contiene i server python, i server jolie e i client java relativi ai diversi partecipanti alla coreografia (servizi bancari, prontogram ecc.). 

# Quickstart

Attualmente nei computer di dipartimento di Informatica sono in esecuzione un'istanza di camunda e istanze dei diversi server di supporto per la coreografia (come airline, prontogram ecc.).\
Per testare l'invio di interessi da parte dell'utente e delle offerte last minute da parte delle compagnie aereee, è sufficiente eseguire: 

`python3 'Interfaccia a caratteri per Cliente/main.py'` 

## Compilazione

- **Camunda**: per generare il file `acmesky.war`, all'interno della cartella `acmesky_java_camunda` dare il comando:

  `mvn clean package -Dmaven.test.skip=true`


  Il file risulterà nella cartella `acmesky_java_camunda/target`. Per la compilazione, è necessario installare prima i client java (si veda sezione sottostante).

- **Server python**: le cartelle `soseng-project-airline`, `soseng-project-geographical-distances-provider`, `soseng-project-payment-provider` e `soseng-project-prontogram` contengono dei server python, nelle cartelle `python_server`, che sono stati generati usando l'eseguibile [**swagger-codegen**](https://github.com/swagger-api/swagger-codegen) tramite il comando:

  `java -jar swagger-codegen-cli.jar generate -l python-flask -o python_server -i file.yaml`

  al posto di `file.yaml` ci vuole il nome file appropriato 
  (Attenzione: questa operazione riscriverà il contenuto delle cartelle `python_server/swagger_server/controllers`, perdendo tutte le modifiche al codice del server).

- **Client Java**: i client java sono presenti in `soseng-project-airline`, `soseng-project-geographical-distances-provider`, `soseng-project-payment-provider` e `soseng-project-prontogram`  nelle cartelle `java_client`. È possibile generare ogni client java attraverso il comando:

  `java -jar swagger-codegen-cli.jar generate -l java --api-package=nomeprovider --artifatc-id=nomeprovider --group-id=io.swaggger --artifact-version=1.0.0 -o java_client -i file.yaml`

  al posto di `file.yaml` ci vuole il nome appropriato e, a seconda del client, `nomeprovider` può essere uno tra `airline.airline-client`, `geoprovider.geo-client`, `paymentprovider.payment-client`, `prontogramprovider.prontogram-client`. 

- **Jolie**: il codice del server jolie è all'interno della cartella  `soseng-project-travel-company/sources` ed è stato generato un wsdl attraverso il comando `jolie2wsdl`.

## Configurazione e uso

### Configurazione dei server python

È necessario modificare alcuni file in `server_python_jolie_e_client_java`:

- `airline.list`: è necessario configurare questo file  all'interno di `soseng-project-payment-provider/python_server`, che contiene la lista degli url dove sono in esecuzione server delle compagnie aeree. 
- `config.txt`: file presente in `soseng-project-airline/python_server`, serve per specificare a quale compagnia aerea appartenga il server. 
- `simpleCamundaRESTPost.py`: per i server python di `soseng-project-airline`, `soseng-project-prontogram` e `soseng-project-payment-provider` è necessario modificare questo file, inserendo gli url relativi all'istanza di Camunda in esecuzione. 

### Eseguire server python e installare client java

Per l'installazione dei client java e l'avvio dei server python, si veda la documentazione all'interno delle rispettive cartelle.

### Configurazione di camunda e avvio del processo

Nella propria cartella dove è presente il server di camunda, è necessario avere una cartella chiamata `server_list` che deve contenere 5 file: `airline.list`, `geo-distance-provider.list`, `payment-provider.list`, `prontogram.list`, `transport.list`.\
Questi file contengono la lista degli url che corrispondono rispettivamente alle istanze dei vari server python e jolie: il formato dei file deve essere il semplice elenco dei server, una riga alla volta nel caso bisogni specificare più server. 

Per `transport.list` è necessario specificare anche un indirizzo civico, sulla stessa riga dell'url, separato da uno spazio, composto da `indirizzo, città`.\
Esempio di `transport.list`:

`http://localhost:8000 via calabria 1, Napoli
http://localhost:8001 via indipendenza 1, Bologna`

Una volta dopo aver fatto il deploy di `acmesky.war` è necessario avviare il processo dalla sezione **tasklist** del pannello di amministrazione web di camunda.

### Test attraverso l'interfaccia a caratteri

Per testare il processo attraverso l'interfaccia a caratteri, bisogna configurare il file `Interfaccia a caratteri per Cliente/simpleCamundaRESTPost.py` in modo che tutti gli url puntino all'stanza di camunda in esecuzione. Occorre anche modificare `Interfaccia a caratteri per Cliente/airline.list` (vedere sezioni precedenti).

Infine si può eseguire:

`python3 Interfaccia a caratteri per Cliente/main.py`

per inviare offerte last minute e interessi utente.




