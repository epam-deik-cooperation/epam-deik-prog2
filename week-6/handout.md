# 6. hét

## Interfészek. Kollekciók.

### Bevezetés
Különböző programozói feladatok vagy problémák megoldása közben elkerülhetetlen, hogy egyszerre nem csak egy, hanem több
objektumot is tudnom kell kezelni, tárolni. Erre egy megoldást adhat a tömb (array), ami a legtöbb nyelvben, így Java-ban
is natívan elérhető. Azonban bizonyos esetekben más adatszerkezetek sokkal kényelmesebb és jobb megoldást adhatnak. Mint
például:
* Halmaz (set)
	* Adott típusú elemek tárolására való
	* Homogén
	* Dinamikus
	* Nem értelmez sorrendet az elemek között
* Lista (list)
	* Adott típusú elemek tárolására való
	* Homogén
	* Dinamikus
	* Értelmez sorrendet az elemek között
* Map (map)
	* Kulcs-érték párok tárolására való
	* Homogén
	* Dinamikus
	* Nem értelmez sorrendet a kulcs-érték párok között

A következő fejezetekben az említett adatszerkezetek fogjuk megismerni Java-ban.

### Collection interfész és implementációi
![Collection interfész](collection-interface.png)

#### ArrayList
* A háttérben egy tömböt használ az elemek tárolására
* Az ArrayList módosítása (elemek törlése, hozzáadása) költséges lehet
* Az elemek elérése indexek alapján közvetlenül történik, így az olvasás nagyon gyors
* Ha tudjuk pontosan hány elemet szeretnénk tárolni, és nincs szükség gyakori módosításra, akkor egy jó választás lehet

#### LinkedList
* A háttérben egy kétirányból lácolt listát használ az elemek tárolására
* A módosítás kevésbé időigényes az ArrayList implementációhoz képest
* Az elemek elérése a láncolt lista bejárásán alapul, így ez lassabb lehet az ArrayList-hez képest, illetve egy elem
tárolása is költségesebb
* Ha nem tudjuk pontosan mennyi elemet szeretnénk tárolni, és szükséges a listánk gyakori módosítása, akkor a LinkedList
egy jó választás lehet

#### HashSet
* A háttérben HashMap-et használ az adatok tárolására
* Gyorsabb mint a TreeSet
* Az elemeket nem rendezett módon tárolja

#### TreeSet
* A háttérben TreeMap-et használ az adatok tárolására
* Lassabb mint a HashSet
* Az elemeket rendezetten tárolja, így támogat higher(), floor() és ceiling() műveleteket

### Map interfész és implementációi
![Map interfész](map-interface.png)

#### HashMap
* A Hashtable egy általánosabb implementációja
    * Tud null kulcsokat és értékeket kezelni
    * Azonban a Hashtable implementtációval ellentétben nem szálbiztos
* Nem értelmez sorrendet a kulcs-érték párok között
* Szükséges az equals() és a hashCode() megfelelő implementációja a kulcs típusokra
* Általános célú Map implementáció, gyors adateléréssel, de nem szálbiztos
    * Szálbiztos változata a ConcurrentHashMap

#### LinkedHashMap
* A HashMap és a LinkedList implementációk keveréke
* Tud null kulcsokat és értékeket kezelni
* Értelmes sorrendet az elemek között (beszúrás vagy lekérdezés sorrendje)
* Nem szálbiztos
* Szükséges az equals() és a hashCode() megfelelő implementációja a kulcs típusokra
* Akkor érdemes használni, ha számít a beszúrás vagy az elérés sorrendje

#### TreeMap
* Piros Fekete bináris fa implementációt használ
* Nem tud null kulcsot kezelni minden esetben
* Értelmes sorrendet az elemek között (a kulcsok természetes sorrendje vagy egy megadott Comparator alapján)
* Nem szálbiztos
* Szükséges egy megfelelő Comparator megadása, vagy máskülönben a kulcsok természetes sorrendjét fogja használni
* Olyan esetekben érdemes használni, amikor fontos a rendezési vagy navigációs tulajdonság

## Funkcionális nyelvi elemek. Lambda kifejezések.

### Funkcionális Inerfészek
A funkcionális interfészek olyan interfészek melyek csak egyetlen egy absztrakt metódust tartalmaznak.

