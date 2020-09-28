# 4. hét

## Objektumorientált programozási nyelvek programnyelvi elemei: karakterkészlet, lexikális egységek, kifejezések, utasítások

### Karakterkészlet
Minden program forráskódjának legkisebb alkotórészei a *karakterek*. A forráskód (vagy forrásszöveg) összeállításánál alapvető a *karakterkészlet*, ennek elemei jelenhetnek meg az adott nyelv programjaiban. Minden nyelv definiálja a saját karakterkészletét. A karakterkészletek között lényeges eltérések lehetnek, de a programnyelvek általában a karaktereket a következő módon kategorizálják:
* betűk (a, b, c)
* számjegyek (1, 2, 3)
* egyéb karakterek (+, -, *, /)

A Java nyelv ismeri az *UNICODE* karakterkészletet, tehát a forráskódban használhatnánk bármilyen nemzetközi karaktert. Azonban ajánlatos a -már C-ben is - megszokott ASCII formátumot használni.

### Lexikális egység
A lexikális egységek a program szövegének azon elemei, melyeket a fordító a lexikális elemzés során felismer és tokenizál (közbenső formára hoz).
Fajtái:
* többkarakteres szimbólum (pl.: &&, ||, ++, --, /*, */)
* címke (végrehajtható utasítások cimkézésére használható)
* megjegyzés (a forráskód értelmezését segítő kommentek)
* szimbolikus nevek
* literálok

#### Szimbólikus nevek
##### Azonosító
Olyan karaktersorozat, amely betővel kezdődik, és betűvel vagy számjeggyel folytatódhat. Arra való, hogy a program írója a saját programozói eszközeit megnevezze vele, és ezután ezzel hivatkozzon rá a program szövegében bárhol. 

##### Kulcsszó (alapszó, fenntartott szó, védett szó, foglalt szó)
Olyan karaktersorozat, amelynek az adott nyelv tulajdonít jelentést, és ez a jelentés a programozó által nem megváltoztatható.
A legfontosabbak: 
* `abstract`, 
* `break`, 
* `case`, `catch`, `class`, 
* `default`, `do`, 
* `else`, `extends`, 
* `final`, `finally`, `for`,
* `goto`, 
* `if`, `implements`, `interface`, 
* `return`, `strictfp`, `super`, `switch`, `synchronized`, 
* `this`, `throw`, `throws`, `try`, 
* `void`, `while`

#### Literálok
Bármilyen konstans értéket, amit egy változónak értékül adhatunk literálnak nevezünk.
Például:
* `"alma"` Sztring literál
* `123` Egész szám (int) literál
* `23.023` Tört szám (double) literál
* `23.023f` Tört szám (float) literál

### Szeparátorok
| Szimbólum | Név | Cél |
| --- | --- | --- |
| ` ` | Szóköz | Univerzális elválasztó |
| `( )` | Zárójel | Metódus argumentum, típus kasztolás, aritmetikai kifejezések precedencia sorrend kifejezése |
| `{ }` | Kapcsos zárójel | Kód blokkok elválasztása, tömbök inicializálása |
| `[ ]` | Szögletes zárójel | Tömbök definiálása és inicializálása |
| `< >` | Kúpos zárójel | Generikusok elválasztása |
| `;` | Pontosvessző | Utasítások elválasztása |
| `,` | Vessző | Elválaszt azonosítókat változó deklarációban, értékeket és kifejezéseket a for ciklusban |
| `.` | Pont | Csomagnév elválasztó, objektum mező és metódus szelektor |
| `:` | Kettőspont | Ciklus cimkéket követ, illetve feltételes értékadó utasításban szerepelhet |
| `' '` | Aposztróf | Karakter literál indikátor |
| `" "` | Idézőjel | Sztring literál indikátor |
| `//` | Dupla perjel | Egysoros megjegyzés (komment) indikátor |
| `/* */` | Perjel csillaggal | Többsoros blokk megjegyzés (komment) indikátor  |
| `/** */` | Perjel dupla csillaggal | JavaDoc indikátor |

### Operátorok
#### Értékadó operátorok
| Operátor | Jelentés |
| --- | --- |
| `=` | Értékadás |
| `+=` | Értékadás összeadással |
| `-=` | Értékadás kivonással |
| `*=` | Értékadás szorzással |
| `/=` | Értékadás osztással |
| `%=` | Értékadás maradékos osztással |

