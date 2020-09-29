# 2. hét

Öröklődés, osztályhierarchia. Polimorfizmus, metódustúlterhelés. Hatáskörkezelés. A bezárási eszközrendszer, láthatósági szintek. Absztrakt osztályok és interfészek

## Öröklődés, osztályhierarchia, polimorfizmus

### Miért?

1. Implementáció öröklése: kód újrafelhasználhatóságának eszköze
2. Altípus ("is-a") kapcsolat, helyettesíthetőség: Liskov helyettesítési elv nyelvi szintű támogatása

Egy olyan rendszeren dolgozol, amely egész számokat ír egy FIFO sorba, hogy
tetszőleges consumer azokat feldolgozhassa. A számokat generáló komponensed
a következőképp néz ki:
```java
public class IntegerProducer {

    private IntegerQueue queue;

    public IntegerProducer(IntegerQueue queue) {
        this.queue = queue;
    }

    public void produce() {
        IntStream.range(0, 10)
            .forEach(queue::enqueue);
    }
}
```

A FIFO sor fejlesztését egy másik csapat végzi, ennek ismered a forráskódját, de
módosítani nem tudod.
```java
public class IntegerQueue {

    protected LinkedList<Integer> itemList = new LinkedList<>();

    public void enqueue(Integer item) {
        itemList.addFirst(item);
    }

    public Integer dequeue() {
        return itemList.removeLast();
    }

}
```

Hogyan oldanád meg azt, hogy a consumerek egy része LIFO sort használjon?

### Hogyan?

* Két osztály (szuperosztály/szülő osztály/alaposztály és 
  alosztály/gyermek osztály/származtatott osztály) 
  között fennálló asszimetrikus kapcsolat
* Az alosztály átveszi a szuperosztály minden (a bezárás által megengedett)
  attribútumát és metódusát
* Az alosztály definiálhat új metódusokat és attribútumokat
* Helyettesíthetőség: az alosztály példánya minden olyan helyen megjelenhet a programkódban,
  ahol az szuperosztály példánya megjelenhet.
* Java-specifikus tulajdonságok:
    * Egy alosztálynak csak egyetlen szuperosztálya lehet (*közvetlenül* csak egy osztálytól örökölhet)
    * Megengedett a többszintű öröklődés (pl. `A` szuperosztálya `B`-nek és `B` szuperosztálya `C`-nek, ekkor 
      `C` osztály közvetve A metódusait és attribútumait örökli)
    * Az alosztály az ősosztálynak a nem `final`, osztályszintű metódusát felülírhatja,
      amennyiben az a bezárás által megengedett - futási idejű polimorfizmus.
    * Nem megengedett a többszörös öröklődés (pl. `A` alosztálya `B`-nek és `C`-nek is)
    * Az öröklési fa gyökere az `Object` osztály
    * Dinamikus kötés - az objektum a példányosító osztályában megadott (vagy amennyiben
    nincs felülírva, örökölt) metódusa fut

## Bezárási eszközrendszer, láthatósági szintek

### Miért?

Ha `A` osztály használja `B` osztályt és `B` osztálynak elérhetőek
az implementációs részletei, akkor:
1. `A` osztály használhatja ezeket a részleteket, így `B` implementációjának
   módosítása `A` "eltöréséhez" vezethet.
2. `A` osztály módosíthatja `B` belső állapotát olyan módon, ami inkonzisztens
   állapotba hozza.
   
### Hogyan?

Láthatósági szintek:

* `public` - Bárhonann elérhető
* `protected` - Az osztályon belülről, a csomagon belülről és az alosztályokból érhető el
* Csomagszintű (explicit módosító nélkül, "alapértelmezett") Az osztályon belülről és 
  a csomagon belülről érhető el
* `private` - Csak az osztályon belülről érhető el

Alosztályokban a láthatóság bővítése lehetséges (amennyiben az adott tag elérhető 
az alosztályból), szűkítése nem.


## Absztrakt osztályok

### Miért?

Előfordul olyan helyzet, hogy egy-egy metódusnak csak a specifikációját kívánjuk
megadni, az implementációjukat nem.

Például: template method pattern

### Hogyan?

Egy absztrakt osztály
* Az `abstract` módosítóval van deklarálva
* Tartalmazhat `abstract` módosítóval deklarált, implementáció nélküli
  metódus specifikációkat. Ilyen metódusokat csak absztrakt osztályok és 
 (jellemzően implicit módon) interfészek tartalmazhatnak.
* Nem példányosítható
 

## Interfészek

### Miért?

"Contract" megadására. 

Például a soroknak általánosságban van enqueue és dequeue
metódusa, ám hogy ezek hogyan kerülnek implementálásra (hogyan tároljuk
az elemeket, stb.) az a hívó számára irreleváns. Az `interface`
Java-ban az ilyen jellegű "contract"-ok megadására (azaz, létezik `enqueue()`
és `dequeue()` metódus) alkalmazhatóak.

### Hogyan?

Az interfész:
* Az osztályhoz hasonlóan referenciatípus
* Tartalmazhat
    * konstansokat (implicit `final static`)
    * metódus szignatúrákat - implicit absztrakt
    * default metódusokat - lehet metódus törzse
    * statikus metódusokat - lehet metódus törzse
    * Beágyazott típusokat
* A tagjai implicit `public` láthatóságuak
* Tartalmazhat `private` példányszintű és statikus metódusokat; ezek az interfészen belüli
  kód újrafelhasználást segítik
* Nem példányosítható
* Más interfész kiterjesztheti
* Osztályok implementálhatják

Egy osztály több interfészt is implementálhat (default metódusok ütközése).
Az implementáló osztályt vagy absztraktnak kell jelölni, vagy az összes 
példányszintű metódust, amelyhez nem tartozik implementáció, implementálni kell benne.

## Metódustúlterhelés

### Miért?

Segítheti az olvashatóságot.

### Hogyan?

Egy osztályban lehet több azonos nevű metódus, feltéve, hogy a paraméterlistájuk
különbözik a paraméterek számában, típusában

## Hatáskörkezelés

### Miért?

Hogy meg tudjuk határozni, melyik változó meddig létezik, honnan érhető el.

### Hogyan?

* Metódusok, konstruktorok, lambda kifejezések formális paramétereinek hatásköre
  a metódus, konstruktor vagy lambda kifejezés teljes törzse
* Lokális változók hatásköre, ha
    * a változót egy blokkban deklaráltuk, akkor a változó hatásköre 
      a blokknak a deklarálás helyétől a blokk végéig eső része
    * a változót egy `for` ciklus fejlécének (`for ( [ForInit] ; [Expression] ; [ForUpdate] )`)
      `ForInit` részében adjuk meg, akkor a változó hatásköre a 
      `ForInit` deklarációtól jobbra eső része, az `Expression`, a `ForUpdate` részek
      illetve maga a ciklusmag.
    * a változó egy foreach stílusú `for` ciklus fejlécében formális paraméterként van deklarálva,
      akkor a változó hatásköre a ciklusmag.
      
További részleteket itt találtok:
https://docs.oracle.com/javase/specs/jls/se8/html/jls-6.html#jls-6.3