Példák beépített funkcionális interfészekre:
* [Runnable](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Runnable.html)
* [Comparable](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Comparable.html)
* [Supplier](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/Supplier.html)
* [Consumer](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/Consumer.html)
* [BiConsumer](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/BiConsumer.html)
* [Predicate](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/Predicate.html)
* [BiPredicate](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/BiPredicate.html)
* [Function](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/Function.html)
* [BiFunction](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/function/BiFunction.html)

Bármilyen tetszőleges funkcionális interfészt létrehozhatunk mi magunk is. Ezeket a `@FunctionalInterface` annotációval
szokás megjelölni.

### Lambda kifejezések
Java 8-tól funkcionális interfészek példányai reprezentálhatóak lambda kifejezések segítségével. Java 8 előtt anoním
belső osztályokat kellett létrehozni:
```java
class Main { 
    public static void main(String args[]) {
        new Thread(new Runnable() { 
            @Override
            public void run() { 
                System.out.println("New thread created"); 
            } 
        }).start(); 
    } 
} 
```
Ugyanez Java 8-tól lambda kifejezéssel:
```java
class Main { 
    public static void main(String args[]) {
        new Thread(() -> {System.out.println("New thread created");}).start();
    } 
} 
```
Egy lambda kifejezés általános alakja: `(int arg1, String arg2) -> {System.out.println("Two arguments " + arg1 + " and " + arg2);}`,
ahol a zárójelben a funkcionális interfész egyetlen metódusának paraméter listája szerepel, majd a `->` után kapcsos
zárójelben az adott interfészhez tartozó implementáció.

### Stream API
A Stream API Java 8-ban lett bevezetve, annak érdekében, hogy könnyen és hatékonyan lehessen objektumok kollekcióját
feldolgozni és rajtuk összetett műveleteket végrehajtani. Egy Stream objektumok egy szekvenciája, mely szekvenciát
változatos metódusok segítségével, egymást követve, feldolgozhatjuk a kívánt műveletek végrehajtásával.

Funkcionalitásai / tulajdonságai:
* A Stream nem egy adatszerkezet, hanem egy kollekció, tömb vagy I/O csatorna alapján hozható létre
* A Strem-ek sosem változtatják meg az eredeti adat szerkezetét, ők csak az eredményét adják az egymás után láncolt
speciális metódusoknak
* Ezeknek a speciális metódusoknak / operátoroknak két kategóriájuk van
    * Közbenső operátor
    * Terminális operátor
* A közbenső operátor nem kerülnek egyből meghívásra, ők csak egy újabb Stream objektummal fognak visszatérni
* A terminális operátor jelzik a kifejezés végét, így majd ők fogják előállítani a végleges eredményt

#### Közbenső operátor
* `map`: annak a segítségével egy adott `Function`-t tudunk megadni, amely a Stream minden elemére le fog futni
```
List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
List square = numbers.stream()
                     .map(x -> x*x)
                     .collect(Collectors.toList());
```
* `filter`: egy megadott `Predicate` alapján megszűri a Stream elemeit
```
List<String> names = Arrays.asList("Reflection","Collection","Stream");
List<String> result = names.stream()
                           .filter(s -> s.startsWith("S"))
                           .collect(Collectors.toList());
```
* `sorted`: berendezi az elemeket
```
List<String> names = Arrays.asList("Reflection","Collection","Stream");
List<String> result = names.stream()
                           .sorted()
                           .collect(Collectors.toList());
```

#### Terminális operátor
* `collect`: összegyűjti és visszatér az őt megelőző közbenső operátorok alapján előálló elemekkel
```
List<Integer> numbers = Arrays.asList(2,3,4,5,3);
Set<Integer> squares = numbers.stream()
                              .map(x -> x*x)
                              .collect(Collectors.toSet());
```  
* `forEach`: végigiterál az eredményként előálló Stream elemein
```
List<Integer> numbers = Arrays.asList(2,3,4,5);
numbers.stream()
       .map(x -> x*x)
       .forEach(y -> System.out.println(y));
```  
* `reduce`: segítségével a Stream elemeit egyetlen értékké redukálhatjuk, ehhez egy `BinaryOperator`-t kell megadnunk
```
List<Integer> numbers = Arrays.asList(2,3,4,5);
int even = numbers.stream()
                  .filter(x -> x%2 == 0)
                  .reduce(0, (ans,i) -> ans + i);
```