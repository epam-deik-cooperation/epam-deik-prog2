# 5. hét

Objektumorientált programozási nyelvek típusrendszere. Típusok tagjai: mezők, 
(nevesített) konstansok, tulajdonságok, metódusok, események, operátorok, indexelők, 
konstruktorok, destruktorok, beágyazott típusok.

## Objektumorientált programozási nyelvek típusrendszere

A következők kimondottan a Java nyelvre vonatkoznak, érdemes megvizsgálni ezen tulajdonságok
meglétét/hiányát más nyelvekben is.

* Minden változó és kifejezés típusa ismert fordítási időben (statikus típuskezelés).
* Erősen típusos nyelv, egy adott változó/kifejezés típusa meghatározza, hogy milyen értéket 
vehet fel, milyen műveletek értelmezettek rajta.
* A típusokat két csoportra oszthatjuk:
    * Primitív típusok
    * Referencia típusok

### Referencia típusok

* Osztály, interfész és tömb típusok
** Az objektum egy dinamikusan létrehozott osztály vagy tömb példány
** A referencia típusú változók/kifejezések ezen objektumokra hivatkoznak
* A számos nyelv által definiált típus mellett bővíthető felhasználói típusokkal
* A Null típus egy speciális referencia típus, az egyetlen lehetséges értéke a `null` referencia, 
  nincs azonosító a típushoz rendelve, így közveltlenül nem lehet használni, viszont a 
  `null` érték bármely referencia típushoz hozzárendelhető. 
  Gyakorlatban a `null` értékre inkább mint a referencia típusok egy speciális értékére gondolunk.
* Lásd még: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.3

### Primitív típusok

* Nem objektumokra mutatnak
* A nyelv előre definiálja az összes primitív típust:
    * Egész típusok
        * `byte`: [-128 .. 127]
        * `short`: [-32768 .. 32767]
        * `int`: [-2147483648 .. 2147483647]
        * `long`: [-9223372036854775808 .. 9223372036854775807]
        * `char`: [\u0000 .. \uffff] (azaz [0 .. 65535])
    * Lebegőpontos típusok
        * `float`: 32 bites lebegőpontos
        * `double`: 64 bites lebegőpontos
    * `boolean`: {`true`, `false`}
* Lásd még: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.2

#### Autoboxing/unboxing

* Minden primitív típushoz létrehoztak egy olyan referencia típust, amely "becsomagolja"
  az adott primitív típust.
* Szükség esetén (pl. ha egy metódus formális paramétere `Integer` (referencia) típusú, de
  a metódus hívásakor az ennek megfelelő aktuális paraméter `int` (primitív) típusú) 
  a konverzió a primitív típus és a megfelelő referencia típus között (boxing) illetve
  a referencia típus és a neki megfelelő primitív típus között (unboxing) automatikusan
  megtörténik.
* Lásd még: https://docs.oracle.com/javase/specs/jls/se15/html/jls-5.html#jls-5.1.7 és 
  https://docs.oracle.com/javase/specs/jls/se15/html/jls-5.html#jls-5.1.8 .

### Típusok tagjai

```java
public class SomeClass {

    private Integer aField; // Példányszintű mező
    private final static Integer A_CONSTANT = 42; // Nevesített konstans
    
    public SomeClass(int initialValueOfField) { // Konstruktor
        this.aField = initialValueOfField;
    }

    public void addValueToField(int valueToAdd) { // Metódus
        this.aField += valueToAdd;
    }

    public static class SomeInternalClass { // Beágyazott osztály
        // ... 
    }
}
```