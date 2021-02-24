include "compagnie_noleggio_interface.iol"

inputPort NoleggioPort {
    Location: "socket://0.0.0.0:8000"
    Protocol: soap {
        .wsdl = "./prenotazione_trasporto.wsdl";
        .wsdl.port = "NoleggioPortServicePort";
        .dropRootValue = true
    }

    Interfaces: prenotazione_trasporto 
}