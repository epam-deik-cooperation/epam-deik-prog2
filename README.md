# Magas szintű programozási nyelvek 2. megoldási minták

## Kind of equal
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

## Order of everything
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

## It's gone. Or is it?

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


## Reactive

Számoljuk ki az első 10 nem negatív egész szám összegét és áltagát.
	
1. Tegyük mindezt reaktív módon.
2. A számok előállítását végző komponensre "figyelhessenek" a különböző 
   statisztikákat számító komponensek, az egyes számítások pedig
   párhuzamosan, külön szálon menjenek végbe.
2. Ügyeljünk arra, hogy a számok előállítása során ne küldjünk több 
   számot az összeget és átlagot számoló szálaknak, mint amit azok fel 
   tudnak dolgozni, bármilyen lassú is legyen a számítás. 
   Az egyes számítások sebessége ne befolyásolja a számok előállításának 
   és más számításoknak a sebességét.
3. Amennyiben egy számítást végző szál nem tudja fogadni a következő számot, 
   azt mentsük el és kínáljuk fel a szálnak amint kész a 
   számot fogadni. Az így elmentett számok mennyisége legyen 
   limitálva, ha túl sok számot kellene elmentenünk, töröljük azt, amelyik a 
   legrégebben érkezett. Ne blokkoljuk a számok előállítását, ha van olyan 
   számítást végző szál, amely nem tudja feldolgozni az előállítot számot.
4. A számokat a számítást végző szálak az előállításuknak megfelelő 
   sorrendben dolgozzák fel.
5. Igyekezzünk minimálisra csökkenteni a blokkolt szálak számát.
6. A számítást végző szálak fejeződjenek be, ha nincs több feldolgozandó szám.
7. A megoldásunk legyen nyitott a bővítésre de zárt a módosításra. 
   Legyen lehetőség új statisztikák bevezetésére úgy, hogy a meglévő 
   osztályokat nem módosítjuk illetve szükség esetén tudjunk hasonlóképpen
   új komponenseket létrehozni a számok előállítására is.