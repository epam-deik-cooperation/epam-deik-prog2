# 3. hét

## Modellező eszközök és nyelvek. Az UML és az UML osztálydiagramja

### A rendszerek modellezéséről általában

#### Miért?

1. Kommunikáció segítésére
    1. Közös terminológia meghatározására
    2. Megállapodások, követelmények rögzítésére
    3. Rampup, training támogatására
    4. Az adott kontextusban lényeges részletek vizualizációjára - minden fontos
       részlet megtalálható a modellben
2. Verifikáció
    1. Egy formális modell lehetővé teszi a modellezett rendszer vizsgálatát
       konzisztencia, teljesség és helyesség szempontjából

####  Hogyan?

1. A modell egy rendszer leírása
2. Egy meglévő vagy jövőbeli rendszerről készült modell általában nem tartalmazza a rendszer
   minden részletét. Bizonyos információkat elhagyhatunk, míg másokat kihangsúlyozhatunk
   a modellünkben. 
    1. Az, hogy mely részleteket jelenítsük meg a modellünkben, függ a
       modell céljától és a célközönségtől.
    2. Ugyanarról a rendszerről több modell is létezhet, különböző céllal és célközönséggel
    3. A modellezett rendszer minden részletét tartalmazó modell esetén
        1. az adott kontextusban fontos részletek könnyen elvésznek
        2. nagyon nehézzé válik a modell karbantartása
        3. a modell ugyan azt az információt tartalmazza, mint maga a 
           (megfelelően megírt, öndokumentáló) kód, ám nehezebben 
           olvasható, tesztelhető, futtatható - itt megjegyzendő, hogy
           léteznek futtatásra, kódgenerálásra és validációra szánt modell nyelvek,
           pl. xUML.
3. Külömböző diagrammokat vagy nézeteket használhatunk a modell külömböző aspektusainak trágyalására
    1. Absztrakciós szint szerint
        1. Analízis modellek - üzleti fogalmak, folyamatok, magas szintű, absztrakt
        2. Implementációs modellek - részletes tervezéshez, kód és adatmodell generáláshoz, 
           interfészek dokumentációjára
    3. Struktúrára, viselkedés, interakció leírására szánt diagrammok
    
### Unified Modelling Language

1. Grafikus, általános célú modellező nyelv
2. Az Object Management Group (OMG) szabványa
3. Többféle diagramtípus áll rendelkezésre a rendszer statikus és dinamikus aspektusainak leírására
    1. Strukturális diagramok
    2. Viselkedési diagramok
    3. Interakciós diagramok

### Hasznos linkek
1. https://sourcemaking.com/uml/introduction
2. https://arato.inf.unideb.hu/jeszenszky.peter/download/swe/presentations/hu/uml-2x2.pdf
3. https://inf.mit.bme.hu/sites/default/files/materials/category/kateg%C3%B3ria/oktat%C3%A1s/bsc-t%C3%A1rgyak/rendszermodellez%C3%A9s/11/UML%20%C3%A1ttekint%C5%91.pdf