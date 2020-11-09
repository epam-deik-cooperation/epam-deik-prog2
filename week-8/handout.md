# 8. hét

Kivételkezelés és reflexió. A fordítást és a kódgenerálást támogató nyelvi elemek (annotációk, attribútumok).

## Kivételkezelés

### Exception osztályhierarhia

#### Error

#### Exception

#### RuntimeException

### Checked és Unchecked exception

### Kivételkezelés szintaktikája

#### Throws

#### Try-Catch-Finally

#### Try-With-Resources

### Saját kivétel osztály létrehozása

## Annotációk

## Reflexió

## A fordítást és a kódgenerálást támogató nyelvi elemek (annotációk, attribútumok)

# XP feladat

Implementálj egy Java nyelven írt parancssori Web Shop alkalmazást, amely az alábbi funkcionalitásokat teszi
elérhetővé:

Admin parancsok - 30 XP
 - Admin paranccsal be tudok importálni Termék Típusok listáját egy CSV fájlból az alkalmazásba
 - Admin paranccsal lehetséges Termék Típus létrehozása és törlése
 - Admin paranccsal lehetséges Termék Típusok listázása
 - Admin paranccsal be tudok importálni Termékek listáját egy CSV fájlból az alkalmazásba
 - Admin paranccsal lehetséges Termék létrehozása és törlése
 - Admin paranccsal lehetséges Termékek listázása

Ügyfél parancsok - 20 XP
 - Vásárlók listázhatják a Termék Típusokat
 - Vásárlók a kosarukba tehetnek Termékeket, tetszőleges mennyiségben
 - Vásárlók megvásárolhatják a korábban a kosarukba tett termékeket
	- A megvásárolt konkrét Termékek kikerülnek a nyilvántartásból
	- A megvásárolt tételek kiíratásra kerülnek és egy végösszeg is megjelenik

Non-funkcionális követelmény: Írj annyi egység tesztet (Unit Test) amennyit csak tudsz - 50 XP

Termék Típus:
 - Kategória
 - Márka
 - Típus
 - Ár (forintban)
 
Termék:
 - Termék Típus
 - Sorozatszám
 
Kosár:
 - Termék Típusok (a megvásárolni kívánt termékek)