```
C ::= (invio_interesse: cliente --> acmesky)*

|

(((richiesta_offerte: acmesky --> compagnia_aerea_a ;
risposta_offerte: compagnia_aerea_a --> acmesky) | ... |
(richiesta_offerte: acmesky --> compagnia_aerea_z ; 
risposta_offerte: compagnia_aerea_z --> acmesky)) ; 
1 + (invio_codici: acmesky --> prontogram ;
(inoltro_codice: prontogram --> cliente_1 ; ... ; 
inoltro_codice: prontogram --> cliente_n)))

|     

((invio_offerte_LM: compagnia_aerea_a --> acmesky ;
1 + (invio_codici_LM: acmesky --> prontogram ; 
(inoltro_codice_LM: prontogram --> cliente_1a ; ... ;
inoltro_codice_LM: prontogram --> cliente_na))) | 
... |
(invio_offerte_LM: compagnia_aerea_z --> acmesky ;
1 + (invio_codici_LM: acmesky --> prontogram ; 
(inoltro_codice_LM: prontogram --> cliente_1z ; ... ; 
inoltro_codice_LM: prontogram --> cliente_nz)) ))

| 

(invio_codice_offerta: cliente --> acmesky ;
(notifica_errore_codice: acmesky --> cliente) +
(richiesta_link_pagamento: acmesky --> fornitore_servizi_bancari ;
invio_link_pagamento: fornitore_servizi_bancari --> acmesky;
inoltro_link_pagamento: acmesky --> cliente ;
pagamento: cliente --> fornitore_servizi_bancari ;
(notifica_errore_pagamento: fornitore_servizi_bancari --> cliente +
( (invio_quota_pagamento: fornitore_servizi_bancari  --> compagnia_aerea ;
invio_biglietto: compagnia_aerea --> cliente) | 
invio_quota_pagamento: fornitore_servizi_bancari --> acmesky ;
1 + richiesta_distanza_domicilio_aeroporto: acmesky --> maps ;
1 + (proposta_trasferimento: acmesky --> cliente ; 
1 + (richiesta_distanze_domicilio_compagnie_trasporto: acmesky --> maps ;
prenotazione_trasferimento: acmesky --> compagnia_trasporto_vicina))))))
```