#### Aritmetikai operátorok
| Operátor | Jelentés |
| --- | --- |
| `+` | Összeadás |
| `-` | Kivonás |
| `*` | Szorzás |
| `/` | Osztás |
| `%` | Maradékos osztás |

#### Relációs operátorok
| Operátor | Jelentés |
| --- | --- |
| `==` | Egyenlő |
| `!=` | Nem egyenlő |
| `<` | Kisebb |
| `>` | Nagyobb |
| `<=` | Kisebb vagy egyenlő |
| `>=` | Nagyobb vagy egyenlő |

#### Logikai operátorok
| Operátor | Jelentés |
| --- | --- |
| `\|\|` | Vagy |
| `&&` | És |
| `!` | Negáció |

#### Bit műveleti operátorok
| Operátor | Jelentés |
| --- | --- |
| `~` | Unáris bitenkénti komplementer |
| `<<` | Előjeles balra tolás |
| `>>` | Előjeles jobbra tolás |
| `>>>` | Előjel nélküli jobbra tolás |
| `&` | Bitenkénti és |
| `^` | Bitenkénti kizáró vagy |
| `\|` | Bitenkénti megengedő vagy |

### Kifejezések
A kifejezések olyan konstrukciók melyek változókból, literálokból, operátorokból és metódushívásokból állnak, és egyetlen értékre fognak kiértékelődni.
Például:
* `"alma"` String típusú kifejezés
* `1 + 4` int típusú kifejezés
* `1.5f` float típusú kifejezés
* `(a.methodB() + 6) / 2.4 == 8.5` logikai (boolean) típusú kifejezés

### Utasítások
#### Kifejezés utasítások
| Utasítás | Jelentés |
| --- | --- |
| `valtozo = 7;` | Értékadás, az érték lehet egy literál vagy egy tetszőleges kifejezés |
| `++valtozo;` | Léptető |
| `--valtozo;` | Léptető |
| `valtozo++;` | Léptető |
| `valtozo--;` | Léptető |
| `metodus();` | Metódus hívás |
| `new Osztaly();` | Objektum példányosítás |

#### Elágaztató utasítások
* Kétirányú elágaztató utasítás (feltételes utasítás)
```java
if (value == 0) { 
	doSomething(); 
}
```
```java
if (value == 0) {
	doSomething();
} else if (value > 0) { 
	doSomethingElse(); 
} else { 
	doFallbackThing(); 
}
```
* Többirányú elágaztató utasítás 
```java
switch (num) { 
	case 100: doSomething();
	case 200: doSomethingElse(); break; 
	default: doFallbackThing(); break;
}
```
* Ternális operátor
```java
int variable = (inputVariable == null) ? 0 : inputVariable;
```

#### Ciklusszervező utasítások
* for ciklus
```java
for (int i=0; i<10; i++){
	System.out.println(i);
}
```
* foreach ciklus
```java
int numbers[] = {0,1,2,3,4,5,6,7,8,9}
for (int i : numbers){
	System.out.println(i);
}
```
* Kezdőfeltételes ciklus
```java
while (areWeThereNow){
	doTravel();
}
```
* Végfeltételes ciklus
```java
do { 
	doTravel();
} while (areWeThereNow);
```

### Java elnevezési konvenciók
| Elem | Betűzés | Jellegzetesség | Példa |
| --- | --- | --- | --- |
| Osztály név | Nagy kezdőbetűs "camel case" | Főnév | OfficeBuilding|
| Interfész név | Ugyanaz mint az Osztály | Jellemzően melléknév "able" vagy "ible" végződéssel | Paintable |
| Metódus név | Kis kezdőbetűs "camel case" | Ige | prepare |
| Példány és Osztályszintű változó | Ugyanaz mint a metódus | Főnév | color |
| Paraméter és lokális változó | Ugyanaz mint a változó | Főnév | colorCode|
| Generikus típus paraméter | Egy nagybetű | Jellemzően egy nagy T betű | T |
| Konstans | Csupa nagybetű | Több szó aláhúzás (_) karakterrel elválasztva | BLUE_CODE |
| Enumeráció | Ugyanaz mint az Osztály | Főnév | enum WorkNeeded {PAINT_ONLY, RENOVATION_ONLY, PAINT_AND_RENOVATION} |
| Csomag | Csupa kisbetű | A fordított domain néve az adott cégnek | com.epam.training |