# Magas szintű programozási nyelvek 2. mintamegoldások

## Első hét

## Második hét

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

## Harmadik hét

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

## Hatodik hét

### Refactoring
Adott egy “legacy” kód mely tartalmaz anonymus interface implementációkat, ciklusokat és feltételes kifejezések. 
Ebben a feladatban ezt a “legacy” kódot szeretnénk átírni lambda kifejezések segítségével (metódus referencia használata előnyt jelent).

## Hetedik hét

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