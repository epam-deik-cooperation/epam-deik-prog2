# Magas szintű programozási nyelvek 2. mintamegoldások

## Első hét

### Java Object metódusok

Mutasd be a Java Object metódusait és mutass rá mely metódusokat érdemes 
egy saját osztályunkban felüldefiniálni és miért. (Lásd még Object class forráskódja)

### Eljárásorientált vs Objektumorientált

Írj egy 1 oldalas értekező esszé szöveget, amiben összehasonlítod az 
eljárásorientált és az objektumorientált paradigmát, igyekezve kiemelni az 
objektumorientált paradigma előnyeit!

### Objektum példányosítás programozási mintákkal

Hozz példát mindegyik “creational design pattern”-re és mutasd be mikor 
érdemes használni őket!

## Második hét

### Interfész evolúció Java-ban 

Mutasd be milyen változások történtek Java 7 és Java 8 között az interfészekben. Miért volt erre szükség, milyen problémát vezetett ez be? 

### Liskov exercise

Adott az alábbi osztály hierarchia: `Vehicle -> Car -> Supercar`

Mindegyik osztály konstruktorában történik egy kiíratás, valamint a `Vehicle` osztályban szereplő `start()` 
metódus mindegyik alosztályban felül van definiálva. 

Mi történik ezen kódok futtatása esetén (mi íratódik ki a standard outputra)? Válaszát indokolja!

```
Vehicle firstVehicle = new Supercar();
firstVehicle.start();
System.out.println(firstVehicle instanceof Car);

Car secondVehicle = (Car) firstVehicle;
secondVehicle.start();
System.out.println(secondVehicle instanceof Supercar);

Supercar supercar = new Vehicle();
```

### Interfész, Osztály, Absztrakt Osztály 

Mi a különbség Java-ban a Class, Abstract Class és az Interface között? Egy tetszőleges példával / példa kódon keresztül mutasd be őket és hogy mikor melyik koncepciót célszerű használni. 

## Harmadik hét

### Neptun tantárgyfelvétel modellezése UML-ben 
Modellezd le a Neptun rendszer tárgyfelvételéhez szükséges objektumokat UML diagramm segítségével. 

### Neptun tantárgyfelvétel UML diagram implementálása 
Implementáld le az előző feladatban létrehozott diagrammot egy tetszőleges nyelven. 

### OO modellezés 
Írj egy 1 oldalas esszét arról, hogy OO modellezés során milyen elveket tudsz követni (pl.: SOLID, KISS, DRY, YAGNI). 

## Negyedik hét

### Order of everything
Collection-ok rendezése esetén jellemzően futási időben derül ki,
ha olyan típusú objektumokat próbálunk rendezni, amelyeken az összehasonlítás
nem értelmezett (azaz `T` típus esetén nem implementálják a `Comparable<T>` interface-t).

Pl. ClassCastException a [Collections.sort()](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List)) esetében,
vagy ClassCastException a [Stream.sorted()](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#sorted--) esetében.

Írj olyan metódust, amely tetszőleges Collection esetén vissza adja az elemeket
egy List-ben növekvően rendezve, amennyiben az elemek összehasonlíthatóak velük azonos típusú objektumokkal.
Ha ez a feltétel nem teljesül, az eredményezzen syntax error-t.
Például:
```
    List<Integer> actualOutput = createOrderedList(input);
```
Ahol az `input` `Collection<Integer>` típusú. Természetesen más típusokkal is működnie kell,
feltéve, hogy implementálják a Comparable interface-t.

### Bináris keresés és Buborék rendezés implementálása 

Implementálj egy Java osztályt, amely képes egy előre definiált n darab Integer tárolására. Ennek az osztálynak az alábbi funkcionalitásokkal kell rendelkeznie: 
* Elem hozzáadása a tárolt elemekhez 
* Egy tetszőleges Integer értékről tudja eldönteni, hogy már tároljuk-e (ehhez egy bináris keresőt implementálj) 
* A tárolt elemeket az osztályunk be tudja rendezni és a rendezett (pl növekvő sorrend) struktúrával vissza tud térni (ehhez egy buborék rendezőt implementálj) 

### Saját HashMap implementáció 

Írj egy saját java.util.Map implementációt, mely nem használja a Java Collection API-t.
Az implementáció meg kell feleljen az összes megadott unit tesztnek, nem kell tudjon kezelni null értékű kulcsokat és a “keySet”, “values”, “entrySet” metódusok nem kell támogassák az elem törlést. 

Plusz feladatok: 
* az implementáció támogat null kulcsokat, 
* a “keySet”, “values”, “entrySet” metódusok támogatják az elem törlést.  

## Ötödik hét


### It's gone. Or is it?

Adott a következő osztály:
```
public class BugousStuffProducer {
    private final Writer writer;
    public BugousStuffProducer(String outputFileName) throws IOException {
        writer = new FileWriter(outputFileName);
    }
    public void writeStuff() throws IOException {
        writer.write("Stuff");
    }
    @Override
    public void finalize() throws IOException {
        writer.close();
    }
}
```
Mutass példát arra az esetre, amikor előfordulhat, hogy bár a program futása során meghívtuk a writeStuff() metódust,
a fájl, amibe írtunk még is üres. 

Magyarázd meg, miért. Mutass alternatívát.

### Kind of equal
Adott az alábbi kódrészlet.

```
// Given
String first = "...";
String second = "...";
String third = "...";
// When
var firstMatchesSecondWithEquals = first.equals(second);
var firstMatchesSecondWithEqualToOperator = first == second;
var firstMatchesThirdWithEquals = first.equals(third);
var firstMatchesThirdWithEqualToOperator = first == third;
```

Változtasd meg a ```String third = "...";``` sort úgy, hogy a firstMatchesSecondWithEquals,
firstMatchesSecondWithEqualToOperator, firstMatchesThirdWithEquals értéke true,
a firstMatchesThirdWithEqualToOperator értéke pedig false legyen. Magyarázd meg, mi történik a háttérben.

### Java GC 
Mutasd be nagy vonalakban hogyan működik Java-ban a GC (Garbage Collector). Lehetséges az OutOfMemoryError kezelése, ha igen milyen esetekben? 

Források: 
* https://medium.com/@hasithalgamge/seven-types-of-java-garbage-collectors-6297a1418e82 
* https://stackoverflow.com/questions/2679330/catching-java-lang-outofmemoryerror 

## Hatodik hét

### Mátrix szorzás Stream API-val
Implementáld le a mátrix szorzást Java-ban for és while ciklusok használata nélkül.

### LinkedList vs ArrayList
Mutass rá konkrét esetekre amikor a Java-beli LinkedList és ArrayList rosszabb performanciát eredményezhet a másikhoz képest. (Lásd még
LinkedList és ArrayList forráskódja). Végezz méréseket is. (mit csinál az ArrayList amikor megtelik)

### Refactoring
Adott egy “legacy” kód mely tartalmaz anonymus interface implementációkat, ciklusokat és feltételes kifejezések. 
Ebben a feladatban ezt a “legacy” kódot szeretnénk átírni lambda kifejezések segítségével (metódus referencia használata előnyt jelent).

## Hetedik hét

### ASCII Art 
ASCII Art in Java! Implementálj egy Java parancssori programot, ami beolvas egy képet és kirajzolja azt a parancssorba és / vagy egy szöveges fájlba is ASCII karakterekkel. 

### Titkos üzenet, száll a gépben! 
Implementálj egy olyan parancssori alkalmazást, amely a billentyűzetről olvas soronként ASCII karakterekből álló sorokat, és a beolvasott szöveget Caesar kódolással egy txt fájlba írja soronként. 

### XML to SVG
Adott egy koordinátákat és államokat tartalmazó XML:
```
<cities>
    <city>
        <coordinateX>190.77674000000002</coordinateX>
        <coordinateY>673.62922</coordinateY>
        <state>NY</state>
    </city>
</cities>
```
Ezt az XML-t feldolgozva szeretnénk létrehozni egy SVG fájlt, melyben minden város megjelenik egy pont formájában az adott koordináták alapján (tetszőleges színnel).
Plusz feladat: A városokat csoportosíthatjuk államok szerint, és minden állam külön színnel jelenjen meg a térképen, így látszódni fognak a határok is.
Mire kell figyelni ezen XML feldolgozása során, és miért? Milyen probléma adódhat DOM parsing esetén?

## Nyolcadik hét

### DI 
Implementálj egy alap DI (Dependency Injection) keretrendszert Java-ban annotációk és reflexió használatával megvalósítva az IoC-t (Inversion Of Control).  

### JSON szerializáció 
Implementálj egy JSON szerializációs könyvtárat, mely képes kezelni sztringeket, számokat, listákat és beágyazott objektumokat. A megoldás meg kell feleljen az összes adott unit tesztnek.

Plusz feladat: 
* a könyvtár tudjon deszerializálni 

### Exception handling
Adott az alábbi kódrészlet:
```
public void test(Object input) {
    try {
        System.out.println("Try!");
        if (input instanceof Float) {
            throw new ChildException();
        } else if (input instanceof String) {
            throw new ParentException();
        } else {
            throw new RuntimeException();
        }
    } catch (ChildException e) {
        System.out.println("Child Exception is caught!");
        if (e instanceof ParentException) {
            throw new ParentException();
        }
    } catch (ParentException e) {
        System.out.println("Parent Exception is caught!");
        System.exit(1);
    } catch (Exception e) {
        System.out.println("Exception is caught!");
    } finally {
        System.out.println("Finally!");
    }
}
```
Mi történik, ha az input változó 1F, “string” vagy pedig null? 
Meghívódik e minden esetben a finally ág? Válaszát indokolja!

## Kilencedik hét

### Reactive

Számoljuk ki az első 10 nem negatív egész szám összegét és áltagát.

1. Tegyük mindezt reaktív módon.
2. A számok előállítását végző komponensre "figyelhessenek" a különböző 
   statisztikákat számító komponensek, az egyes számítások pedig
   párhuzamosan, külön szálon menjenek végbe.
3. Ügyeljünk arra, hogy a számok előállítása során ne küldjünk több 
   számot az összeget és átlagot számoló szálaknak, mint amit azok fel 
   tudnak dolgozni, bármilyen lassú is legyen a számítás. 
   Az egyes számítások sebessége ne befolyásolja a számok előállításának 
   és más számításoknak a sebességét.
4. Amennyiben egy számítást végző szál nem tudja fogadni a következő számot, 
   azt mentsük el és kínáljuk fel a szálnak amint kész új 
   számot fogadni. Az így elmentett számok mennyisége legyen 
   limitálva, ha túl sok számot kellene elmentenünk, töröljük azt, amelyik a 
   legrégebben érkezett. Ne blokkoljuk a számok előállítását, ha van olyan 
   számítást végző szál, amely nem tudja feldolgozni az előállítot számot.
5. A számokat a számítást végző szálak az előállításuknak megfelelő 
   sorrendben dolgozzák fel.
6. Igyekezzünk minimálisra csökkenteni a blokkolt szálak számát.
7. A számítást végző szálak fejeződjenek be, ha nincs több feldolgozandó szám.
8. A megoldásunk legyen nyitott a bővítésre de zárt a módosításra. 
   Legyen lehetőség új statisztikák bevezetésére úgy, hogy a meglévő 
   osztályokat nem módosítjuk illetve szükség esetén tudjunk hasonlóképpen
   új komponenseket létrehozni a számok előállítására is.
   
### Back To The Future 

Adott az alábbi kódrészlet: 
```
public class FutureChainingExercise { 

  private static ExecutorService executorService = Executors.newFixedThreadPool(2); 

  public static void main(String[] args) { 

    CompletableFuture<String> longTask = CompletableFuture.supplyAsync(() -> { 
        sleep(1000); 
        return "Hello"; 
    }, executorService); 

    CompletableFuture<String> shortTask = CompletableFuture.supplyAsync(() -> { 
        sleep(500); 
        return "Hi"; 
    }, executorService); 

    CompletableFuture<String> mediumTask = CompletableFuture.supplyAsync(() -> { 
        sleep(750); 
        return "Hey"; 
    }, executorService); 

    CompletableFuture<String> result = longTask.applyToEitherAsync(shortTask, String::toUpperCase, executorService);
    
    result = result.thenApply(s -> s + " World"); 

    CompletableFuture<Void> extraLongTask = CompletableFuture.supplyAsync(() -> { 
        sleep(1500); 
        return null; 
    }, executorService); 

    result = result.thenCombineAsync(mediumTask, (s1, s2) -> s2 + ", " + s1, executorService); 
    
    System.out.println(result.getNow("Bye")); 
    sleep(1500); 
    System.out.println(result.getNow("Bye")); 

    result.runAfterBothAsync(extraLongTask, () -> System.out.println("After both!"), executorService); 
    result.whenCompleteAsync((s, throwable) -> System.out.println("Complete: " + s), executorService); 
    executorService.shutdown(); 

  } 

  /** 
   *  
   * @param sleeptime sleep time in milliseconds 
   */ 

  private static void sleep(int sleeptime) {...} 

} 
```
Mi lesz kiíratva a standard kimenetre és miért? 

### AOP
Készíts két példa projektet, melyben egyes metódusok futási idejét méred majd kiíratod úgy, hogy a metódus futási idejének méréséhez AOP-t használsz. Az első projektben csak az AspectJ könyvtárat, a második esetében pedig Spring AOP-t használj. 